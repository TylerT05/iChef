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

public class HomeActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    private SearchView mSearchView;
    private ListView mListView;

    private RecipeDBHelper tdb = new RecipeDBHelper(HomeActivity.this);


    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, tdb.getAllSTitle());
        mListView = findViewById(R.id.listRecipes);
        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String title = ((TextView)view).getText().toString();
                String n = "Home";
                Intent intent = new Intent(getApplicationContext(),SRecipeActivity.class);
                intent.putExtra("title",title);
                intent.putExtra("n",n);
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
            case R.id.your_recipes:
                Intent intent_your_recipes = new Intent(HomeActivity.this, YourListActivity.class);
                startActivity(intent_your_recipes);
                break;
            case R.id.favorite:
                Intent intent_favorite = new Intent(HomeActivity.this, FavoriteActivity.class);
                startActivity(intent_favorite);
                break;
            case R.id.about:
                Intent intent_about = new Intent(HomeActivity.this, AboutActivity.class);
                startActivity(intent_about);
                break;
            case R.id.contact:
                Intent intent_contact = new Intent(HomeActivity.this, ContactActivity.class);
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
