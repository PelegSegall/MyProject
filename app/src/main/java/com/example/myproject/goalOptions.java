package com.example.myproject;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.io.Serializable;
import java.util.ArrayList;

public class goalOptions extends AppCompatActivity{

    private ListView optionsList;
    private ArrayList<String> arrayList;
    Serializable newArray1;
    ArrayList<goal_feed>newArray2;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goal_options);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        arrayList=new ArrayList<>();
        arrayList.add("Manage to eat accordingly to the plan for a week straight");
        arrayList.add("Drink well for a week straight");

        newArray1=getIntent().getParcelableArrayListExtra("arrayList");
        newArray2= (ArrayList<goal_feed>) newArray1;

        optionsList=findViewById(R.id.options_list);

        ArrayAdapter arrayAdapter= new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrayList);

        optionsList.setAdapter(arrayAdapter);

        optionsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                new AlertDialog.Builder(goalOptions.this)
                        .setMessage("Do you want to add this goal to your list of goals?")
                        .setCancelable(false)
                        .setPositiveButton("Add", (dialog, which) -> {
                            goal_feed goalFeed=new goal_feed(arrayList.get(position).toString(), 5,8);
                            newArray2.add(goalFeed);
                            intent=new Intent(goalOptions.this, goals.class);
                            intent.putExtra("newArray",newArray2);
                            startActivity(intent);
                            finish();
                        })
                        .setNegativeButton("Cancel",null)
                        .show();
            }
        });

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