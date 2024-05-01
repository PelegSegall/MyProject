package com.example.myproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.ktx.Firebase;

public class splash_screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        new Handler().postDelayed(() -> {
            FirebaseUser currentUser= FirebaseAuth.getInstance().getCurrentUser();
            if(currentUser!=null){
                UserService.getUserById(currentUser.getUid()).addOnCompleteListener(task -> {
                    if (UserService.myUser==null){
                        startActivity(new Intent(splash_screen.this,
                                Profile.class));
                    }else{
                        startActivity(new Intent(splash_screen.this,
                                home_page.class));
                    }
                });
            } else {
                startActivity(new Intent(splash_screen.this,
                        sign_up.class));
            }
            finish();
        },1000);
    }
}