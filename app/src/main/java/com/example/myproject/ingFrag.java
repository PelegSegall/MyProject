package com.example.myproject;

import android.os.Bundle;

import androidx.fragment.app.ListFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class ingFrag extends ListFragment {

    String[]ingArray={"for 12 cookies",
            "½ cup granulated sugar(100 g)",
            "¾ cup brown sugar(165 g), packed",
            "1 teaspoon salt",
            "½ cup unsalted butter(115 g), melted",
            "1 large egg",
            "1 teaspoon vanilla extract",
            "¼ cup all-purpose flour(155 g)",
            "½ teaspoon baking soda",
            "4 oz milk or semi-sweet chocolate chunks(110 g)",
            "4 oz dark chocolate chunk(110 g), or your preference"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_ingre, container, false);


        ingAdapter iAdapter=new ingAdapter(inflater.getContext(), ingArray);
        setListAdapter(iAdapter);
        return view;
    }
}