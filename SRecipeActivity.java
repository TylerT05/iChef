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
        } else if(x.equals("General Tsao's Chicken II")){
            image.setImageResource(R.drawable.general_tsaos_chicken_ii);
        } else if(x.equals("Baja Fish Tacos")){
            image.setImageResource(R.drawable.baja_fish_tacos);
        } else if(x.equals("Chilaquiles")) {
            image.setImageResource(R.drawable.chilaquiles);
        } else if(x.equals("Black Bean Burritos")){
            image.setImageResource(R.drawable.black_bean_burritos);
        } else if(x.equals("Chicken Parmesan")){
            image.setImageResource(R.drawable.chicken_parmesan);
        } else if(x.equals("Double Layer Pumpkin Cheesecake")) {
            image.setImageResource(R.drawable.double_layer_pumpkin_cheesecake);
        } else if(x.equals("Ultra Easy Pineapple and Chicken Kabobs")){
            image.setImageResource(R.drawable.ultra_easy_pineapple_chicken_kabobs);
        } else if(x.equals("Pan Fried Sand Dabs")){
            image.setImageResource(R.drawable.pan_fried_sand_dabs);
        } else if(x.equals("The Best Sweet and Sour Meatballs")){
            image.setImageResource(R.drawable.the_best_sweet_and_sour_meatballs);
        } else if(x.equals("Easy Mexican Casserole")){
            image.setImageResource(R.drawable.easy_mexican_casserole);
        } else if(x.equals("Slow Cooker Beef Stew I")) {
            image.setImageResource(R.drawable.slow_cooker_beef_stew_i);
        } else if(x.equals("World's Best Lasagna")){
            image.setImageResource(R.drawable.worlds_best_lasagna);
        } else if(x.equals("Loaded Crack Potatoes")){
            image.setImageResource(R.drawable.loaded_crack_potatoes);
        } else if(x.equals("Bourbon Street Rib-Eye Steak")) {
            image.setImageResource(R.drawable.bourbon_street_rib_eye_steak);
        } else if(x.equals("Salsa Chicken Rice Casserole")){
            image.setImageResource(R.drawable.salsa_chickedn_rice_casserole);
        } else if(x.equals("Salisbury Steak")){
            image.setImageResource(R.drawable.salisbury_steak);
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
