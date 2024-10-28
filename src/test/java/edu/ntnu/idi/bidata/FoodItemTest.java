package edu.ntnu.idi.bidata;

import static org.junit.jupiter.api.Assertions.*;

import edu.ntnu.idi.bidata.food.FoodItem;
import org.junit.jupiter.api.*;
import java.time.LocalDate; // Import LocalDate
class FoodItemTest {

    static FoodItem foodItemTest;

    /**
     * Arrange
     * act
     * assert
     *
     *
     * assertEquals
     * assertThrows
     */

    @BeforeEach
    void BeforeEach()
    {
        System.out.println("Before all each");
        // Arrange
        LocalDate expirationDate = LocalDate.of(2025, 10, 20);

        foodItemTest = new FoodItem("milk", 7f, "liters", 20.0, expirationDate);
        // Other arrange
    }

    @Test
    void testConstructorAndGetters() {
        LocalDate expirationDate = LocalDate.of(2025, 12, 20);
        FoodItem food = new FoodItem("Milk", 1.0f, "liter", 1.50, expirationDate);

        assertEquals("Milk", food.getNameOfFood());
        assertEquals(1.0f, food.getAmount());
        assertEquals("liter", food.getUnits());
        assertEquals(1.50, food.getPrice());
        assertEquals(expirationDate, food.getExpirationDate());
    }

    @Test
    void setNameOfFoodTestForEmptyString() {
        LocalDate expirationDate = LocalDate.of(2025, 12, 20);
        FoodItem food = new FoodItem("milk", 1.0f, "liter", 1.50, expirationDate);
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
    void setAmountTestForNegativeValues() {
        LocalDate expirationDate = LocalDate.of(2025, 12, 20);
        assertThrows(IllegalArgumentException.class, () -> {
            new FoodItem("Milk", -1.0f, "liter", 1.50, expirationDate);
        });
    }

    @Test
    void setAmountTestForPositiveValues() {
        LocalDate expirationDate = LocalDate.of(2025, 10, 20);
        FoodItem food = new FoodItem("Milk", 1.0f, "liter", 1.50, expirationDate);
        assertEquals(1.0f, food.getAmount());
    }



    @Test
    void setPriceTestForNegativeValuesTwo(){
        LocalDate expirationDate = LocalDate.of(2025, 12, 20);
        assertThrows(IllegalArgumentException.class, () -> {
            new FoodItem("Milk", 1.0f, "liter", -1.50, expirationDate);
        });
    }

    @Test
    void setPriceTestForPositiveValues() {
        LocalDate expirationDate = LocalDate.of(2025, 10, 20);
        FoodItem food = new FoodItem("Milk", 1.0f, "liter", 1.50, expirationDate);
        assertEquals(1.50, food.getPrice());
    }

    @Test
    void setExpirationDateTestBeforeExpiration() {
        LocalDate newExpiryDate = LocalDate.of(2025, 10, 20);

        // Create FoodItem with a valid future expiration date
        FoodItem foodDate = new FoodItem("milk", 7f, "liters", 10.0, newExpiryDate);

        // Assert that the expiration date is set correctly
        assertEquals(newExpiryDate, foodDate.getExpirationDate(), "The expiration date should be set to 2025-10-20");
    }

    @Test
    void setExpirationDateTestInPastThrowsException() {
        LocalDate pastDate = LocalDate.of(2020, 1, 1);

        // Verify that creating a FoodItem with a past date throws an exception
        assertThrows(IllegalArgumentException.class, () ->
                new FoodItem("milk", 7f, "liters", 10.0, pastDate)
        );
    }

    //TODO NY tester for dato
}

