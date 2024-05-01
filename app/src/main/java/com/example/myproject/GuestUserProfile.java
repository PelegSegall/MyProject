package com.example.myproject;

import android.net.Uri;

public class GuestUserProfile {
    private String fullName;
    private Uri profilePhoto;

    public GuestUserProfile(String fullName, Uri profilePhoto) {
        this.fullName = fullName;
        this.profilePhoto = profilePhoto;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Uri getProfilePhoto() {
        return profilePhoto;
    }

    public void setProfilePhoto(Uri profilePhoto) {
        this.profilePhoto = profilePhoto;
    }

    @Override
    public String toString() {
        return "UserProfile{" +
                "fullName='" + fullName + '\'' +
                ", profilePhoto=" + profilePhoto +
                '}';
    }
}
