package edu.ntnu.idi.bidata.recipe;

import edu.ntnu.idi.bidata.food.FoodItem;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Represents a recipe.
 *
 * @since 0.0.1
 * @author Arpit Sahoo
 * @version 0.0.5
 */


public class Recipes {
  private String nameOfRecipe;
  private String description;
  private String steps;
  private final ArrayList<FoodItem> ingredients;

  public Recipes(String nameOfRecipe, String description, String steps) {
    setNameOfRecipe(nameOfRecipe);
    setDescription(description);
    setSteps(steps);
    this.ingredients = new ArrayList<>();
  }

  public String getNameOfRecipe() {
    return nameOfRecipe;
  }

  public void setNameOfRecipe(String nameOfRecipe) {
    if (nameOfRecipe == null || nameOfRecipe.isEmpty() || nameOfRecipe.isBlank()) {
      throw new IllegalArgumentException("Recipe name cannot be blank");
    }
    this.nameOfRecipe = nameOfRecipe;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    if (description == null || description.isEmpty() || description.isBlank()) {
      throw new IllegalArgumentException("Recipe description cannot be blank");
    }
    this.description = description;
  }

  public String getSteps() {
    return steps;
  }

  public void setSteps(String steps) {
    if (steps == null || steps.isEmpty() || steps.isBlank()) {
      throw new IllegalArgumentException("Recipe steps cannot be blank");
    }
    this.steps = steps;
  }

  public Iterator<FoodItem> getIngredients() {
    return ingredients.iterator();
  }

  public void addIngredient(String name, Float amount, String unit) {
    if (name.isBlank() || name.isEmpty()) {
      throw new IllegalArgumentException("Recipe name cannot be blank");
    } else if (amount <= 0) {
      throw new IllegalArgumentException("Recipe amount cannot be negative or zero");
    } else if (unit == null || unit.isEmpty() || unit.isBlank()) {
      throw new IllegalArgumentException("Recipe unit cannot be blank");
    }
    ingredients.add(new FoodItem(name, amount, unit));
  }
}
