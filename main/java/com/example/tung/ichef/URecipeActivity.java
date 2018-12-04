package com.example.tung.ichef;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class URecipeActivity extends AppCompatActivity {

    private RecipeDBHelper tdb = new RecipeDBHelper(URecipeActivity.this);
    private String x = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_urecipe);

        Intent i = getIntent();
        String t = i.getStringExtra("title");
        x = t;

        TextView title = (TextView) findViewById(R.id.title_content_u);
        title.setText(t); //names[p]);
        TextView ingredient = (TextView) findViewById(R.id.ingredient_content_u);
        ingredient.setText(tdb.getIngredient(t)); //recipe_ingredient[p]);
        TextView direction = (TextView) findViewById(R.id.direction_content_u);
        direction.setText(tdb.getDirection(t)); //recipe_directions[p]);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getMenuInflater().inflate(R.menu.option_menu_u_recipe, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
//        switch (item.getItemId()){
//            case android.R.id.home:
//                onBackPressed();
//                break;
//        }
//        return true;

        switch (item.getItemId()){
            case android.R.id.home:
                onBackPressed();
                break;
            case R.id.edit:
                Intent intent_edit = new Intent(URecipeActivity.this, EditActivity.class);
                intent_edit.putExtra("title",x);
                startActivity(intent_edit);
                break;
            case R.id.delete:
                tdb.deleteRecipe(x);
                Intent intent_your_list = new Intent(URecipeActivity.this, YourListActivity.class);
                startActivity(intent_your_list);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
