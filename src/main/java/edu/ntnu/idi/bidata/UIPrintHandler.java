package edu.ntnu.idi.bidata;

import java.util.Iterator;
import java.util.Map;

public class UIPrintHandler {
  public void choiceScreen() {
    System.out.println("\n--- Fridge ---");
    System.out.println("1. Add food");
    System.out.println("2. Remove food");
    System.out.println("3. Take out an item");
    System.out.println("4. Display fridge contents");
    System.out.println("5. Check for expired food");
    System.out.println("6. Exit");
    System.out.println("Choose a following number: ");
  }

  public void choiceOfUnits() {
    System.out.println("Choose an unit (1, 2 or 3):");
    System.out.println("1. kg");
    System.out.println("2. liter");
    System.out.println("3. pieces");
  }

  public void displayFoodPrint(){
    System.out.println("=====Fridge Content=====");
  }

  /**
   * Prints all food items currently stored in the fridge.
   *
   * <p>Iterates over each food item in the fridge and prints its details,
   * including name, amount, unit, total price, and expiration date.</p>
   *
   * @param foodIterator an iterator over the entries of food items stored in the fridge
   */
  public void printFridge(Iterator<Map.Entry<String, FoodItem>> foodIterator) { while (foodIterator.hasNext()) {
    Map.Entry<String, FoodItem> entry = foodIterator.next();
    FoodItem food = entry.getValue();
    System.out.println("Name: " + food.getNameOfFood()
        + " | Amount: " + food.getAmount() + " " + food.getUnits()
        + " | Total Price: " + food.getPricePerUnit()
        + " | Expiry: " + food.getExpirationDate());
    }
  }

  public void exit(){
    System.out.println("Goodbye...");
  }


}
