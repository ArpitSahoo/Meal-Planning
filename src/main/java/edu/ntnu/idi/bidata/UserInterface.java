package edu.ntnu.idi.bidata;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

import static java.lang.System.in;


public class UserInterface {
  private final FridgeStorage fridgeRegister;
  private final Scanner scanner;
  private final UIPrintHandler print;

  /**
   * A constructor for the class FoodItem.
   * Initializes the fridge register, scanner, and print handler, then starts the interface.
   */
  public UserInterface(){
    fridgeRegister = new FridgeStorage();
    scanner = new Scanner(in);
    print = new UIPrintHandler();
    start();
  }

  /**
   * Starts the user interface loop.
   * <p>
   *   This method continuously displays the choice screen till the user decides to exit the loop.
   *   The user has several actions to choose; such as adding food, removing food, taking out the a fixed amount,
   *   getting a full display of the fridge, display of all the expired food and exiting the application.
   * </p>
   * TODO needs to be corrected
   */
  public void start(){
    boolean running = true;
    while(running){
      print.choiceScreen();

      String choice = scanner.nextLine();

      switch(choice){
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
          fridgeRegister.displayExpiredItemsAndTotalCost();
          break;
        case "5":
          print.displayFoodPrint();
          printFridge();
          break;
        case "6":
          running = false;
          print.exit();
          break;
        default:
          System.out.println("Invalid unit choice. Food item not added.");
      }
    }
  }


  /**
   * Adds a new food item to the fridge with user-specified details.
   *
   * <p>This method prompts the user to enter the name, price per unit, expiration date,
   * amount, and unit of a food item through the console. It validates the expiration
   * date format (yyyy-MM-dd) using a try-catch block and ensures a valid unit choice.
   * If all inputs are valid, the food item is added to the {@link FridgeStorage}.
   * </p>
   *
   * <p>Input Details:
   * <ul>
   *   <li><b>Name:</b> The name of the food item</li>
   *   <li><b>Price per Unit:</b> The total price of the food item</li>
   *   <li><b>Expiration Date:</b> The expiration date in yyyy-MM-dd format</li>
   *   <li><b>Amount:</b> The quantity of the food item (numeric)</li>
   *   <li><b>Unit:</b> The unit type chosen from a list of predefined options</li>
   * </ul>
   * </p>
   *
   * <p>If an invalid date format is entered, the user is prompted to re-enter it.
   * Additionally, if an invalid unit choice is entered, the item will not be added.
   * </p>
   *
   * @throws DateTimeParseException if the expiration date format is incorrect
   */

  public void addFood(){
    System.out.print("Enter food name: ");
    String nameOfFood = scanner.nextLine();

    System.out.print("Enter total price: ");
    double price = scanner.nextDouble();
    scanner.nextLine();

    LocalDate expirationDate = null;
    boolean validDate = false;

    while (!validDate) {
      System.out.print("Enter expiration date (yyyy-MM-dd): ");
      String expiration = scanner.next();
      scanner.nextLine();
      try {
        expirationDate = LocalDate.parse(expiration, DateTimeFormatter.ofPattern("yyyy-MM-dd")); // (OpenAI, 2024)
        validDate = true;
      } catch (Exception e) {
        System.out.println("Invalid date format. Please enter in the format yyyy-MM-dd.");
        validDate = false;
      }
    }

    System.out.print("Enter quantity (numeric value): ");
    Float amount = scanner.nextFloat();
    scanner.nextLine();

    print.choiceOfUnits();

    String unitChoice = scanner.nextLine();

    String units = "";
    switch (unitChoice) {
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
        System.out.println("Invalid unit choice. Food item not added.");
    }

    FoodItem food = new FoodItem(nameOfFood, amount, units, price, expirationDate);
    fridgeRegister.addFoodItem(food);
  }

  /**
   * Method that removes food from fridge
   */
  public void removeFoodItem() {
    System.out.println("Enter the name of the food item to remove:");
    String name = scanner.nextLine();
    FoodItem item = new FoodItem(name);
    boolean removed = fridgeRegister.removeFoodItem(item);
    if (removed) {
      System.out.println("Food item removed.");
    } else {
      System.out.println("Food item not found.");
    }
  }

  /**
   * Method that takes out food item
   */
  public void takeOutFoodItem(){
    System.out.println("Enter the name of the food item to remove:");
    String name = scanner.nextLine();
    FoodItem item = new FoodItem(name);
    fridgeRegister.FoodToTake(item);
    boolean takenOut = fridgeRegister.FoodToTake(item);
    if (takenOut) {
      System.out.println("Food item taken out.");
    } else {
      System.out.println("Food item not found.");
    }
  }

  /**
   * Iterates through the fridge and prints the fridge content.
   * <p> * This method retrieves an iterator from the fridge register and passes it to the print handler
   * to print the details of each food item stored in the fridge.
   * </p>
   */
  public void printFridge() {
    Iterator<Map.Entry<String, FoodItem>> iterator = fridgeRegister.getIterator(); print.printFridge(iterator);
  }

}

