package edu.ntnu.idi.bidata.recipebook;

import edu.ntnu.idi.bidata.recipe.Recipes;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Represents the Recipe book.
 *
 * <p>{@code RecipeStorage} is a class used to store alle the recipes.
 * The class interacts with {@link Recipes} objects and stores them.
 * This class allows the user add, remove and get the name of the recipe.</p>
 *
 * @since 0.0.1
 * @author Arpit Sahoo
 * @version 0.0.6
 */
public class RecipeStorage {
  private final Map<String, Recipes> recipesMap;

  /**
   * Constructs a {@code RecipeStorage} instance and initializes the recipes Map.
   *
   * <p>This constructor initializes the {@code recipesMap} as a new {@link HashMap}.
   * </p>
   */
  public RecipeStorage() {
    recipesMap = new HashMap<>();
  }

  /**
   * Adds a recipe to the recipe book.
   *
   * <p>If the recipe is already in the recipe book (based on its name)
   * the method does not add the recipe.
   * If the food item is not found in the recipe book,
   * the recipe will be added as a new entry.</p>
   *
   * @param newRecipe the {@link Recipes} to be added or updated in the fridge
   * @return wasAdded, if {@code true} the recipe was added. If {@code false}
   * food was not added.
   */
  public boolean addRecipe(Recipes newRecipe) {
    boolean waAdded = false;
    if (!recipesMap.containsKey(newRecipe.getNameOfRecipe())) {
      recipesMap.put(newRecipe.getNameOfRecipe(), newRecipe);
      waAdded = true;
    }
    return waAdded;
  }

  /**
   * Removes recipe from the recipe book.
   *
   * <p>Removes recipe from recipe book if it exists in the recipe book.
   * Compares the name prompted and checks for a similar recipe.
   * </p>
   * @param recipeName is the name of the recipe.
   * @return wasRemoved is {@code false} till removed, then {@code true}.
   */
  public boolean removeRecipe(String recipeName) {
    boolean wasRemoved = false;
    if (recipesMap.containsKey(recipeName)) {
      recipesMap.remove(recipeName);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  /**
   * Gets the name of the recipe from the recipe book.
   *
   * @param recipeName the name of the recipe.
   * @return the name of the recipe.
   */
  public Recipes getRecipe(String recipeName) {
    return recipesMap.get(recipeName); // allows the other method get the name of the recipe
  }

  /**
   * Gets an iterator over the recipe book.
   *
   * @return recipes from recipe book to iterator in alphabetical order.
   */
  public Iterator<String> getRecipeNamesAlphabeticalOrder() {
    return recipesMap.keySet()
        .stream()
        .sorted(String::compareToIgnoreCase)
        .iterator();
  }

}
