package edu.ntnu.idi.bidata;

import java.time.LocalDate;

/**
 * Class for food
 */
public class Food {
    private String nameOfFood;
    private Integer priceOfFood;
    private LocalDate expirationDate;
    private Amount amountOfFood;


    public String getNameOfFood() {
        return nameOfFood;
    }

    public void setNameOfFood(String nameOfFood) {
        this.nameOfFood = nameOfFood;
    }

    public Integer getPriceOfFood() {
        return priceOfFood;
    }

    public void setPriceOfFood(Integer priceOfFood) {
        this.priceOfFood = priceOfFood;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Amount getAmountOfFood() {
        return amountOfFood;
    }

    public void setAmountOfFood(Amount amountOfFood) {
        this.amountOfFood = amountOfFood;

    }


}
