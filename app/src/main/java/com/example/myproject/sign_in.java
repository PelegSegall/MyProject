package com.example.myproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class sign_in extends AppCompatActivity {
    EditText mail, password;
    Button signUp,continueBt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        mail= findViewById(R.id.mail);
        password=findViewById(R.id.password);
        continueBt=findViewById(R.id.sign_in);
        signUp=findViewById(R.id.sign_up);

        signUp.setOnClickListener(v -> {
            Intent intent= new Intent(sign_in.this, sign_up.class);
            startActivity(intent);
        });

        continueBt.setOnClickListener(v -> signIn());
    }
    private void signIn(){
        String email= mail.getText().toString();
        String pass=password.getText().toString();

        if(email.isEmpty()||pass.isEmpty()){
            Toast.makeText(this,
                    "please enter mail or password",
                    Toast.LENGTH_SHORT).show();
            return;
        }

        FirebaseAuth.getInstance().signInWithEmailAndPassword(email,
                        pass)
                .addOnCompleteListener(task -> {
                    if(task.isSuccessful()){
                        Toast.makeText(this,
                                "Signed in successfully",
                                Toast.LENGTH_LONG).show();
                        startActivity(new Intent(sign_in.this,
                                splash_screen.class));
                    }else{
                        Toast.makeText(this,
                                "Error: "+ task.getException().getLocalizedMessage(),
                                Toast.LENGTH_LONG).show();
                    }
                });
    }
}