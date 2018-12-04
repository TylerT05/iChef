package com.example.tung.ichef;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class EditActivity extends AppCompatActivity {

    private RecipeDBHelper tdb = new RecipeDBHelper(EditActivity.this);
    private Recipe recipe;

    String x = "";

    EditText title_content;
    EditText ingredient_content;
    EditText direction_content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        Intent i = getIntent();
        String t = i.getStringExtra("title");
        x = t;

        title_content = (EditText)findViewById(R.id.title_content_e);
        title_content.setText(tdb.getTitle(t));
        ingredient_content = (EditText)findViewById(R.id.name_content_e);
        ingredient_content.setText(tdb.getIngredient(t));
        direction_content = (EditText)findViewById(R.id.directions_content_e);
        direction_content.setText(tdb.getDirection(t));
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
                if(title_content.getText().toString().equals(tdb.getTitle(x)) && ingredient_content.getText().toString().equals(tdb.getIngredient(x)) && direction_content.getText().toString().equals(tdb.getDirection(x))){
                    Intent intent_save = new Intent(EditActivity.this, URecipeActivity.class);
                    intent_save.putExtra("title",title_content.getText().toString());
                    startActivity(intent_save);
                    break;
                }else if(!title_content.getText().toString().equals("")){
                    if(title_content.getText().toString().equals(tdb.getTitle(x))){
                        tdb.deleteRecipe(x);
                        recipe = new Recipe(title_content.getText().toString(),null,ingredients,direction_content.getText().toString(),"u","no",null);
                        tdb.addRecipe(recipe);
                        tdb.addIngredient(recipe);
                        tdb.addDirection(recipe);
                        Intent intent_save = new Intent(EditActivity.this, URecipeActivity.class);
                        intent_save.putExtra("title",title_content.getText().toString());
                        startActivity(intent_save);
                        break;
                    }
                    else if(tdb.getTitle(title_content.getText().toString()).equals("")){
                        tdb.deleteRecipe(x);
                        recipe = new Recipe(title_content.getText().toString(),null,ingredients,direction_content.getText().toString(),"u","no",null);
                        tdb.addRecipe(recipe);
                        tdb.addIngredient(recipe);
                        tdb.addDirection(recipe);
                        Intent intent_save = new Intent(EditActivity.this, URecipeActivity.class);
                        intent_save.putExtra("title",title_content.getText().toString());
                        startActivity(intent_save);
                        break;
                    }
                    else{
                        title_content.setError("Your Title is invalid or already used!");
                    }
                }
                else{
                    title_content.setError("Your Title is invalid or already used!");
                }
        }
        return super.onOptionsItemSelected(item);
    }
}
