package edu.ntnu.idi.bidata.recipebook;

import edu.ntnu.idi.bidata.recipe.Recipes;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * A test class for the {@link RecipeStorage} class.
 *
 * <p>This class tests different methods from the {@code RecipeStorage} class.
 *  this class ensures that it is possible to add, remove and get recipes.
 *  It does this by doing positive and negative tests.
 *  </p>
 *
 * @since 0.0.1
 * @author Arpit Sahoo
 * @version 0.0.1
 */
class RecipeStorageTest {
  private RecipeStorage storage;
  private Recipes recipes1;

  /**
   * Before each test method, a new food item is made.
   *
   * <p>Creates a new instance of {@code RecipeStorage} and {@code Recipes}
   *  objects before each test</p>
   */
  @BeforeEach
  void setUp() {
    storage = new RecipeStorage();
    recipes1 = new Recipes("butter chicken",
        "Good indian dish", "First make chicken, then make butter");
    recipes1.addIngredient("Butter", 2f, "Kg");
    recipes1.addIngredient("Chicken", 1f, "Kg");
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
   * A positive test for the method {@code addRecipe}.
   *
   * <p>This method ensures that the recipe is successfully added to
   * the recipe book. This test will assert {@code true},
   * when successfully added.</p>
   *
   * <p>Expected behavior:
   * <ul>
   *   <li>{@code addRecipe(recipes1)} returns {@code true}.</li>
   * </ul>
   *</p>
   */
  @Test
  void addRecipePositiveTest() {
    boolean wasAdded = storage.addRecipe(recipes1);
    assertTrue(wasAdded);
  }

  /**
   * A negative test for the method {@code addRecipe}.
   *
   * <p>This method ensures that the recipe will not be added to
   * the recipe book. Since the {@code recipe1} already exists
   * in the recipe book.</p>
   *
   * <p>Expected behavior:
   * <ul>
   *   <li>{@code addRecipe(recipes1)} returns {@code false}.</li>
   * </ul>
   *</p>
   */
  @Test
  void addRecipeNegativeTest() {
    storage.addRecipe(recipes1);
    boolean wasAdded = storage.addRecipe(recipes1);
    assertFalse(wasAdded);
  }


  /**
   * A positive test for the {@code removeRecipe} method.
   *
   * <p>This method ensures that the {@code recipes1} is successfully
   * removed from the recipe book. This test will assert {@code true},
   * when successfully removed.</p>
   *
   * <p>Expected behavior:
   * <ul>
   *   <li>{@code removeRecipe("butter chicken")} returns {@code true}.</li>
   * </ul>
   */
  @Test
  void removeRecipePositiveTest() {
    storage.addRecipe(recipes1);
    boolean wasRemoved = storage.removeRecipe("butter chicken");
    assertTrue(wasRemoved);
  }

  /**
   * A negative test for the {@code removeRecipe} method.
   *
   * <p>This method ensures that the {@code recipes1} is not
   * removed, since the recipe does not exist. This test will assert {@code false}.</p>
   *
   * <p>Expected behavior:
   * <ul>
   *   <li>{@code removeRecipe("butter chicken")} returns {@code false}.</li>
   * </ul>
   */
  @Test
  void removeRecipeNegativeTest() {
    boolean wasRemoved = storage.removeRecipe("butter chicken");
    assertFalse(wasRemoved);
  }


  /**
   * A positive test for the {@code getRecipe} method.
   *
   * <p>This method ensures that the {@code getRecipe} is able to
   * fetch the correct recipe.</p>
   *
   * <p>Expected behavior:
   * <ul>
   *   <li>{@code getRecipe} equals to getRecipe("butter chicken").</li>
   * </ul>
   */
  @Test
  void getRecipe() {
    storage.addRecipe(recipes1);
    assertEquals(recipes1, storage.getRecipe("butter chicken"));
  }
}
