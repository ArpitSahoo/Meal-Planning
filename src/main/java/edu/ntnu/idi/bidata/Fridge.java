package edu.ntnu.idi.bidata;

import edu.ntnu.idi.bidata.food.FoodItem;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class Fridge {
  private final List<FoodItem> items;

  /**
   * A constructor that creat a new fridge arraylist.
   * Creates Scanner.
   */
  private Fridge() {
    items = new ArrayList<>();
  }

  public void addFood(FoodItem item){
    items.add(item);
  }

  public boolean removeFood(String foodName) {
    Iterator<FoodItem> iterator = items.iterator();
    while (iterator.hasNext()) {
      FoodItem food = iterator.next();
      if (food.getNameOfFood().equalsIgnoreCase(foodName)) {
        iterator.remove();
        return true;
      }
    }
    return false;
  }



}
