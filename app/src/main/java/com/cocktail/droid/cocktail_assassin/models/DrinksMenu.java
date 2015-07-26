package com.cocktail.droid.cocktail_assassin.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by jigishchawda on 26/7/15.
 */
public class DrinksMenu {
    private ArrayList<Drink> drinks;


    public static void loadDrinksMenu(String jsonString) {
        try {
            JSONObject drinksJsonObject = new JSONObject(jsonString);
            ArrayList<Drink> drinks = new ArrayList<>();

            JSONArray drinksJsonArray = drinksJsonObject.getJSONArray("drinks");
            for (int index = 0; index < drinksJsonArray.length(); index++) {
                JSONObject drinkJsonObject = drinksJsonArray.getJSONObject(index);
                Drink drink = Drink.readDrink(drinkJsonObject);

                System.out.println("##################\n" + drink + "\n#####################");
                drinks.add(drink);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
