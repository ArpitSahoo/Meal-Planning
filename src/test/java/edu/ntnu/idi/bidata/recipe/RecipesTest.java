package edu.ntnu.idi.bidata.recipe;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;


/**
 *
 * @author Arpit Sahoo
 * @version 0.0.1
 */
class RecipesTest {
  private Recipes recipes1;

  @BeforeEach
  void setUp(){
    recipes1 = new Recipes("Butter beer",
        "Beer with butter. A great drink from Harry Potter",
        "Add butter to beer and then boil");
    recipes1.addIngredient("Butter", 1f, "Kg");
    recipes1.addIngredient("Beer", 1f, "Liter");
  }

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

  @Test
  void setNameOfRecipePositiveTest(){
    assertEquals("Butter beer", recipes1.getNameOfRecipe());
  }

  @Test
  void setNameOfRecipeNegativeTest(){
    assertThrows(IllegalArgumentException.class, () -> recipes1.setNameOfRecipe(" "));
    assertThrows(IllegalArgumentException.class, () -> recipes1.setNameOfRecipe(null));
  }

  @Test
  void setDescriptionOfRecipePositiveTest(){
    assertEquals("Beer with butter. A great drink from Harry Potter", recipes1.getDescription());
  }

  @Test
  void setDescriptionOfRecipeNegativeTest(){
    assertThrows(IllegalArgumentException.class, () -> recipes1.setDescription(null));
    assertThrows(IllegalArgumentException.class, () -> recipes1.setDescription(""));
  }

  @Test
  void setStepsPositiveTest(){
    assertEquals("Add butter to beer and then boil", recipes1.getSteps());
  }

  @Test
  void setStepsNegativeTest(){
    assertThrows(IllegalArgumentException.class, () -> recipes1.setSteps(null));
    assertThrows(IllegalArgumentException.class, () -> recipes1.setSteps(""));
  }


}
