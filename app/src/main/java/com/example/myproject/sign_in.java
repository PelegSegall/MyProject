package com.example.myproject;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.List;
import java.util.Objects;

public class sign_in extends AppCompatActivity {
    protected EditText mail, password;
    protected Button signUp,continueBt;
    protected FrameLayout layoutAbout;
    protected LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getColor(R.color.turkiz)));

        layoutAbout=findViewById(R.id.layoutAbouts);
        mail= findViewById(R.id.mail);
        password=findViewById(R.id.password);
        continueBt=findViewById(R.id.sign_in);
        signUp=findViewById(R.id.sign_up);

        signUp.setOnClickListener(v -> {
            Intent intent= new Intent(sign_in.this, sign_up.class);
            startActivity(intent);
        });

        continueBt.setOnClickListener(v -> signIn());

        forceRTLIfSupported();
    }

    private void signIn(){
        String email= mail.getText().toString();
        String pass=password.getText().toString();

        if(email.isEmpty()||pass.isEmpty()){
            Toast.makeText(this,
                    "please enter mail or password",
                    Toast.LENGTH_SHORT).show();
            return;
        }

        FirebaseAuth.getInstance().signInWithEmailAndPassword(email,
                        pass)
                .addOnCompleteListener(task -> {
                    if(task.isSuccessful()){
                        Toast.makeText(this,
                                "Signed in successfully",
                                Toast.LENGTH_LONG).show();
                        startActivity(new Intent(sign_in.this,
                                splash_screen.class));
                    }else{
                        Toast.makeText(this,
                                "Error: "+ Objects.requireNonNull(task.getException()).getLocalizedMessage(),
                                Toast.LENGTH_LONG).show();
                    }
                });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.sign_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        int itemId = item.getItemId();
        if (itemId == R.id.item_exit) {
            Toast.makeText(this,"Exit is selected", Toast.LENGTH_SHORT).show();
            new AlertDialog.Builder(this)
                    .setMessage("Are you sure you want to exit?")
                    .setCancelable(false)
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ActivityManager activityManager=(ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
                            List<ActivityManager.AppTask> appTasks=activityManager.getAppTasks();
                            for (ActivityManager.AppTask appTask:appTasks){
                                appTask.finishAndRemoveTask();
                            }
                        }
                    })
                    .setNegativeButton("No",null)
                    .show();
            return true;
        } else if (itemId == R.id.about_prog) {
            Toast.makeText(this,"About the programmer is selected", Toast.LENGTH_SHORT).show();
            CreatePopUp1();
            return true;
        }else if (itemId == R.id.about_program) {
            Toast.makeText(this, "About the program is selected", Toast.LENGTH_SHORT).show();
            CreatePopUp2();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void CreatePopUp1(){
        layout=findViewById(R.id.layout);
        LayoutInflater inflater=(LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        View popUpview= inflater.inflate(R.layout.programmer_popup,null);
        int width= ViewGroup.LayoutParams.MATCH_PARENT;
        int height= ViewGroup.LayoutParams.MATCH_PARENT;
        boolean focusable=true;
        PopupWindow popupWindow=new PopupWindow(popUpview,width,height,focusable);
        layoutAbout.post(() -> {
            popupWindow.showAtLocation(layoutAbout, Gravity.CENTER, 0, 0);
            layout.setAlpha((float)0.1);
        });
        popUpview.setOnTouchListener((v, event) -> {
            popupWindow.dismiss();
            layout.setAlpha((float)1);
            return true;
        });
    }

    private void CreatePopUp2(){
        layout=findViewById(R.id.layout);
        LayoutInflater inflater=(LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        View popUpview= inflater.inflate(R.layout.program_popup,null);
        int width= ViewGroup.LayoutParams.MATCH_PARENT;
        int height= ViewGroup.LayoutParams.MATCH_PARENT;
        boolean focusable=true;
        PopupWindow popupWindow=new PopupWindow(popUpview,width,height,focusable);
        layoutAbout.post(() -> {
            popupWindow.showAtLocation(layoutAbout, Gravity.CENTER, 0, 0);
            layout.setAlpha((float)0.1);
        });
        popUpview.setOnTouchListener((v, event) -> {
            popupWindow.dismiss();
            layout.setAlpha((float)1);
            return true;
        });
    }

    @SuppressLint("ObsoleteSdkInt")
    private void forceRTLIfSupported() {
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.JELLY_BEAN_MR1){
            getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_LTR);
        }
    }
}