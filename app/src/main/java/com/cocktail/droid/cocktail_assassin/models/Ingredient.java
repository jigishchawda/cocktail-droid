package com.cocktail.droid.cocktail_assassin.models;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by jigishchawda on 26/7/15.
 */
public class Ingredient {
    private String name;
    private IngredientType ingredientType;

    private Ingredient(){}

    private Ingredient(String name, String ingredientType) {
        this.name = name;
        this.ingredientType = IngredientType.getIngredientTypeFor(ingredientType);
    }

    public static Ingredient readIngredient(JSONObject ingredientJsonObject) {
        try {
            String name = ingredientJsonObject.getString("name");
            String type = ingredientJsonObject.getString("type");

            return new Ingredient(name, type);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ingredient that = (Ingredient) o;

        if (!name.equals(that.name)) return false;
        return ingredientType == that.ingredientType;

    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + (ingredientType != null ? ingredientType.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "name='" + name + '\'' +
                ", ingredientType=" + ingredientType +
                '}';
    }
}
