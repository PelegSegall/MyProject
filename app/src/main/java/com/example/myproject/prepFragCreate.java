package com.example.myproject;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class prepFragCreate extends Fragment {


    public prepFragCreate() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    TextView stepNum;
    EditText stepDes;
    ImageButton forward,backward;
    Button addBtn, saveBtn;
    List<String> list;

    int i=1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_prep_frag_create, container, false);

        stepNum=view.findViewById(R.id.stepNum2);
        stepDes=view.findViewById(R.id.stepDes2);

        backward=view.findViewById(R.id.backward2);
        forward=view.findViewById(R.id.forward2);

        addBtn=view.findViewById(R.id.addBtn2);
        saveBtn=view.findViewById(R.id.saveBtn2);

        String[]ingArray;

        list = new ArrayList<>();

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list.add(stepDes.getText().toString());
                stepDes.setText("");
                i++;
                stepNum.setText(String.valueOf(i));
            }
        });

        backward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        return view;
    }
}