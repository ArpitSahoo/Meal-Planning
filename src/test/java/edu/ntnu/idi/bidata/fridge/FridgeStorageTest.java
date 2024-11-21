package edu.ntnu.idi.bidata.fridge;

import edu.ntnu.idi.bidata.food.FoodItem;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class FridgeStorageTest {
    private FridgeStorage fridgeRegister;
    private FoodItem foodItem1;
    private final LocalDate expirationDate = LocalDate.of(2025, 10, 20); //Arrange

    @BeforeEach
    void setUp() {
        // Arrange
        fridgeRegister = new FridgeStorage();
        foodItem1 = new FoodItem("milk", 7f, "liter", 20.0, expirationDate);
    }

    @AfterEach
    void tearDown() {
        System.out.println("After each test case");
    }

    @Test
    void addFoodItem() {
        fridgeRegister.addFoodItem(foodItem1);
        assertEquals("milk", foodItem1.getNameOfFood() );
    }

    @Test
    void removeFoodItem() {
        fridgeRegister.addFoodItem(foodItem1);
        boolean removed = fridgeRegister.removeFoodItem(foodItem1);
        assertTrue(removed); // True if condition is true.

    }

    @Test
    void foodToTake() {
        fridgeRegister.addFoodItem(foodItem1);
        FoodItem foodToTake = new FoodItem("milk",
                2f, "liter", 20.0, expirationDate
        );

        boolean wasFoodTaken = fridgeRegister.foodToTake(foodToTake); //inspired by chatGPT
        assertTrue(wasFoodTaken, "food was taken");
    }

    @Test
    void notExistingFoodToTake(){
        FoodItem foodToTake = new FoodItem("juice",
                2f, "liter", 20.0, expirationDate
        );

        boolean wasFoodTaken = fridgeRegister.foodToTake(foodToTake);
        assertFalse(wasFoodTaken);
    }


    @Test
    void searchFoodByName() {
        fridgeRegister.addFoodItem(foodItem1);
        boolean wasFoodTaken = fridgeRegister.foodToTake(foodItem1);
        assertTrue(wasFoodTaken, "food was found");
    }

    @Test
    void notExistingSearchFoodByName() {
        FoodItem foodNotExisting =  new FoodItem("juice", 2f, "liter", 20.0, expirationDate);
        boolean wasFoodTaken = fridgeRegister.foodToTake(foodNotExisting);
        assertFalse(wasFoodTaken);
    }

    @Test
    void getIterator() {
    }

    @Test
    void getIteratorAlphabetical() {
    }
}