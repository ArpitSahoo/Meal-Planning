package edu.ntnu.idi.bidata.fridge;

import edu.ntnu.idi.bidata.food.FoodItem;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.Iterator;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;



class FridgeStorageTest {
    private FridgeStorage fridgeRegister;
    private FoodItem foodItem1;
    private FoodItem foodItem2;
    private FoodItem foodItem3;
    private final LocalDate expirationDate = LocalDate.of(2025, 10, 20); //Arrange

    @BeforeEach
    void setUp() {
        // Arrange
        fridgeRegister = new FridgeStorage();
        foodItem1 = new FoodItem("milk", 7f, "liter", 20.0, expirationDate);
        foodItem2 = new FoodItem("bread", 1f, "pieces", 20.0, expirationDate);
        foodItem3 = new FoodItem("monster white", 1.5f, "liter", 50.0, expirationDate);
    }

    @AfterEach
    void tearDown() {
        System.out.println("After each test case");
    }

    @Test
    @DisplayName("Positive test for the method to add food items.")
    void addFoodItem() {
        boolean wasFoodAdded = fridgeRegister.addFoodItem(foodItem1);
        assertTrue(wasFoodAdded);
    }

    @Test
    void removeFoodItem() {
        fridgeRegister.addFoodItem(foodItem1);
        boolean removed = fridgeRegister.removeFoodItem(foodItem1);
        assertTrue(removed); // True if condition is true.

    }

    @Test
    void removeFoodItemNegativeTest() {
        boolean removed = fridgeRegister.removeFoodItem(foodItem1);
        assertFalse(removed); // False if condition is false.

    }



    @Test
    void foodToTakeTestPositive() {
        fridgeRegister.addFoodItem(foodItem1);
        FoodItem foodToTake = new FoodItem("milk",
                2f, "liter", 20.0, expirationDate
        );

        boolean wasFoodTaken = fridgeRegister.foodToTake(foodToTake); //inspired by chatGPT
        assertTrue(wasFoodTaken, "food was taken");
    }

    @Test
    void FoodToTakeNegativeTest(){
        FoodItem foodToTake = new FoodItem("juice",
                2f, "liter", 20.0, expirationDate
        );

        boolean wasFoodTaken = fridgeRegister.foodToTake(foodToTake);
        assertFalse(wasFoodTaken);
    }


    @Test
    void searchFoodByNamePositiveTest() {
        fridgeRegister.addFoodItem(foodItem1);
        boolean wasFoodTaken = fridgeRegister.foodToTake(foodItem1);
        assertTrue(wasFoodTaken, "food was found");
    }

    @Test
    void SearchFoodByNameNegativeTest() {
        FoodItem foodNotExisting =  new FoodItem("juice", 2f, "liter", 20.0, expirationDate);
        boolean wasFoodTaken = fridgeRegister.foodToTake(foodNotExisting);
        assertFalse(wasFoodTaken);
    }

    @Test
    void getIteratorTest() {
        fridgeRegister.addFoodItem(foodItem1);
        fridgeRegister.addFoodItem(foodItem2);
        fridgeRegister.addFoodItem(foodItem3);

        Iterator<Map.Entry<String, FoodItem>> getIteratorTest = fridgeRegister.getIterator();

        assertTrue(getIteratorTest.hasNext());
        assertEquals("bread", getIteratorTest.next().getKey());

        assertTrue(getIteratorTest.hasNext());
        assertEquals("milk", getIteratorTest.next().getKey());

        assertTrue(getIteratorTest.hasNext());
        assertEquals("Monster white", getIteratorTest.next().getKey());

        assertFalse(getIteratorTest.hasNext());

    }



    @Test
    void getIteratorAlphabetical() {
    }
}