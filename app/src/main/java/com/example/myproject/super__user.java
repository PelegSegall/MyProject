package com.example.myproject;

import android.net.Uri;

public class super__user extends UserProfile {

    private boolean isAdmin;

    public super__user(String fullName, Uri profilePhoto, String gender, int age, double height, int weight, boolean isAdmin) {
        super(fullName, profilePhoto, gender, age, height, weight);
        this.isAdmin = isAdmin;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    @Override
    public String toString() {
        return "super__user{" +
                "isAdmin=" + isAdmin +
                '}';
    }
}
