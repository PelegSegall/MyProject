package com.example.myproject;

public class recipe_feed {

    private int profileImage;
    private int recipeImage;
    private String name;

    public recipe_feed(int profileImage, int recipeImage, String name) {
        this.profileImage = profileImage;
        this.recipeImage = recipeImage;
        this.name = name;
    }

    public int getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(int profileImage) {
        this.profileImage = profileImage;
    }

    public int getRecipeImage() {
        return recipeImage;
    }

    public void setRecipeImage(int recipeImage) {
        this.recipeImage = recipeImage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
