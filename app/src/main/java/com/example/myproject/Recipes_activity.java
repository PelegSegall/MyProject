package com.example.myproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class Recipes_activity extends AppCompatActivity implements RecyclerViewInterface{

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle drawerToggle;
    private RecyclerView recyclerView;
    private ArrayList<recipe_feed>arrayList;
    FrameLayout recipe_popUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipes);

        drawerLayout=findViewById(R.id.drawerLayout);
        navigationView=findViewById(R.id.nav_view);
        drawerToggle=new ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close);

        drawerLayout.addDrawerListener(drawerToggle);

        drawerToggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getColor(R.color.turkiz)));

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();
                if (itemId == R.id.home) {
                    Toast.makeText(Recipes_activity.this,"Home is selected", Toast.LENGTH_SHORT).show();
                    Intent intent= new Intent(Recipes_activity.this, home_page.class);
                    startActivity(intent);
                    return true;
                } else if (itemId == R.id.Profile) {
                    Toast.makeText(Recipes_activity.this,"Profile is selected", Toast.LENGTH_SHORT).show();
                    Intent intent= new Intent(Recipes_activity.this, Profile.class);
                    startActivity(intent);
                    return true;
                }else if (itemId == R.id.Recipes) {
                    Toast.makeText(Recipes_activity.this,"Recipes is selected", Toast.LENGTH_SHORT).show();
                    drawerLayout.closeDrawer(Gravity.LEFT,true);
                    return true;
                } else if (itemId == R.id.Goals) {
                    Toast.makeText(Recipes_activity.this,"Goals is selected", Toast.LENGTH_SHORT).show();
                    Intent intent= new Intent(Recipes_activity.this, goals.class);
                    startActivity(intent);
                    return true;
                }else if (itemId == R.id.summary) {
                    Toast.makeText(Recipes_activity.this,"Summary is selected", Toast.LENGTH_SHORT).show();
                    Intent intent= new Intent(Recipes_activity.this, Summary.class);
                    startActivity(intent);
                    return true;
                }else if (itemId == R.id.sign_out) {
                    Toast.makeText(Recipes_activity.this, "Sign out is selected", Toast.LENGTH_SHORT).show();
                    new AlertDialog.Builder(Recipes_activity.this)
                            .setMessage("Are you sure you want to sign out?")
                            .setCancelable(false)
                            .setPositiveButton("Sign Out", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Intent intent= new Intent(Recipes_activity.this, sign_in.class);
                                    startActivity(intent);
                                }
                            })
                            .setNegativeButton("No",null)
                            .show();
                    return true;
                }else if (itemId == R.id.exit) {
                    Toast.makeText(Recipes_activity.this, "Exit is selected", Toast.LENGTH_SHORT).show();
                    new AlertDialog.Builder(Recipes_activity.this)
                            .setMessage("Are you sure you want to exit?")
                            .setCancelable(false)
                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    ActivityManager activityManager=(ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
                                    List<ActivityManager.AppTask> appTasks=activityManager.getAppTasks();
                                    for (ActivityManager.AppTask appTask:appTasks){
                                        appTask.finishAndRemoveTask();
                                    }
                                }
                            })
                            .setNegativeButton("No",null)
                            .show();
                    return true;
                }
                return false;
            }
        });

        arrayList=new ArrayList<>();

        recyclerView=findViewById(R.id.recyclerView);

        arrayList.add(new recipe_feed(R.drawable.outline_account_circle_24,R.drawable.outline_fastfood_24,"name"));
        arrayList.add(new recipe_feed(R.drawable.outline_account_circle_24,R.drawable.outline_fastfood_24,"name"));

        RecyclerAdapter recyclerAdapter= new RecyclerAdapter(arrayList, this);

        recyclerView.setAdapter(recyclerAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recipe_popUp=findViewById(R.id.recipe_popUp);

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

    @Override
    public void OnItemClick(int position) {
        startActivity(new Intent(Recipes_activity.this,recipe_info_Activity.class));
    }
}