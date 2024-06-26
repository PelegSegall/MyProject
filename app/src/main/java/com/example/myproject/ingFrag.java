package com.example.myproject;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import androidx.fragment.app.ListFragment;

import java.io.Serializable;

public class ingFrag extends ListFragment {

    public static ingFrag newInstance(String[] array) {
        ingFrag fragment = new ingFrag();
        Bundle args = new Bundle();
        args.putStringArray("ingArray",array);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(getArguments()!=null) {
            ingArray= getArguments().getStringArray("ingArray");
        }
    }

    String[]ingArray;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_ing, container, false);

        ingAdapter iAdapter=new ingAdapter(inflater.getContext(), ingArray);
        setListAdapter(iAdapter);
        return view;
    }
}