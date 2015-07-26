package com.cocktail.droid.cocktail_assassin.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by jigishchawda on 26/7/15.
 */
public class Drink {
    private String name;
    private Recipe recipe;

    private Drink(String name, Recipe recipe) {
        this.name = name;
        this.recipe = recipe;
    }

    public static Drink readDrink(JSONObject drinkJsonObject) {
        try {
            String name = drinkJsonObject.getString("name");

            JSONArray recipeJsonArray = drinkJsonObject.getJSONArray("recipe");
            Recipe recipe = Recipe.readRecipe(recipeJsonArray);

            return new Drink(name, recipe);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String toString() {
        return "Drink{" +
                "name='" + name + '\'' +
                ", recipe=" + recipe +
                '}';
    }
}

