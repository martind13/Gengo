package com.example.devma.gengojapanese;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Chapter1_7_1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter1_7_1);

        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent myIntent = new Intent(Chapter1_7_1.this, Chapter1_8.class);
                Chapter1_7_1.this.startActivity(myIntent);
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
