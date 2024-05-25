package com.example.myproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ingFragCreate extends Fragment {

    public ingFragCreate() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    TextView stepNum;
    EditText stepDes;
    LinearLayout arrows;
    ImageButton forward,backward;
    Button addBtn, saveBtn;
    List<String> list;
    Intent intent;
    int i=1;
    int m=1;
    String[]ingArray;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_ing_frag_create, container, false);

        stepNum=view.findViewById(R.id.stepNum1);
        stepDes=view.findViewById(R.id.stepDes1);

        arrows=view.findViewById(R.id.arrows);
        backward=view.findViewById(R.id.backward1);
        forward=view.findViewById(R.id.forward1);

        addBtn=view.findViewById(R.id.addBtn1);
        saveBtn=view.findViewById(R.id.saveBtn1);

        list = new ArrayList<>();

        intent=new Intent();

        addBtn.setOnClickListener(v -> {
            list.add(stepDes.getText().toString());
            stepDes.setText("");
            arrows.setVisibility(View.VISIBLE);
            i++;
            stepNum.setText(String.valueOf(i));
            m++;
        });

        backward.setOnClickListener(v -> {
            i--;
            stepDes.setText(list.get(i-1));
            stepNum.setText(String.valueOf(i));
            if(i>1)
                backward.setVisibility(View.VISIBLE);
            else
                backward.setVisibility(View.INVISIBLE);
            if(m>i)
                forward.setVisibility(View.VISIBLE);
        });

        forward.setOnClickListener(v -> {
            i++;
            if(i<m) {
                stepDes.setText(list.get(i - 1));
                stepNum.setText(String.valueOf(i));
            } else if (i==m) {
                stepDes.setText("");
                stepNum.setText(String.valueOf(i));
                forward.setVisibility(View.INVISIBLE);
            } else if (i==1)
                forward.setVisibility(View.INVISIBLE);
            if (i!=1)
                backward.setVisibility(View.VISIBLE);
        });

        saveBtn.setOnClickListener(v -> {
            ingArray=new String[list.size()];
            Toast.makeText(getContext(), String.valueOf(ingArray.length), Toast.LENGTH_SHORT).show();
            for(int y=0; y<list.size(); y++){
                ingArray[y]=list.get(y);
            }
            finishFrag.newInstance(ingArray);

            prepFragCreate prepfragcreate = new prepFragCreate();

            Bundle bundle = new Bundle();
            bundle.putStringArray("ingArray", ingArray);
            prepfragcreate.setArguments(bundle);

            getActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.frameLayoutCreate, prepfragcreate)
                    .addToBackStack(null)
                    .commit();

            stepDes.setText("Continue To Preparation");
            stepDes.setEnabled(false);
            stepNum.setVisibility(View.GONE);
            addBtn.setVisibility(view.GONE);
            saveBtn.setVisibility(view.INVISIBLE);
            arrows.setVisibility(view.GONE);
        });

        return view;
    }

}