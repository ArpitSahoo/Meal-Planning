package edu.ntnu.idi.bidata;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

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

    public FridgeApp(){
        fridge = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void run(){
        boolean running = true;

        while (running){
            System.out.println("\n--- Fridge Management ---");
            System.out.println("1. Add food");
            System.out.println("2. Remove food");
            System.out.println("3. Display fridge contents");
            System.out.println("4. Check for expired food");
            System.out.println("5. Exit");
            System.out.println("Choose a following number: ");


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
                    CheckExpiredFood();
                case 5:
                    running = false;
                    System.out.println("Goodbye....");
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }



    }

    public void addFoodItem(){
        try{
            System.out.print("Hva is the name of the food: ");
            String nameOfFood = scanner.nextLine();

            System.out.println("What is the quantity: ");
            Float amount = scanner.nextFloat();

            System.out.println("Choose unit:");
            System.out.println("1. kg");
            System.out.println("2. liter");
            System.out.println("3. gram");
            System.out.println("4. pieces");

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
                    System.out.println("Invalid unit choice. Food item not added.");
                    return;
            }

            System.out.println("What is the price of the food");
            Double price = scanner.nextDouble();


            System.out.print("Enter expiration date (yyyy-MM-dd): ");
            String expiration = scanner.next();
            LocalDate expirationDate = LocalDate.parse(expiration, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

            FoodItem food = new FoodItem(nameOfFood, amount, units, price, expirationDate);
            fridge.add(food);
            System.out.print("Food added:" + food.displayFoodItem());
        }
        catch(IllegalArgumentException illegalArgument){
            System.out.println(illegalArgument.getMessage());
        }

    }

    public void removeFoodItem(){
        System.out.println("What do you want to remove?: ");
        String nameOfFood = scanner.nextLine();

        for(int i = 0; i < fridge.size(); i++){
            if(fridge.get(i).getNameOfFood().equalsIgnoreCase(nameOfFood)){
                fridge.remove(i);
                System.out.println("Removed food: " + nameOfFood);
            }
        }

    }

    public void displayFridge(){
        System.out.println("\n--- Fridge Contents ---");
        if(fridge.isEmpty()){
            System.out.println("The fridge is empty.");
        }
        else{
            double totalPrice = 0;
            for(FoodItem food : fridge){
                System.out.println(food.displayFoodItem());
                totalPrice += food.getPrice();
            }
            System.out.println("Total price of all items in the fridge: " + totalPrice);
        }
    }

    public void CheckExpiredFood(){

    }

    public static void main(String[] args) {
        FridgeApp app = new FridgeApp();
        app.run();
    }

}
