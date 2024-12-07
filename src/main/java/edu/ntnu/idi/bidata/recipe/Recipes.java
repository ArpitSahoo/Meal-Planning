package edu.ntnu.idi.bidata.recipe;

import edu.ntnu.idi.bidata.food.FoodItem;
import edu.ntnu.idi.bidata.recipebook.RecipeStorage; //imported for documentation.
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Represents a recipe.
 *
 * <p>{@code Recipes}class is used to store relevant information about a specific Recipes.
 *  Allows the user to set and retrieve information about the recipe.
 *  It also communicates with the {@link RecipeStorage}
 *  and {@link FoodItem}.</p>
 *
 * @since 0.0.1
 * @author Arpit Sahoo
 * @version 0.0.8
 */
public class Recipes {
  private String nameOfRecipe;
  private String description;
  private String steps;
  private Integer portion;
  private final List<FoodItem> ingredients;

  /**
   *A constructor for the class {@code Recipes}.
   *
   * <p>ingredients is initialized the ingredients as a {@link ArrayList}</p>
   *
   * @param nameOfRecipe of the recipe.
   * @param description of the recipe.
   * @param steps to make the recipe.
   */
  public Recipes(String nameOfRecipe, String description, String steps, int portion) {
    setNameOfRecipe(nameOfRecipe);
    setDescription(description);
    setSteps(steps);
    setPortion(portion);
    this.ingredients = new ArrayList<>();
  }

  /**
   * Access the name of the recipe.
   *
   * @return nameOfRecipe.
   */
  public String getNameOfRecipe() {
    return nameOfRecipe;
  }

  /**
   * Mutates the name of the recipe.
   *
   * @param nameOfRecipe the name of the recipe.
   * @throws IllegalArgumentException if nameOfRecipe is null, empty or blank.
   */
  public void setNameOfRecipe(String nameOfRecipe) {
    if (nameOfRecipe == null || nameOfRecipe.isEmpty() || nameOfRecipe.isBlank()) {
      throw new IllegalArgumentException("Recipe name cannot be blank");
    }
    this.nameOfRecipe = nameOfRecipe;
  }

  /**
   * Access the description of the recipe.
   *
   * @return description.
   */
  public String getDescription() {
    return description;
  }

  /**
   * Mutates the description of the recipe.
   *
   * @param description the description of the recipe.
   * @throws IllegalArgumentException if description is null, empty or blank.
   */
  public void setDescription(String description) {
    if (description == null || description.isEmpty() || description.isBlank()) {
      throw new IllegalArgumentException("Recipe description cannot be blank");
    }
    this.description = description;
  }

  /**
   * Access the steps to make the recipe.
   *
   * @return steps.
   */
  public String getSteps() {
    return steps;
  }

  /**
   * Mutates the steps to make the recipe.
   *
   * @param steps the steps to make the recipe.
   * @throws IllegalArgumentException if steps is null, empty or blank.
   */
  public void setSteps(String steps) {
    if (steps == null || steps.isEmpty() || steps.isBlank()) {
      throw new IllegalArgumentException("Recipe steps cannot be blank");
    }
    this.steps = steps;
  }

  /**
   * Access the portion of the recipe.
   * @return portion.
   */
  public int getPortion() {
    return portion;
  }

  /**
   * Mutates the portion for the recipe.
   *
   * @param portion the portion for the recipe.
   * @throws IllegalArgumentException if the portion is lower than 0
   * or bigger than 100.
   */
  public void setPortion(int portion) {
    if (portion <= 0  || portion > 100) {
      throw new IllegalArgumentException("Portion must be between 0 and 100");
    }
    this.portion = portion;
  }

  /**
   * Gets the ingredients for the recipe.
   *
   * @return ingredients as an iterator for the recipe.
   */
  public Iterator<FoodItem> getIngredients() {
    return ingredients.iterator();
  }

  /**
   * Adds ingredients to the recipe.
   *
   * @param name of the {@code FoodItem}.
   * @param amount of the {@code FoodItem}.
   * @param unit of the {@code FoodItem}.
   * @throws IllegalArgumentException if name is null, blank or empty.
   * @throws IllegalArgumentException if amount is 0 or lower.
   * @throws IllegalArgumentException if unit is null, blank or empty.
   */
  public void addIngredient(String name, Float amount, String unit) {
    ingredients.add(new FoodItem(name, amount, unit));
  }
}
