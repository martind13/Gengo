package com.example.devma.gengojapanese;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;


public class Chapter1_Welcome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter1__welcome);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.hide();


            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent myIntent = new Intent(Chapter1_Welcome.this, Chapter1_Welcome1.class);
                    Chapter1_Welcome.this.startActivity(myIntent);
                    //overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    overridePendingTransition(0, 0);
                    finish();

                }
            }, 3000);
        }
    @Override
    public void onBackPressed() {
        startActivity(new Intent(Chapter1_Welcome.this, Chapters.class));
        finish();
    }

    }
