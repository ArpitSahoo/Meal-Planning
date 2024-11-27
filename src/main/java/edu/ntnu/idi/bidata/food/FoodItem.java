package edu.ntnu.idi.bidata.food;

import edu.ntnu.idi.bidata.fridge.FridgeStorage;

import java.time.LocalDate;

/**
 * Represents a food item.
 *
 * <p>{@code FoodItem}class is used to store relevant information about a specific food item.
 * Allows the user to set and retrieve information about the food item.
 * It also communicates with the {@link FridgeStorage}.
 * </p>
 *
 * @author Arpit Sahoo
 * @version 0.0.3
 *
 */
public class FoodItem {
  private String nameOfFood; //used food instead
  private Float amount;
  private String units;
  private LocalDate expirationDate;
  private Double pricePerUnit;

  /**
   * A constructor for the class FoodItem.
   *
   * @param nameOfFood of FoodItem.
   * @param amount of FoodItem.
   */
  public FoodItem(String nameOfFood, Float amount) { // Allows the user to remove and take food
    setNameOfFood(nameOfFood); // Also allows the method in UI to work.
    setAmount(amount);
  }

  /**
   * A constructor for the class FoodItem.
   *
   * @param nameOfFood of FoodItem.
   * @param amount of FoodItem.
   * @param units of FoodItem.
   */
  public FoodItem(String nameOfFood, Float amount, String units) {
    setNameOfFood(nameOfFood);
    setAmount(amount);
    setUnits(units);
  }

  /**
   * A constructor for the class FoodItem.
   *
   * @param nameOfFood     the name of FoodItem.
   * @param amount         of FoodItem.
   * @param units          of the FoodItem.
   * @param pricePerUnit          of FoodItem.
   * @param expirationDate of FoodItem.
   */
  public FoodItem(String nameOfFood, Float amount, String units,
                  Double pricePerUnit, LocalDate expirationDate){ // Makes it possible to create a FoodItem object.
    setNameOfFood(nameOfFood);
    setAmount(amount);
    setUnits(units);
    setPricePerUnit(pricePerUnit);
    setExpirationDate(expirationDate);
  }

  /** Mutates the <code>nameOfFood</code>.
   *
   * @return nameOfFood
   */
  public String getNameOfFood() {
    return nameOfFood;
  }

  /**
   * Mutates the <code>nameOfFood</code>.
   *
   * @param nameOfFood the FoodItem's name.
   * @throws IllegalArgumentException if nameOfFood null, empty or blank.
   */
  public void setNameOfFood(String nameOfFood) throws IllegalArgumentException {
    if (nameOfFood == null || nameOfFood.isEmpty() || nameOfFood.isBlank()) {
      throw new IllegalArgumentException("No input in name of food");
    }
    this.nameOfFood = nameOfFood;
  }

  /**
   * Mutates the amount.
   *
   * @return the amount of FoodItem.
   */
  public Float getAmount() {
    return amount;
  }

  /**
   * Mutates the <code>amount</code>.
   *
   * @param amount the FoodItem's amount.
   * @throws IllegalArgumentException if amount is 0 or a negative number.
   */
  public void setAmount(Float amount) throws IllegalArgumentException {
    if (amount <= 0) {
      throw new IllegalArgumentException("Amount can not be 0 or under");
    }
    this.amount = amount;
  }

  /**
   * Returns the units.
   *
   * @return units of the FoodItem.
   */
  public String getUnits() {
    return units;
  }

  /**
   * Mutates the <code>units</code>.
   *
   * @param units the FoodItem's unit.
   * @throws IllegalArgumentException if units is null, empty or blank.
   */
  public void setUnits(String units) throws IllegalArgumentException {
    if (units == null || units.isEmpty() || units.isBlank()) {
      throw new IllegalArgumentException("No input of units");
    }
    this.units = units;
  }

  /**
   * Return the expirationDate.
   *
   * @return expirationDate of the FoodItem.
   */
  public LocalDate getExpirationDate() {
    return expirationDate;
  }

  /**
   * Mutates the <code>expirationDate</code>.
   *
   * @param expirationDate the FoodItem's expiration date.
   * @throws IllegalArgumentException if expirationDate is in the past.
   */
  public void setExpirationDate(LocalDate expirationDate) throws IllegalArgumentException {
    if (expirationDate.isBefore(LocalDate.now())) {
      throw new IllegalArgumentException("Expiration date cannot be in the past.");
    }
    this.expirationDate = expirationDate;
  }

  /**
   * Returns the pricePerUnit.
   *
   * @return the pricePerUnit of the FoodItem.
   */
  public Double getPricePerUnit() {
    return pricePerUnit;
  }

  /**
   * Mutates the <code>price</code>.
   *
   * @param pricePerUnit the FoodItem's price.
   * @throws IllegalArgumentException if price is 0 or a negative number.
   */
  public void setPricePerUnit(Double pricePerUnit) throws IllegalArgumentException {
    if (pricePerUnit <= 0) {
      throw new IllegalArgumentException("Price can not be a 0 or lower.");
    }
    this.pricePerUnit = pricePerUnit;
  }



}
