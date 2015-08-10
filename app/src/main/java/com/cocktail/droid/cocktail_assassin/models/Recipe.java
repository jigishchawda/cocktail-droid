package com.cocktail.droid.cocktail_assassin.models;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import static com.cocktail.droid.cocktail_assassin.models.Ingredient.readIngredient;
import static com.cocktail.droid.cocktail_assassin.models.Quantity.readQuantity;

/**
 * Created by jigishchawda on 26/7/15.
 */
public class Recipe implements Parcelable {
//    private HashMap<Ingredient, Quantity> ingredientsWithQuantity;

    private ArrayList<RecipeItem> recipeItems;

    private Recipe(ArrayList<RecipeItem> items) {
        this.recipeItems = items;
    }

    public static Recipe readRecipe(JSONArray recipeJsonArray) {
        try {
//            HashMap<Ingredient, Quantity> ingredientsWithQuantity = new HashMap<>();
            ArrayList<RecipeItem> recipeItems = new ArrayList<>();
            for (int index = 0; index < recipeJsonArray.length(); index++) {
                JSONObject recipeItemJSONObject = recipeJsonArray.getJSONObject(index);

                JSONObject ingredientJsonObject = recipeItemJSONObject.getJSONObject("ingredient");

                recipeItems.add(new RecipeItem(readIngredient(ingredientJsonObject), readQuantity(recipeItemJSONObject)));
            }

            return new Recipe(recipeItems);
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

        return recipeItems.equals(recipe.recipeItems);

    }

    @Override
    public int hashCode() {
        return recipeItems.hashCode();
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "ingredientsWithQuantity=" + recipeItems +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(this.recipeItems);
    }

    protected Recipe(Parcel in) {
        recipeItems = in.createTypedArrayList(RecipeItem.CREATOR);
    }

    public static final Parcelable.Creator<Recipe> CREATOR = new Parcelable.Creator<Recipe>() {
        public Recipe createFromParcel(Parcel source) {
            return new Recipe(source);
        }

        public Recipe[] newArray(int size) {
            return new Recipe[size];
        }
    };
}
