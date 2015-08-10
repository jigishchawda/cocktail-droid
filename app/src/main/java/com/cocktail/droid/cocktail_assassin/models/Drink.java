package com.cocktail.droid.cocktail_assassin.models;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by jigishchawda on 26/7/15.
 */
public class Drink implements Parcelable {
    public static final String DRINK_EXTRA = "com.cocktail.droid.cocktail_assassin.models.drink";
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

    public String getName() {
        return name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeParcelable(this.recipe, flags);
    }

    protected Drink(Parcel in) {
        this.name = in.readString();
        this.recipe = in.readParcelable(Recipe.class.getClassLoader());
    }

    public static final Parcelable.Creator<Drink> CREATOR = new Parcelable.Creator<Drink>() {
        public Drink createFromParcel(Parcel source) {
            return new Drink(source);
        }

        public Drink[] newArray(int size) {
            return new Drink[size];
        }
    };
}

