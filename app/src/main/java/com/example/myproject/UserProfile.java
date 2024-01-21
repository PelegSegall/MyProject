package com.example.myproject;

public class UserProfile {
    private String FullName;
    public UserProfile(String fullName) {
        FullName = fullName;
    }
    public String getFullName() {
        return FullName;
    }
    public void setFullName(String fullName) {
        FullName = fullName;
    }
}
