package edu.ntnu.idi.bidata;

import java.time.LocalDate;

/**
 * Class for food
 */
public class Food {
    private String nameOfFood;
    private Amount amount;
    private LocalDate expirationDate;
    private float price;

    public Food(String nameOfFood, Amount amount, LocalDate expirationDate, float price) {
        this.nameOfFood = nameOfFood;
        this.amount = amount;
        this.expirationDate = expirationDate;
        this.price = price;
    }

    public String getNameOfFood() {
        return nameOfFood;
    }

    public void setNameOfFood(String nameOfFood) {
        this.nameOfFood = nameOfFood;
    }

    public Amount getAmount() {
        return amount;
    }

    public void setAmount(Amount amount) {
        this.amount = amount;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
