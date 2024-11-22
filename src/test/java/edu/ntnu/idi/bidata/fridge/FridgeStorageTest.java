package edu.ntnu.idi.bidata.fridge;

import edu.ntnu.idi.bidata.food.FoodItem;
import org.junit.jupiter.api.*;
import java.time.LocalDate;
import java.util.Iterator;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for {@link FridgeStorage} class.
 * <p>This class tests different methods from the {@link FridgeStorage} class.
 * It checks if it is possible to add, remove and take food from the fridge.
 * It also ensures that the food is organized and managed correctly.
 * </p>
 *
 * @author Arpit Sahoo
 * @version 0.0.1
 */

class FridgeStorageTest {
    private FridgeStorage fridgeRegister;
    private FoodItem foodItem1;
    private FoodItem foodItem2;
    private FoodItem foodItem3;
    private final LocalDate expirationDate = LocalDate.of(2025, 10, 20); //Arrange

    @BeforeEach
    void setUp() {
        // Arrange
        System.out.println("New test case");
        fridgeRegister = new FridgeStorage();
        foodItem1 = new FoodItem("milk", 7f, "liter", 20.0, expirationDate);
        foodItem2 = new FoodItem("bread", 1f, "pieces", 20.0, expirationDate);
        foodItem3 = new FoodItem("monster white", 1.5f, "liter", 50.0, expirationDate);
    }

    @AfterEach
    void tearDown() {
        System.out.println("Test passed");
    }

    @AfterAll
    static void tearDownAll() {
        System.out.println("All Test passed");
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
        assertEquals("monster white", getIteratorTest.next().getKey());

        assertFalse(getIteratorTest.hasNext());

    }
    /*
    // needs to be made.
    @Test
    void getIteratorAlphabetical() {
    }

     */
}