package com.example.myproject;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.github.dhaval2404.imagepicker.ImagePicker;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

public class Profile extends AppCompatActivity {

    protected FrameLayout frameLayout;
    protected TabLayout tabLayout;
    protected DrawerLayout drawerLayout;
    protected NavigationView navigationView;
    protected ActionBarDrawerToggle drawerToggle;
    protected ImageView imageView;
    protected Bitmap profileImage;
    protected FloatingActionButton fBtn;
    protected Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

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
                Toast.makeText(Profile.this,"Home is selected", Toast.LENGTH_SHORT).show();
                Intent intent= new Intent(Profile.this, home_page.class);
                startActivity(intent);
                return true;
            } else if (itemId == R.id.Profile) {
                Toast.makeText(Profile.this,"Profile is selected", Toast.LENGTH_SHORT).show();
                drawerLayout.closeDrawer(Gravity.LEFT,true);
                return true;
            }else if (itemId == R.id.Recipes) {
                Toast.makeText(Profile.this,"Recipes is selected", Toast.LENGTH_SHORT).show();
                Intent intent= new Intent(Profile.this, Recipes_activity.class);
                startActivity(intent);
                return true;
            } else if (itemId == R.id.Goals) {
                Toast.makeText(Profile.this,"Goals is selected", Toast.LENGTH_SHORT).show();
                Intent intent= new Intent(Profile.this, goals.class);
                startActivity(intent);
                return true;
            }else if (itemId == R.id.summary) {
                Toast.makeText(Profile.this,"Summary is selected", Toast.LENGTH_SHORT).show();
                Intent intent= new Intent(Profile.this, Summary.class);
                startActivity(intent);
                return true;
            }else if (itemId == R.id.sign_out) {
                Toast.makeText(Profile.this, "Sign out is selected", Toast.LENGTH_SHORT).show();
                new AlertDialog.Builder(this)
                        .setMessage("Are you sure you want to sign out?")
                        .setCancelable(false)
                        .setPositiveButton("Sign Out", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent= new Intent(Profile.this, sign_in.class);
                                startActivity(intent);
                            }
                        })
                        .setNegativeButton("No",null)
                        .show();
                return true;
            }else if (itemId == R.id.exit) {
                Toast.makeText(Profile.this, "Exit is selected", Toast.LENGTH_SHORT).show();
                new AlertDialog.Builder(this)
                        .setMessage("Are you sure you want to exit?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finishAndRemoveTask();
                                finish();
                                System.exit(0);
                            }
                        })
                        .setNegativeButton("No",null)
                        .show();
                return true;
            }
            return false;
        });

        frameLayout= findViewById(R.id.frameLayout);
        tabLayout=findViewById(R.id.tabLayout);

        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,new ProfileFrag1())
                .addToBackStack(null)
                .commit();

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener(){

            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                Fragment fragment=null;
                switch (tab.getPosition()){
                    case 0:
                        fragment=new ProfileFrag1();
                        break;
                    case 1:
                        fragment=new ProfileFrag2();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,fragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        imageView=findViewById(R.id.profileImage);
        fBtn=findViewById(R.id.photo);

        fBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImagePicker.with(Profile.this)
                        .crop()
                        .compress(1024)
                        .maxResultSize(1080, 1080)
                        .start();
            }
        });

        forceRTLIfSupported();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(drawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        uri=data.getData();
        imageView.setImageURI(uri);
        Intent intent= new Intent(this, ProfileFrag1.class);
        intent.putExtra("profile image", uri);
    }

    @SuppressLint("ObsoleteSdkInt")
    private void forceRTLIfSupported() {
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.JELLY_BEAN_MR1){
            getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_LTR);
        }
    }
}