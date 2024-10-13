package edu.ntnu.idi.bidata;

public class Amount {
    private Float kilogram;
    private Float liters;
    private Integer pieces;

    public Amount(Float kilogram, Float liters, Integer pieces){

    }
    public Float getKilogram() {
        return kilogram;
    }

    public void setKilogram(Float kilogram) {
        this.kilogram = kilogram;
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
}

