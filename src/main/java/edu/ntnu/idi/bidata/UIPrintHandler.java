package edu.ntnu.idi.bidata;
import java.time.LocalDate;
import java.util.Iterator;
import java.util.Map;

public class UIPrintHandler {

  public void choiceScreen() {
    System.out.println("\n--- Fridge ---");
    System.out.println("Choose 1, 2, 3, 4, 5 or 6: ");
    System.out.println("1. Add food");
    System.out.println("2. Remove food");
    System.out.println("3. Take out an item");
    System.out.println("4. Check for expired food");
    System.out.println("5. Display fridge contents");
    System.out.println("6. Exit");
    System.out.println("Choose a following number: ");
  }

  public void invalidChoice(){
    System.out.println("Invalid choice. Food item not added.");
  }

  public void nameOfFoodOutput(){
    System.out.print("Enter food name: ");
  }

  public void pricePerUnitOutput(){
    System.out.print("Enter total price per unit: ");
  }

  public void expirationDateOutput(){
    System.out.print("Enter expiration date (yyyy-MM-dd): ");
  }

  public void invalidExpirationDateOutput(){
    System.out.println("Invalid date format. Please enter in the format yyyy-MM-dd.");
  }

  public void foodAmountOutput(){
    System.out.print("Enter quantity (numeric value): ");
  }

  public void choiceOfUnits() {
    System.out.println("Choose an unit (1, 2 or 3):");
    System.out.println("1. kg");
    System.out.println("2. liter");
    System.out.println("3. pieces");
  }

  public void invalidUnitChoice(){
    System.out.println("Invalid unit choice. Food item not added.");
  }

  public void displayFoodPrint(){
    System.out.println("=====Fridge Content=====");
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
    while (foodIterator.hasNext()) {
      Map.Entry<String, FoodItem> entry = foodIterator.next();
      FoodItem food = entry.getValue();
      System.out.println("Name: " + food.getNameOfFood()
          + " | Amount: " + food.getAmount() + " " + food.getUnits()
          + " | Price per unit: " + food.getPricePerUnit()
          + " | Expiry: " + food.getExpirationDate()
      );
      totalPrice = food.getAmount() * food.getPricePerUnit();
    }
    System.out.println("The total price is: " + totalPrice +" kr");

  }

  /**
   * Prints all expired food items currently stored in the fridge along with their details.
   *
   * <p>This method iterates over each food item in the fridge. If the food item is expired,
   * it prints its details, including the name, amount, unit, price per unit, and expiration date.
   * After printing all expired items, it calculates and prints the total price of the expired items in the fridge.
   * If there are no expired items, it prints a message indicating that no expired food items were found.</p>
   *
   * @param foodIterator an iterator over the entries of food items stored in the fridge
   */
  public void printExpiredFood(Iterator<Map.Entry<String, FoodItem>> foodIterator){
    boolean hasExpiredItems = false;
    double totalPrice = 0;
    while (foodIterator.hasNext()){
      LocalDate currentDate = LocalDate.now();
      Map.Entry<String, FoodItem> entry = foodIterator.next();
      FoodItem food = entry.getValue();
      if(food.getExpirationDate() != null && food.getExpirationDate().isBefore(currentDate)){
        hasExpiredItems = true;
        System.out.println("Name: " + food.getNameOfFood()
            + " | Amount: " + food.getAmount() + " " + food.getUnits()
            + " | Price per unit: " + food.getPricePerUnit()
            + " | Expiry: " + food.getExpirationDate()
        );
        totalPrice = food.getAmount() * food.getPricePerUnit();
      }
    }
    if (hasExpiredItems) {
      System.out.printf("Total cost of expired items: %.2f kr%n", totalPrice);
    } else {
      System.out.println("No expired food items found.");
    }
  }

  public void printFood(Iterator<String> foodIterator){
    while (foodIterator.hasNext()) {
      System.out.println(foodIterator.next());
    }
  }

  public void removeFoodOutput(){
    System.out.println("Enter the name of the food item to remove: ");
  }

  public void foodRemovedOutput(){
    System.out.println("Food item removed.");
  }

  public void foodNotRemovedOutput(){
    System.out.println("Food item not found.");
  }

  public void foodToTakeOutput(){
    System.out.println("Enter the name of the food item to remove:");
  }

  public void foodTakenOutput(){
    System.out.println("Food item taken out.");
  }

  public void foodNotTakenOutput(){
    System.out.println("Food item not found.");
  }
  public void exit(){
    System.out.println("Goodbye...");
  }


}
