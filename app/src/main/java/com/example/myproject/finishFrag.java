package com.example.myproject;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.io.Serializable;

public class finishFrag extends Fragment {

    public static finishFrag newInstance(String[] array) {
        finishFrag fragment = new finishFrag();
        Bundle args = new Bundle();
        args.putStringArray("ingArray",(String[])array);
        fragment.setArguments(args);
        return fragment;
    }

    String[]ingArray, prepArray, nutriArray;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(getArguments()!=null) {
            ingArray= getArguments().getStringArray("ingArray");
        } ingFrag.newInstance(ingArray);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_finish, container, false);

        return view;
    }

}