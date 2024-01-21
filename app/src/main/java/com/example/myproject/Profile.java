package com.example.myproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Profile extends AppCompatActivity {
    Button save;
    EditText name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        name=findViewById(R.id.name);
        save=findViewById(R.id.save);
        save.setOnClickListener(v -> {
            UserProfile userProfile= createUserProfileFromForm(name.getText());
            UserService.setMyUser(userProfile).addOnCompleteListener(task -> {
                if(task.isSuccessful()){
                    startActivity(new Intent(Profile.this,
                            splash_screen.class));
                }else{
                    Toast.makeText(this,
                            "Error: "+ task.getException().getLocalizedMessage(),
                            Toast.LENGTH_LONG).show();
                }
            });
        });
    }
}