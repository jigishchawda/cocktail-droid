package com.cocktail.droid.cocktail_assassin.models;

/**
 * Created by jigishchawda on 26/7/15.
 */
public class Quantity {
    public static final String DEFAULT_UNIT = "ml";
    private int value;
    private String unit;

    public Quantity(String quantity) {
        value = Integer.parseInt(quantity);
        unit = DEFAULT_UNIT;
    }

    @Override
    public String toString() {
        return "Quantity{ " + value + " " + unit  + '}';
    }
}
