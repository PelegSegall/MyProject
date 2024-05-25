package com.example.myproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

public class recipe_info_Activity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_info);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        forceRTLIfSupported();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        finishAndRemoveTask();
        return super.onOptionsItemSelected(item);
    }

    @SuppressLint("ObsoleteSdkInt")
    private void forceRTLIfSupported() {
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.JELLY_BEAN_MR1){
            getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_LTR);
        }
    }
}