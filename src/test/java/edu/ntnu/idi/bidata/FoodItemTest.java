package edu.ntnu.idi.bidata;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.time.LocalDate; // Import LocalDate
class FoodItemTest {

    static FoodItem foodItemTest;

    @BeforeAll
    static void BeforeAll()
    {
        System.out.println("Before all run");
        // Arrange
        LocalDate expiryDate = LocalDate.of(2024, 10, 20); // Correct date format

        foodItemTest = new FoodItem("milk", 7f, "liters", 20.0, expiryDate);
        // Other arrange
    }

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
    @Test
    void setAmountTestForNegativeValuesTwo(){
        LocalDate expiryDate = LocalDate.of(2024, 10, 20); // Correct date format

        foodItemTest = new FoodItem("milk", -7f, "liters", 20.0, expiryDate);
    }
    @Test
    void setAmountTestForPositiveValues(){
        LocalDate expiryDate = LocalDate.of(2024, 10, 20); // Correct date format

        foodItemTest = new FoodItem("milk", 20f, "liters", 20.0, expiryDate);
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


    @Test
    void setPriceTestForNegativeValuesTwo(){
        LocalDate expiryDate = LocalDate.of(2024, 10, 20); // Correct date format

        foodItemTest = new FoodItem("milk", 7f, "liters", -20.0, expiryDate);
    }
    @Test
    void setPriceTestForPositiveValues(){
        LocalDate expiryDate = LocalDate.of(2024, 10, 20); // Correct date format

        foodItemTest = new FoodItem("milk", 7f, "liters", 20.0, expiryDate);
    }
}