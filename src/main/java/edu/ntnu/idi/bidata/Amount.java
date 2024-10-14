package edu.ntnu.idi.bidata;

public class Amount {
    private Float amount;
    private String units;
    private Float kilogram;
    private Float gram;
    private Float liters;
    private Integer pieces;
    private float foodPrive;
    public Amount(Float amount, String units){
        setAmount(amount);
        setUnits(units);
        /*
        setKilogram(kilogram);
        setGram(gram);
        setLiters(liters);
        setPieces(pieces);
         */

    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    /*
    public Float getKilogram() {
        return kilogram;
    }

    public void setKilogram(Float kilogram) {
        this.kilogram = kilogram;
    }

    public Float getGram() {
        return gram;
    }

    public void setGram(Float gram) {
        this.gram = gram;
    }

    public Float getLiters() {
        return liters;
    }

    public void setLiters(Float liters) {
        this.liters = liters;
    }

    public Integer getPieces() {
        return pieces;
    }

    public void setPieces(Integer pieces) {
        this.pieces = pieces;
    }
     */

}

