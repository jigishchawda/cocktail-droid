package com.cocktail.droid.cocktail_assassin.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by jigishchawda on 10/8/15.
 */
public class RecipeItem implements Parcelable {
    public final Ingredient ingredient;
    public final Quantity quantity;

    public RecipeItem(Ingredient ingredient, Quantity quantity) {
        this.ingredient = ingredient;
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RecipeItem that = (RecipeItem) o;

        if (!ingredient.equals(that.ingredient)) return false;
        return quantity.equals(that.quantity);

    }

    @Override
    public int hashCode() {
        int result = ingredient.hashCode();
        result = 31 * result + quantity.hashCode();
        return result;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.ingredient, 0);
        dest.writeParcelable(this.quantity, 0);
    }

    protected RecipeItem(Parcel in) {
        this.ingredient = in.readParcelable(Ingredient.class.getClassLoader());
        this.quantity = in.readParcelable(Quantity.class.getClassLoader());
    }

    public static final Parcelable.Creator<RecipeItem> CREATOR = new Parcelable.Creator<RecipeItem>() {
        public RecipeItem createFromParcel(Parcel source) {
            return new RecipeItem(source);
        }

        public RecipeItem[] newArray(int size) {
            return new RecipeItem[size];
        }
    };
}
