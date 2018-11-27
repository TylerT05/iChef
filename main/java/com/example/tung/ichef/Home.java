package com.example.tung.ichef;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

public class Home extends AppCompatActivity implements SearchView.OnQueryTextListener {

    private SearchView mSearchView;
    private ListView mListView;

    String[] titles = {"Hamburger Steak with Onions and Gravy","Bats and Cobwebs","Three-Ingredient Baked Chicken Breasts","Chinese Pepper Steak"};
//    String[] recipe_author = {"Anne Marie Sweden","Kristin McNeil","Jennifer Jones","Kim Wilson"};
//    String[] recipe_ingredient = {"    - 1 pound ground beef" +
//                                        "\n    - 1 egg" +
//                                        "\n    - 1/4 cup bread crumbs" +
//                                        "\n    - 1/8 teaspoon ground pepper" +
//                                        "\n    - 1/2 teaspoon seasoned salt" +
//                                        "\n    - 1/2 teaspoon onion powder" +
//                                        "\n    - 1/2 teaspoon garlic powder" +
//                                        "\n    - 1 teaspoon Worcestershire sauce" +
//                                        "\n    - 1 tablespoon vegetable oil" +
//                                        "\n    - 1 cup thinly sliced onion" +
//                                        "\n    - 2 tablespoons all-purpose flour" +
//                                        "\n    - 1 cup beef broth" +
//                                        "\n    - 1 tablespoon cooking sherry" +
//                                        "\n    - 1/2 teaspoon seasoned salt",
//                                "    - 1 (8 ounce) package farfalle (bow tie) pasta" +
//                                        "\n    - 1 pound ground beef" +
//                                        "\n    - 1 small onion, chopped (optional)" +
//                                        "\n    - 1 (28 ounce) jar pasta sauce" +
//                                        "\n    - 8 ounces mozzarella cheese, cut into 1/2 inch cubes" +
//                                        "\n    - 1/4 cup grated Parmesan cheese",
//                                "    - 1/4 cup butter, melted" +
//                                        "\n    - 1 teaspoon salt" +
//                                        "\n    - 4 skinless, boneless chicken breast halves",
//                                "    - 1 pound beef top sirloin steak" +
//                                        "\n    - 1/4 cup soy sauce" +
//                                        "\n    - 2 tablespoons white sugar" +
//                                        "\n    - 2 tablespoons cornstarch" +
//                                        "\n    - 1/2 teaaspoon ground ginger" +
//                                        "\n    - 3 tablespoons vegetable oil, divided" +
//                                        "\n    - 1 red onion, cut into 1-inch squares" +
//                                        "\n    - 1 green bell pepper, cut into 1-inch squares" +
//                                        "\n    - 2 tomatoes, cut into wedges"};
//    String[] recipe_directions = {"    - In large bowl, mix together the ground beef, egg, bread crumbs, pepper, salt, onion powder, garlic powder, and Worcestershire sauce. Form into 8 balls, and flatten into patties." +
//                                        "\n    - Heat the oil in a large skillet over medium heat. Fry the patties and onion in the oil until patties are nicely browned, about 4 minutes per side. Remove the beef patties to a plate, and keep warm." +
//                                        "\n    - Sprinkle flour over the onions and drippings in the skillet. Stir in flour with a fork, scraping bits of beef off of the bottom as you stir. Gradually mix in the beef broth and sherry. Season with seasoned salt. Simmer and stir over medium-low heat for about 5 minutes, until the gravy thickens. Turn heat to low, return patties to the gravy, cover, and simmer for another 15 minutes.",
//                                "    - Preheat oven to 400 degrees F (200 degrees C)." +
//                                        "\n    - Fill a large pot with lightly salted water, bring to a rolling boil over high heat. Stir in the bow tie pasta and return to a boil. Boil pasta, stirring occasionally, until cooked through but still firm to the bite, about 12 minutes. Brain well." +
//                                        "\n    - Cook and stir ground beef and onion in a large skillet until beef is no longer pink, about 5 minutes. Drain fat. Stir in pasta sauce and bring to a boil. Reduce heat to simmer." +
//                                        "\n    - Stir cooked pasta and half of the mozzarella cheese into the sauce; toss to combine. Transfer to a 2-quart baking dish. Top with remaining mozzarella and Parmesan cheese." +
//                                        "\n    - Bake in preheated oven until lightly browned and bubbly, 15 to 20 minutes.",
//                                "    - Preheat oven to 350 degrees F (175 degrees C). Lightly butter a baking dish." +
//                                        "\n    - Stir 1/4 cup melted butter and salt together in a bowl." +
//                                        "\n    - Arrange chicken in the baking dish. Brush butter mixture onto the chicken until thoroughly coated, pouring any extra over the chicken." +
//                                        "\n    - Bake in the preheated oven until no longer pink in the center and the juices run clear, about 30 to 45 minutes. An instant-read thermometer inserted into the center should read at least 165 degrees F (74 degrees C).",
//                                "    - Slice the steak into 1/2-inch thick slices across the grain." +
//                                        "\n    - Whisk together soy sauce, sugar, cornstarch, and ginger in a bowl until the sugar has dissolved and the mixture is smooth. Place the steak slices into the marinade, and stir until well-coated." +
//                                        "\n    - Heat 1 teaspoon of vegetable oil in a wok or large skillet over medium-high heat, and place 1/3 of the steak strips into the hot oil. Cook and stir until the beef is well-browned, about 3 minutes, and remove the beef from the wok to a bowl. Repeat twice more, with the remaining beef, and set the cooked beef aside." +
//                                        "\n    - Return all the cooked beef to the hot wok, and stir in the onion. Toss the beef and onion together until the onion begins to soften, about 2 minutes, then stir in the green pepper. Cook and stir the mixture until the pepper has turned bright green and started to become tender, about 2 minutes, then add the tomatoes, stir everything together, and serve."};

    //String[] names = getResources().getStringArray(R.array.recipe_names);

    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, titles);
        mListView = findViewById(R.id.listRecipes);
        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String title = ((TextView)view).getText().toString();
                Intent intent = new Intent(getApplicationContext(),Recipe.class);
                intent.putExtra("title",title);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getMenuInflater().inflate(R.menu.option_menu_home, menu);
        getMenuInflater().inflate(R.menu.search_view, menu);
        MenuItem itemSearch = menu.findItem(R.id.action_search);
        mSearchView = (SearchView)itemSearch.getActionView();
        mSearchView.setOnQueryTextListener(this);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.login:
                break;
            case R.id.create:
                break;
            case R.id.favorite:
                break;
            case R.id.about:
                Intent intent_about = new Intent(Home.this, About.class);
                startActivity(intent_about);
                break;
            case R.id.contact:
                Intent intent_contact = new Intent(Home.this, Contact.class);
                startActivity(intent_contact);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return true;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        if(TextUtils.isEmpty(newText)){
            adapter.getFilter().filter("");
            mListView.clearTextFilter();
        }else {
            adapter.getFilter().filter(newText.toString());
        }
        return true;
    }
}
