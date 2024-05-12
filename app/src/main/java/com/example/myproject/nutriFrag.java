package com.example.myproject;

import android.os.Bundle;

import androidx.fragment.app.ListFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class nutriFrag extends ListFragment {

    String[]nutriArray={"Calories 271",
            "Carbs 34g",
            "Fat 14g",
            "Protein 2g"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_ingre, container, false);


        nutriAdapter nAdapter=new nutriAdapter(inflater.getContext(), nutriArray);
        setListAdapter(nAdapter);
        return view;
    }
}