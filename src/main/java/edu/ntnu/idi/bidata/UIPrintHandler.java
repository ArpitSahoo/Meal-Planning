package edu.ntnu.idi.bidata;

import java.util.Iterator;

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
    System.out.println("Choose an unit (1, 2, 3 or 4):");
    System.out.println("1. kg");
    System.out.println("2. liter");
    System.out.println("2. pieces");
  }

  public void printDisplay(Iterator<FoodItem> foodItemIterator) {
    while (foodItemIterator.hasNext()) {
      FoodItem food = foodItemIterator.next();
      System.out.println("Name: " + food.getNameOfFood() +
          " | Amount: " + food.getAmount() + " " + food.getUnits() +
          " | Price: " + (food.getPricePerUnit() * food.getAmount()) +
          " | Expiry: " + food.getExpirationDate());
    }
  }

  public void exit(){
    System.out.println("Goodbye...");
  }

}
