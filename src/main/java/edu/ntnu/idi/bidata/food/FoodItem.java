package edu.ntnu.idi.bidata.food;

import java.time.LocalDate;

/**
 * Class for FoodItem
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
     * @param amount         of Grocery FoodItem.
     * @param units          of the FoodItem.
     * @param price          of FoodItem.
     * @param expirationDate of FoodItem.
     */
    public FoodItem(String nameOfFood, Float amount, String units, Double price, LocalDate expirationDate) {
        setNameOfFood(nameOfFood);
        setAmount(amount);
        setUnits(units);
        setPrice(price);
        setExpirationDate(expirationDate);
    }

    /**
     * Return the nameOfFood.
     *
     * @return nameOfFood of FoodItem.
     */
    public String getNameOfFood() {
        return nameOfFood;
    }

    /**
     * Mutate the <code>nameOfFood</code>
     * Exception to check that nameOfFood is not blank or empty.
     * Throws an IllegalArgumentException if empty or blank.
     *
     * @param nameOfFood the FoodItem's name.
     * @throws IllegalArgumentException if null....
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
     * Mutates the amount.
     * Exception to check that amount is not a negative number.
     * Throws an IllegalArgumentException if Amount is a negative number.
     *
     * @param amount the FoodItem's amount.
     */
    public void setAmount(Float amount) {
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
     * Mutates the units.
     * Exception to check that units is not blank or empty.
     * Throws an IllegalArgumentException if empty or blank.
     *
     * @param units the FoodItem's unit.
     */
    public void setUnits(String units) {
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
     * Mutates the expirationDate.
     * Exception to check that expirationDate is the present date.
     * Throws an IllegalArgumentException if the expiration date is before the present date.
     *
     * @param expirationDate the FoodItem's expiration date.
     */
    public void setExpirationDate(LocalDate expirationDate) {
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
     * Mutates the price.
     * Exception to check that price is not a negative number.
     * Throws an IllegalArgumentException if the price is a negative number.
     *
     * @param price the FoodItem's price.
     */
    public void setPrice(Double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Price can not be a negative input.");
        }
        this.price = price;
    }

    public String displayFoodItem() {
        return String.format("%s - %.1f %s, Price: %.2f, Expiration Date: %s",
                nameOfFood, amount, units, price*amount, expirationDate);
    }
}
