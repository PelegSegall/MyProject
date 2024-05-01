package com.example.myproject;

import android.net.Uri;

import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Objects;

public class UserService {
    static GuestUserProfile guestUser;
    static UserProfile myUser;
    static Task<Void>setMyGuestUser(GuestUserProfile user){
        FirebaseDatabase database=FirebaseDatabase.getInstance();

        String userId= FirebaseAuth.getInstance().getCurrentUser().getUid();

        DatabaseReference ref=database.getReference("guests/"+userId);

        HashMap<String, Object> userMap= new HashMap<>();
        userMap.put("full name", user.getFullName());
        userMap.put("profile image",user.getProfilePhoto());

        return ref.setValue(userMap).addOnCompleteListener(task -> {
            if (task.isSuccessful()){
                guestUser=user;
            }
        });
    }

    static Task<GuestUserProfile>getGuestById(String userId){
        FirebaseDatabase database=FirebaseDatabase.getInstance();
        DatabaseReference ref=database.getReference("guests/"+userId);

        return ref.get().continueWith(task -> {
            if (task.isSuccessful()) {
                String fullName = task.getResult().child("fullName").getValue(String.class);
                Uri profilePhoto= task.getResult().child("profilePhoto").getValue(Uri.class);
                GuestUserProfile profile = new GuestUserProfile(fullName,profilePhoto);

                if (Objects.equals(userId, FirebaseAuth.getInstance().getCurrentUser().getUid())) {
                    guestUser = profile;
                }
                return profile;
            }else{
                throw task.getException();
            }
        });
    }

    static Task<Void>setMyUser(UserProfile user){
        FirebaseDatabase database=FirebaseDatabase.getInstance();

        String userId= FirebaseAuth.getInstance().getCurrentUser().getUid();

        DatabaseReference ref=database.getReference("users/"+userId);

        HashMap<String, Object> userMap= new HashMap<>();
        userMap.put("full name", user.getFullName());
        userMap.put("profile image",user.getProfilePhoto());
        userMap.put("gender",user.getGender());
        userMap.put("age",user.getAge());
        userMap.put("height",user.getHeight());
        userMap.put("weight",user.getWeight());

        return ref.setValue(userMap).addOnCompleteListener(task -> {
            if (task.isSuccessful()){
                myUser=user;
            }
        });
    }

    static Task<UserProfile>getUserById(String userId){
        FirebaseDatabase database=FirebaseDatabase.getInstance();
        DatabaseReference ref=database.getReference("users/"+userId);

        return ref.get().continueWith(task -> {
            if (task.isSuccessful()) {
                String fullName = task.getResult().child("fullName").getValue(String.class);
                Uri profilePhoto= task.getResult().child("profilePhoto").getValue(Uri.class);
                String gender= task.getResult().child("gender").getValue(String.class);
                int age= task.getResult().child("age").getValue(int.class);
                double height= task.getResult().child("age").getValue(double.class);
                int weight= task.getResult().child("age").getValue(int.class);
                UserProfile profile = new UserProfile(fullName,profilePhoto,gender,age,height,weight);

                if (Objects.equals(userId, FirebaseAuth.getInstance().getCurrentUser().getUid())) {
                    myUser = profile;
                }
                return profile;
            }else{
                throw task.getException();
            }
        });
    }
}
