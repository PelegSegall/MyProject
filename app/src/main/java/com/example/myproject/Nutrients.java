package com.example.myproject;

public class Nutrients {

    protected double calories,carbs,fats,proteins;
    protected String vitamins,minerals;

    public Nutrients(double calories, double carbs, double fats, double proteins, String vitamins, String minerals) {
        this.calories = calories;
        this.carbs = carbs;
        this.fats = fats;
        this.proteins = proteins;
        this.vitamins = vitamins;
        this.minerals = minerals;
    }

    public double getCalories() {
        return calories;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }

    public double getCarbs() {
        return carbs;
    }

    public void setCarbs(double carbs) {
        this.carbs = carbs;
    }

    public double getFats() {
        return fats;
    }

    public void setFats(double fats) {
        this.fats = fats;
    }

    public double getProteins() {
        return proteins;
    }

    public void setProteins(double proteins) {
        this.proteins = proteins;
    }

    public String getVitamins() {
        return vitamins;
    }

    public void setVitamins(String vitamins) {
        this.vitamins = vitamins;
    }

    public String getMinerals() {
        return minerals;
    }

    public void setMinerals(String minerals) {
        this.minerals = minerals;
    }

    @Override
    public String toString() {
        return "Nutrients{" +
                "calories=" + calories +
                ", carbs=" + carbs +
                ", fats=" + fats +
                ", proteins=" + proteins +
                ", vitamins='" + vitamins + '\'' +
                ", minerals='" + minerals + '\'' +
                '}';
    }
}
