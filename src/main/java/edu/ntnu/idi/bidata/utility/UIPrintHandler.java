package edu.ntnu.idi.bidata.utility;
import edu.ntnu.idi.bidata.food.FoodItem;
import edu.ntnu.idi.bidata.recipe.Recipes;
import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Represents the output to the user.
 *
 * <p>The {@code UIPrintHandler} is responsible for managing all user-facing output.
 * It handles the command screen that allows the user to select a command in the
 * {@link UserInterface} class. Additionally, it displays food items in the correct
 * format and provides the user with necessary information.
 * </p>
 *
 * <p>This class ensures that the user interface remains clear and interactive by
 * formatting the output and guiding the user through actions and options.
 * </p>
 *
 * @author Arpit Sahoo
 * @version 0.0.5
 */


public class UIPrintHandler {

  public void choiceScreen() {
    System.out.println("\n--- Fridge ---");
    System.out.println("Choose 1, 2, 3, 4, 5 or 6: ");
    System.out.println("1. Add a food");
    System.out.println("2. Remove a food");
    System.out.println("3. Take out an item");
    System.out.println("4. Find food by name");
    System.out.println("5. Display all expired food");
    System.out.println("6. Display foods with a certain expiry date");
    System.out.println("7. Display fridge contents");
    System.out.println("8. Display fridge contents in an alphabetical order");
    System.out.println("9. Add a recipe to recipe book");
    System.out.println("10. Find a recipe by name");
    System.out.println("11. Exit");
    System.out.println("Choose a following number: ");
  }

  public void invalidChoice(){
    System.out.println("Invalid choice. Food item not added.");
  }

  public void nameOfFoodOutput(){
    System.out.print("Enter food name: ");
  }

  public void pricePerUnitOutput(){
    System.out.print("Enter the price per unit: ");
  }

  public void expirationDateOutput(){
    System.out.print("Enter expiration date (yyyy-MM-dd): ");
  }

  public void invalidExpirationDateOutput(){
    System.out.println("Invalid date format. Please enter in the format yyyy-MM-dd.");
  }

  public void foodAmountOutput(){
    System.out.print("Enter quantity (numeric value): ");
  }

  public void invalidFoodAmountOutput(){
    System.out.println("Invalid quantity. Please enter in the numeric value.");
  }

  public void invalidPriceOutput(){
    System.out.println("Invalid Price per unit. Please choose a positive number.");
  }
  public void choiceOfUnits() {
    System.out.println("Choose an unit (1, 2 or 3):");
    System.out.println("1. kg");
    System.out.println("2. liter");
    System.out.println("3. pieces");
  }

  public void invalidUnitChoice(){
    System.out.println("Invalid unit choice. Food item not added.");
  }

  /**
   * Prints all food items currently stored in the fridge along with their details.
   *
   * <p>This method iterates over each food item in the fridge and prints its details, including
   * the name, amount, unit, price per unit, and expiration date. After printing all food items,
   * it calculates and prints the total price of the items in the fridge.</p>
   *
   * @param foodIterator an iterator over the entries of food items stored in the fridge
   */
  public void printItFridge(Iterator<Map.Entry<String, FoodItem>> foodIterator) {
    double totalPrice = 0;
    System.out.println("\n--- Fridge Contents---");
    while (foodIterator.hasNext()) {
      Map.Entry<String, FoodItem> entry = foodIterator.next();
      FoodItem food = entry.getValue();
      printLocatedFood(food);
      totalPrice += food.getAmount() * food.getPricePerUnit();
    }
    System.out.println("The total price is: " + totalPrice +" kr");

  }

  /**
   * Prints all expired food items currently stored in the fridge along with their details.
   *
   * <p>This method iterates over each food item in the fridge. If the food item is expired,
   * it prints its details, including the name, amount, unit, price per unit, and expiration date.
   * After printing all expired items, it calculates and prints the total price of the expired items in the fridge.
   * If there are no expired items, it prints a message indicating that no expired food items were found.</p>
   *
   * @param foodIterator an iterator over the entries of food items stored in the fridge
   */
  public void printExpiredFood(Iterator<Map.Entry<String, FoodItem>> foodIterator){
    boolean hasExpiredItems = false;
    double totalPrice = 0;
    LocalDate currentDate = LocalDate.now();
    while (foodIterator.hasNext()){ // while loop that iterates with entrySet (OpenAI 2024)
      Map.Entry<String, FoodItem> entry = foodIterator.next();
      FoodItem food = entry.getValue();
      if(food.getExpirationDate() != null && food.getExpirationDate().isBefore(currentDate)){
        hasExpiredItems = true;
        printLocatedFood(food);
        totalPrice = food.getAmount() * food.getPricePerUnit();
      }
    }
    if (hasExpiredItems) {
      System.out.printf("Total cost of expired items: %.2f kr%n", totalPrice);
    } else {
      System.out.println("No expired food items found.");
    }
  }


  /**
   * Prints the details of a specific food item.
   *
   * <p>This method displays the details of a provided {@code FoodItem}, including its name, amount,
   * unit, price per unit, and expiration date.</p>
   *
   * @param food the {@code FoodItem} whose details are to be printed
   */
  public void printLocatedFood(FoodItem food){
      System.out.println("Name: " + food.getNameOfFood()
          + " | Amount: " + food.getAmount() + " " + food.getUnits()
          + " | Price per unit: " + food.getPricePerUnit()
          + " | Expiry: " + food.getExpirationDate()
      );
  }

  public void printLocatedRecipe(Recipes recipe) {
    System.out.println("Name:" + recipe.getNameOfRecipe() //Gets all the information of the Recipe.
            + " | Description: " + recipe.getDescription() //Formatted print.
            + " | Steps: " + recipe.getSteps()
            + " | Ingredients: "

    );
    Iterator<FoodItem> ingredients = recipe.getIngredients();
    while (ingredients.hasNext()) { //Recommended by ChatGPT 2024, Iterates through the list.
      FoodItem ingredient = ingredients.next();
      System.out.println("Name: " + ingredient.getNameOfFood() //Gets all the information of the ingredient from the list.
              + " | Amount: " + ingredient.getAmount() + " " + ingredient.getUnits() //Formatted print.

      );
    }
  }

  public void printLocatedExpiredFood(List<FoodItem> foodList) {
    if (foodList.isEmpty()) { // If statement recommended by OpenAI.
      System.out.println("No food items found with the specified expiration date.");
      return;
    }
    System.out.println("Matching food items:");
    for (FoodItem food : foodList) { //Partially recommended by OpenAI.
      printLocatedFood(food);
    }
  }



  /**
   * Prints the names of food items in alphabetical order.
   *
   * <p>This method iterates over a provided iterator of food names (assumed to be sorted alphabetically)
   * and prints each name to the console.</p>
   *
   * @param foodIterator an iterator over the sorted names of food items
   */
  public void printFoodAlphabetical(Iterator<String> foodIterator){
    while (foodIterator.hasNext()) {
      System.out.println(foodIterator.next());
    }
  }

  public void removeFoodOutput(){
    System.out.println("Enter the name of the food item to remove: ");
  }



  public void foodRemovedOutput(){
    System.out.println("Food item removed.");
  }

  public void foodNotFoundOutput(){
    System.out.println("Food item not found.");
  }

  public void foodToTakeOutput(){
    System.out.println("Enter the name of the food item to remove:");
  }

  public void foodTakenOutput(){
    System.out.println("Food item taken out.");
  }

  public void exit(){
    System.out.println("Goodbye...");
  }

  public void recipeNameOutput(){
    System.out.println("What is the name of the recipe?: ");
  }

  public void descriptionOutput(){
    System.out.println("What is the description?: ");
  }

  public void stepsOutput(){
    System.out.println("what are the steps to make it");
  }

  public void howManyIngredientsOutput(){
    System.out.println("How many ingredients?: ");
  }

  public void recipeNotFound(){
    System.out.println("Recipe not found.");
  }

}
