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
  private Fridge() {
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

  public boolean removeFood(FoodItem foodToRemove){
    boolean foodFound = false;
    String nameOfFood = foodToRemove.getNameOfFood();
    if(fridgeRegister.containsKey(nameOfFood)){
      FoodItem foodStored = fridgeRegister.get(nameOfFood);
      if(foodStored.equals(foodToRemove)){
        fridgeRegister.remove(foodToRemove);
        foodFound = true;
      }
    }
    return foodFound;
  }

  public boolean takeOutItem(FoodItem foodToTake){
    boolean foodFound = false;
    String nameOfFood = foodToTake.getNameOfFood();
    if(fridgeRegister.containsKey(nameOfFood)){
      FoodItem foodStored = fridgeRegister.get(nameOfFood);
      if(foodStored.equals(foodToTake)){

      }

    }


    return foodFound;
  }






}
