package com.example.devma.gengojapanese;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.google.firebase.auth.FirebaseAuth;

public class Chapter1_4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter1_4);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent myIntent = new Intent(Chapter1_4.this, Chapter1_4_2.class);
                Chapter1_4.this.startActivity(myIntent);
                //overridePendingTransition(R.anim.fade_in, R.anim.fade_out);

                finish();
                overridePendingTransition(0, 0);
            }
        }, 3000);
    }
    @Override
    public void onBackPressed() {

    }
}
