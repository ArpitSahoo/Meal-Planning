package edu.ntnu.idi.bidata.recipebook;


import edu.ntnu.idi.bidata.recipe.Recipes;

import java.util.HashMap;
import java.util.Map;

public class RecipeStorage {
    private final Map<String, Recipes> recipesMap;

    public RecipeStorage() {
        recipesMap = new HashMap<>();
    }

}
