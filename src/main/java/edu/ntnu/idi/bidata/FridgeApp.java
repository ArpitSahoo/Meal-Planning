package edu.ntnu.idi.bidata;
import edu.ntnu.idi.bidata.food.FoodItem;
import edu.ntnu.idi.bidata.userinterfaces.UserInterface;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.*;

/**
 * The main starting point of your application. Let this class create the
 * instance of your main-class that starts your application.
 *
 * @author Arpit Sahoo
 * @version 0.0.1
 */


public class FridgeApp {
  private final List<FoodItem> fridge;
  private final Scanner scanner;

  /**
   * A constructor that creat a new fridge arraylist.
   * Creates Scanner.
   */
  private FridgeApp() {
    fridge = new ArrayList<>();
    scanner = new Scanner(in);
  }

  /**
   * A function that keeps the program running.
   * Print's out different commands.
   * Switch case to choose.
   */
  private void run() {
    boolean running = true;
    UserInterface uiFridgeApp = new UserInterface();
    uiFridgeApp.start();
    while (running) {
      uiFridgeApp.choiceScreen();
      String chosen = scanner.nextLine();

      switch (chosen) {
        case "1":
          addFoodItem();
          break;
        case "2":
          removeFoodItem();
          break;
        case "3":
          takeOutItem();
          break;
        case "4":
          displayFridge();
          break;
        case "5":
          checkExpiredFood();
          break;
        case "6":
          running = false;
          out.println("System ending...");
          out.println("Goodbye....");
          break;
        default:
          out.println("Invalid choice. Please try again.");
      }
    }
  }

  /**
   * Function to add food.
   * Switch case to choose units.
   * IllegalArgumentException argument to catch illegalArgument.
   */
  private void addFoodItem() {
    try {
      out.print("What is the name of the food: ");
      String nameOfFood = scanner.nextLine();

      out.println("What is the quantity: ");
      Float amount = scanner.nextFloat();
      scanner.nextLine();

      UserInterface uiFridgeApp = new UserInterface();
      uiFridgeApp.choiceOfUnits();

      out.println("Which unit is the food?: ");
      int unitChosen = scanner.nextInt();
      scanner.nextLine();


      String units;
      switch (unitChosen) {
        case 1:
          units = "kg";
          break;
        case 2:
          units = "liter";
          break;
        case 3:
          units = "gram";
          break;
        case 4:
          units = "stk";
          break;
        default:
          units = "";
          out.println("Invalid unit choice. Food item not added.");
      }


      out.println("What is the price per unit of the food (Kilo/KR):");
      Double price = scanner.nextDouble();
      scanner.nextLine();

      out.print("Enter expiration date (yyyy-MM-dd): ");
      String expiration = scanner.nextLine();
      LocalDate expirationDate = LocalDate.parse(expiration, DateTimeFormatter.ofPattern("yyyy-MM-dd"));


      FoodItem food = new FoodItem(nameOfFood, amount, units, price, expirationDate);
      fridge.add(food);
      out.print("Food added:" + food.displayFoodItem());
    } catch (IllegalArgumentException illegalArgument) {
      out.println(illegalArgument.getMessage());
    }

  }

  /**
   * Function to remove food Item.
   * For-each-loop to find the food in the fridge arraylist.
   */
  private void removeFoodItem() {
    out.println("What do you want to remove?: ");
    String foodToRemove = scanner.nextLine();
    boolean found = false;
    Iterator<FoodItem> iteratorObject = fridge.iterator();
    while (iteratorObject.hasNext()) {
      FoodItem food = iteratorObject.next();
      if (food.getNameOfFood().equalsIgnoreCase(foodToRemove)) {
        iteratorObject.remove();
        out.println("Removed food: " + foodToRemove);
        found = true;
      }

    }
    if (!found) {
      out.println("The item was not found");
    }
  }

  private void takeOutItem() {
    out.println("What do you want to take out?: ");
    String foodToTake = scanner.nextLine();

    out.println("What is the quantity you want to take out? ");
    Float amountToTake = scanner.nextFloat();
    scanner.nextLine();

    for (FoodItem food : fridge) {
      if (food.getNameOfFood().equalsIgnoreCase(foodToTake)) {
        food.setAmount(food.getAmount() - amountToTake);
        out.println("The food you want to take out is "
            + foodToTake
            + " "
            + food.getAmount()
            + food.getUnits());
      }

    }
  }

  /**
   * Function to display food.
   * If-statement to see if fridge is empty.
   * Else-statement to go through the whole list.
   * Calculate the total food price.
   */
  private void displayFridge() {
    out.println("\n--- Fridge Contents ---");
    if (fridge.isEmpty()) {
      out.println("The fridge is empty.");
    } else {
      double totalPrice = 0;
      for (FoodItem food : fridge) {
        out.println(food.displayFoodItem());
        totalPrice = totalPrice + food.getAmount() * food.getPrice();
      }
      out.println("Total price of all items in the fridge: " + totalPrice + " kr.");
    }

  }

  /**
   * Function that checks for expired food.
   * For-each-loop checks trough whole fridge arraylist.
   * Calculates and print the name and total price.
   */
  private void checkExpiredFood() {
    out.println("\n--- Expired Food ---");
    LocalDate currentDate = LocalDate.now();
    double totalPrice = 0;
    for (FoodItem food : fridge) {
      if (food.getExpirationDate().isBefore(currentDate)) {
        out.print(food.getNameOfFood() + " has expired.");
        totalPrice += food.getPrice();
      } else {
        out.println("There are no expired food");
      }
    }
    out.println("Total price of expired food is: " + totalPrice + "kr");
  }

  /**
   * Main function that runs the FridgeApp.
   *
   * @param args FridgeAPP
   */
  public static void main(String[] args) {
    FridgeApp app = new FridgeApp();
    app.run();
  }

}
