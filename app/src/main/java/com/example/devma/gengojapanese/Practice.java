package com.example.devma.gengojapanese;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.firebase.auth.FirebaseAuth;

public class Practice extends AppCompatActivity {
   private AdView mAdView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setLogo(R.drawable.gengo_logo);
        actionBar.setDisplayUseLogoEnabled(true);

       mAdView = (AdView) findViewById(R.id.adView);
       AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        Button one = (Button)this.findViewById(R.id.btn1);

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(Practice.this, ListeningGame_Practice.class);
                Practice.this.startActivity(myIntent);
            }
        });

        Button two = (Button)this.findViewById(R.id.btn2);

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(Practice.this, Romanji_Practice.class);
                Practice.this.startActivity(myIntent);
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_activity, menu);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Take appropriate action for each action item click
        switch (item.getItemId()) {
            case R.id.action_logout:
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(this, LoginActivity.class));
                finish();
                return true;
            case R.id.action_home:
                startActivity(new Intent(this, WelcomeScreen.class));
                finish();
                return true;
            case R.id.action_practice:
                startActivity(new Intent(this, Practice.class));
                finish();
                return true;
            case R.id.action_chapters:
                startActivity(new Intent(this, Chapters.class));
                finish();
                return true;
            case R.id.action_about:
                startActivity(new Intent(this, About.class));
                finish();
                return true;
            case R.id.action_vocab:
                startActivity(new Intent(this, VocabMenu.class));
                finish();
                return true;
            case R.id.action_kanji:
                startActivity(new Intent(this, Kanji.class));
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
