package edu.ntnu.idi.bidata.userinterface;

import edu.ntnu.idi.bidata.food.FoodItem;
import edu.ntnu.idi.bidata.recipe.Recipes;
import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Represents the output to the user.
 *
 * <p>The {@code UIPrintHandler} is responsible for managing all user-facing output.
 * It handles the command screen that allows the user to select a command in the
 * {@link UserInterface} class. Additionally, it displays food items in the correct
 * format and provides the user with necessary information.
 * </p>
 *
 * <p>This class ensures that the user interface remains clear and interactive by
 * formatting the output and guiding the user through actions and options.
 * </p>
 *
 * @since 0.0.1
 * @author Arpit Sahoo
 * @version 0.0.14
 */


public class UiPrintHandler {

  /**
   * A choice menu of commands.
   *
   * <p>A menu that displays all the commands the user can choose to do.</p>
   */
  public void choiceScreen() {
    System.out.println("\n--- Fridge ---");
    System.out.println("Choose a number between 1 to 11: ");
    System.out.println("1. Add a food from fridge");
    System.out.println("2. Remove a food from fridge");
    System.out.println("3. Take out a fixed amount of a food");
    System.out.println("4. Find food by name");
    System.out.println("5. Display all expired food");
    System.out.println("6. Find foods with a certain expiry date");
    System.out.println("7. Display fridge contents");
    System.out.println("8. Display fridge contents in an alphabetical order");
    System.out.println("9. Add a recipe to recipe book");
    System.out.println("10. Display all the recipes");
    System.out.println("11. Find a recipe by name");
    System.out.println("12. Remove a recipe from recipe book");
    System.out.println("13. Exit");
    System.out.println("Choose a following number: ");
  }

  /**
   * Informs the user that the choice was invalid.
   */
  public void invalidChoice() {
    System.out.println("Invalid choice. Food item not added.");
  }

  /**
   * Asks the user of the name of the food.
   */
  public void nameOfFoodOutput() {
    System.out.print("Enter food name: ");
  }

  /**
   * Asks the user of the price per unit of the food.
   */
  public void pricePerUnitOutput() {
    System.out.print("Enter the price per unit: ");
  }

  /**
   * Asks the user of the expiration date of the food.
   */
  public void expirationDateOutput() {
    System.out.print("Enter expiration date (yyyy-MM-dd): ");
  }

  /**
   * Informs the user that the expiration date format was invalid.
   */
  public void invalidExpirationDateOutput() {
    System.out.println("Invalid date format. Please enter in the format yyyy-MM-dd.");
  }

  /**
   * Asks the user of the amount of the food.
   */
  public void foodAmountOutput() {
    System.out.print("Enter the amount of the food (numeric value): ");
  }

  /**
   * Informs the user that the amount was invalid.
   */
  public void invalidFoodAmountOutput() {
    System.out.println("Invalid amount. Please enter in the numeric value.");
  }

  /**
   * Informs the user that the price per unit was invalid.
   */
  public void invalidPriceOutput() {
    System.out.println("Invalid Price per unit. Please choose a positive number.");
  }

  /**
   * A menu of units the user can choose.
   */
  public void choiceOfUnits() {
    System.out.println("Choose an unit (1, 2 or 3):");
    System.out.println("1. kg");
    System.out.println("2. liter");
    System.out.println("3. pieces");
  }

  /**
   * Informs the user that the unit was invalid.
   */
  public void invalidUnitChoice() {
    System.out.println("Invalid unit choice. Food item not added.");
  }

  /**
   * Informs the user that the food was added.
   */
  public void foodAdded() {
    System.out.println("Food was added to fridge!");
  }

  /**
   * Prints all food items currently stored in the fridge along with their details.
   *
   * <p>This method iterates over each food item in the fridge and prints its details, including
   * the name, amount, unit, price per unit, and expiration date. After printing all food items,
   * it calculates and prints the total price of the items in the fridge.</p>
   *
   * @param foodIterator an iterator over the entries of food items stored in the fridge
   */
  public void printItFridge(Iterator<Map.Entry<String, FoodItem>> foodIterator) {
    double totalPrice = 0;
    System.out.println("\n--- Fridge Contents---");
    while (foodIterator.hasNext()) { // Iterates with entrySet:
      Map.Entry<String, FoodItem> entry = foodIterator.next();
      FoodItem food = entry.getValue(); // Gets the value.
      printLocatedFood(food); // Prints the values.
      totalPrice += food.getAmount() * food.getPricePerUnit(); // Calculates the total price.
    }
    System.out.println("The total price is: " + totalPrice + " kr");
  }

  /**
   * Prints all expired food items currently stored in the fridge along with their details.
   *
   * <p>This method iterates over each food item in the fridge.
   * If the food item is expired, it prints its details,
   * including the name, amount, unit, price per unit, and expiration date.
   * After printing all expired items,
   * it calculates and prints the total price of the expired items in the fridge.
   * If there are no expired items, it prints a message indicating
   * that no expired food items were found.</p>
   *
   * @param foodIterator an iterator over the entries of food items stored in the fridge
   */
  public void printExpiredFood(Iterator<Map.Entry<String, FoodItem>> foodIterator) {
    boolean hasExpiredItems = false; //No expired food.
    double totalPrice = 0; // starts at 0.
    LocalDate currentDate = LocalDate.now();
    while (foodIterator.hasNext()) { // while loop that iterates with entrySet (OpenAI 2024)
      Map.Entry<String, FoodItem> entry = foodIterator.next();
      FoodItem food = entry.getValue();
      if (food.getExpirationDate() != null && food.getExpirationDate().isBefore(currentDate)) {
        hasExpiredItems = true; //When it finds the foods, it is true.
        printLocatedFood(food); // Prints the values.
        totalPrice += food.getAmount() * food.getPricePerUnit(); // calculates the total price.
      }
    }
    if (hasExpiredItems) {
      System.out.printf("Total cost of expired items: %.2f kr%n", totalPrice);
    } else {
      System.out.println("No expired food was found.");
    }
  }

  /**
   * Prints the details of a specific food item.
   *
   * <p>This method displays the details of a provided {@code FoodItem}, including its name, amount,
   * unit, price per unit, and expiration date.</p>
   *
   * @param food the {@code FoodItem} whose details are to be printed
   */
  public void printLocatedFood(FoodItem food) {
    System.out.println("Name: " + food.getNameOfFood()
        + " | Amount: " + food.getAmount() + " " + food.getUnits()
        + " | Price per unit: " + food.getPricePerUnit()
        + " | Total price: " + food.getAmount() * food.getPricePerUnit()
        + " | Expiry: " + food.getExpirationDate()
    );
  }

  /**
   * Displays the details of a specific recipe.
   *
   * <p>This method displays the details of the provided {@code Recipes},
   * including its name, description, steps and ingredients.
   * This method also prints out the needed ingredients. It prints out the
   * {@code FoodItem} name, amount and unit.</p>
   *
   * @param recipe the {@code Recipes} whose details are to be printed
   */
  public void printLocatedRecipe(Recipes recipe) {
    System.out.println("Name:" + recipe.getNameOfRecipe() //Gets all the information of the Recipe.
        + " | Description: " + recipe.getDescription() //Formatted print.
        + " | Steps: " + recipe.getSteps()
        + " | portion: " + recipe.getPortion()
        + " | Ingredients: "
    );

    Iterator<FoodItem> ingredients = recipe.getIngredients();
    while (ingredients.hasNext()) { //(Recommended by OpenAI 2024), Iterates through the list.
      FoodItem ingredient = ingredients.next();
      System.out.println("Name: " + ingredient.getNameOfFood()
          //Gets all the information of the ingredient from the list.
          + " | Amount: " + ingredient.getAmount() + " "
          + ingredient.getUnits() //Formatted print.
      );
    }
  }

  /**
   * Method that informs the user if the specific food exists.
   *
   * <p>This method lets user know if there is or not a list of{@code FoodItem} in a
   * specific expiration date.</p>
   *
   * @param foodList a list of food the has the same expiration date.
   */
  public void printLocatedExpiredFood(List<FoodItem> foodList) {
    if (foodList.isEmpty()) { // If statement recommended by OpenAI 2024.
      System.out.println("No food was found with the specified expiration date.");
      return;
    }
    System.out.println("Matching food items:");
    for (FoodItem food : foodList) { //Partially recommended by OpenAI 2024
      printLocatedFood(food);
    }
  }


  /**
   * Prints the names of food items in alphabetical order.
   *
   * <p>This method iterates over a provided iterator
   * of food names (assumed to be sorted alphabetically)
   * and prints each name to the console.</p>
   *
   * @param foodIterator an iterator over the sorted names of food items
   */
  public void printFoodAlphabetical(Iterator<String> foodIterator) {
    System.out.println("---Recipes to make---");
    while (foodIterator.hasNext()) {
      System.out.println(foodIterator.next());
    }
  }

  /**
   * A method that tells the user to enter the name of the food
   * that they want to remove.
   */
  public void removeFoodOutput() {
    System.out.println("Enter the name of the food you want to remove: ");
  }

  /**
   * A method that informs the user food is removed.
   */
  public void foodRemovedOutput() {
    System.out.println("Food was removed.");
  }

  /**
   * A method that informs the user food was not found.
   */
  public void foodNotFoundOutput() {
    System.out.println("Food was not found.");
  }

  /**
   * A method that tells the user to enter the {@code nameOfFood}
   * that they want to take out.
   */
  public void foodToTakeOutput() {
    System.out.println("Enter the name of the food you want to take out:");
  }

  /**
   * Informs the user that the food was taken out.
   */
  public void foodTakenOutput() {
    System.out.println("The food was taken out.");
  }

  /**
   * Informs the food was not taken out.
   */
  public void foodNotTakenOutput() {
    System.out.println("Food was not taken out");
    System.out.println("Please choose an existing food item \nor a correct amount");
  }

  /**
   * Says goodbye to the user.
   */
  public void exit() {
    System.out.println("Goodbye...");
  }

  /**
   * Asks what the name of the recipe is to the user.
   */
  public void recipeNameOutput() {
    System.out.println("What is the name of the recipe?: ");
  }

  /**
   * Asks what the description of the recipe is to the user.
   */
  public void descriptionOutput() {
    System.out.println("What is the description?: ");
  }

  /**
   * Asks what the steps of the recipe is to the user.
   */
  public void stepsOutput() {
    System.out.println("what are the steps to make it?: ");
  }

  /**
   * Asks how many ingredients are needed to make the recipe.
   */
  public void howManyIngredientsOutput() {
    System.out.println("How many ingredients are needed to make the recipe?: ");
  }

  /**
   * Asks the user how many portions is the recipe for.
   */
  public void howManyPortion() {
    System.out.println("How many portion is this dish made for?: ");
  }

  /**
   * Informs the user that the recipe was added.
   */
  public void recipeAdded() {
    System.out.println("Yummy! Recipe was added to the recipe book");
  }

  /**
   * Informs the user that the recipe was not found.
   */
  public void recipeNotFound() {
    System.out.println("Recipe not found.");
  }

  /**
   * Informs the user that the recipe was removed.
   */
  public void recipeWasRemoved() {
    System.out.println("Recipe was removed.");
  }

  /**
   * Informs the user what happens when the food already exists.
   */
  public void alreadyExisting() {
    System.out.println("\nNotice!");
    System.out.println("If the fridge already exists"
        + "the amount will increase, but the expiration date "
        + "will be the same as the was added. ");
  }
}
