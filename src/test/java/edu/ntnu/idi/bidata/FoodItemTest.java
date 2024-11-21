package edu.ntnu.idi.bidata;

import static org.junit.jupiter.api.Assertions.*;

import edu.ntnu.idi.bidata.food.FoodItem;
import org.junit.jupiter.api.*;
import java.time.LocalDate; // Import LocalDate
class FoodItemTest {

    static FoodItem foodItemTest; //Arrange
    LocalDate expirationDate = LocalDate.of(2025, 10, 20); //Arrange
    /**
     * Arrange
     * act
     * assert
     * assertEquals
     * assertThrows
     */

    @BeforeEach
    void setUp()
    {

        foodItemTest = new FoodItem("milk", 7f, "liter", 20.0, expirationDate);
        // Other arrange
    }

    @Test
    void testConstructorAndGetters() {
        assertEquals("milk", foodItemTest.getNameOfFood());
        assertEquals(7f, foodItemTest.getAmount());
        assertEquals("liter", foodItemTest.getUnits());
        assertEquals(20.0, foodItemTest.getPricePerUnit());
        assertEquals(LocalDate.of(2025, 10, 20), foodItemTest.getExpirationDate());
    }

    @Test
    void setNameOfFoodTestForString() {
        foodItemTest.setNameOfFood("milk");
        assertEquals("milk", foodItemTest.getNameOfFood());
    }

    @Test
    void setNameOfFoodTestForEmptyString() {
        assertThrows(IllegalArgumentException.class, () -> foodItemTest.setNameOfFood(""));
    }


    @Test
    void setNameOfFoodTestForNull() {
        assertThrows(IllegalArgumentException.class, () -> foodItemTest.setNameOfFood(null));
    }


    @Test
    void setAmountTestForNegativeValues() {
        assertThrows(IllegalArgumentException.class, () -> foodItemTest.setAmount(-1.0f));
    }

    @Test
    void setAmountTestForPositiveValues() {
        assertEquals(7.0f, foodItemTest.getAmount());
    }



    @Test
    void setPriceTestForNegativeValues(){
        assertThrows(IllegalArgumentException.class, () -> foodItemTest.setPricePerUnit(-1.0));
    }

    @Test
    void setPriceTestForPositiveValues() {
        assertEquals(20.0, foodItemTest.getPricePerUnit());
    }

    @Test
    void setExpirationDateTest() {

        // Create FoodItem with a valid future expiration date
        FoodItem foodDate = new FoodItem("milk", 7f, "liters", 10.0, expirationDate);

        // Assert that the expiration date is set correctly
        assertEquals(expirationDate, foodDate.getExpirationDate());
    }

    @Test
    void setExpirationDateTestInPastThrowsException() {
        LocalDate pastDate = LocalDate.of(2020, 1, 1);

        // Verify that creating a FoodItem with a past date throws an exception
        assertThrows(IllegalArgumentException.class, () ->
                new FoodItem("milk", 7f, "liters", 10.0, pastDate)
        );
    }

}

