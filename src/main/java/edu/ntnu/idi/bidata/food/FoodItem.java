package edu.ntnu.idi.bidata.food;

import java.time.LocalDate;

/**
 * Class for <code>FoodItem</code>.
 */
public class FoodItem {
  private String nameOfFood; //used food instead
  private Float amount;
  private String units;
  private LocalDate expirationDate;
  private Double price;

  /**
   * A constructor for the class FoodItem.
   *
   * @param nameOfFood     the name of FoodItem.
   * @param amount         of FoodItem.
   * @param units          of the FoodItem.
   * @param price          of FoodItem.
   * @param expirationDate of FoodItem.
   */
  public FoodItem(String nameOfFood, Float amount, String units,
                  Double price, LocalDate expirationDate) {
    setNameOfFood(nameOfFood);
    setAmount(amount);
    setUnits(units);
    setPrice(price);
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
   * Mutate the <code>nameOfFood</code>.
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
   * Return the amount.
   *
   * @return the amount of FoodItem.
   */
  public Float getAmount() {
    return amount;
  }

  /**
   * Mutates the <code>amount</code>.
   * @param amount the FoodItem's amount.
   * @throws IllegalArgumentException if amount is less than 0.1
   */
  public void setAmount(Float amount) throws IllegalArgumentException {
    if (amount < 0.1) {
      throw new IllegalArgumentException("Amount can not be under 0");
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
   * Returns the price.
   *
   * @return the price of the FoodItem.
   */
  public Double getPrice() {
    return price;
  }

  /**
   * Mutates the <code>price</code>.
   *
   * @param price the FoodItem's price.
   * @throws IllegalArgumentException if price is a negative number.
   */
  public void setPrice(Double price) throws IllegalArgumentException {
    if (price < 0) {
      throw new IllegalArgumentException("Price can not be a negative input.");
    }
    this.price = price;
  }

  public String displayFoodItem() {
    return String.format("%s - %.1f %s, Price: %.2f, Expiration Date: %s",
        nameOfFood, amount, units, price * amount, expirationDate);
  }

  public boolean validToMerge(FoodItem foodToBeValidated){
    boolean validMerge = false;
    if(this.getNameOfFood().equalsIgnoreCase(foodToBeValidated.getNameOfFood())){
      foodToBeValidated.mergeFood(foodToBeValidated);
      validMerge = true;
    }
    return validMerge;
  }

  public void mergeFood(FoodItem foodToBeMerged){
    Float newAmount = this.amount + foodToBeMerged.amount;
    this.setAmount(newAmount);
  }

  public boolean validToTake(FoodItem foodToBeValidated) {
    boolean validTake = false;
    if (this.getNameOfFood().equalsIgnoreCase(foodToBeValidated.getNameOfFood())
        && this.amount >= foodToBeValidated.amount) {
      this.amountToTake(foodToBeValidated);
      validTake = true;
    }
    return validTake;
  }

  public void amountToTake(FoodItem foodToBeMerged) {
    this.amount -= foodToBeMerged.amount;
  }


}
