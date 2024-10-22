package edu.ntnu.idi.bidata;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import static java.lang.System.*;

/**
 * The main starting point of your application. Let this class create the
 * instance of your main-class that starts your application.
 *
 * @author Arpit Sahoo
 * @version 0.0.1
 */


public class FridgeApp {
    public ArrayList<FoodItem> fridge = new ArrayList<>();
    public Scanner scanner;

    /**
     * A constructor that creat a new fridge arraylist.
     * Creates Scanner
     */
    public FridgeApp(){
        fridge = new ArrayList<>();
        scanner = new Scanner(in);
    }

    /**
     * A function that keeps the program running
     * Print's out different commands
     * Switch case to choose
     */
    public void run(){
        boolean running = true;

        while (running){
            out.println("\n--- Fridge Management ---");
            out.println("1. Add food");
            out.println("2. Remove food");
            out.println("3. Display fridge contents");
            out.println("4. Check for expired food");
            out.println("5. Exit");
            out.println("Choose a following number: ");


            int chosen = scanner.nextInt();
            scanner.nextLine();

            switch(chosen){
                case 1:
                    addFoodItem();
                    break;
                case 2:
                    removeFoodItem();
                    break;
                case 3:
                    displayFridge();
                    break;
                case 4:
                    checkExpiredFood();
                    break;
                case 5:
                    running = false;
                    out.println("System ending...");
                    out.println("Goodbye....");
                    break;
                default:
                    out.println("Invalid choice. Please try again.");
            }
        }



    }

    /**
     * Function to add food
     * Switch case to choose units
     * IllegalArgumentException argument to catch illegalArgument
     */
    public void addFoodItem(){
        try{
            out.print("Hva is the name of the food: ");
            String nameOfFood = scanner.nextLine();

            out.println("What is the quantity: ");
            Float amount = scanner.nextFloat();

            out.println("Choose an unit (1, 2, 3 or 4):");
            out.println("1. kg");
            out.println("2. liter");
            out.println("3. gram");
            out.println("4. pieces");

            out.println("Which unit is the food?: ");
            int unitChosen = scanner.nextInt();

            String units;
            switch (unitChosen){
                case 1:
                    units = "kg";
                    break;
                case 2:
                    units = "liter";
                    break;
                case 3:
                    units = "gram";
                    break;
                case 4:
                    units = "stk";
                    break;
                default:
                    out.println("Invalid unit choice. Food item not added.");
                    return;
            }

            out.println("What is the price of the food");
            Double price = scanner.nextDouble();


            out.print("Enter expiration date (yyyy-MM-dd): ");
            String expiration = scanner.next();
            LocalDate expirationDate = LocalDate.parse(expiration, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

            FoodItem food = new FoodItem(nameOfFood, amount, units, price, expirationDate);
            fridge.add(food);
            out.print("Food added:" + food.displayFoodItem());
        }
        catch(IllegalArgumentException illegalArgument){
            out.println(illegalArgument.getMessage());
        }

    }

    /**
     * Function to remove food Item.
     * For-each-loop to find the food in the fridge arraylist.
     */
    public void removeFoodItem(){
        out.println("What do you want to remove?: ");
        String nameOfFood = scanner.nextLine();

        for(int i = 0; i < fridge.size(); i++){
            if(fridge.get(i).getNameOfFood().equalsIgnoreCase(nameOfFood)){
                fridge.remove(i);
                out.println("Removed food: " + nameOfFood);
            }
        }

    }

    /**
     * Function to display food.
     * If-statement to see if fridge is empty.
     * Else-statement to go through the whole list.
     * Calculate the total food price.
     */
    public void displayFridge(){
        out.println("\n--- Fridge Contents ---");
        if(fridge.isEmpty()){
            out.println("The fridge is empty.");
        }
        else{
            double totalPrice = 0;
            for(FoodItem food : fridge){
                out.println(food.displayFoodItem());
                totalPrice += food.getPrice();
            }
            out.println("Total price of all items in the fridge: " + totalPrice);
        }
    }

    /**
     * Function that checks for expired food.
     * For-each-loop checks trough whole fridge arraylist.
     * Calculates and print the name and total price.
     */
    public void checkExpiredFood(){
        out.println("\n--- Expired Food ---");
        LocalDate currentDate = LocalDate.now();
        double totalPrice = 0;
        for(FoodItem food : fridge){
            if(food.getExpirationDate().isBefore(currentDate)){
               out.print(food.getNameOfFood() + " has expired.");
               totalPrice += food.getPrice();
            }
            else{
                out.println("There are no expired food");
            }
        }
        out.println("Total price of expired food is: " + totalPrice + "kr");
    }

    /**
     * Main function that runs the FridgeApp.
     * @param args FridgeAPP
     */
    public static void main(String[] args) {
        FridgeApp app = new FridgeApp();
        app.run();
    }

}
