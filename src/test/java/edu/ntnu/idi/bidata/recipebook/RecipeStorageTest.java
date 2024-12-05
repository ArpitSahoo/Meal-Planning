package edu.ntnu.idi.bidata.recipebook;

import edu.ntnu.idi.bidata.recipe.Recipes;
import org.junit.jupiter.api.*;

import java.util.Iterator;

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
 * @version 0.0.2
 */
class RecipeStorageTest {
  private RecipeStorage storage;
  private Recipes recipes1;
  private Recipes recipes2;
  private Recipes recipes3;

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

    recipes2 = new Recipes("tomato sauce",
        "Good italian dish", "Add Tomato to the sauce");
    recipes2.addIngredient("Tomato", 1f, "Kg");
    recipes2.addIngredient("Sauce", 1f, "liter");
    recipes3 = new Recipes("kebab in pita","Delicacy from Turkey",
        "Cook the meat, add the sauce and add it to the pita bread.");
    recipes3.addIngredient("Pita", 2f, "pieces");
    recipes3.addIngredient("Meat", 200f, "Kg");
    recipes3.addIngredient("Sauce", 0.5f, "liters");
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

  /**
   * Tests the {@code getRecipeNamesAlphabeticalOrder}
   * method of the {@code FridgeRegister} class.
   *
   * <p>This test ensures that the {@code getRecipeNamesAlphabeticalOrder}
   * method correctly provides an iterator
   * over the items stored in the recipe book. It also ensures that the {@code Recipes} are
   * sorted alphabetical.
   * It verifies that the iterator retrieves
   * the recipes in the expected order, and checks the following:
   *
   * <ul>
   *   <li>The iterator starts with the first item and progresses sequentially.</li>
   *   <li>The names of the recipe are in the expected alphabetical order.</li>
   *   <li>The iterator correctly identifies when there are no more items to iterate.</li>
   * </ul>
   *
   * <p>Expected behavior:
   * <ul>
   *   <li>{@code getIterator().hasNext()} is {@code true} initially and until the last item.</li>
   *   <li>{@code getIterator().next()} returns the correct name for each item in the expected order.</li>
   *   <li>{@code getIterator().hasNext()} is {@code false} after the last item.</li>
   * </ul>
   */
  @Test
  void getRecipeNamesAlphabeticalOrderPositiveTest(){
    storage.addRecipe(recipes1);
    storage.addRecipe(recipes2);
    storage.addRecipe(recipes3);

    Iterator<String> getIteratorTest = storage.getRecipeNamesAlphabeticalOrder();
    assertTrue(getIteratorTest.hasNext());
    assertEquals("butter chicken", getIteratorTest.next());
    assertTrue(getIteratorTest.hasNext());
    assertEquals("kebab in pita", getIteratorTest.next());
    assertTrue(getIteratorTest.hasNext());
    assertEquals("tomato sauce", getIteratorTest.next());
    assertFalse(getIteratorTest.hasNext());
  }

  /**
   * A negative test for the {@code getRecipeNamesAlphabeticalOrder} method
   * in the {@code RecipeStorage} class.
   *
   * <p>This test verifies that the {@code getRecipeNamesAlphabeticalOrder} method
   * does not incorrectly return recipe names in the wrong alphabetical order.
   * Specifically, it ensures the following:
   * <ul>
   *   <li>The iterator starts with the first item and proceeds correctly.</li>
   *   <li>The recipe names are not in the incorrect order as expected in this test.</li>
   *   <li>The iterator correctly identifies when no more items are available.</li>
   * </ul>
   * </p>
   *
   * <p>Expected behavior:
   * <ul>
   *   <li>{@code hasNext()} returns {@code true} for each item in the iterator
   *       until the last item is reached.</li>
   *   <li>{@code next()} does not return recipe names in the expected alphabetical order
   *       in this negative test case.</li>
   *   <li>{@code hasNext()} returns {@code false} after the last item is retrieved.</li>
   * </ul>
   * </p>
   */
  @Test
  void getRecipeNamesAlphabeticalOrderNegativeTest(){
    storage.addRecipe(recipes1);
    storage.addRecipe(recipes2);
    storage.addRecipe(recipes3);
    Iterator<String> getIteratorTest = storage.getRecipeNamesAlphabeticalOrder();

    assertTrue(getIteratorTest.hasNext());
    assertNotEquals("tomato sauce", getIteratorTest.next());

    assertTrue(getIteratorTest.hasNext());
    assertNotEquals("butter chicken", getIteratorTest.next());

    assertTrue(getIteratorTest.hasNext());
    assertNotEquals("kebab in pita", getIteratorTest.next());

    assertFalse(getIteratorTest.hasNext());

  }
}
