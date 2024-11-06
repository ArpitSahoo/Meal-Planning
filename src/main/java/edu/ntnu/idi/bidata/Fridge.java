package edu.ntnu.idi.bidata;

import edu.ntnu.idi.bidata.food.FoodItem;
import java.util.HashMap;
import java.util.*;


public class Fridge {
  private final Map<String, FoodItem> fridgeRegister;

  /**
   * A constructor that creat a new fridge arraylist.
   * Creates Scanner.
   */
  public Fridge() {
    fridgeRegister = new HashMap<>();
  }

  public boolean addFoodItem(FoodItem foodToBeAdded){
    boolean wasFoodAdded = false;
    String nameOfFood = foodToBeAdded.getNameOfFood();
    if(fridgeRegister.containsKey(nameOfFood)){
      FoodItem found = fridgeRegister.get(nameOfFood);
      if(found.validToMerge(foodToBeAdded)){
        found.mergeFood(foodToBeAdded);
      }
    }
    else {
      fridgeRegister.put(nameOfFood, foodToBeAdded); // Add new food to the register
      wasFoodAdded = true; // Food was added as new
    }
    return wasFoodAdded;

  }

  public boolean removeFoodItem(FoodItem foodToRemove){
    boolean wasFoodRemoved = false;
    String nameOfFood = foodToRemove.getNameOfFood();
    if(!fridgeRegister.containsKey(nameOfFood)){
      System.out.println("Food does not exist in the fridge.");
    }
    else{
      fridgeRegister.remove(nameOfFood);
      System.out.println("Removed " + nameOfFood + " from the fridge.");
      wasFoodRemoved = true;
    }
    return wasFoodRemoved;
  }

  public boolean takeOutItem(FoodItem foodToTake){
    boolean wasFoodExtracted = false;
    String nameOfFood = foodToTake.getNameOfFood();
    FoodItem found = fridgeRegister.get(nameOfFood);
    if(fridgeRegister.containsKey(nameOfFood)){
      if (found.validToTake(foodToTake)) {
        wasFoodExtracted = true;
        System.out.println("Successfully removed " + foodToTake.getAmount() + " of " + nameOfFood);
      } else {
        System.out.println("Not enough quantity to remove.");
      }
    }
    else{
      System.out.println("Food does not exist in the fridge.");
    }
    return wasFoodExtracted;
  }

}
