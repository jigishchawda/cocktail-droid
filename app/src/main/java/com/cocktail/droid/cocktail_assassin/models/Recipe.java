package com.cocktail.droid.cocktail_assassin.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

/**
 * Created by jigishchawda on 26/7/15.
 */
public class Recipe {
    private HashMap<Ingredient, Quantity> ingredientsWithQuantity;

    private Recipe(HashMap<Ingredient, Quantity> ingredientsWithQuantity) {
        this.ingredientsWithQuantity = ingredientsWithQuantity;
    }

    public static Recipe readRecipe(JSONArray recipeJsonArray) {
        try {
            HashMap<Ingredient, Quantity> ingredientsWithQuantity = new HashMap<>();
            for (int index = 0; index < recipeJsonArray.length(); index++) {
                JSONObject recipeItemJSONObject = recipeJsonArray.getJSONObject(index);

                JSONObject ingredientJsonObject = recipeItemJSONObject.getJSONObject("ingredient");
                Ingredient ingredient = Ingredient.readIngredient(ingredientJsonObject);

                String quantity = recipeItemJSONObject.getString("quantity");

                ingredientsWithQuantity.put(ingredient, new Quantity(quantity));
            }

            return new Recipe(ingredientsWithQuantity);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Recipe recipe = (Recipe) o;

        return ingredientsWithQuantity.equals(recipe.ingredientsWithQuantity);

    }

    @Override
    public int hashCode() {
        return ingredientsWithQuantity.hashCode();
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "ingredientsWithQuantity=" + ingredientsWithQuantity +
                '}';
    }
}
