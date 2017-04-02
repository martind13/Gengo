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


public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

    }

    public void loginClick(View view) {
        Button login = (Button)findViewById(R.id.login);
       /* final Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.bounce);
        MyBounceInterpolator interpolator = new MyBounceInterpolator(0.2, 20);
        myAnim.setInterpolator(interpolator);
        login.startAnimation(myAnim);*/
        Intent myIntent = new Intent(MainActivity.this, LoginActivity.class);
        MainActivity.this.startActivity(myIntent);
        finish();
    }
    public void newuserClick(View view) {
        Button newuser = (Button)findViewById(R.id.newuser);
        final Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.bounce);
        MyBounceInterpolator interpolator = new MyBounceInterpolator(0.2, 20);
        myAnim.setInterpolator(interpolator);
        newuser.startAnimation(myAnim);
        Intent myIntent = new Intent(MainActivity.this, RegistrationActivity.class);
        MainActivity.this.startActivity(myIntent);
        finish();
    }
    public void aboutClick(View view) {
        Button about = (Button)findViewById(R.id.about);
        final Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.bounce);
        MyBounceInterpolator interpolator = new MyBounceInterpolator(0.2, 20);
        myAnim.setInterpolator(interpolator);
        about.startAnimation(myAnim);
        Intent myIntent = new Intent(MainActivity.this, About.class);
        MainActivity.this.startActivity(myIntent);
        finish();
    }


}
