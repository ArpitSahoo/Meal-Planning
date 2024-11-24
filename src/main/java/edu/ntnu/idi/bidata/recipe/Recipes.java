package edu.ntnu.idi.bidata.recipe;

import edu.ntnu.idi.bidata.food.FoodItem;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @version 0.0.2
 */


public class Recipes {
    private String nameOfRecipe;
    private String description;
    private String steps;
    private final ArrayList<FoodItem>ingredients;

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
        this.nameOfRecipe = nameOfRecipe;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSteps() {
        return steps;
    }

    public void setSteps(String steps) {
        this.steps = steps;
    }

    public Iterator<FoodItem> getIngredients() {
        return ingredients.iterator();
    }

    public void addIngredient(String name, Float amount, String unit) {
        ingredients.add(new FoodItem(name, amount, unit));

    }




}
