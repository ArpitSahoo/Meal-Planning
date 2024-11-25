package edu.ntnu.idi.bidata.recipebook;

import edu.ntnu.idi.bidata.recipe.Recipes;
import java.util.HashMap;
import java.util.Map;

/**
 * Represents the Recipe book.
 *
 * <p>{@code RecipeStorage} is a class used to store alle the recipes.
 * The class interacts with {@link Recipes} objects and stores them.
 * This class allows the user add, remove and get the name of the recipe.</p>
 *
 * @author Arpit Sahoo
 * @version 0.0.2
 * @since 0.0.1
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
     * @return {@code true} if the recipe was added.
     * {@code false} if the recipe was not added.
     */
    public boolean addRecipe(Recipes newRecipe) {
        boolean wasAdded;
        if (recipesMap.containsKey(newRecipe.getNameOfRecipe())) {
            wasAdded = false;
        } else {
            recipesMap.put(newRecipe.getNameOfRecipe(), newRecipe);
            wasAdded = true;
        }
        return wasAdded;
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


}
