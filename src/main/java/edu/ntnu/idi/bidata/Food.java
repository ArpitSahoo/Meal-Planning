package edu.ntnu.idi.bidata;

import java.time.LocalDate;

/**
 * Class for food
 */
public class Food {
    private String nameOfFood;
    private Float amount;
    private String units;
    private LocalDate expirationDate;
    private Float price;

    public Food(String nameOfFood, Float amount, String units, Float price, LocalDate expirationDate){
        setNameOfFood(nameOfFood);
        setAmount(amount);
        setUnits(units);
        setPrice(price);
        setExpirationDate(expirationDate);
    }

    public String getNameOfFood() {
        return nameOfFood;
    }

    public void setNameOfFood(String nameOfFood) {
        if(nameOfFood == null || nameOfFood.isEmpty() || nameOfFood.isBlank()){
            throw new IllegalArgumentException("No input in name of food");
        }
        this.nameOfFood = nameOfFood;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        if(amount < 0){
            throw new IllegalArgumentException("Amount can not be under 0" + units);
        }
        this.amount = amount;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        if(units == null || units.isEmpty() || units.isBlank()){
            throw new IllegalArgumentException("No input of units");
        }
        this.units = units;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        if (expirationDate.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Expiration date cannot be in the past.");
        }
        this.expirationDate = expirationDate;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        if(price < 0){
            throw new IllegalArgumentException("Price can not be a negative input.");
        }
        this.price = price;
    }
}
