package edu.ntnu.idi.bidata.food;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.time.LocalDate; // Import LocalDate

/**
 * Test class for {@link FoodItem} class.
 *
 * <p>This class tests different methods from the {@link FoodItem} class.
 * It checks if it is possible to access, mutate the recipes.
 * </p>
 *
 * @author Arpit Sahoo
 * @version 0.0.3
 */
class FoodItemTest {
  private FoodItem foodItemTest; //Arrange
  private final LocalDate expirationDate = LocalDate.of(2025, 10, 20); //Arrange


  /**
   * Before each test methods, a new {@code FoodItem} is made.
   */
  @BeforeEach
  void setUp() {
    foodItemTest = new FoodItem("milk", 7f, "liter", 20.0, expirationDate);
    // arrange
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
   * Test if the constructor and access methods in the {@code FoodItem}.
   *
   * <p> Ensures if the accessors and constructor are doing as expected.</p>
   */
  @Test
  void testConstructorAndGetters() {
    assertEquals("milk", foodItemTest.getNameOfFood()); // Act
    assertEquals(7f, foodItemTest.getAmount()); // Act
    assertEquals("liter", foodItemTest.getUnits()); // Act
    assertEquals(20.0, foodItemTest.getPricePerUnit()); // Act
    assertEquals(LocalDate.of(2025, 10, 20), foodItemTest.getExpirationDate()); // Act
  }


  /**
   * A positive test that tests the method {@code setNameOfFood}.
   *
   * <p>This methods tests if the {@code setNameOfFood} is a valid input.</p>
   */
  @Test
  void setNameOfFoodPositiveTest() {
    assertEquals("milk", foodItemTest.getNameOfFood());
  }

  /**
   * A negative test that test the {@code setNameOfFood} method of the {@code FoodItem} class.
   *
   * <p>This test ensures that the {@code setNameOfFood} method correctly throws an
   * {@code IllegalArgumentException} when provided with invalid input.
   *
   * <p>Expected:
   *    <ul><li>{@code IllegalArgumentException} is thrown is if the input is empty</li></ul>
   *    <ul><li>{@code IllegalArgumentException} is thrown is if the input is null</li></ul>
   * </p>
   */
  @Test
  void setNameOfFoodNegativeTest() {
    assertThrows(IllegalArgumentException.class, () -> foodItemTest.setNameOfFood(""));
    assertThrows(IllegalArgumentException.class, () -> foodItemTest.setNameOfFood(null));
  }

  /**
   * A positive test that tests the method {@code setAmount}.
   *
   * <p>This methods tests if the {@code setAmount} is a valid input.</p>
   */
  @Test
  void setAmountTestForPositiveValues() {
    assertEquals(7.0f, foodItemTest.getAmount());
  }

  /**
   * A negative test that test the {@code setAmount} method of the {@code FoodItem} class.
   *
   * <p>This test ensures that the {@code setAmount} method correctly throws an
   * {@code IllegalArgumentException} when provided with invalid input.
   *
   * <p>Expected:
   *    <ul><li>{@code IllegalArgumentException} is thrown is if the input is negative number</li></ul>
   *    <ul><li>{@code IllegalArgumentException} is thrown is if the input is 0</li></ul>
   * </p>
   */
  @Test
  void setAmountTestForNegativeValues() {
    assertThrows(IllegalArgumentException.class, () -> foodItemTest.setAmount(-1.0f));
    assertThrows(IllegalArgumentException.class, () -> foodItemTest.setAmount(0f));
  }

  /**
   *A negative test that test the {@code setPricePerUnit}.
   *
   * <p>This methods tests if the {@code setAmount} is a valid input.</p>
   */
  @Test
  void setPricePerUnitTestForPositiveValues() {
    assertEquals(20.0, foodItemTest.getPricePerUnit());
  }

  /**
   * A negative test that test the {@code setAmount} method of the {@code FoodItem} class.
   *
   * <p>This test ensures that the {@code setAmount} method correctly throws an
   * {@code IllegalArgumentException} when provided with invalid input.
   *
   * <p>Expected:
   *    <ul><li>{@code IllegalArgumentException} is thrown is if the input is negative number</li></ul>
   *    <ul><li>{@code IllegalArgumentException} is thrown is if the input is 0</li></ul>
   * </p>
   */
  @Test
  void setPricePerUnitTestForNegativeValues() {
    assertThrows(IllegalArgumentException.class, () -> foodItemTest.setPricePerUnit(-1.0));
    assertThrows(IllegalArgumentException.class, () -> foodItemTest.setPricePerUnit(0.0));
  }

  /**
   *A negative test that test the {@code setExpirationDate}.
   *
   * <p>This methods tests if the {@code setExpirationDate} is a valid input.</p>
   */
  @Test
  void setExpirationDatePositiveTest() {

    // Create FoodItem with a valid future expiration date
    FoodItem foodDate = new FoodItem("milk", 7f, "liters", 10.0, expirationDate);

    // Assert that the expiration date is set correctly
    assertEquals(expirationDate, foodDate.getExpirationDate());
  }

  /**
   * A negative test that test the {@code setExpirationDate} method of the {@code FoodItem} class.
   *
   * <p>This test ensures that the {@code setAmount} method correctly throws an
   * {@code IllegalArgumentException} when provided with invalid input.
   *
   * <p> Notice:
   *   <ul><li>A new {@code FoodItem} is created to be tested.</li></ul>
   * </p>
   * <p>Expected:
   *    <ul><li>{@code IllegalArgumentException} is thrown is if the date is in the past</li></ul>
   * </p>
   */
  @Test
  void setExpirationDateTestInPastThrowsException() {
    LocalDate pastDate = LocalDate.of(2020, 1, 1); // arrange

    // Verify that creating a FoodItem with a past date throws an exception
    assertThrows(IllegalArgumentException.class, () ->
        new FoodItem("milk", 7f, "liters", 10.0, pastDate)
    );
  }

}

