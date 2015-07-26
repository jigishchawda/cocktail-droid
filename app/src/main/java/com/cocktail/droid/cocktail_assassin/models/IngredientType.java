package com.cocktail.droid.cocktail_assassin.models;

/**
 * Created by jigishchawda on 26/7/15.
 */
public enum IngredientType {
    ALCOHOLIC("alcoholic"),
    NON_ALCOHOLIC("non_alcoholic"),
    UNKNOWN("unknown");

    private String type;

    IngredientType(String type) {
        this.type = type;
    }

    public static IngredientType getIngredientTypeFor(String type) {
        IngredientType[] values = values();
        for (IngredientType value : values) {
            if(value.type.equalsIgnoreCase(type)) return value;
        }
        return UNKNOWN;
    }
}
