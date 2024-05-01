package com.example.myproject;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;

import com.google.android.material.navigation.NavigationView;

public class home_page extends AppCompatActivity {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle drawerToggle;
    ProgressBar progressBar1,progressBar2,progressBar3,progressBar4,progressBar5,progressBar6,progressBar7;
    ImageView check1,check2,check3,check4,check5,check6,check7;
    AnimatedVectorDrawableCompat avd;
    AnimatedVectorDrawable avd2;
    String gender;
    int age,weight,BMR,water;
    double height;
    TextView prog1,prog2,prog3,prog4,prog5,prog6,prog7,goal1,goal2,goal3,goal4,goal5,goal6,goal7;
    Drawable drawable1,drawable2,drawable3,drawable4,drawable5,drawable6,drawable7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        prog1=findViewById(R.id.prog1);
        prog2=findViewById(R.id.prog2);
        prog3=findViewById(R.id.prog3);
        prog4=findViewById(R.id.prog4);
        prog5=findViewById(R.id.prog5);
        prog6=findViewById(R.id.prog6);
        prog7=findViewById(R.id.prog7);

        goal1=findViewById(R.id.goal1);
        goal2=findViewById(R.id.goal2);
        goal3=findViewById(R.id.goal3);
        goal4=findViewById(R.id.goal4);
        goal5=findViewById(R.id.goal5);
        goal6=findViewById(R.id.goal6);
        goal7=findViewById(R.id.goal7);

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
                Toast.makeText(home_page.this,"Home is selected", Toast.LENGTH_SHORT).show();
                drawerLayout.closeDrawer(Gravity.LEFT,true);
                return true;
            }else if (itemId == R.id.Profile) {
                Toast.makeText(home_page.this,"Profile is selected", Toast.LENGTH_SHORT).show();
                Intent intent= new Intent(home_page.this, Profile.class);
                startActivity(intent);
                return true;
            }else if (itemId == R.id.Recipes) {
                Toast.makeText(home_page.this,"Recipes is selected", Toast.LENGTH_SHORT).show();
                Intent intent= new Intent(home_page.this, Recipes_activity.class);
                startActivity(intent);
                return true;
            }else if (itemId == R.id.Goals) {
                Toast.makeText(home_page.this,"Goals is selected", Toast.LENGTH_SHORT).show();
                Intent intent= new Intent(home_page.this, goals.class);
                startActivity(intent);
                return true;
            }else if (itemId == R.id.summary) {
                Toast.makeText(home_page.this,"Summary is selected", Toast.LENGTH_SHORT).show();
                Intent intent= new Intent(home_page.this, Summary.class);
                startActivity(intent);
                return true;
            }else if (itemId == R.id.sign_out) {
                Toast.makeText(home_page.this, "Sign out is selected", Toast.LENGTH_SHORT).show();
                new AlertDialog.Builder(this)
                        .setMessage("Are you sure you want to sign out?")
                        .setCancelable(false)
                        .setPositiveButton("Sign Out", (dialog, which) -> {
                            Intent intent= new Intent(home_page.this, sign_in.class);
                            startActivity(intent);
                        })
                        .setNegativeButton("No",null)
                        .show();
                return true;
            }else if (itemId == R.id.exit) {
                Toast.makeText(home_page.this, "Exit is selected", Toast.LENGTH_SHORT).show();
                new AlertDialog.Builder(this)
                        .setMessage("Are you sure you want to exit?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", (dialog, which) -> {
                            finishAndRemoveTask();
                            finish();
                        })
                        .setNegativeButton("No",null)
                        .show();
                return true;
            }
            return false;
        });

        if(UserService.myUser==null){
            gender="";
            age=0;
            height=0;
            weight=0;
        }else{
            gender=UserService.myUser.getGender();
            age = UserService.myUser.getAge();
            height= UserService.myUser.getHeight();
            weight= UserService.myUser.getWeight();
        }


        Toast.makeText(this, String.valueOf(age), Toast.LENGTH_SHORT).show();
        Toast.makeText(this, String.valueOf(height), Toast.LENGTH_SHORT).show();
        Toast.makeText(this, String.valueOf(weight), Toast.LENGTH_SHORT).show();
        Toast.makeText(this, gender, Toast.LENGTH_SHORT).show();
        if(gender == "Male"){
            BMR= (int)(88.362 + (13.397 * weight) + (4.799 * height*100) - (5.677 * age));
        } else if (gender == "Female"){
            BMR= (int)(447.593 + (9.247 * weight) + (3.098 * height*100) - (4.330 * age));
        }
        Toast.makeText(this, String.valueOf(BMR), Toast.LENGTH_SHORT).show();

        progressBar1=findViewById(R.id.progressBar1);
        progressBar2=findViewById(R.id.progressBar2);
        progressBar3=findViewById(R.id.progressBar3);
        progressBar4=findViewById(R.id.progressBar4);
        progressBar5=findViewById(R.id.progressBar5);
        progressBar6=findViewById(R.id.progressBar6);
        progressBar7=findViewById(R.id.progressBar7);

        check1=findViewById(R.id.checkMark1);
        check2=findViewById(R.id.checkMark2);
        check3=findViewById(R.id.checkMark3);
        check4=findViewById(R.id.checkMark4);
        check5=findViewById(R.id.checkMark5);
        check6=findViewById(R.id.checkMark6);
        check7=findViewById(R.id.checkMark7);

        drawable1=check1.getDrawable();
        drawable2=check2.getDrawable();
        drawable3=check3.getDrawable();
        drawable4=check4.getDrawable();
        drawable5=check5.getDrawable();
        drawable6=check6.getDrawable();
        drawable7=check7.getDrawable();

        goal1.setText("0");
        progressBar1.setMax(0);

        new Handler().postDelayed(() -> {
            prog1.setText(String.valueOf(progressBar1.getProgress()));
            if (progressBar1.getProgress() == progressBar1.getMax()) {
                if (drawable1 instanceof AnimatedVectorDrawableCompat) {
                    avd = (AnimatedVectorDrawableCompat) drawable1;
                    avd.start();
                } else if (drawable1 instanceof AnimatedVectorDrawable) {
                    avd2 = (AnimatedVectorDrawable) drawable1;
                    avd2.start();
                }
            }
        },1000);

        progressBar2.setMax(BMR);
        goal2.setText(String.valueOf(BMR));

        new Handler().postDelayed(() -> {
            prog2.setText(String.valueOf(progressBar2.getProgress()));
            if (progressBar2.getProgress() == progressBar2.getMax()) {
                if (drawable2 instanceof AnimatedVectorDrawableCompat) {
                    avd = (AnimatedVectorDrawableCompat) drawable2;
                    avd.start();
                } else if (drawable2 instanceof AnimatedVectorDrawable) {
                    avd2 = (AnimatedVectorDrawable) drawable2;
                    avd2.start();
                }
            }
        },1000);

        new Handler().postDelayed(() -> {
            prog3.setText(String.valueOf(progressBar3.getProgress()));
            if (progressBar3.getProgress() == progressBar3.getMax()) {
                if (drawable3 instanceof AnimatedVectorDrawableCompat) {
                    avd = (AnimatedVectorDrawableCompat) drawable3;
                    avd.start();
                } else if (drawable3 instanceof AnimatedVectorDrawable) {
                    avd2 = (AnimatedVectorDrawable) drawable3;
                    avd2.start();
                }
            }
        },1000);

        new Handler().postDelayed(() -> {
            prog4.setText(String.valueOf(progressBar4.getProgress()));
            if (progressBar4.getProgress() == progressBar4.getMax()) {
                if (drawable4 instanceof AnimatedVectorDrawableCompat) {
                    avd = (AnimatedVectorDrawableCompat) drawable4;
                    avd.start();
                } else if (drawable4 instanceof AnimatedVectorDrawable) {
                    avd2 = (AnimatedVectorDrawable) drawable4;
                    avd2.start();
                }
            }
        },1000);

        water=(35*weight)/240;
        progressBar5.setMax(water);
        goal5.setText(String.valueOf(water));

        new Handler().postDelayed(() -> {
            prog5.setText(String.valueOf(progressBar5.getProgress()));
            if (progressBar5.getProgress() == progressBar5.getMax()) {
                if (drawable5 instanceof AnimatedVectorDrawableCompat) {
                    avd = (AnimatedVectorDrawableCompat) drawable5;
                    avd.start();
                } else if (drawable5 instanceof AnimatedVectorDrawable) {
                    avd2 = (AnimatedVectorDrawable) drawable5;
                    avd2.start();
                }
            }
        },1000);

        new Handler().postDelayed(() -> {
            prog6.setText(String.valueOf(progressBar6.getProgress()));
            if (progressBar6.getProgress() == progressBar6.getMax()) {
                if (drawable6 instanceof AnimatedVectorDrawableCompat) {
                    avd = (AnimatedVectorDrawableCompat) drawable6;
                    avd.start();
                } else if (drawable6 instanceof AnimatedVectorDrawable) {
                    avd2 = (AnimatedVectorDrawable) drawable6;
                    avd2.start();
                }
            }
        },1000);

        new Handler().postDelayed(() -> {
            prog7.setText(String.valueOf(progressBar7.getProgress()));
            if (progressBar7.getProgress() == progressBar7.getMax()) {
                if (drawable7 instanceof AnimatedVectorDrawableCompat) {
                    avd = (AnimatedVectorDrawableCompat) drawable7;
                    avd.start();
                } else if (drawable7 instanceof AnimatedVectorDrawable) {
                    avd2 = (AnimatedVectorDrawable) drawable7;
                    avd2.start();
                }
            }
        },1000);

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