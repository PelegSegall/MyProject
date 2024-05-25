package com.example.myproject;

import android.graphics.Bitmap;

import java.util.ArrayList;

public class Recipes extends Nutrients{

    private String type,veg,taste,dairy_meat;
    private ArrayList<String>description, ingredients, nutrients;
    private Bitmap image;

    public Recipes(double calories, double carbs, double fats, double proteins,
                   String vitamins, String minerals, String type, String veg, String taste, String dairy_meat,
                   ArrayList<String> description, ArrayList<String> ingredients, ArrayList<String> nutrients,
                   Bitmap image) {
        super(calories, carbs, fats, proteins, vitamins, minerals);
        this.type = type;
        this.veg = veg;
        this.taste = taste;
        this.dairy_meat = dairy_meat;
        this.description = description;
        this.ingredients = ingredients;
        this.nutrients = nutrients;
        this.image = image;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getVeg() {
        return veg;
    }

    public void setVeg(String veg) {
        this.veg = veg;
    }

    public String getTaste() {
        return taste;
    }

    public void setTaste(String taste) {
        this.taste = taste;
    }

    public String getDairy_meat() {
        return dairy_meat;
    }

    public void setDairy_meat(String dairy_meat) {
        this.dairy_meat = dairy_meat;
    }

    public ArrayList<String> getDescription() {
        return description;
    }

    public void setDescription(ArrayList<String> description) {
        this.description = description;
    }

    public ArrayList<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(ArrayList<String> ingredients) {
        this.ingredients = ingredients;
    }

    public ArrayList<String> getNutrients() {
        return nutrients;
    }

    public void setNutrients(ArrayList<String> nutrients) {
        this.nutrients = nutrients;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Recipes{" +
                "type='" + type + '\'' +
                ", veg='" + veg + '\'' +
                ", taste='" + taste + '\'' +
                ", dairy_meat='" + dairy_meat + '\'' +
                ", description=" + description +
                ", ingredients=" + ingredients +
                ", nutrients=" + nutrients +
                ", image=" + image +
                ", calories=" + calories +
                ", carbs=" + carbs +
                ", fats=" + fats +
                ", proteins=" + proteins +
                ", vitamins='" + vitamins + '\'' +
                ", minerals='" + minerals + '\'' +
                '}';
    }
}
