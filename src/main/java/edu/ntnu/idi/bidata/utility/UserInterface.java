package edu.ntnu.idi.bidata.utility;

import edu.ntnu.idi.bidata.food.FoodItem;
import edu.ntnu.idi.bidata.fridge.FridgeStorage;
import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * The {@code UserInterface} class handles user interactions for managing the fridge.
 *
 * <p>This class provides methods to add, remove, take out
 * and display food items, as well as manage expired food items.
 * It presents a menu to the user, processes commands,
 * and interfaces with {@code FridgeStorage}
 * to update and retrieve fridge data. It also uses
 * {@code UIPrintHandler} for displaying output to the user.</p>
 */
public class UserInterface {
  private final FridgeStorage fridgeRegister;
  private final UIPrintHandler print;
  private final InputReader input;

  /**
   * Constructs a {@code UserInterface} instance and initializes the necessary components.
   *
   * <p>This constructor creates an instance of {@code FridgeStorage}
   * to manage the fridge's contents,
   * initializes a {@code Scanner} for user input,
   * and sets up a {@code UIPrintHandler} for output.
   * It also initializes the {@code init} to add food to the fridge.
   * After the initialization,
   * it starts the user interface by calling the {@code start} method.
   * </p>
   */

  public UserInterface() {
    input = new InputReader();
    fridgeRegister = new FridgeStorage();
    print = new UIPrintHandler();
    init();
    printFridge();
    start();
  }

  /**
   * Starts the main loop of the fridge management application.
   *
   * <p>This method presents a choice menu to the user
   * and processes commands in a loop until the user chooses to exit.
   * Based on the user's input, it can add a food item, remove a food item,
   * take out a specified quantity of food,
   * display expired food, print all fridge contents, or exit
   * the application. If an invalid choice is entered,
   * an error message is displayed.
   * </p>
   *
   * <p>Menu options:
   * <ul>
   *   <li><b>1:</b> Add a food item to the fridge</li>
   *   <li><b>2:</b> Remove a food item by name</li>
   *   <li><b>3:</b> Take out a specified amount of a food item</li>
   *   <li><b>4:</b> Display all expired food items</li>
   *   <li><b>5:</b> Print the contents of the fridge</li>
   *   <li><b>6:</b> Exit the application</li>
   * </ul>
   * </p>
   * TODO Needs to be updated
   */
  public void start() {
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
   * the name, price per unit, amount, expiration date, and unit. After collecting
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
   *   <li><b>Unit:</b> The unit of measure, chosen from predefined options (kg, liter, stk)</li>
   * </ul>
   * </p>
   *
   * <p>If the expiration date or unit selection is invalid, the user is prompted
   * to re-enter the information. The food item is only added to the fridge if
   * all input values are valid.
   * </p>
   */
  public void addFood() {
    print.nameOfFoodOutput();
    String nameOfFood = input.scannerString();

    Double price = input.getValidPrice();

    Float amount = input.getValidAmount();

    LocalDate expirationDate = input.getValidExpirationDate();

    print.choiceOfUnits();
    String units = input.scannerString();


    switch (units) {
      case "1":
        units = "kg";
        break;
      case "2":
        units = "liter";
        break;
      case "3":
        units = "stk";
        break;
      default:
        print.invalidUnitChoice();
    }
    try {
      FoodItem food = new FoodItem(nameOfFood, amount, units, price, expirationDate);
      fridgeRegister.addFoodItem(food);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }

  }



  /**
   * Removes a food item from the fridge by name.
   *
   * <p>This method prompts the user to enter the name of a food item to remove. If the
   * item exists in the fridge, it is removed, and a success message is displayed.
   * Otherwise, an error message is shown to indicate that the item was not found.
   * </p>
   */
  public void removeFoodItem() {
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
   *
   * <p>This method prompts the user to enter the name and amount of a food item to take out. If the
   * item exists in the fridge, the amount is taken out and a success message is displayed.
   * Otherwise, an error message is shown to indicate that the item was not found.
   * </p>
   */
  public void takeOutFoodItem() {
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
   * <p>This method retrieves an iterator from {@link FridgeStorage}
   * and passes it to the {@link UIPrintHandler}.
   * to print the details of each food item stored in the fridge.
   *</p>
   */
  public void printFridge() {
    Iterator<Map.Entry<String, FoodItem>> iterator = fridgeRegister.getIterator();
    print.printItFridge(iterator);
  }

  /**
   * Iterates through the fridge and prints the fridge content.
   *
   * <p>This method retrieves an iterator from the {@link FridgeStorage}
   * and passes it to the {@link UIPrintHandler}.
   * to print the details of each expired food item stored in the fridge.
   * </p>
   */
  public void displayAllExpiredFood() {
    Iterator<Map.Entry<String, FoodItem>> iterator = fridgeRegister.getIterator();
    print.printExpiredFood(iterator);
  }

  /**
   * Finds the food by its name.
   *
   * <p>Checks if the food is in the fridge.
   * If found in the fridge it prints out that it is in the fridge
   * else it prints out that it is not in the fridge.
   * UserInput:
   *    <ul>
   *      <li><b>Name of Food:</b> The name of the food item</li>
   *    </ul>
   * </p>
   */
  public void findFoodByName() {
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
  public void printFridgeAlphabetical() {
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
   *    prints out that it is not in the fridge else
   *    it prints out that it is not in the fridge.
   * </p>
   */
  public void findFoodByExpiryDate() {
    LocalDate expirationDate = input.getValidExpirationDate();
    List<FoodItem> item = fridgeRegister.searchByDate(expirationDate);
    print.printLocatedExpiredFood(item);
  }

  /**
   * Initializes the fridge with a set of predefined food items.
   *
   * <p>This method creates several {@link FoodItem} objects with predefined values
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

