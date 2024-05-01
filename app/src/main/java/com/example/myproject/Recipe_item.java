package com.example.myproject;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.imageview.ShapeableImageView;

public class Recipe_item extends AppCompatActivity {

    ImageButton like,comment,save;
    ShapeableImageView profileImage;
    int num=1;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recipe_item);

        like=findViewById(R.id.like);
        comment=findViewById(R.id.comment);
        save=findViewById(R.id.mealAdd);

        profileImage=findViewById(R.id.profileImage);

        like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (num == 1) {
                    like.setImageResource(R.drawable.baseline_favorite_24);
                    num++;
                } else if (num == 2) {
                    like.setImageResource(R.drawable.baseline_favorite_border_24);
                    num--;
                }
            }
        });

    }
}
