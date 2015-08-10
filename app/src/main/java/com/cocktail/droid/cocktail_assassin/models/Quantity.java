package com.cocktail.droid.cocktail_assassin.models;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by jigishchawda on 26/7/15.
 */
public class Quantity implements Parcelable {
    public static final String DEFAULT_UNIT = "ml";
    private int value;
    private String unit;

    private Quantity(String quantity) {
        value = Integer.parseInt(quantity);
        unit = DEFAULT_UNIT;
    }

    @Override
    public String toString() {
        return "Quantity{ " + value + " " + unit  + '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.value);
        dest.writeString(this.unit);
    }

    protected Quantity(Parcel in) {
        this.value = in.readInt();
        this.unit = in.readString();
    }

    public static final Parcelable.Creator<Quantity> CREATOR = new Parcelable.Creator<Quantity>() {
        public Quantity createFromParcel(Parcel source) {
            return new Quantity(source);
        }

        public Quantity[] newArray(int size) {
            return new Quantity[size];
        }
    };

    public static Quantity readQuantity(JSONObject recipeItemJSONObject) {
        try {
            return new Quantity(recipeItemJSONObject.getString("quantity"));
        } catch (JSONException e) {
            return new Quantity("0");
        }
    }
}
