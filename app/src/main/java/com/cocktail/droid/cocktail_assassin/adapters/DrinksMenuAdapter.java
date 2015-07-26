package com.cocktail.droid.cocktail_assassin.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cocktail.droid.cocktail_assassin.R;
import com.cocktail.droid.cocktail_assassin.models.Drink;

import java.util.ArrayList;

/**
 * Created by jigishchawda on 26/7/15.
 */
public class DrinksMenuAdapter extends RecyclerView.Adapter<DrinksMenuAdapter.ViewHolder> {
    private ArrayList<Drink> drinks;

    public static interface DrinkItemTouchListener {
        public void onDrinkItemSelected(String drinkName);
    }
    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private final DrinkItemTouchListener listener;
        public TextView drinkNameTextView;

        public ViewHolder(View view, DrinkItemTouchListener listener) {
            super(view);
            this.listener = listener;
            drinkNameTextView = (TextView) view.findViewById(R.id.drink_name);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            String drinkName = drinkNameTextView.getText().toString();
            listener.onDrinkItemSelected(drinkName);
        }
    }
    public DrinksMenuAdapter(ArrayList<Drink> drinks) {
        this.drinks = drinks;
    }

    @Override
    public DrinksMenuAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.drink_item_view, parent, false);
        return new ViewHolder(view, new DrinkItemTouchListener() {
            @Override
            public void onDrinkItemSelected(String drinkName) {
                Drink selectedDrink = getDrinkWithName(drinkName);
                if(selectedDrink != null) {
                    //open drink details activity
                    System.out.println("##########\n" + "Selected drink : " + selectedDrink + "\n################");
                }
            }
        });
    }

    private Drink getDrinkWithName(String drinkName) {
        for (Drink drink : drinks) {
            if(drink.getName().equalsIgnoreCase(drinkName)) return drink;
        }
        return null;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        viewHolder.drinkNameTextView.setText(drinks.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return drinks.size();
    }

}
