package edu.ntnu.idi.bidata.userinterfaces;

import edu.ntnu.idi.bidata.food.FoodItem;

import java.time.LocalDate;

import static java.lang.System.out;

public class UserInterface {
  public void choiceScreen() {
    out.println("\n--- Fridge Management ---");
    out.println("1. Add food");
    out.println("2. Remove food");
    out.println("3. Take out an item");
    out.println("4. Display fridge contents");
    out.println("5. Check for expired food");
    out.println("6. Exit");
    out.println("Choose a following number: ");
  }

  public void choiceOfUnits() {
    out.println("Choose an unit (1, 2, 3 or 4):");
    out.println("1. kg");
    out.println("2. liter");
    out.println("2. pieces");
  }

  public void start() {
    LocalDate expirationDate1 = LocalDate.of(2025, 10, 20);
    LocalDate expirationDate2 = LocalDate.of(2025, 11, 20);
    LocalDate expirationDate3 = LocalDate.of(2025, 12, 20);
    LocalDate expirationDate4 = LocalDate.of(2025, 9, 20);

    FoodItem food1 = new FoodItem("egg", 3f, "pieces", 3.0, expirationDate1);
    FoodItem food2 = new FoodItem("milk", 1f, "liter", 3.0, expirationDate2);
    FoodItem food3 = new FoodItem("Chicken", 1f, "kg", 300.0, expirationDate3);
    FoodItem food4 = new FoodItem("Soda", 2f, "liters", 40.0, expirationDate4);

    /*
     *  public void init(){
     *     LocalDate expirationDate1 = LocalDate.of(2025, 10, 20);
     *     fridge.add(new FoodItem("egg", 3f, "pieces", 3.0, expirationDate1));
     *     fridge.add(new FoodItem("milk", 1f, "liter", 3.0, expirationDate1));
     *     fridge.add(new FoodItem("Chicken", 1f, "kg", 300.0, expirationDate1));
     *     fridge.add(new FoodItem("Soda", 2f, "liters", 40.0, expirationDate1));
     *   }
     */
  }
}
