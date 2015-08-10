package com.cocktail.droid.cocktail_assassin.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.cocktail.droid.cocktail_assassin.R;
import com.cocktail.droid.cocktail_assassin.adapters.DrinksMenuAdapter;
import com.cocktail.droid.cocktail_assassin.models.Drink;
import com.cocktail.droid.cocktail_assassin.models.DrinksMenu;

import static com.cocktail.droid.cocktail_assassin.models.Drink.*;


public class CocktailMenuActivity extends ActionBarActivity implements DrinSelectionListener{
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cocktail_menu);

        recyclerView = (RecyclerView) findViewById(R.id.drinks_menu_view);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // specify an adapter (see also next example)
        adapter = new DrinksMenuAdapter(DrinksMenu.loadDrinksMenu(getResources()), this);

        recyclerView.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_cocktail_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onDrinkDetailSelected(Drink drink) {
        Intent intent = new Intent(this, DrinkDetailActivity.class);
        intent.putExtra(DRINK_EXTRA, drink);

        startActivity(intent);
    }

    @Override
    public void onPourMeADrinkSelected(Drink drink) {

    }
}
