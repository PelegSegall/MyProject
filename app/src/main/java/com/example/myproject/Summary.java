package com.example.myproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class Summary extends AppCompatActivity {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle drawerToggle;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        drawerLayout=findViewById(R.id.drawerLayout);
        navigationView=findViewById(R.id.nav_view);
        drawerToggle=new ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close);

        drawerLayout.addDrawerListener(drawerToggle);

        drawerToggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getColor(R.color.turkiz)));

        navigationView.setNavigationItemSelectedListener(item -> {
            int itemId = item.getItemId();
            if (itemId == R.id.home) {
                Toast.makeText(Summary.this,"Home is selected", Toast.LENGTH_SHORT).show();
                Intent intent= new Intent(Summary.this, home_page.class);
                startActivity(intent);
                return true;
            }else if (itemId == R.id.Profile) {
                Toast.makeText(Summary.this,"Profile is selected", Toast.LENGTH_SHORT).show();
                Intent intent= new Intent(Summary.this, Profile.class);
                startActivity(intent);
                return true;
            }else if (itemId == R.id.Recipes) {
                Toast.makeText(Summary.this,"Recipes is selected", Toast.LENGTH_SHORT).show();
                Intent intent= new Intent(Summary.this, Recipes_activity.class);
                startActivity(intent);
                return true;
            }else if (itemId == R.id.Goals) {
                Toast.makeText(Summary.this,"Goals is selected", Toast.LENGTH_SHORT).show();
                Intent intent= new Intent(Summary.this, goals.class);
                startActivity(intent);
                return true;
            }else if (itemId == R.id.summary) {
                Toast.makeText(Summary.this,"Summary is selected", Toast.LENGTH_SHORT).show();
                drawerLayout.closeDrawer(Gravity.LEFT,true);
                return true;
            }else if (itemId == R.id.sign_out) {
                Toast.makeText(Summary.this, "Sign out is selected", Toast.LENGTH_SHORT).show();
                new AlertDialog.Builder(this)
                        .setMessage("Are you sure you want to sign out?")
                        .setCancelable(false)
                        .setPositiveButton("Sign Out", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent= new Intent(Summary.this, sign_in.class);
                                startActivity(intent);
                            }
                        })
                        .setNegativeButton("No",null)
                        .show();
                return true;
            }else if (itemId == R.id.exit) {
                Toast.makeText(Summary.this, "Exit is selected", Toast.LENGTH_SHORT).show();
                new AlertDialog.Builder(this)
                        .setMessage("Are you sure you want to exit?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finishAndRemoveTask();
                                System.exit(0);
                                finish();
                            }
                        })
                        .setNegativeButton("No",null)
                        .show();
                return true;
            }
            return false;
        });

        spinner=findViewById(R.id.sum_type);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                String item=adapterView.getItemAtPosition(position).toString();
                Toast.makeText(Summary.this, "Selected "+item, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayList<String>arrayList=new ArrayList<>();
        arrayList.add("Daily");
        arrayList.add("Weekly");
        arrayList.add("Monthly");
        ArrayAdapter<String> adapter=
                new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,arrayList);
        adapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        spinner.setAdapter(adapter);

        forceRTLIfSupported();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(drawerToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressLint("ObsoleteSdkInt")
    private void forceRTLIfSupported() {
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.JELLY_BEAN_MR1){
            getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_LTR);
        }
    }
}