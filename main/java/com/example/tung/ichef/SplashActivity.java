package com.example.tung.ichef;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity {

    private Handler mWaitHandler = new Handler();

    Recipe recipe;

    private RecipeDBHelper tdb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        this.deleteDatabase("recipeManager");
        tdb = new RecipeDBHelper(this);

        String title_1 = "Hamburger Steak with Onions and Gravy";
        String title_2 = "Bats and Cobwebs";
        String title_3 = "Three-Ingredient Baked Chicken Breasts";
        String title_4 = "Chinese Pepper Steak";

        String author_1 = "Anne Marie Sweden";
        String author_2 = "Kristin McNeil";
        String author_3 = "Jennifer Jones";
        String author_4 = "Kim Wilson";

        String[] ingredients_1 = {"- 1 pound ground beef",
                                    "- 1 egg",
                                    "- 1/4 cup bread crumbs",
                                    "- 1/8 teaspoon ground pepper",
                                    "- 1/2 teaspoon seasoned salt",
                                    "- 1/2 teaspoon onion powder",
                                    "- 1/2 teaspoon garlic powder",
                                    "- 1 teaspoon Worcestershire sauce",
                                    "- 1 tablespoon vegetable oil",
                                    "- 1 cup thinly sliced onion",
                                    "- 2 tablespoons all-purpose flour",
                                    "- 1 cup beef broth",
                                    "- 1 tablespoon cooking sherry",
                                    "- 1/2 teaspoon seasoned salt"};
        String[] ingredients_2 = {"- 1 (8 ounce) package farfalle (bow tie) pasta",
                                    "- 1 pound ground beef",
                                    "- 1 small onion, chopped (optional)",
                                    "- 1 (28 ounce) jar pasta sauce",
                                    "- 8 ounces mozzarella cheese, cut into 1/2 inch cubes",
                                    "- 1/4 cup grated Parmesan cheese"};
        String[] ingredients_3 = {"- 1/4 cup butter, melted",
                                    "- 1 teaspoon salt",
                                    "- 4 skinless, boneless chicken breast halves"};
        String[] ingredients_4 = {"- 1 pound beef top sirloin steak",
                                    "- 1/4 cup soy sauce",
                                    "- 2 tablespoons white sugar",
                                    "- 2 tablespoons cornstarch",
                                    "- 1/2 teaspoon ground ginger",
                                    "- 3 tablespoons vegetable oil, divided",
                                    "- 1 red onion, cut into 1-inch squares",
                                    "- 1 green bell pepper, cut into 1-inch squares",
                                    "- 2 tomatoes, cut into wedges"};

        String direction_1 = "    - In large bowl, mix together the ground beef, egg, bread crumbs, pepper, salt, onion powder, garlic powder, and Worcestershire sauce. Form into 8 balls, and flatten into patties." +
                            "\n\n    - Heat the oil in a large skillet over medium heat. Fry the patties and onion in the oil until patties are nicely browned, about 4 minutes per side. Remove the beef patties to a plate, and keep warm." +
                            "\n\n    - Sprinkle flour over the onions and drippings in the skillet. Stir in flour with a fork, scraping bits of beef off of the bottom as you stir. Gradually mix in the beef broth and sherry. Season with seasoned salt. Simmer and stir over medium-low heat for about 5 minutes, until the gravy thickens. Turn heat to low, return patties to the gravy, cover, and simmer for another 15 minutes.";
        String direction_2 = "    - Preheat oven to 400 degrees F (200 degrees C)." +
                            "\n\n    - Fill a large pot with lightly salted water, bring to a rolling boil over high heat. Stir in the bow tie pasta and return to a boil. Boil pasta, stirring occasionally, until cooked through but still firm to the bite, about 12 minutes. Brain well." +
                            "\n\n    - Cook and stir ground beef and onion in a large skillet until beef is no longer pink, about 5 minutes. Drain fat. Stir in pasta sauce and bring to a boil. Reduce heat to simmer." +
                            "\n\n    - Stir cooked pasta and half of the mozzarella cheese into the sauce; toss to combine. Transfer to a 2-quart baking dish. Top with remaining mozzarella and Parmesan cheese." +
                            "\n\n    - Bake in preheated oven until lightly browned and bubbly, 15 to 20 minutes.";
        String direction_3 = "    - Preheat oven to 350 degrees F (175 degrees C). Lightly butter a baking dish." +
                            "\n\n    - Stir 1/4 cup melted butter and salt together in a bowl." +
                            "\n\n    - Arrange chicken in the baking dish. Brush butter mixture onto the chicken until thoroughly coated, pouring any extra over the chicken." +
                            "\n\n    - Bake in the preheated oven until no longer pink in the center and the juices run clear, about 30 to 45 minutes. An instant-read thermometer inserted into the center should read at least 165 degrees F (74 degrees C).";
        String direction_4 = "\"    - Slice the steak into 1/2-inch thick slices across the grain." +
                            "\n\n    - Whisk together soy sauce, sugar, cornstarch, and ginger in a bowl until the sugar has dissolved and the mixture is smooth. Place the steak slices into the marinade, and stir until well-coated." +
                            "\n\n    - Heat 1 teaspoon of vegetable oil in a wok or large skillet over medium-high heat, and place 1/3 of the steak strips into the hot oil. Cook and stir until the beef is well-browned, about 3 minutes, and remove the beef from the wok to a bowl. Repeat twice more, with the remaining beef, and set the cooked beef aside." +
                            "\n\n    - Return all the cooked beef to the hot wok, and stir in the onion. Toss the beef and onion together until the onion begins to soften, about 2 minutes, then stir in the green pepper. Cook and stir the mixture until the pepper has turned bright green and started to become tender, about 2 minutes, then add the tomatoes, stir everything together, and serve.";

        String reference_1 = "https://www.allrecipes.com/recipe/78370/hamburger-steak-with-onions-and-gravy/?internalSource=hub%20recipe&referringContentType=Search&clickId=cardslot%201";
        String reference_2 = "https://www.allrecipes.com/recipe/216231/bats-and-cobwebs/?internalSource=hub%20recipe&referringContentType=Search&clickId=cardslot%202";
        String reference_3 = "https://www.allrecipes.com/recipe/239137/three-ingredient-baked-chicken-breasts/?internalSource=hub%20recipe&referringContentType=Search&clickId=cardslot%201";
        String reference_4 = "https://www.allrecipes.com/recipe/172704/chinese-pepper-steak/?internalSource=hub%20recipe&referringContentType=Search&clickId=cardslot%201";

        recipe = new Recipe(title_1,author_1,ingredients_1,direction_1,"s","no",reference_1);

        tdb.addRecipe(recipe);
        tdb.addIngredient(recipe);
        tdb.addDirection(recipe);

        recipe = new Recipe(title_2,author_2,ingredients_2,direction_2,"s","no",reference_2);

        tdb.addRecipe(recipe);
        tdb.addIngredient(recipe);
        tdb.addDirection(recipe);

        recipe = new Recipe(title_3,author_3,ingredients_3,direction_3,"s","no",reference_3);

        tdb.addRecipe(recipe);
        tdb.addIngredient(recipe);
        tdb.addDirection(recipe);

        recipe = new Recipe(title_4,author_4,ingredients_4,direction_4,"s","no",reference_4);

        tdb.addRecipe(recipe);
        tdb.addIngredient(recipe);
        tdb.addDirection(recipe);

        mWaitHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                try{
                    Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                    startActivity(intent);
                    finish();
                } catch (Exception ignored){
                    ignored.printStackTrace();
                }
            }
        }, 2000);
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        mWaitHandler.removeCallbacksAndMessages(null);
    }
}
