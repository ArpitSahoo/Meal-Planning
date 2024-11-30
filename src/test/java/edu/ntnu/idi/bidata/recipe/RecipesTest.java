package edu.ntnu.idi.bidata.recipe;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;


/**
 * Test class for {@link Recipes} class.
 *
 * <p>This class tests different methods from the {@code Recipes} class.
 * It checks if it is possible to access, mutate the recipes.
 * </p>
 *
 * @since 0.0.1
 * @author Arpit Sahoo
 * @version 0.0.1
 */
class RecipesTest {
  private Recipes recipes1;

  /**
   * Before each test methods, a new recipe is made.
   */
  @BeforeEach
  void setUp(){
    recipes1 = new Recipes("Butter beer",
        "Beer with butter. A great drink from Harry Potter",
        "Add butter to beer and then boil");
    recipes1.addIngredient("Butter", 1f, "Kg");
    recipes1.addIngredient("Beer", 1f, "Liter"); // arrange
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
   * A positive test that tests the method {@code setNameOfRecipe}.
   *
   * <p>This methods tests if the {@code setNameOfRecipe} is a valid input.</p>
   */
  @Test
  void setNameOfRecipePositiveTest(){
    assertEquals("Butter beer", recipes1.getNameOfRecipe());
  }

  /**
   * A negative test that test the {@code setNameOfRecipe} method of the {@code Recipe} class.
   *
   * <p>This test ensures that the {@code setNameOfRecipe} method correctly throws an
   * {@code IllegalArgumentException} when provided with invalid input.
   *
   * <p>Expected:
   *    <ul><li>{@code IllegalArgumentException} is thrown is if the input is empty</li></ul>
   *    <ul><li>{@code IllegalArgumentException} is thrown is if the input is null</li></ul>
   * </p>
   */
  @Test
  void setNameOfRecipeNegativeTest(){
    assertThrows(IllegalArgumentException.class, () -> recipes1.setNameOfRecipe(" "));
    assertThrows(IllegalArgumentException.class, () -> recipes1.setNameOfRecipe(null));
  }

  /**
   * A positive test that tests the method {@code setDescriptionOfRecipe}.
   *
   * <p>This methods tests if the {@code setDescriptionOfRecipe} is a valid input.</p>
   */
  @Test
  void setDescriptionOfRecipePositiveTest(){
    assertEquals("Beer with butter. A great drink from Harry Potter", recipes1.getDescription());
  }

  /**
   * A negative test that test the {@code setDescriptionOfRecipe} method of the {@code Recipe} class.
   *
   * <p>This test ensures that the {@code setDescriptionOfRecipe} method correctly throws an
   * {@code IllegalArgumentException} when provided with invalid input.
   *
   * <p>Expected:
   *    <ul><li>{@code IllegalArgumentException} is thrown is if the input is empty</li></ul>
   *    <ul><li>{@code IllegalArgumentException} is thrown is if the input is null</li></ul>
   * </p>
   */
  @Test
  void setDescriptionOfRecipeNegativeTest(){
    assertThrows(IllegalArgumentException.class, () -> recipes1.setDescription(null));
    assertThrows(IllegalArgumentException.class, () -> recipes1.setDescription(""));
  }

  /**
   * A positive test that tests the method {@code setSteps}.
   *
   * <p>This methods tests if the {@code setSteps} is a valid input.</p>
   */
  @Test
  void setStepsPositiveTest(){
    assertEquals("Add butter to beer and then boil", recipes1.getSteps());
  }

  /**
   * A negative test that test the {@code setSteps} method of the {@code Recipe} class.
   *
   * <p>This test ensures that the {@code setSteps} method correctly throws an
   * {@code IllegalArgumentException} when provided with invalid input.
   *
   * <p>Expected:
   *    <ul><li>{@code IllegalArgumentException} is thrown is if the input is null</li></ul>
   *    <ul><li>{@code IllegalArgumentException} is thrown is if the input is empty</li></ul>
   * </p>
   */
  @Test
  void setStepsNegativeTest(){
    assertThrows(IllegalArgumentException.class, () -> recipes1.setSteps(null));
    assertThrows(IllegalArgumentException.class, () -> recipes1.setSteps(""));
  }


}
