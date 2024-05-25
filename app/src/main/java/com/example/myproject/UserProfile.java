package com.example.myproject;

import android.net.Uri;
import android.widget.Toast;

public class UserProfile extends GuestUserProfile {

    private String gender;
    private int age;
    private double height;
    private int weight;

    public UserProfile(String fullName, Uri profilePhoto, String gender, int age, double height, int weight) {
        super(fullName, profilePhoto);
        this.gender = gender;
        this.age = age;
        this.height = height;
        this.weight = weight;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getBMR(){
        int bmr=0;
        if(gender.equals("Male")){
            bmr= (int)(88.362 + (13.397 * weight) + (4.799 * height*100) - (5.677 * age));
        } else if (gender.equals("Female")){
            bmr= (int)(447.593 + (9.247 * weight) + (3.098 * height*100) - (4.330 * age));
        }
        return bmr;
    }

    @Override
    public String toString() {
        return "UserProfile{" +
                "gender='" + gender + '\'' +
                ", age=" + age +
                ", height=" + height +
                ", weight=" + weight +
                '}';
    }
}
