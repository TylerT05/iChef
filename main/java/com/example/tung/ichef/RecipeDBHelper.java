package com.example.tung.ichef;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class RecipeDBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "recipeManager";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_RECIPES = "recipes";
    private static final String TABLE_INGREDIENTS = "ingredients";
    private static final String TABLE_DIRECTIONS = "directions";

    private static final String RECIPE_TITLE = "title";
    private static final String RECIPE_AUTHOR = "author";
    private static final String RECIPE_TYPE = "type";
    private static final String RECIPE_FAVORITE = "favorite";
    private static final String RECIPE_REFERENCE = "reference";

    private static final String INGREDIENT_TITLE = "title";
    private static final String INGREDIENT_NAME = "name";

    private static final String DIRECTION_TITLE = "title";
    private static final String DIRECTION_DESCRIPTION = "description";

    private Context context;

    public RecipeDBHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //String create_recipes_table = String.format("CREATE TABLE %s(%s TEXT PRIMARY KEY, %s TEXT, %s TEXT, %s INTEGER)", TABLE_RECIPES, RECIPE_TITLE, RECIPE_AUTHOR, RECIPE_TYPE, RECIPE_FAVORITE);
        String create_recipes_table = "CREATE TABLE " + TABLE_RECIPES + "(" + RECIPE_TITLE + " TEXT PRIMARY KEY, " + RECIPE_AUTHOR + " TEXT, " + RECIPE_TYPE + " TEXT, " + RECIPE_FAVORITE + " TEXT, " + RECIPE_REFERENCE + " TEXT)";
        db.execSQL(create_recipes_table);

        //String create_ingredients_table = String.format("CREATE TABLE %s(%s TEXT, %s TEXT, FOREIGN KEY(%s) REFERENCES %s(%s) ON DELETE CASCADE, PRIMARY KEY(%s,%s))", TABLE_INGREDIENTS, INGREDIENT_TITLE, INGREDIENT_NAME, INGREDIENT_TITLE, TABLE_RECIPES, RECIPE_TITLE, INGREDIENT_TITLE, INGREDIENT_NAME);
        String create_ingredients_table = "CREATE TABLE " + TABLE_INGREDIENTS + "(" + INGREDIENT_TITLE + " TEXT, " + INGREDIENT_NAME + " TEXT, PRIMARY KEY(" + INGREDIENT_TITLE + " , " + INGREDIENT_NAME + "), FOREIGN KEY(" + INGREDIENT_TITLE + ") REFERENCES " + TABLE_RECIPES + " (" + RECIPE_TITLE + ") ON DELETE CASCADE)";
        db.execSQL(create_ingredients_table);

        //String create_directions_table = String.format("CREATE TABLE %s(%s TEXT, %s TEXT, FOREIGN KEY(%s) REFERENCES %s(%s) ON DELETE CASCADE, PRIMARY KEY(%s)", TABLE_DIRECTIONS, DIRECTION_TITLE, DIRECTION_DESCRIPTION, DIRECTION_TITLE, TABLE_RECIPES, RECIPE_TITLE, DIRECTION_TITLE);
        String create_directions_table = "CREATE TABLE " + TABLE_DIRECTIONS + "(" + DIRECTION_TITLE + " TEXT PRIMARY KEY, " + DIRECTION_DESCRIPTION + " TEXT, FOREIGN KEY(" + DIRECTION_TITLE + ") REFERENCES " + TABLE_RECIPES + " (" + RECIPE_TITLE + ") ON DELETE CASCADE)";
        db.execSQL(create_directions_table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String drop_recipes_table = String.format("DROP TABLE IF EXISTS %s", TABLE_RECIPES);
        db.execSQL(drop_recipes_table);

        String drop_ingredients_table = String.format("DROP TABLE IF EXISTS %s", TABLE_INGREDIENTS);
        db.execSQL(drop_ingredients_table);

        String drop_directions_table = String.format("DROP TABLE IF EXISTS %s", TABLE_DIRECTIONS);
        db.execSQL(drop_directions_table);

        onCreate(db);
    }

    public void addRecipe(Recipe recipe){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(RECIPE_TITLE, recipe.getTitle());
        values.put(RECIPE_AUTHOR, recipe.getAuthor());
        values.put(RECIPE_TYPE, recipe.getType());
        values.put(RECIPE_FAVORITE, recipe.getFavorite());
        values.put(RECIPE_REFERENCE, recipe.getReference());

        db.insert(TABLE_RECIPES, null, values);
        db.close();
    }

    public void addIngredient(Recipe recipe){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values;

        for(int i = 0; i < recipe.getIngredients().size(); i++){
            values = new ContentValues();

            values.put(INGREDIENT_TITLE, recipe.getTitle());
            values.put(INGREDIENT_NAME, recipe.getIngredients().get(i));

            db.insert(TABLE_INGREDIENTS, null, values);
        }

        db.close();
    }

    public void addDirection(Recipe recipe){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(DIRECTION_TITLE, recipe.getTitle());
        values.put(DIRECTION_DESCRIPTION, recipe.getDirections());

        db.insert(TABLE_DIRECTIONS, null, values);
        db.close();
    }

//    public Recipe getRecipe(String recipeTitle){
//        SQLiteDatabase db = this.getReadableDatabase();
//
//        Cursor cursor = db.query(TABLE_NAME, null, KEY_TITLE + " = ?", new String[]{String.valueOf(recipeTitle)},null,null,null);
//        if(cursor != null)
//            cursor.moveToFirst();
//        Recipe recipe = new Recipe(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3));
//        return recipe;
//    }

//    public List<Recipe> getAllRecipes(){
//        List<Recipe> recipeList = new ArrayList<>();
//        String query = "SELECT * FROM " + TABLE_NAME;
//
//        SQLiteDatabase db = this.getReadableDatabase();
//        Cursor cursor = db.rawQuery(query, null);
//        cursor.moveToFirst();
//
//        while (cursor.isAfterLast() == false){
//            Recipe recipe = new Recipe(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3));
//            recipeList.add(recipe);
//            cursor.moveToNext();
//        }
//        return recipeList;
//    }

    public List<String> getAllSTitle(){
        List<String> titleList = new ArrayList<>();
        String[] params = new String[]{"s"};
        String query = "SELECT " + RECIPE_TITLE + " FROM " + TABLE_RECIPES + " WHERE " + RECIPE_TYPE + " = ? ORDER BY " + RECIPE_TITLE + " ASC";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, params);
        cursor.moveToFirst();

        while (cursor.isAfterLast() == false){
            titleList.add(cursor.getString(0));
            cursor.moveToNext();
        }
        return titleList;
    }

    public List<String> getAllUTitle(){
        List<String> titleList = new ArrayList<>();
        String[] params = new String[]{"u"};
        String query = "SELECT " + RECIPE_TITLE + " FROM " + TABLE_RECIPES + " WHERE " + RECIPE_TYPE + " = ? ORDER BY " + RECIPE_TITLE + " ASC";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, params);
        cursor.moveToFirst();

        while (cursor.isAfterLast() == false){
            titleList.add(cursor.getString(0));
            cursor.moveToNext();
        }
        return titleList;
    }

    public List<String> getAllFavoriteTitle(){
        List<String> titleList = new ArrayList<>();
        String[] params = new String[]{"yes"};
        String query = "SELECT " + RECIPE_TITLE + " FROM " + TABLE_RECIPES + " WHERE " + RECIPE_FAVORITE + " = ? ORDER BY " + RECIPE_TITLE + " ASC";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, params);
        cursor.moveToFirst();

        while (cursor.isAfterLast() == false){
            titleList.add(cursor.getString(0));
            cursor.moveToNext();
        }
        return titleList;
    }

    public String getTitle(String title){
        String t = "";
        String[] params = new String[]{title};
        String query = "SELECT " + RECIPE_TITLE + " FROM " + TABLE_RECIPES + " WHERE " + RECIPE_TITLE + " = ?";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, params);
        cursor.moveToFirst();

        while (cursor.isAfterLast() == false){
            t = t + cursor.getString(0);
            cursor.moveToNext();
        }
        return t;
    }

    public String getUTitle(String title){
        String t = "";
        String[] params = new String[]{title,"u"};
        String query = "SELECT " + RECIPE_TITLE + " FROM " + TABLE_RECIPES + " WHERE " + RECIPE_TITLE + " = ? AND " + RECIPE_TYPE + " = ?";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, params);
        cursor.moveToFirst();

        while (cursor.isAfterLast() == false){
            t = t + cursor.getString(0);
            cursor.moveToNext();
        }
        return t;
    }

    public String getAuthor(String t){
        String a = "";
        String[] params = new String[]{t};
        String query = "SELECT " + RECIPE_AUTHOR + " FROM " + TABLE_RECIPES + " WHERE " + RECIPE_TITLE + " = ?";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, params);
        cursor.moveToFirst();

        while (cursor.isAfterLast() == false){
            a = a + cursor.getString(0);
            cursor.moveToNext();
        }
        return a;
    }

    public String getIngredient(String t){
        String i = "";
        String[] params = new String[]{t};
        String query = "SELECT " + INGREDIENT_NAME + " FROM " + TABLE_INGREDIENTS + " WHERE " + INGREDIENT_TITLE + " = ?";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, params);
        cursor.moveToFirst();

        while (cursor.isAfterLast() == false){
            i = i + cursor.getString(0) + "\n";
            cursor.moveToNext();
        }
        return i;
    }

    public String getDirection(String t){
        String d = "";
        String[] params = new String[]{t};
        String query = "SELECT " + DIRECTION_DESCRIPTION + " FROM " + TABLE_DIRECTIONS + " WHERE " + DIRECTION_TITLE + " = ?";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, params);
        cursor.moveToFirst();

        while (cursor.isAfterLast() == false){
            d = d + cursor.getString(0);
            cursor.moveToNext();
        }
        return d;
    }

    public String getReference(String t) {
        String r = "";
        String[] params = new String[]{t};
        String query = "SELECT " + RECIPE_REFERENCE + " FROM " + TABLE_RECIPES + " WHERE " + RECIPE_TITLE + " = ?";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, params);
        cursor.moveToFirst();

        while (cursor.isAfterLast() == false){
            r = r + cursor.getString(0);
            cursor.moveToNext();
        }
        return r;
    }

    public void addFavorite(String t){
        String[] params = new String[]{t};
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(RECIPE_FAVORITE, "yes");
        db.update(TABLE_RECIPES, values, RECIPE_TITLE + " = ?", params);
        db.close();
    }

    public void removeFavorite(String t){
        String[] params = new String[]{t};
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(RECIPE_FAVORITE, "no");
        db.update(TABLE_RECIPES, values, RECIPE_TITLE + " = ?", params);
        db.close();
    }

    public boolean checkFavorite(String t){
        String c = "";
        String[] params = new String[]{t,"yes"};
        String query = "SELECT " + RECIPE_TITLE + " FROM " + TABLE_RECIPES + " WHERE " + RECIPE_TITLE + " = ? AND " + RECIPE_FAVORITE + " = ?";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, params);
        cursor.moveToFirst();

        while (cursor.isAfterLast() == false){
            c = c + cursor.getString(0);
            cursor.moveToNext();
        }

        if(c.equals("")){
            return false;
        } else{
            return true;
        }
    }

    public void deleteRecipe(String t){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_DIRECTIONS,DIRECTION_TITLE + " = ?", new String[]{String.valueOf(t)});
        db.delete(TABLE_INGREDIENTS, INGREDIENT_TITLE + " = ?", new String[]{String.valueOf(t)});
        db.delete(TABLE_RECIPES, RECIPE_TITLE + " = ?", new String[]{String.valueOf(t)});
        db.close();
    }

//    public void updateRecipe(Recipe recipe){
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues values = new ContentValues();
//        values.put(KEY_AUTHOR, recipe.getAuthor());
//        values.put(KEY_INGREDIENT, recipe.getIngredients());
//        values.put(KEY_DIRECTION, recipe.getDirections());
//
//        db.update(TABLE_NAME, values, KEY_TITLE + " = ?", new String[]{String.valueOf(recipe.getTitle())});
//        db.close();
//    }
//
//    public void deleteRecipe(String recipeTitle){
//        SQLiteDatabase db = this.getWritableDatabase();
//        db.delete(TABLE_NAME, KEY_TITLE + " = ?", new String[]{String.valueOf(recipeTitle)});
//        db.close();
//    }
}
