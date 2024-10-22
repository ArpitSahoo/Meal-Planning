package edu.ntnu.idi.bidata;

import static org.junit.jupiter.api.Assertions.*;

import edu.ntnu.idi.bidata.food.FoodItem;
import org.junit.jupiter.api.*;
import java.time.LocalDate; // Import LocalDate
class FoodItemTest {

    static FoodItem foodItemTest;

    @BeforeAll
    static void BeforeAll()
    {
        System.out.println("Before all run");
        // Arrange
        LocalDate expiryDate = LocalDate.of(2024, 10, 20);

        foodItemTest = new FoodItem("milk", 7f, "liters", 20.0, expiryDate);
        // Other arrange
    }

    @Test
    void testConstructorAndGetters() {
        LocalDate expirationDate = LocalDate.of(2025, 12, 31);
        FoodItem food = new FoodItem("Milk", 1.0f, "liter", 1.50, expirationDate);

        assertEquals("Milk", food.getNameOfFood());
        assertEquals(1.0f, food.getAmount());
        assertEquals("liter", food.getUnits());
        assertEquals(1.50, food.getPrice());
        assertEquals(expirationDate, food.getExpirationDate());
    }
    /*
    @org.junit.jupiter.api.Test
    void getNameOfFood() {
    }

    @org.junit.jupiter.api.Test
    void setNameOfFood() {
    }
        @org.junit.jupiter.api.Test
    void getAmount() {
    }

    @org.junit.jupiter.api.Test
    void setAmount() {
    }

        @org.junit.jupiter.api.Test
    void getUnits() {
    }


    @org.junit.jupiter.api.Test
    void setUnits() {
    }

    @org.junit.jupiter.api.Test
    void getExpirationDate() {
    }

    @org.junit.jupiter.api.Test
    void setExpirationDate() {
    }

    @org.junit.jupiter.api.Test
    void getPrice() {
    }

    @org.junit.jupiter.api.Test
    void setPrice() {
    }

    NEED TO FIND OUT IF I NEED THESE

     */

    @Test
    void setNameOfFoodTestForEmptyString() {
        foodItemTest.setNameOfFood("");
    }

    @Test
    void setNameOfFoodTestForNull() {
        foodItemTest.setNameOfFood(null);

    }

    @Test
    void setNameOfFoodTestForString() {
        foodItemTest.setNameOfFood("milk");

    }

    @Test
    void setAmountTestForNegativeValuesTwo(){
        LocalDate expiryDate = LocalDate.of(2024, 10, 20);

        foodItemTest = new FoodItem("milk", -7f, "liters", 20.0, expiryDate);
    }
    @Test
    void setAmountTestForPositiveValues(){
        LocalDate expiryDate = LocalDate.of(2024, 10, 20);

        foodItemTest = new FoodItem("milk", 20f, "liters", 20.0, expiryDate);
    }


    @Test
    void setPriceTestForNegativeValuesTwo(){
        LocalDate expiryDate = LocalDate.of(2024, 10, 20);

        foodItemTest = new FoodItem("milk", 7f, "liters", -20.0, expiryDate);
    }
    @Test
    void setPriceTestForPositiveValues(){
        LocalDate expiryDate = LocalDate.of(2024, 10, 20);

        foodItemTest = new FoodItem("milk", 7f, "liters", 20.0, expiryDate);
    }

    @Test
    void setExpirationDateTestBeforeExpiration(){
        LocalDate NewExpiryDate = LocalDate.of(2024, 10, 20);


        foodItemTest = new FoodItem("milk", 7f, "liters", 10.0, NewExpiryDate);

    }
    @Test
    void setExpirationDateTestIsCorrect(){
        LocalDate NewExpiryDate = LocalDate.of(2024, 10, 20);


        foodItemTest = new FoodItem("milk", 7f, "liters", 20.0, NewExpiryDate);

    }
}

