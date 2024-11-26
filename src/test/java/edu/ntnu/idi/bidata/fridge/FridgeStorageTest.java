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
 * @since 0.0.1
 * @author Arpit Sahoo
 * @version 0.0.2
 */

class FridgeStorageTest {
  private FridgeStorage fridgeRegister;
  private FoodItem foodItem1;
  private FoodItem foodItem2;
  private FoodItem foodItem3;
  private final LocalDate expirationDate = LocalDate.of(2025, 10, 20); //Arrange

  /**
   * Before each test method a new test, a new food item is made.
   */
  @BeforeEach
  void setUp() {
    // Arrange
    System.out.println("New test case");
    fridgeRegister = new FridgeStorage();
    foodItem1 = new FoodItem("milk", 7f, "liter", 20.0, expirationDate);
    foodItem2 = new FoodItem("bread", 1f, "pieces", 20.0, expirationDate);
    foodItem3 = new FoodItem("monster white", 1.5f, "liter", 50.0, expirationDate);
  }

  /**
   * After each test method, "Test passed" is displayed.
   */
  @AfterEach
  void tearDown() {
    System.out.println("Test passed");
  }

  /**
   * After all test methods are passed, "All Test passed" is displayed.
   */
  @AfterAll
  static void tearDownAll() {
    System.out.println("All Test passed");
  }

  /**
   *Tests the {@code addFoodItem} method of the {@code FridgeRegister} class.
   *
   * <p>This test verifies that a food item is successfully added to the fridge.
   * It asserts that the method returns {@code true} when the food item
   * is added successfully.</p>
   *
   * <p>Preconditions:
   * <ul>
   *   <li>{@code fridgeRegister} is an initialized and empty fridge.</li>
   *   <li>{@code foodItem1} is a valid {@code FoodItem} object.</li>
   * </ul>
   *</p>
   * <p>Expected behavior:
   * <ul>
   *   <li>{@code addFoodItem(foodItem1)} returns {@code true}.</li>
   * </ul>
   *</p>
   */
  @Test
  void addFoodItem() {
    boolean wasFoodAdded = fridgeRegister.addFoodItem(foodItem1); //Act
    assertTrue(wasFoodAdded); //Assert
  }

  /**
   *Negative test to test the {@code addFoodItem} method
   * of the {@code FridgeRegister} class.
   *
   * <p>This test verifies that a not exiting food item is not added to the fridge.
   * It asserts that the method returns {@code false} when using {@code foodToTake}.
   *</p>
   *
   * <p>Preconditions:
   * <ul>
   *   <li>{@code fridgeRegister} is an initialized and empty fridge.</li>
   *   <li>{@code notExistingFood} is a valid {@code FoodItem} object.</li>
   *   <li>{@code notExistingFood} is not added.</li>
   * </ul>
   *</p>
   *
   * <p>Expected behavior:
   * <ul>
   *   <li>{@code foodToTake(foodItem1)} returns {@code false}.</li>
   * </ul>
   *</p>
   */
  @Test
  void addFoodItemNegativeTest() {
      FoodItem notExistingFood = new FoodItem("juice",
          2f, "liter", 20.0, expirationDate
      );
      boolean wasFoodAdded = fridgeRegister.foodToTake(notExistingFood); //Act
      assertFalse(wasFoodAdded); //Assert
  }

  /**
   *Tests the {@code removeFoodItem} method of the {@code FridgeRegister} class.
   *
   * <p>This test if an existing {@code FoodItem} is in the {@code FridgeRegister}
   * is removed from the fridge.
   * It asserts that the method returns {@code true} when using {@code removeFoodItem}.</p>
   *
   *<p>Preconditions:
   * <ul>
   *   <li>{@code fridgeRegister} is an initialized and empty fridge.</li>
   *   <li>{@code foodItem1} is a valid {@code FoodItem} object.</li>
   * </ul>
   *</p>
   *
   * <p>Expected behavior:
   *   <ul><li>{@code removeFoodItem(foodItem1)} returns {@code True}.</li></ul>
   *</p>
   */
  @Test
  void removeFoodItem() {
    fridgeRegister.addFoodItem(foodItem1); // act
    boolean removed = fridgeRegister.removeFoodItem(foodItem1); //act
    assertTrue(removed); // Assert - true if condition is true.

  }

  /**
   *Negative test to test the {@code removeFoodItem} method
   * of the {@code FridgeRegister} class.
   *
   * <p>This test if an non-existing {@code FoodItem} in the {@code FridgeRegister}
   * is removed from the fridge.
   * It asserts that the method returns {@code false} when using {@code removeFoodItem}.</p>
   *
   *<p>Preconditions:
   * <ul>
   *   <li>{@code fridgeRegister} is an initialized and empty fridge.</li>
   *   <li>{@code foodItem1} is a valid {@code FoodItem} object.</li>
   *   <li>{@code foodItem1} is not added to the fridge</li>
   * </ul>
   *</p>
   * <p>Expected behavior:
   *   <ul><li>{@code removeFoodItem(foodItem1)} returns {@code false}.</li></ul>
   *</p>
   */
  @Test
  void removeFoodItemNegativeTest() {
    boolean removed = fridgeRegister.removeFoodItem(foodItem1);
    assertFalse(removed); // False if condition is false.

  }

  /**
   *Tests the {@code foodToTake} method of the {@code FridgeRegister} class.
   *
   * <p>This test if a fixed amount of a {@code FoodItem} in the {@code FridgeRegister}
   * is taken from the fridge.
   * A new {@code FoodItem} is initialized to take out from the fridge.
   * It asserts that the method returns {@code True} when using {@code foodToTake}.</p>
   *
   *<p>Preconditions:
   * <ul>
   *   <li>{@code fridgeRegister} is an initialized and empty fridge.</li>
   *   <li>{@code foodItem1} is a valid {@code FoodItem} object.</li>
   *   <li>{@code foodToTake} is a valid {@code FoodItem} object.</li>
   * </ul>
   *</p>
   * <p>Expected behavior:
   *   <ul><li>{@code foodToTake(foodItem1)} returns {@code True}.</li></ul>
   *</p>
   */
  @Test
  void foodToTakeTestPositive() {
    fridgeRegister.addFoodItem(foodItem1);
    FoodItem foodToTake = new FoodItem("milk",
        2f, "liter", 20.0, expirationDate
    );

    boolean wasFoodTaken = fridgeRegister.foodToTake(foodToTake); //inspired by chatGPT
    assertTrue(wasFoodTaken, "food was taken");
  }

  /**
   *Negative test to test the {@code foodToTake} method
   * of the {@code FridgeRegister} class.
   *
   * <p>This test if a fixed amount of a {@code FoodItem} in the {@code FridgeRegister}
   * is taken from the fridge.
   * A new {@code FoodItem} is initialized to take out from the fridge.
   * It asserts that the method returns {@code false} when using {@code foodToTake}.</p>
   *
   *<p>Preconditions:
   * <ul>
   *   <li>{@code fridgeRegister} is an initialized and empty fridge.</li>
   *   <li>{@code foodToTake} is a valid {@code FoodItem} object.</li>
   *   <li>{@code foodToTake} does not exists in the fridge.</li>
   * </ul>
   *</p>
   *
   * <p>Expected behavior:
   *   <ul><li>{@code foodToTake(foodToTake)} returns {@code false}.</li></ul>
   *</p>
   */
  @Test
  void FoodToTakeNegativeTest() {
    FoodItem foodToTake = new FoodItem("juice",
        2f, "liter", 20.0, expirationDate
    );

    boolean wasFoodTaken = fridgeRegister.foodToTake(foodToTake);
    assertFalse(wasFoodTaken);
  }


  @Test
  void searchFoodByNamePositiveTest() {
    fridgeRegister.addFoodItem(foodItem1); // Act
    assertEquals(foodItem1, fridgeRegister.searchFoodByName("milk")); // Arrange
  }


  @Test
  void SearchFoodByNameNegativeTest() {
    FoodItem foodNotExisting =
        new FoodItem("juice", 2f, "liter", 20.0, expirationDate);
    boolean wasFoodAdded = fridgeRegister.foodToTake(foodNotExisting);
    assertFalse(wasFoodAdded);
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

  @Test
  void getIteratorNegativeTest() {
    fridgeRegister.addFoodItem(foodItem1);
    fridgeRegister.addFoodItem(foodItem2);
    fridgeRegister.addFoodItem(foodItem3);

    Iterator<Map.Entry<String, FoodItem>> getIteratorTest = fridgeRegister.getIterator();

    assertTrue(getIteratorTest.hasNext());
    assertEquals("bread", getIteratorTest.next().getKey());

    assertTrue(getIteratorTest.hasNext());
    assertNotEquals("juice", getIteratorTest.next().getKey());

    assertTrue(getIteratorTest.hasNext());
    assertEquals("monster white", getIteratorTest.next().getKey());

    assertFalse(getIteratorTest.hasNext());

  }

  @Test
  void getIteratorAlphabetical() {
    fridgeRegister.addFoodItem(foodItem1);
    fridgeRegister.addFoodItem(foodItem2);
    fridgeRegister.addFoodItem(foodItem3);

    Iterator<String> getIteratorTest = fridgeRegister.getIteratorAlphabetical();

    assertTrue(getIteratorTest.hasNext());
    assertEquals("bread", getIteratorTest.next());

    assertTrue(getIteratorTest.hasNext());
    assertEquals("milk", getIteratorTest.next());

    assertTrue(getIteratorTest.hasNext());
    assertEquals("monster white", getIteratorTest.next());

    assertFalse(getIteratorTest.hasNext());
  }

  @Test
  void getIteratorAlphabeticalNegativeTest() {
    fridgeRegister.addFoodItem(foodItem1);
    fridgeRegister.addFoodItem(foodItem2);
    fridgeRegister.addFoodItem(foodItem3);

    Iterator<String> getIteratorTest = fridgeRegister.getIteratorAlphabetical();

    assertTrue(getIteratorTest.hasNext());
    assertNotEquals("milk", getIteratorTest.next());

    assertTrue(getIteratorTest.hasNext());
    assertNotEquals("monster white", getIteratorTest.next());


    assertTrue(getIteratorTest.hasNext());
    assertNotEquals("bread", getIteratorTest.next());

    assertFalse(getIteratorTest.hasNext());
  }
}