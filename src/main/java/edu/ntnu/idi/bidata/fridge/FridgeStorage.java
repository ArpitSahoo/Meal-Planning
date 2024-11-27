package edu.ntnu.idi.bidata.fridge;

import edu.ntnu.idi.bidata.food.FoodItem;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Represents the fridge.
 *
 * <p>{@code FridgeStorage} is a class used to store all the food item.
 * The class interacts with {@link FoodItem} objects and stores them.
 * This class allows the user add, remove, take, find and display all the food items
 * stored in the fridge.
 * It also handles the validation and organization of food items, ensuring they are managed in an
 * efficiently.</p>
 * </p>
 *
 * @since 0.0.1
 * @author Arpit Sahoo
 * @version 0.0.4
 *
 */

public class FridgeStorage {
  private final Map<String, FoodItem> fridgeRegister; //Allows the user

  /**
   * Constructs a {@code FridgeStorage} instance and initializes the fridge register.
   *
   * <p>This constructor initializes the {@code fridgeRegister} as a new {@link HashMap}.
   * </p>
   */
  public FridgeStorage() {
    fridgeRegister = new HashMap<>();
  }

  /**
   * Adds a food item to the fridge or updates its amount if it already exists.
   *
   * <p>If the food item is already present in the fridge (based on its name), this method updates
   * the amount by adding the new quantity to the existing amount. If the food item is not found, it
   * is added as a new entry in the fridge.</p>
   *
   * @param foodToBeAdded the {@link FoodItem} to be added or updated in the fridge
   * @return  {@code true} if the food item was added.
   *          {@code false} if the food item was not added.
   */
  public boolean addFoodItem(FoodItem foodToBeAdded) {
    boolean wasFoodAdded = false;
    if (fridgeRegister.containsKey(foodToBeAdded.getNameOfFood())) {
      float oldAmount = fridgeRegister.get(foodToBeAdded.getNameOfFood()).getAmount();
      float newAmount = oldAmount + foodToBeAdded.getAmount();
      fridgeRegister.get(foodToBeAdded.getNameOfFood()).setAmount(newAmount);
    } else {
      fridgeRegister.put(foodToBeAdded.getNameOfFood(), foodToBeAdded);
      wasFoodAdded = true;
    }
    return wasFoodAdded;
  }

  /**
   * Removes a food item in the fridge.
   *
   * <p>This method checks if the specified {@code FoodItem}
   * is already present in the fridge (based on its name).
   * if the food item is found it will remove the food from the fridge.
   * If not the return will be {@code false}.
   * </p>
   *
   * @param foodToBeRemoved the {@code FoodItem} to be removed.
   * @return {@code true} if the food item was found and removed.
   *         {@code false} otherwise.
   */
  public boolean removeFoodItem(String foodToBeRemoved) {
    boolean wasFoodFound = false;
    if (fridgeRegister.containsKey(foodToBeRemoved)) {
      fridgeRegister.remove(foodToBeRemoved);
      wasFoodFound = true;
    }
    return wasFoodFound;
  }

  /**
   * Removes a specified amount of a food item from the fridge.
   *
   * <p>This method checks if the specified {@code FoodItem}
   * exists in the fridge (based on its name and amount).
   * If the food item is found and the specified amount is smaller than or equal to the amount in
   * fridge, it reduces the quantity. If the remaining amount is 0 or less, the item is removed
   * entirely. If the item is not found or the amount exceeds the available quantity, the method
   * returns {@code false}.</p>
   *
   * <p>If the prompted amount to remove is bigger than amount in the fridge.
   * the food will not be touched.</p>
   *
   * @param foodToBeTaken the {@code FoodItem} to be removed from the fridge.
   * @return {@code true} if the food item was found and the amount was successfully removed,
   * {@code false} otherwise.
   */
  public boolean foodToTake(FoodItem foodToBeTaken) {
    boolean wasFoodFound = false;
    if (fridgeRegister.containsKey(foodToBeTaken.getNameOfFood())) {
      float oldAmount = fridgeRegister.get(foodToBeTaken.getNameOfFood()).getAmount();
      if (oldAmount > foodToBeTaken.getAmount()) {
        float newAmount = oldAmount - foodToBeTaken.getAmount();
        if (newAmount <= 0) {
          fridgeRegister.remove(foodToBeTaken.getNameOfFood());
        } else {
          fridgeRegister.get(foodToBeTaken.getNameOfFood()).setAmount(newAmount);
        }
        wasFoodFound = true;
      } else {
        return false;
      }
    }
    return wasFoodFound;
  }

  /**
   * searches a specific food by its name.
   *
   * @param foodName name of the food.
   * @return fridgeRegister.get(foodName);
   */
  public FoodItem searchFoodByName(String foodName) {
    return fridgeRegister.get(foodName);
  }


  /**
   * Searches food item by expiration date.
   *
   * <p>Goes trough the fridge and checks if there are any food items
   * specific expiration date. If found, the food gets added to the {@code foodList}.</p>
   *
   * @param expirationDate of the food item.
   * @return foodList a list with food items in the specific expiration date.
   */
  public List<FoodItem> searchByDate(LocalDate expirationDate) {
    List<FoodItem> foodList = new ArrayList<>(); // new list
    for (Map.Entry<String, FoodItem> entry : fridgeRegister.entrySet()) {
      FoodItem food = entry.getValue();
      if (food.getExpirationDate().equals(expirationDate)) {
        foodList.add(food); // Adds it to the list
      }
    }
    return foodList; // Always returns a list, possibly empty.
  }


  /**
   * Gets an iterator over the fridge entries.
   *
   * @return food items from fridge to iterator.
   */
  public Iterator<Map.Entry<String, FoodItem>> getIterator() {
    return fridgeRegister.entrySet(). // Sends key and value (OpenAI 2024).
            iterator(); //return an iterator because, you cant send a whole list to another class.
  }

  /**
   * Gets an iterator over the fridge entries.
   *
   * @return food items from fridge to iterator in alphabetical order.
   */
  public Iterator<String> getIteratorAlphabetical() {
    return fridgeRegister.keySet()
        .stream()
        .sorted(String::compareToIgnoreCase) //Streams it and sorts it and ignores casings.
        .iterator(); //return an iterator because, should not send a whole list to another class.
  }
}
