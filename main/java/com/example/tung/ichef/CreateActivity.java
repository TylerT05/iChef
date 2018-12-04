package com.example.tung.ichef;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.SearchView;
import android.widget.TextView;

public class CreateActivity extends AppCompatActivity {

    private RecipeDBHelper tdb = new RecipeDBHelper(CreateActivity.this);
    private Recipe recipe;

    EditText title_content;
    EditText ingredient_content;
    EditText direction_content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        title_content = (EditText)findViewById(R.id.title_content_c);
        ingredient_content = (EditText)findViewById(R.id.name_content_c);
        direction_content = (EditText)findViewById(R.id.directions_content_c);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getMenuInflater().inflate(R.menu.option_menu_create_and_edit, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case android.R.id.home:
                onBackPressed();
                break;
            case R.id.save_button:
                String[] ingredients = ingredient_content.getText().toString().split("\n");
                if(!title_content.getText().toString().equals("") && tdb.getTitle(title_content.getText().toString()).equals("")){
                    recipe = new Recipe(title_content.getText().toString(),null,ingredients,direction_content.getText().toString(),"u","no",null);
                    tdb.addRecipe(recipe);
                    tdb.addIngredient(recipe);
                    tdb.addDirection(recipe);

                    Intent intent_save = new Intent(CreateActivity.this, URecipeActivity.class);
                    intent_save.putExtra("title",title_content.getText().toString());
                    startActivity(intent_save);
                    break;
                }
                else{
                    title_content.setError("Your Title is invalid or already used!");
                }
        }
        return super.onOptionsItemSelected(item);
    }
}
