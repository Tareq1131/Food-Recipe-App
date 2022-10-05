package com.tareq.android.food;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.tareq.android.food.Adapters.RandomRecipeAdapter;
import com.tareq.android.food.Listners.RandomRecipeResponseListener;
import com.tareq.android.food.Listners.RecipeClickListner;
import com.tareq.android.food.Models.RandomRecipeApiResponse;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ProgressDialog dialog;
    RequestManager manager;
    RandomRecipeAdapter randomRecipeAdapter;
    RecyclerView recyclerView;
    Spinner spinner;
    List<String> tags = new ArrayList<>();
    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dialog = new ProgressDialog(this);
        dialog.setTitle("Loading...");

        searchView = findViewById(R.id.searchView_home);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                tags.clear();
                tags.add(query);
                manager.getRandomRecipes(randomRecipeResponseListener,tags);
                dialog.show();
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        spinner = findViewById(R.id.spinner_tags);
        ArrayAdapter arrayAdapter = ArrayAdapter.createFromResource(
                this,
                R.array.tags,
                R.layout.spinner_text
        );
        arrayAdapter.setDropDownViewResource(R.layout.spinner_inner_text);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(spinnerSelectedListener);

        manager = new RequestManager(this);
//        manager.getRandomRecipes(randomRecipeResponseListener);
//        dialog.show();
    }

    private final RandomRecipeResponseListener randomRecipeResponseListener=
            new RandomRecipeResponseListener() {
                @Override
                public void didFetch(RandomRecipeApiResponse response, String message) {
                    dialog.dismiss();
                  recyclerView = findViewById(R.id.recycler_random);
                  recyclerView.setHasFixedSize(true);
                  recyclerView.setLayoutManager(new GridLayoutManager(MainActivity.this,1));
                  randomRecipeAdapter = new RandomRecipeAdapter
                          (MainActivity.this,response.getRecipes(), recipeClickListner);
                  recyclerView.setAdapter(randomRecipeAdapter);
                  dialog.dismiss();

                }

                @Override
                public void didError(String message) {
                    Toast.makeText(MainActivity.this, "Message", Toast.LENGTH_SHORT).show();
                }
            };

    private final AdapterView.OnItemSelectedListener spinnerSelectedListener =
            new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    tags.clear();
                    tags.add(parent.getSelectedItem(). toString());
                    manager.getRandomRecipes(randomRecipeResponseListener,tags);
                    dialog.show();
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {


                }
            };

    private final RecipeClickListner recipeClickListner = new RecipeClickListner() {
        @Override
        public void onRecipeClicked(String id) {
            //Toast.makeText(MainActivity.this, id, Toast.LENGTH_SHORT).show();
            startActivity(new Intent(MainActivity.this,RecipeDetailsActivity.class)
            .putExtra("id",id));

        }
    };
}