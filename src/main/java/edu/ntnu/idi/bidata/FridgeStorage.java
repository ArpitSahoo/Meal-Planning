package edu.ntnu.idi.bidata;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class FridgeStorage {
  private final Map<String, FoodItem> fridgeRegister;

  public FridgeStorage() {
    fridgeRegister = new HashMap<>();
    init();
  }


  public boolean addFoodItem(FoodItem foodToBeAdded) {
    boolean wasFoodFound = false;
    if (fridgeRegister.containsKey(foodToBeAdded.getNameOfFood())) {
      float oldAmount = fridgeRegister.get(foodToBeAdded.getNameOfFood()).getAmount();
      float newAmount = oldAmount + foodToBeAdded.getAmount();
      fridgeRegister.get(foodToBeAdded.getNameOfFood()).setAmount(newAmount);
      wasFoodFound = true;
    } else {
      fridgeRegister.put(foodToBeAdded.getNameOfFood(), foodToBeAdded);
    }
    return wasFoodFound;
  }

  public boolean removeFoodItem(FoodItem foodToBeRemoved) {
    boolean wasFoodFound = false;
    if (fridgeRegister.containsKey(foodToBeRemoved.getNameOfFood())) {
      fridgeRegister.remove(foodToBeRemoved.getNameOfFood());
      wasFoodFound = true;
    }
    return wasFoodFound;
  }

  public boolean FoodToTake(FoodItem foodToBeTaken) {
    boolean wasFoodFound = false;
    if (fridgeRegister.containsKey(foodToBeTaken.getNameOfFood())) {
      float oldAmount = fridgeRegister.get(foodToBeTaken.getNameOfFood()).getAmount();
      float newAmount = oldAmount - foodToBeTaken.getAmount();
      fridgeRegister.get(foodToBeTaken.getNameOfFood()).setAmount(newAmount);
      wasFoodFound = true;
      if (fridgeRegister.get(foodToBeTaken.getNameOfFood()).getAmount() <= 0) {
        fridgeRegister.remove(foodToBeTaken.getNameOfFood());
      }
    }
    //TODO må lage en print
    return wasFoodFound;
  }


  public void displayExpiredItemsAndTotalCost() {
    LocalDate currentDate = LocalDate.now();
    double totalExpiredCost = 0;

    System.out.println("\n--- Expired Food Items ---");
    System.out.printf("%-20s %-10s %-10s %-10s %-15s%n", "Food Name", "Quantity", "Units", "Price", "Expiration Date");

    boolean hasExpiredItems = false;
    for (Map.Entry<String, FoodItem> entry : fridgeRegister.entrySet()) {
      FoodItem item = entry.getValue();
      if (item.getExpirationDate() != null && item.getExpirationDate().isBefore(currentDate)) {
        hasExpiredItems = true;
        System.out.printf(
            "%-20s %-10.2f %-10s %-10.2f %-15s%n",
            item.getNameOfFood(),
            item.getAmount(),
            item.getUnits(),
            item.getPricePerUnit(),
            item.getExpirationDate().toString()
        );
        totalExpiredCost += item.getAmount() * item.getPricePerUnit();
      }
    }
    if (hasExpiredItems) {
      System.out.printf("Total cost of expired items: %.2f kr%n", totalExpiredCost);
    } else {
      System.out.println("No expired food items found.");
    }
  }

  private void init() {
    LocalDate expirationDate = LocalDate.of(2025, 10, 20);
    FoodItem apple = new FoodItem("Apple", 20f, "kg", 5.0, expirationDate);
    FoodItem banana = new FoodItem("Banana", 10f, "kg", 5.0, expirationDate);
    fridgeRegister.put(apple.getNameOfFood(), apple);
    fridgeRegister.put(banana.getNameOfFood(), banana);
  }

  /**
   * Gets an iterator over the HashMap entries
   * @return fridgeRegister.entrySet().iterator();
   */
  public Iterator<Map.Entry<String, FoodItem>> getIterator() {
    return fridgeRegister.entrySet().iterator();
  }
}
