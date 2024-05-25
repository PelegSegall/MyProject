package com.example.myproject;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Space;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.navigation.NavigationView;
import com.mikhaellopez.circularprogressbar.CircularProgressBar;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class goals extends AppCompatActivity implements Serializable {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle drawerToggle;
    ImageButton addGoal;
    private RecyclerView goalsRecycler;
    private ArrayList<goal_feed>arrayList;
    Space space;
    TextView noItem, successStat;
    CircularProgressBar success;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goals);

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
                Toast.makeText(goals.this,"Home is selected", Toast.LENGTH_SHORT).show();
                Intent intent= new Intent(goals.this, home_page.class);
                startActivity(intent);
                return true;
            }else if (itemId == R.id.Profile) {
                Toast.makeText(goals.this,"Profile is selected", Toast.LENGTH_SHORT).show();
                Intent intent= new Intent(goals.this, Profile.class);
                startActivity(intent);
                return true;
            }else if (itemId == R.id.Recipes) {
                Toast.makeText(goals.this,"Recipes is selected", Toast.LENGTH_SHORT).show();
                Intent intent= new Intent(goals.this, Recipes_activity.class);
                startActivity(intent);
                return true;
            }else if (itemId == R.id.Goals) {
                Toast.makeText(goals.this,"Goals is selected", Toast.LENGTH_SHORT).show();
                drawerLayout.closeDrawer(Gravity.LEFT,true);
                return true;
            }else if (itemId == R.id.summary) {
                Toast.makeText(goals.this,"Summary is selected", Toast.LENGTH_SHORT).show();
                Intent intent= new Intent(goals.this, Summary.class);
                startActivity(intent);
                return true;
            }else if (itemId == R.id.sign_out) {
                Toast.makeText(goals.this, "Sign out is selected", Toast.LENGTH_SHORT).show();
                new AlertDialog.Builder(this)
                        .setMessage("Are you sure you want to sign out?")
                        .setCancelable(false)
                        .setPositiveButton("Sign Out", (dialog, which) -> {
                            Intent intent= new Intent(goals.this, sign_in.class);
                            startActivity(intent);
                        })
                        .setNegativeButton("No",null)
                        .show();
                return true;
            }else if (itemId == R.id.exit) {
                Toast.makeText(goals.this, "Exit is selected", Toast.LENGTH_SHORT).show();
                new AlertDialog.Builder(this)
                        .setMessage("Are you sure you want to exit?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", (dialog, which) -> {
                            ActivityManager activityManager=(ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
                            List<ActivityManager.AppTask> appTasks=activityManager.getAppTasks();
                            for (ActivityManager.AppTask appTask:appTasks){
                                appTask.finishAndRemoveTask();
                            }
                        })
                        .setNegativeButton("No",null)
                        .show();
                return true;
            }
            return false;
        });

        arrayList=new ArrayList<>();

        addGoal=findViewById(R.id.addGoal);
        addGoal.setOnClickListener(v -> {
            intent= new Intent(goals.this, goalOptions.class);
            intent.putExtra( "arrayList", arrayList);
            startActivity(intent);
        });

        goalsRecycler=findViewById(R.id.goals_recycler);

        Serializable newArray = (ArrayList<goal_feed>) getIntent().getSerializableExtra("newArray");

        if(newArray!=null)
            arrayList= (ArrayList<goal_feed>) newArray;

        GoalAdapter goalAdapter= new GoalAdapter(arrayList);

        goalsRecycler.setAdapter(goalAdapter);
        goalsRecycler.setLayoutManager(new LinearLayoutManager(this));

        space=findViewById(R.id.space);
        noItem=findViewById(R.id.no_items);
        success=findViewById(R.id.successRate);
        successStat=findViewById(R.id.successStats);

        success.setProgressMax(1);
        success.setProgress(0);
        successStat.setText((int) success.getProgress() +"/"+ (int) success.getProgressMax());

        if(arrayList.isEmpty()) {
            space.setVisibility(View.VISIBLE);
            goalsRecycler.setVisibility(View.GONE);
            if(success.getProgressMax()!=0) {
                success.setVisibility(View.VISIBLE);
                successStat.setVisibility(View.VISIBLE);
                noItem.setText("Add New Goals To Achieve!");
                noItem.setVisibility(View.VISIBLE);
            } else {
                success.setVisibility(View.GONE);
                successStat.setVisibility(View.GONE);
                noItem.setText("No Goals Have been Created Yet, Add Your First!");
                noItem.setVisibility(View.VISIBLE);
            }
        } else {
            space.setVisibility(View.GONE);
            noItem.setVisibility(View.GONE);
            goalsRecycler.setVisibility(View.VISIBLE);
            success.setVisibility(View.VISIBLE);
            successStat.setVisibility(View.VISIBLE);
        }

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