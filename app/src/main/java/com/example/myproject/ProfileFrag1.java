package com.example.myproject;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

public class ProfileFrag1 extends Fragment {

    protected EditText fName,lName;
    protected Button save;
    Intent intent;

    public ProfileFrag1() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_profile_frag1, container, false);

        fName=view.findViewById(R.id.fName);
        lName=view.findViewById(R.id.lName);

        save=view.findViewById(R.id.save);

        if(UserService.guestUser!=null) {
            String[] name=UserService.guestUser.getFullName().split(" ");
            fName.setText(name[0]);
        }

        save.setOnClickListener(v -> {

            String fullName=fName.getText().toString()+" "+lName.getText().toString();

            Uri profileImage=(Uri)intent.getParcelableExtra("profile image");
            intent=getActivity().getIntent();

            if(fName==null||lName==null||profileImage==null) {
                Toast.makeText(getContext(), "One of the must fields hasn't been entered", Toast.LENGTH_SHORT).show();
            } else {
                GuestUserProfile guestUserProfile =createUserProfileFromForm1(fullName,profileImage);
                createUser(guestUserProfile);
            }
        });

        return view;
    }
    public void createUser(GuestUserProfile guestUserProfile) {
        UserService.setMyGuestUser(guestUserProfile).addOnCompleteListener(task -> {
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

    public static GuestUserProfile createUserProfileFromForm1(String fullName, Uri profilePhoto){
        return new GuestUserProfile(fullName,profilePhoto);
    }
}