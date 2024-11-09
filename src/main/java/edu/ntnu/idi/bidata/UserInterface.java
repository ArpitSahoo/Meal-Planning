package edu.ntnu.idi.bidata;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.Scanner;

import static java.lang.System.in;



public class UserInterface {
  private final FridgeStorage fridgeRegister;
  private final Scanner scanner;
  private final UIPrintHandler print;

  public UserInterface(){
    fridgeRegister = new FridgeStorage();
    scanner = new Scanner(in);
    print = new UIPrintHandler();
  }

  public void start(){
    boolean running = true;
    while(running){
      print.choiceScreen();

      String choice = scanner.nextLine();
      scanner.nextLine();

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

  public void addFood(){
    System.out.print("Enter food name: ");
    String nameOfFood = scanner.nextLine();

    System.out.print("Enter total price: ");
    double price = scanner.nextDouble();

    LocalDate expirationDate = null;
    boolean validDate = false;

    while (!validDate) {
      System.out.print("Enter expiration date (yyyy-MM-dd): ");
      String expiration = scanner.next();
      try {
        expirationDate = LocalDate.parse(expiration, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        validDate = true;
      } catch (Exception e) {
        System.out.println("Invalid date format. Please enter in the format yyyy-MM-dd.");
        validDate = false;
      }
    }

    System.out.print("Enter quantity (numeric value): ");
    Float amount = scanner.nextFloat();

    print.choiceOfUnits();

    String unitChoice = scanner.nextLine();
    scanner.nextLine();

    String units;
    switch (unitChoice) {
      case "0":
        units = "kg";
        break;
      case "1":
        units = "liter";
        break;
      case "2":
        units = "gram";
        break;
      case "3":
        units = "stk";
        break;
      default:
        System.out.println("Invalid unit choice. Food item not added.");
        return;
    }

    FoodItem food = new FoodItem(nameOfFood, amount, units, price, expirationDate);
    fridgeRegister.addFoodItem(food);  // Store the item in the ArrayList
  }

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

  public void printFridge() {
    Iterator<FoodItem> iterator = fridgeRegister.sortedList();
    print.printDisplay(iterator);
  }

}

//TODO find a method to change to handle the rest of the print, in UI
