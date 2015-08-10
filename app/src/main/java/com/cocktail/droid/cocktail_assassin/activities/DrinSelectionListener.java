package com.cocktail.droid.cocktail_assassin.activities;

import com.cocktail.droid.cocktail_assassin.models.Drink;

/**
 * Created by jigishchawda on 30/7/15.
 */
public interface DrinSelectionListener {
    void onDrinkDetailSelected(Drink drink);
    void onPourMeADrinkSelected(Drink drink);
}
