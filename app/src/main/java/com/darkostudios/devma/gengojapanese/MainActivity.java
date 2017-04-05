package com.example.devma.gengojapanese;


import android.app.ActionBar;
import android.content.Intent;

import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.iid.FirebaseInstanceId;


public class MainActivity extends AppCompatActivity {


    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

       mDatabase = FirebaseDatabase.getInstance().getReference("Tokens");

        //ArrayList<String> tokenArray = new ArrayList<String>();
        String token = FirebaseInstanceId.getInstance().getToken();
        // tokenArray.add(token); //add result into array list
        mDatabase.child(token).setValue(" ");

    }

    public void loginClick(View view) {

        Intent myIntent = new Intent(MainActivity.this, LoginActivity.class);
        MainActivity.this.startActivity(myIntent);
        finish();
    }
    public void newuserClick(View view) {

        Intent myIntent = new Intent(MainActivity.this, RegistrationActivity.class);
        MainActivity.this.startActivity(myIntent);
        finish();
    }
    public void aboutClick(View view) {

        Intent myIntent = new Intent(MainActivity.this, About.class);
        MainActivity.this.startActivity(myIntent);
        finish();
    }


}
