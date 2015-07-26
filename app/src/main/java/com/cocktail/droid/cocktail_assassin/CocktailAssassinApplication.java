package com.cocktail.droid.cocktail_assassin;

import android.app.Application;

import com.cocktail.droid.cocktail_assassin.models.DrinksMenu;
import com.cocktail.droid.cocktail_assassin.utils.ResourceLoader;

/**
 * Created by jigishchawda on 26/7/15.
 */
public class CocktailAssassinApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        loadMenu();
    }

    public void loadMenu() {
        String jsonString = ResourceLoader.loadRawResourceAsString(getResources(), R.raw.drinks);
        DrinksMenu.loadDrinksMenu(jsonString);
    }

}
