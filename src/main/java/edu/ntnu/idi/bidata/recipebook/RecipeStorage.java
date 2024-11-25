package edu.ntnu.idi.bidata.recipebook;

import edu.ntnu.idi.bidata.recipe.Recipes;
import java.util.HashMap;
import java.util.Map;

/**
 * represents the Recipe book.
 * @version 0.0.2
 */
public class RecipeStorage {
    private final Map<String, Recipes> recipesMap;

    public RecipeStorage() {
        recipesMap = new HashMap<>();
    }

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

    public Recipes getRecipe(String recipeName) {
        return recipesMap.get(recipeName);
    }


}
