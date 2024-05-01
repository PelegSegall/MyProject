package com.example.myproject;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class ProfileFrag2 extends Fragment {

    protected EditText fName,lName;
    protected RadioGroup radio;
    protected RadioButton genM,genF;
    protected SeekBar heightB,weightB,ageB;
    protected TextView heightV,weightV,ageV;
    protected Button save;
    protected int age,weight;
    protected double height;
    Intent intent;

    public ProfileFrag2() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_profile_frag2, container, false);

        radio=view.findViewById(R.id.radio);

        genM=view.findViewById(R.id.genM);
        genF=view.findViewById(R.id.genF);

        ageB=view.findViewById(R.id.ageBar);
        ageV=view.findViewById(R.id.ageView);

        heightB=view.findViewById(R.id.heightBar);
        heightV=view.findViewById(R.id.heightView);

        weightB=view.findViewById(R.id.weightBar);
        weightV=view.findViewById(R.id.weightView);

        save=view.findViewById(R.id.save);

        ageB.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                ageV.setText(progress +" yo");

                int width=seekBar.getWidth()-seekBar.getPaddingLeft()-seekBar.getPaddingRight();
                int thumbPos=seekBar.getPaddingLeft()+width*seekBar.getProgress()/seekBar.getMax();

                ageV.measure(0,0);
                int txtW= ageV.getMeasuredWidth();
                int delta=txtW/2;
                ageV.setX(seekBar.getX()+thumbPos-delta);

                age=progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        heightB.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                double height1=Double.parseDouble(String.valueOf(progress))/100;
                heightV.setText(height +" m");

                int width=seekBar.getWidth()-seekBar.getPaddingLeft()-seekBar.getPaddingRight();
                int thumbPos=seekBar.getPaddingLeft()+width*seekBar.getProgress()/seekBar.getMax();

                heightV.measure(0,0);
                int txtW= heightV.getMeasuredWidth();
                int delta=txtW/2;
                heightV.setX(seekBar.getX()+thumbPos-delta);

                height=height1;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        weightB.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                weightV.setText(progress + " kg");

                int width=seekBar.getWidth()-seekBar.getPaddingLeft()-seekBar.getPaddingRight();
                int thumbPos=seekBar.getPaddingLeft()+width*seekBar.getProgress()/seekBar.getMax();

                weightV.measure(0,0);
                int txtW= weightV.getMeasuredWidth();
                int delta=txtW/2;
                weightV.setX(seekBar.getX()+thumbPos-delta);

                weight=progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        if(UserService.guestUser!=null) {
            String[] name=UserService.guestUser.getFullName().split(" ");
            fName.setText(name[0]);
        }else if(UserService.myUser!=null){
            String[] name=UserService.guestUser.getFullName().split(" ");
            fName.setText(name[0]);
        }

        save.setOnClickListener(v -> {

            String fullName=fName.getText().toString()+" "+lName.getText().toString();
            String gender;
            if (genM.isChecked()) {
                gender = "Male";
            } else if (genF.isChecked()) {
                gender = "Female";
            } else {
                gender = "";
            }
            Uri profileImage=(Uri)intent.getParcelableExtra("profile image");
            intent=getActivity().getIntent();
            if(fName==null||lName==null||profileImage==null||gender==""||age==0||height==0||weight==0) {
                Toast.makeText(getContext(), "One of the must fields hasn't been entered", Toast.LENGTH_SHORT).show();
            } else {
                UserProfile userPrivateInfo =createUserProfileFromForm(fullName,profileImage,gender,age,height,weight);
                createUser(userPrivateInfo);
            }
        });

        return view;
    }

    public void createUser(UserProfile userPrivateInfo) {
        UserService.setMyUser(userPrivateInfo).addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                startActivity(new Intent(getContext(),
                        home_page.class));
            } else {
                Toast.makeText(getContext(),
                        "Error: " + task.getException().getLocalizedMessage(),
                        Toast.LENGTH_LONG).show();
            }
        });
    }

    public static UserProfile createUserProfileFromForm(String fullName, Uri profilePhoto, String gender, int age, double height, int weight){
        return new UserProfile(fullName,profilePhoto, gender, age, height, weight);
    }
}