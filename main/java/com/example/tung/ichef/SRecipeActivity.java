package com.example.tung.ichef;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class SRecipeActivity extends AppCompatActivity {

    private RecipeDBHelper tdb = new RecipeDBHelper(SRecipeActivity.this);
    private String x = "";
    private String n = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_srecipe);

        Intent i = getIntent();
        String t = i.getStringExtra("title");
        x = t;

        n = i.getStringExtra("n");

        ImageView image = (ImageView)findViewById(R.id.image);
        if(x.equals("Hamburger Steak with Onions and Gravy")){
            image.setImageResource(R.drawable.hamburger_steak_with_onions_and_gravy);
        } else if(x.equals("Bats and Cobwebs")){
            image.setImageResource(R.drawable.bats_and_cobwebs);
        } else if(x.equals("Three-Ingredient Baked Chicken Breasts")){
            image.setImageResource(R.drawable.three_ingredient_baked_chicken_breasts);
        } else if(x.equals("Chinese Pepper Steak")){
            image.setImageResource(R.drawable.chinese_pepper_steak);
        }

        TextView title = (TextView) findViewById(R.id.title_content_s);
        title.setText(t); //names[p]);
        TextView author = (TextView) findViewById(R.id.author_content_s);
        author.setText(tdb.getAuthor(t)); //recipe_author[p]);
        TextView ingredient = (TextView) findViewById(R.id.ingredient_content_s);
        ingredient.setText(tdb.getIngredient(t)); //recipe_ingredient[p]);
        TextView direction = (TextView) findViewById(R.id.direction_content_s);
        direction.setText(tdb.getDirection(t)); //recipe_directions[p]);
        TextView reference = (TextView) findViewById(R.id.reference_content);
        reference.setText(tdb.getReference(t));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getMenuInflater().inflate(R.menu.option_menu_s_recipe, menu);
        MenuItem itemFavorite = menu.findItem(R.id.add_favorite);

        if(tdb.checkFavorite(x)){
            itemFavorite.setIcon(android.R.drawable.btn_star_big_on);
        } else if(tdb.checkFavorite(x) == false){
            itemFavorite.setIcon(android.R.drawable.btn_star_big_off);
        }

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
//                onBackPressed();
                if(n.equals("Home")){
                    Intent intent_home = new Intent(SRecipeActivity.this, HomeActivity.class);
                    startActivity(intent_home);
                } else if(n.equals("Favorite")){
                    Intent intent_favorite = new Intent(SRecipeActivity.this, FavoriteActivity.class);
                    startActivity(intent_favorite);
                }
                break;
            case R.id.add_favorite:
//                tdb.addFavorite(x);
                if(tdb.checkFavorite(x)){
                    tdb.removeFavorite(x);
                    item.setIcon(android.R.drawable.btn_star_big_off);

                } else if(tdb.checkFavorite(x) == false){
                    tdb.addFavorite(x);
                    item.setIcon(android.R.drawable.btn_star_big_on);
                }
                break;
//            case R.id.remove_favorite:
//                tdb.removeFavorite(x);
//                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
