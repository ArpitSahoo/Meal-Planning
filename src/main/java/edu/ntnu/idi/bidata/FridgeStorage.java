package edu.ntnu.idi.bidata;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class FridgeStorage {
  private final Map<String, FoodItem> fridgeRegister;

  /**
   * Constructs a {@code FridgeStorage} instance and initializes the fridge register.
   *
   * <p>This constructor initializes the {@code fridgeRegister} as a new {@link HashMap} and
   * calls the {@code init} method to add predefined food items to the fridge.
   * </p>
   */
  public FridgeStorage() {
    fridgeRegister = new HashMap<>();
    init();
  }

  /**
   * Adds a food item to the fridge or updates its amount if it already exists.
   *
   * <p>If the food item is already present in the fridge (based on its name), this method updates
   * the amount by adding the new quantity to the existing amount. If the food item is not found, it
   * is added as a new entry in the fridge.</p>
   *
   * @param foodToBeAdded the {@link FoodItem} to be added or updated in the fridge
   */
  public void addFoodItem(FoodItem foodToBeAdded) {
    if (fridgeRegister.containsKey(foodToBeAdded.getNameOfFood())) {
      float oldAmount = fridgeRegister.get(foodToBeAdded.getNameOfFood()).getAmount();
      float newAmount = oldAmount + foodToBeAdded.getAmount();
      fridgeRegister.get(foodToBeAdded.getNameOfFood()).setAmount(newAmount);
    } else {
      fridgeRegister.put(foodToBeAdded.getNameOfFood(), foodToBeAdded);
    }
  }

  /**
   * Removes a food item in the fridge.
   * <p>This method checks if the specified {@code FoodItem} is already present in the fridge (based on its name).
   * if the food item is found it will remove the food from the fridge. If not the return will be {@code false}.
   * </p>
   * @param foodToBeRemoved the {@code FoodItem} to be removed.
   * @return {@code true} if the food item was found and removed.
   *         {@code false} otherwise.
   */
  public boolean removeFoodItem(FoodItem foodToBeRemoved) {
    boolean wasFoodFound = false;
    if (fridgeRegister.containsKey(foodToBeRemoved.getNameOfFood())) {
      fridgeRegister.remove(foodToBeRemoved.getNameOfFood());
      wasFoodFound = true;
    }
    return wasFoodFound;
  }

  /**
   * Takes out a specified amount of a food item from the fridge.
   *
   * <p>This method checks if the specified {@code FoodItem} is present in the fridge (based on its name).
   * If the food item is found, it removes the specified amount from the fridge. If the amount becomes
   * 0 or less after the operation, the food item is removed from the fridge entirely. If the food item
   * is not found, the method returns {@code false}.</p>
   *
   * @param foodToBeTaken the {@code FoodItem} to be removed from the fridge.
   * @return {@code true} if the food item was found and the amount was successfully removed,
   *         {@code false} otherwise.
   */
  public boolean foodToTake(FoodItem foodToBeTaken) {
    boolean wasFoodFound = false;
    if (fridgeRegister.containsKey(foodToBeTaken.getNameOfFood())) {
      float oldAmount = fridgeRegister.get(foodToBeTaken.getNameOfFood()).getAmount();
      float newAmount = oldAmount - foodToBeTaken.getAmount();
      if (newAmount <= 0) {
        fridgeRegister.remove(foodToBeTaken.getNameOfFood());
      }
      else{
        fridgeRegister.get(foodToBeTaken.getNameOfFood()).setAmount(newAmount);
      }
      wasFoodFound = true;
    }
    return wasFoodFound;
  }

  /**
   * searches a specific food by its name.
   * @param foodName name of the food.
   * @return fridgeRegister.get(foodName);
   */
  public FoodItem searchFoodByName(String foodName) {
    return fridgeRegister.get(foodName);
  }

  /**
   * Searches for a food item by its expiration date.
   * @param expirationDate expiration date of the food.
   * @return The FoodItem with the specified expiration date, or null if no such item is found.
   */
  public FoodItem searchFoodByDate(LocalDate expirationDate) {
    for (Map.Entry<String, FoodItem> entry : fridgeRegister.entrySet()){
      FoodItem food = entry.getValue();
      if (food.getExpirationDate().equals(expirationDate)) {
        return food;
      }
    }
    return null;
  }



  /**
   * Gets an iterator over the HashMap entries
   * @return fridgeRegister.entrySet().iterator();
   */
  public Iterator<Map.Entry<String, FoodItem>> getIterator() {
    return fridgeRegister.entrySet().iterator();
  }

  /**
   * Gets an iterator over the HashMap entries.
   * @return fridgeRegister.keySet().stream().sorted(String::compareToIgnoreCase).iterator();
   */
  public Iterator<String> getIteratorAlphabetical(){
    return fridgeRegister.keySet().stream().sorted(String::compareToIgnoreCase).iterator();
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
    LocalDate expirationDate = LocalDate.of(2025, 12, 12);
    LocalDate expirationDate2 = LocalDate.of(2025, 1, 20);
    FoodItem apple = new FoodItem("apple", 20f, "kg", 5.0, expirationDate);
    FoodItem banana = new FoodItem("banana", 10f, "kg", 5.0, expirationDate);
    FoodItem milk = new FoodItem("milk", 2f, "kg", 20.0, expirationDate2);
    FoodItem chicken = new FoodItem("chicken", 1f, "kg", 140.0, expirationDate2);
    fridgeRegister.put(apple.getNameOfFood(), apple);
    fridgeRegister.put(banana.getNameOfFood(), banana);
    fridgeRegister.put(milk.getNameOfFood(), milk);
    fridgeRegister.put(chicken.getNameOfFood(), chicken);
  }




}
