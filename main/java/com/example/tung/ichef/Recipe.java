package com.example.tung.ichef;

import java.util.ArrayList;
import java.util.List;

public class Recipe {
    String title;
    String author;
    List<String> ingredients = new ArrayList<>();
    String directions;
    String favorite;
    String type;
    String reference;

    public Recipe(String title, String author, String[] ingredients, String directions, String type, String favorite, String reference){
        super();
        this.title = title;
        this.author = author;
        for(int i = 0; i < ingredients.length; i++){
            this.ingredients.add(ingredients[i]);
        }
        this.directions = directions;
        this.type = type;
        this.favorite = favorite;
        this.reference = reference;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public String getIngredientsS(){
        String in = "";
        for(int i = 0; i < ingredients.size(); i++){
            in = in + "\n" + ingredients.get(i);
        }
        return in;
    };

    public void setIngredients(String[] ingredients) {
        for(int i = 0; i < ingredients.length; i++){
            this.ingredients.add(ingredients[i]);
        }
    }

    public String getDirections() {
        return directions;
    }

    public void setDirections(String directions) {
        this.directions = directions;
    }

    public String getType(){ return type;}

    public void setType(String type){
        this.type = type;
    }

    public String getFavorite(){ return favorite;}

    public void setFavorite(String favorite){
        this.favorite = favorite;
    }

    public String getReference(){ return reference;}

    public void setReference(String reference){
        this.reference = reference;
    }
}
