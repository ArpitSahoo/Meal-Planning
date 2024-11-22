package edu.ntnu.idi.bidata.fridge;
import edu.ntnu.idi.bidata.food.FoodItem;

import java.time.LocalDate;
import java.util.*;

/**
 * Represents the fridge.
 *
 * <p>{@code FridgeStorage} is a class used to store alle the food item.
 * The class interacts with {@link FoodItem} objects and stores them.
 * this class allows the user add, remove, take, find and display all the food items
 * stored in the fridge.
 * It also handles the validation and organization of food items, ensuring they are managed in an
 * efficiently.</p>
 * </p>
 *
 * @author Arpit Sahoo
 * @version 0.0.2
 *
 */

public class FridgeStorage {
  private final Map<String, FoodItem> fridgeRegister;

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
   *          {@code false} if the food was not added.
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
      //TODO find a method that makes sure that if the old amount.
      // to take out is to big, the user hase to choose another another amount
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
   *
   * @param foodName name of the food.
   * @return fridgeRegister.get(foodName);
   */
  public FoodItem searchFoodByName(String foodName) {
    return fridgeRegister.get(foodName);
  }



  public List<FoodItem> searchByDate(LocalDate expirationDate) {
    List<FoodItem> foodList = new ArrayList<>();
    for (Map.Entry<String, FoodItem> entry : fridgeRegister.entrySet()) {
      FoodItem food = entry.getValue();
      if (food.getExpirationDate().equals(expirationDate)) {
        foodList.add(food);
      }
    }
    return foodList; // Always returns a list, possibly empty.
  }


  /**
   * Gets an iterator over the HashMap entries.
   *
   * @return fridgeRegister.entrySet().iterator();
   */
  public Iterator<Map.Entry<String, FoodItem>> getIterator() {
    return fridgeRegister.
            entrySet().
            iterator();
  }

  /**
   * Gets an iterator over the HashMap entries.
   *
   * @return fridgeRegister.keySet().stream().sorted(String::compareToIgnoreCase).iterator();
   */
  public Iterator<String> getIteratorAlphabetical(){
    return fridgeRegister.keySet().stream().sorted(String::compareToIgnoreCase).iterator();
  }
}
