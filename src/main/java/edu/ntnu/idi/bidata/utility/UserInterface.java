package edu.ntnu.idi.bidata.utility;

import edu.ntnu.idi.bidata.food.FoodItem;
import edu.ntnu.idi.bidata.fridge.FridgeStorage;
import edu.ntnu.idi.bidata.recipe.Recipes;
import edu.ntnu.idi.bidata.recipebook.RecipeStorage;
import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * The {@code UserInterface} class handles user interactions for managing the fridge and recipe book.
 *
 * <p>This class provides methods to add, remove, take out
 * and display food items or recipes.
 * It presents a menu to the user, processes different commands,
 * and interfaces with {@link FridgeStorage} and {@link RecipeStorage}
 * to update and retrieve fridge and recipe data.
 * The class understands the user commands by help from the {@link InputReader}.
 * It also uses {@link UIPrintHandler} for displaying output to the user.
 * </p>
 * @author Arpit Sahoo
 * @version 0.0.4
 *
 */
public class UserInterface {
  private final FridgeStorage fridgeRegister;
  private final UIPrintHandler print;
  private final InputReader input;
  private final RecipeStorage recipeStorage;

  /**
   * Constructs a {@code UserInterface} instance and initializes the necessary components.
   *
   * <p>This constructor creates an instance of {@code FridgeStorage}
   * to manage the fridge's contents,
   * an instance of {@code InputReader} for user prompt,
   * and sets up a {@code UIPrintHandler} for output.
   * It also initializes the {@code init} to add food to the fridge.
   * After the initialization,
   * it has a {@code printFridge} to display all the initialized food.
   * It starts the user interface by calling the {@code start} method.
   * </p>
   */

  public UserInterface() {
    input = new InputReader();
    fridgeRegister = new FridgeStorage();
    print = new UIPrintHandler();
    recipeStorage = new RecipeStorage();
    init();
    printFridge();
    start();
  }

  /**
   * Starts the main loop of the fridge management application.
   *
   * <p>This method presents a choice menu to the user
   * and processes commands in a loop until the user chooses to exit.
   * Based on the user's input, the user can do various of commands
   * as displayed in the list below.
   * If an invalid choice is entered, an error message is displayed.
   * </p>
   *
   * <p>Menu options:
   * <ul>
   *   <li><b>1:</b> Add a food item to the fridge</li>
   *   <li><b>2:</b> Remove a food item by name</li>
   *   <li><b>3:</b> Take out a specified amount of a food item</li>
   *   <li><b>4:</b> Search a food by name</li>
   *   <li><b>5:</b> Display all expired food items</li>
   *   <li><b>6:</b> Find all food in the specific expiry date.</li>
   *   <li><b>7:</b> Display all the food with details</li>
   *   <li><b>8:</b> Display all the food alphabetical</li>
   *   <li><b>9:</b> Add Recipe to the recipe book</li>
   *   <li><b>10:</b> Find a recipe by name</li>
   *   <li><b>11:</b> Exit the application</li>
   * </ul>
   * </p>
   */
  private void start() {
    boolean running = true;
    while (running) {
      print.choiceScreen();

      String choice = input.scannerString();

      switch (choice) {
        case "1":
          addFood();
          break;
        case "2":
          removeFoodItem();
          break;
        case "3":
          takeOutFoodItem();
          break;
        case "4":
          findFoodByName();
          break;
        case "5":
          displayAllExpiredFood();
          break;
        case "6":
          findFoodByExpiryDate();
          break;
        case "7":
          printFridge();
          break;
        case "8":
          printFridgeAlphabetical();
          break;
        case "9":
          addRecipeToBook();
          break;
        case "10":
          findRecipeByName();
          break;
        case "11":
          running = false;
          print.exit();
          break;
        default:
          print.invalidChoice();
      }
    }
  }

  /**
   * Adds a new food item to the fridge with user-specified details.
   *
   * <p>This method prompts the user to input details about a food item, including
   * the name, price per unit, amount, expiration date, and unit from {@code getUnitOfFoodItem}. After collecting
   * and validating each input, a {@link FoodItem} object is created and added to
   * the {@code fridgeRegister}.
   * </p>
   *
   * <p>User inputs:
   * <ul>
   *   <li><b>Name of Food:</b> The name of the food item</li>
   *   <li><b>Price per Unit:</b> The cost per unit of the food item</li>
   *   <li><b>Amount:</b> The quantity of the food item</li>
   *   <li><b>Expiration Date:</b> The expiration date in yyyy-MM-dd format</li>
   *   <li><b>Unit:</b> The unit of measure, chosen from predefined options (kg, liter, pieces)</li>
   * </ul>
   * </p>
   *
   * <p>If the expiration date or unit selection is invalid, the user is prompted
   * to re-enter the information. The food item is only added to the fridge if
   * all input values are valid.
   * </p>
   */
  private void addFood() {
    print.nameOfFoodOutput();
    String nameOfFood = input.scannerString();

    Double price = input.getValidPrice();

    Float amount = input.getValidAmount();

    LocalDate expirationDate = input.getValidExpirationDate();

    print.choiceOfUnits();
    String units = input.scannerString();


    units = getUnitOfFoodItem(units);
    try {
      FoodItem food = new FoodItem(nameOfFood, amount, units, price, expirationDate);
      fridgeRegister.addFoodItem(food);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }

  }

  /**
   * A method that allows the user to add a unit.
   * @param units the unit of food item.
   * @return unit of the food item.
   */
  private String getUnitOfFoodItem(String units) {
    switch (units) {
      case "1":
        units = "kg";
        break;
      case "2":
        units = "liter";
        break;
      case "3":
        units = "pieces";
        break;
      default:
        print.invalidUnitChoice();
    }
    return units;
  }


  /**
   * Removes a food item from the fridge by name.
   * <p>UserInput:
   * <ul><li><b>nameOfFood: </b>The name of the food item.</li></ul></p>
   * </p>
   * <p>This method prompts the user to enter the name of a food item to remove. If the
   * item exists in the fridge, it is removed, and a message is displayed.
   * Otherwise, an error message is shown to indicate that the item was not found.
   * </p>
   */
  private void removeFoodItem() {
    print.removeFoodOutput();
    String name = input.scannerString();
    FoodItem item = new FoodItem(name);
    boolean removed = fridgeRegister.removeFoodItem(item);
    if (removed) {
      print.foodRemovedOutput();
    } else {
      print.foodNotFoundOutput();
    }
  }

  /**
   * Takes out a fixed amount from the fridge by name.
   * <p>UserInput:
   * <ul><li><b>nameOfFood: </b>The name of the food item.</li></ul></p>
   * <ul><li><b>amount: </b>The amount of the food item.</li></ul></p>
   * <p>This method prompts the user to enter the name and amount of a food item to take out. If the
   * item exists in the fridge, the amount is taken out and a success message is displayed.
   * Otherwise, an error message is shown to indicate that the item was not found.
   * </p>
   */
  private void takeOutFoodItem() {
    print.foodToTakeOutput();
    String nameOfFood = input.scannerString();
    print.foodAmountOutput();
    Float amount = input.getValidAmount();
    FoodItem item = new FoodItem(nameOfFood, amount);
    boolean taken = fridgeRegister.foodToTake(item);
    if (taken) {
      print.foodTakenOutput();
    } else {
      print.foodNotFoundOutput();
    }
  }

  /**
   * Iterates through the fridge and prints the fridge content.
   *
   * <p>Retrieves an iterator from {@link FridgeStorage}
   * and passes it to the {@link UIPrintHandler}.
   * to print the details of each food item stored in the fridge.
   *</p>
   */
  private void printFridge() {
    Iterator<Map.Entry<String, FoodItem>> iterator = fridgeRegister.getIterator();
    print.printItFridge(iterator);
  }

  /**
   * Iterates through the fridge and prints the fridge content.
   *
   * <p>Retrieves an iterator from the {@link FridgeStorage}
   * and passes it to the {@link UIPrintHandler}.
   * to print the details of each expired food item stored in the fridge.
   * </p>
   */
  private void displayAllExpiredFood() {
    Iterator<Map.Entry<String, FoodItem>> iterator = fridgeRegister.getIterator();
    print.printExpiredFood(iterator);
  }

  /**
   * Finds the food by its name.
   *
   *
   * <p>
   * UserInput:
   * <ul><li><b>Name: </b>The name of the food item.</li></ul>
   * Checks if the food is in the fridge.
   * If found in the fridge it prints out that it is in the fridge
   * else it prints out that it is not in the fridge.
   * </p>
   */
  private void findFoodByName() {
    print.nameOfFoodOutput();
    String name = input.scannerString();
    FoodItem item = fridgeRegister.searchFoodByName(name);
    if (item != null) { //recommended by (OpenAI, 2024)
      print.printLocatedFood(item);
    } else {
      print.foodNotFoundOutput();
    }
  }


  /**
   * Iterates through the fridge and prints the fridge content.
   *
   * <p>This method retrieves an iterator from the {@link FridgeStorage}
   * and passes it to the {@link UIPrintHandler}.
   * to print food in an alphabetical order.
   * </p>
   */
  private void printFridgeAlphabetical() {
    Iterator<String> sortedNames = fridgeRegister.getIteratorAlphabetical();
    print.printFoodAlphabetical(sortedNames);
  }

  /**
   * Finds the food by expiration date.
   *
   * <p>UserInput:
   *    <ul>
   *      <li><b>Expiration date of Food:</b> The name of the food item</li>
   *    </ul>
   *    Checks if there are food that goes out in that
   *    expiration date in the fridge. If found in the fridge it
   *    prints out the food and the details. Else
   *    it prints out that it is not in the fridge.
   * </p>
   */
  private void findFoodByExpiryDate() {
    LocalDate expirationDate = input.getValidExpirationDate();
    List<FoodItem> item = fridgeRegister.searchByDate(expirationDate);
    print.printLocatedExpiredFood(item);
  }

  /**
   * Adds recipe to recipe book.
   *
   * <p>Gets the information form {@code getRecipe}.
   * Asks the user of how many ingredients they want to add.
   * Loops the following inputs till the user has added the all the ingredient.
   * </p>
   *
   * <p>
   *     <ul><li><b>Name: </b>The name of the ingredient.</li></ul>
   *     <ul><li><b>Amount: </b>The amount of ingredient.</li></ul>
   *     <ul><li><b>Unit: </b>The unit of the ingredient</li></ul>
   * </p>
   *
   * <p>When all the inputs are filled the recipe will be added to the
   * recipe book.
   * If any of the inputs are invalid,
   * the user will be sent back to the command screen.</p>
   */

  private void addRecipeToBook(){
    try{ //Tries to add recipe to book map.
      Recipes newRecipes = getRecipes();
      print.howManyIngredientsOutput();
      int amountOfIngredient = input.amountOfIngredients(); //How many loops?
      for(int indexOfAmount = 0; indexOfAmount < amountOfIngredient; indexOfAmount++){ //Loops.
        print.nameOfFoodOutput();
        String name = input.scannerString();
        Float amount = input.getValidAmount();

        print.choiceOfUnits();
        String unit = input.scannerString();
        unit = getUnitOfFoodItem(unit); // switch-case choice method.
        newRecipes.addIngredient(name, amount, unit); //adds ingredient to list.
      }
      recipeStorage.addRecipe(newRecipes); // adds recipe to recipe book.
    } catch (IllegalArgumentException e) { // Catches illegal argument exception.
      System.out.println(e.getMessage());
    }
  }

  /**
   * Adds information of the Recipe.
   * <p>User inputs:
   * <ul><li><b>Name of recipe: </b>The name of the recipe.</></li></ul>
   * <ul><li><b>Description: </b>The description of the recipe.</></li></ul>
   * <ul><li><b>Steps: </b>The steps to make the recipe.</li></ul>
   * </p>
   *
   * @return a new recipe.
   */
  private Recipes getRecipes() {
    print.recipeNameOutput();
    String nameOfRecipe = input.scannerString();

    print.descriptionOutput();
    String description = input.scannerString();

    print.stepsOutput();
    String steps = input.scannerString();
      return new Recipes(nameOfRecipe, description, steps);
  }

  /**
   * Finds the recipe by name.
   *
   * <p>UserInput:
   *    <ul>
   *      <li><b>Name:</b> The name of the Recipe</li>
   *    </ul>
   *    Checks if there is a recipe in the {@link RecipeStorage}.
   *    If found in the recipe book it
   *    prints out the recipes detail. Else
   *    it prints out that it is not in the fridge.
   * </p>
   */
  private void findRecipeByName() {
    print.recipeNameOutput();
    String name = input.scannerString();

    // Fetch the recipe from recipe book.
    Recipes recipe = recipeStorage.getRecipe(name);
    if (recipe != null) {
      print.printLocatedRecipe(recipe); // Print the located recipe.
    } else {
      print.recipeNotFound(); // print not found.
    }
  }


  /**
   * Initializes the fridge with a set of predefined food items.
   *
   * <p>This adds several {@link FoodItem} with predefined values
   * for name, amount, unit, price, and expiration date. These items are then added
   * to the {@code fridgeRegister} for use in the application.
   * </p>
   */
  private void init() {
    FoodItem apple = new FoodItem("apple", 20f, "kg",
            5.0, LocalDate.of(2025, 12, 12));
    FoodItem banana = new FoodItem("banana", 10f, "kg",
            5.0, LocalDate.of(2025, 12, 12));
    FoodItem milk = new FoodItem("milk", 2f, "kg",
            20.0, LocalDate.of(2025, 1, 20));
    FoodItem chicken = new FoodItem("chicken", 1f, "kg",
            140.0, LocalDate.of(2025, 1, 20));
    fridgeRegister.addFoodItem(apple);
    fridgeRegister.addFoodItem(banana);
    fridgeRegister.addFoodItem(milk);
    fridgeRegister.addFoodItem(chicken);
  }


}

