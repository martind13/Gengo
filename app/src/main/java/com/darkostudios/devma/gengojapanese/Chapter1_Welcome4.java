package com.example.devma.gengojapanese;

import android.app.ActivityManager;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Handler;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;


public class Chapter1_Welcome4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter1__welcome4);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        ImageView img = (ImageView)findViewById(R.id.image1);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent myIntent = new Intent(Chapter1_Welcome4.this, Chapter1_Welcome2.class);
                Chapter1_Welcome4.this.startActivity(myIntent);
                //overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                overridePendingTransition(0, 0);

                finish();
            }
        }, 3000);


        }
    public void onBackPressed() {
        startActivity(new Intent(Chapter1_Welcome4.this, Chapters.class));
        finish();
    }

    }

