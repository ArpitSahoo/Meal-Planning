package edu.ntnu.idi.bidata.recipe;
/**

 *
 * @version 0.0.1
 */


public class Recipes {
    private String nameOfRecipe;
    private String description;
    private String steps;
    private String ingredients;

    public Recipes(String nameOfRecipe, String description, String steps, String ingredients) {
        setNameOfRecipe(nameOfRecipe);
        setDescription(description);
        setSteps(steps);
        setIngredients(ingredients);
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

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getIngredients() {
        return ingredients;
    }
}
