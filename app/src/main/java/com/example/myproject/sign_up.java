package com.example.myproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class sign_up extends AppCompatActivity {
    EditText mail, password;
    Button signIn,continueBt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mail= findViewById(R.id.mail);
        password=findViewById(R.id.password);
        continueBt=findViewById(R.id.sign_up);
        signIn=findViewById(R.id.sign_in);

        signIn.setOnClickListener(v -> {
            Intent intent= new Intent(sign_up.this,sign_in.class);
            startActivity(intent);
        });

        continueBt.setOnClickListener(v -> signUp());
    }
    private void signUp(){
        String email= mail.getText().toString();
        String pass=password.getText().toString();

        if(email.isEmpty()||pass.isEmpty()){
            Toast.makeText(this,
                    "please enter mail or password",
                    Toast.LENGTH_SHORT).show();
            return;
        }

        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email,
                pass)
                .addOnCompleteListener(task -> {
                   if(task.isSuccessful()){
                       Toast.makeText(this,
                               "User created successfully",
                               Toast.LENGTH_LONG).show();
                       startActivity(new Intent(sign_up.this,
                               sign_in.class));
                   }else{
                       Toast.makeText(this,
                               "Error: "+ task.getException().getLocalizedMessage(),
                               Toast.LENGTH_LONG).show();
                   }
                });
    }
}