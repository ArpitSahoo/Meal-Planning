package edu.ntnu.idi.bidata.fridge;

import edu.ntnu.idi.bidata.food.FoodItem;
import org.junit.jupiter.api.*;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;
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
 * @version 0.0.5
 */

class FridgeStorageTest {
  private FridgeStorage fridgeRegister;
  private FoodItem foodItem1;
  private FoodItem foodItem2;
  private FoodItem foodItem3;
  private final LocalDate expirationDate = LocalDate.of(2025, 10, 20); //Arrange

  /**
   * Before each test method, a new food item is made.
   *
   * <p>Creates a new instance of {@code FridgeStorage} and {@code FoodItem}
   * objects before each test.</p>
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
   *A negative test for the {@code addFoodItem} method of the {@code FridgeRegister} class.
   *
   * <p>This test verifies that a food item is not added to the fridge.
   * It asserts that the method returns {@code false}, since {@code foodItem1}
   * already exists. But amount is expected  to be updated.</p>
   * <p>Expected behavior:
   * <ul>
   *   <li>{@code addFoodItem(foodItem1)} returns {@code false}.</li>
   *   <li>The {@code foodItem1} amount is updated.</li>
   * </ul>
   *</p>
   */
  @Test
  void addFoodItemNegativeTest() {
    fridgeRegister.addFoodItem(foodItem1);
    boolean wasFoodAdded = fridgeRegister.addFoodItem(foodItem1); //Act
    assertFalse(wasFoodAdded); //Assert
    assertEquals(14f, fridgeRegister.searchFoodByName(foodItem1.getNameOfFood()).getAmount());
    //Since the food already exists, the amount will be updated.
  }

  /**
   *Tests the {@code removeFoodItem} method of the {@code FridgeRegister} class.
   *
   * <p>This test if an existing {@code FoodItem} is in the {@code FridgeRegister}
   * is removed from the fridge.
   * It asserts that the method returns {@code true} when using {@code removeFoodItem}.</p>
   *
   * <p>Expected behavior:
   *   <ul><li>{@code removeFoodItem(foodItem1)} returns {@code True}.</li></ul>
   *</p>
   */
  @Test
  void removeFoodItemPositiveTest() {
    fridgeRegister.addFoodItem(foodItem1); // act
    boolean removed = fridgeRegister.removeFoodItem("milk"); //act
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
   * <p>Expected behavior:
   *   <ul><li>{@code removeFoodItem(foodItem1)} returns {@code false}.</li></ul>
   *</p>
   */
  @Test
  void removeFoodItemNegativeTest() {
    boolean removed = fridgeRegister.removeFoodItem("milk");
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
   * It asserts that the method returns {@code false} when using {@code foodToTake}.
   * Since a similar {@code foodToTake} does not exists in the fridge.</p>
   *
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

  /**
   *Tests the {@code searchFoodByName} method
   * of the {@code FridgeRegister} class.
   *
   * <p>This test if a {@code FoodItem} in the {@code FridgeRegister}
   * exits in the fridge.
   * A new {@code FoodItem} is initialized to find in the fridge.
   * It asserts that the method is passed when searching {@code foodItem1}.</p>
   *
   * Return the food's name.
   *</p>
   */
  @Test
  void searchFoodByNamePositiveTest() {
    fridgeRegister.addFoodItem(foodItem1); // Act
    assertEquals(foodItem1, fridgeRegister.searchFoodByName("milk")); // Assert
  }

  /**
   * A negative test that tests if the {@code searchFoodByName} method
   * of the {@code FridgeRegister} class. '
   *
   * <p>This test if a non-existing {@code FoodItem} is in the {@code FridgeRegister}
   * exits in the fridge.
   * A new {@code FoodItem} is initialized to find in the fridge.
   * It asserts that the method returns {@code false},
   * when searching {@code foodNotExisting}.</p>
   *
   * Does not return the food's name.
   *</p>
   */
  @Test
  void SearchFoodByNameNegativeTest() {
    FoodItem foodNotExisting =
        new FoodItem("juice", 2f, "liter", 20.0, expirationDate);
    boolean wasFoodAdded = fridgeRegister.foodToTake(foodNotExisting);
    assertFalse(wasFoodAdded);
  }

  /**
   * Tests the {@code getIterator} method of the {@code FridgeRegister} class.
   *
   * <p>This test ensures that the {@code getIterator} method correctly provides an iterator
   * over the items stored in the fridge register. It verifies that the iterator retrieves
   * the food items in the expected order, and checks the following:
   *
   * <ul>
   *   <li>The iterator starts with the first item and progresses sequentially.</li>
   *   <li>The keys of the food items match the expected values.</li>
   *   <li>The iterator correctly identifies when there are no more items to iterate.</li>
   * </ul>
   *
   * <p>Expected behavior:
   * <ul>
   *   <li>{@code getIterator().hasNext()} is {@code true} initially and until the last item.</li>
   *   <li>{@code getIterator().next().getKey()} returns the correct key for each item in the expected order.</li>
   *   <li>{@code getIterator().hasNext()} is {@code false} after the last item.</li>
   * </ul>
   *
   */
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

  /**
   * A negative test that tests the {@code getIterator} method of the {@code FridgeRegister} class.
   *
   * <p>This test ensures that the {@code getIterator} method fails to return an iterator
   * over the items stored in the fridge register. It verifies that the iterator retrieves
   * the food items in the expected order, and checks the following:
   *
   * <ul>
   *   <li>The iterator starts with the first item and progresses sequentially.</li>
   *   <li>The keys of the food items match the expected values.</li>
   *   <li>The iterator correctly identifies when there are no more items to iterate.</li>
   * </ul>
   *
   * <p>Expected behavior:
   * <ul>
   *   <li>{@code getIterator().hasNext()} is {@code true} initially and until the last item.</li>
   *   <li>{@code getIterator().next().getKey()} returns the correct key for {@code foodItem2}</li>
   *   <li>assert will mot equal to juice, since it does not exist the fridge.</li>
   * </ul>
   * </p>
   */
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

  /**
   * A positive test that tests the {@code searchByDate} method of the {@code FridgeRegister} class.
   *
   * <p>This test ensures that the method {@code searchByDate} finds an existing food item in
   * {@code FridgeRegister} with the specific expiration date and adds it to the list.</p>
   *
   * <p>Expected behavior:
   *   <ul>
   *     <li>Adds {@code foodItem1} to the list {@code results} since the dates match.</li>
   *     <li>The code asserts {@code true} when it finds {@code foodItem1} in the list</li>
   *     <li>Expects the list to have a size of 1. Hence, there is only one {@code foodItem}</li>
   *   </ul>
   * </p>
   *
   */
  @Test
  void searchByDatePositiveTest() {
    fridgeRegister.addFoodItem(foodItem1);

    List<FoodItem> result = fridgeRegister.searchByDate(expirationDate); // searches if the

    assertTrue(result.contains(foodItem1)); // This line inspired by ChatGPT 2024
    assertEquals(1, result.size()); // This line inspired by ChatGPT 2024
  }

  /**
   * A negative test that tests {@code searchByDate} method of the {@code FridgeRegister} class.
   *
   * <p>This ensures that the method {@code searchByDate} fails
   * when searching for a {@code FoodItem} the specific expiration date.</p>
   *
   * <p>Expected behavior:
   *   <ul>
   *     <li>Does not {@code foodItem1} to the list {@code results}</li>
   *     <li>The code asserts {@code false}.</li>
   *     <li>Expects the list to have a size of 0.</li>
   *   </ul>
   * </p>
   */
  @Test
  void searchByDateNegativeTest() {
    fridgeRegister.addFoodItem(foodItem1);

    LocalDate expirationDate2 = LocalDate.of(2026, 10, 20);
    List<FoodItem> result = fridgeRegister.searchByDate(expirationDate2); // searches if the

    assertFalse(result.contains(foodItem1)); // False since the date do not match and not added to list.
    assertEquals(0, result.size()); // Expected 0 since not in the list.
  }


  /**
   * Tests the {@code getIteratorAlphabetical} method of the {@code FridgeRegister} class.
   *
   * <p>This test ensures that the {@code getIteratorAlphabetical} method correctly provides an iterator
   * over the items stored in the fridge register. It also ensures that the {@code FoodItem} are
   * sorted alphabetical.
   * It verifies that the iterator retrieves
   * the food items in the expected order, and checks the following:
   *
   * <ul>
   *   <li>The iterator starts with the first item and progresses sequentially.</li>
   *   <li>The keys of the food items are in the expected alphabetical order.</li>
   *   <li>The iterator correctly identifies when there are no more items to iterate.</li>
   * </ul>
   *
   * <p>Expected behavior:
   * <ul>
   *   <li>{@code getIterator().hasNext()} is {@code true} initially and until the last item.</li>
   *   <li>{@code getIterator().next().getKey()} returns the correct key for each item in the expected order.</li>
   *   <li>{@code getIterator().hasNext()} is {@code false} after the last item.</li>
   * </ul>
   */
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

  /**
   * A negative test that test the {@code getIteratorAlphabetical} method of the {@code FridgeRegister} class.
   *
   * <p>This test ensures that the {@code getIteratorAlphabetical} method fails to return an iterator
   * that retrieves the food items in the correct alphabetical order:
   *
   * <ul>
   *   <li>The iterator starts with the first item and tries the next.</li>
   *   <li>The keys of the food items are not in the expected alphabetical order.</li>
   *   <li>The iterator correctly identifies when there are no more items to iterate.</li>
   * </ul>
   *
   * <p>Expected behavior:
   * <ul>
   *   <li>{@code getIteratorTest().hasNext()} is {@code true} initially and until the last item.</li>
   *   <li>{@code getIteratorTest().next()} does not return keys in the correct alphabetical order.</li>
   *   <li>{@code getIteratorTest().hasNext()} is {@code false} after the last item.</li>
   * </ul>
   */
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