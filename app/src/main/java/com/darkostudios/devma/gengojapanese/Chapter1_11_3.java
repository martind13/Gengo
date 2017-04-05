package com.example.devma.gengojapanese;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.firebase.auth.FirebaseAuth;

public class Chapter1_11_3 extends AppCompatActivity {
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter1_11_3);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setLogo(R.drawable.gengo_logo);
        actionBar.setDisplayUseLogoEnabled(true);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        final TextView txt = (TextView)findViewById(R.id.text);
        Resources res = getResources();
        final String[] string1 = res.getStringArray(R.array.MAtoMO);
        final String[] string2 = res.getStringArray(R.array.NAtoNO);
        Button one = (Button)this.findViewById(R.id.btn1);
        final MediaPlayer mp1 = MediaPlayer.create(this, R.raw.ma);
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                txt.setText(string1[0]);
                mp1.start();
            }
        });
        Button two = (Button)this.findViewById(R.id.btn2);
        final MediaPlayer mp2 = MediaPlayer.create(this, R.raw.mi);
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt.setText(string1[1]);
                mp2.start();
            }
        });
        Button three = (Button)this.findViewById(R.id.btn3);
        final MediaPlayer mp3 = MediaPlayer.create(this, R.raw.mu);
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt.setText(string1[2]);
                mp3.start();
            }
        });
        Button four = (Button)this.findViewById(R.id.btn4);
        final MediaPlayer mp4 = MediaPlayer.create(this, R.raw.me);
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt.setText(string1[3]);
                mp4.start();
            }
        });
        Button five = (Button)this.findViewById(R.id.btn5);
        final MediaPlayer mp5 = MediaPlayer.create(this, R.raw.mo);
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt.setText(string1[4]);
                mp5.start();
            }
        });
        Button six = (Button) this.findViewById(R.id.btn6);
        final MediaPlayer mp6 = MediaPlayer.create(this, R.raw.na);
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt.setText(string2[0]);
                mp6.start();
            }
        });
        Button seven = (Button) this.findViewById(R.id.btn7);
        final MediaPlayer mp7 = MediaPlayer.create(this, R.raw.ni);
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt.setText(string2[1]);
                mp7.start();
            }
        });
        Button eight = (Button) this.findViewById(R.id.btn8);
        final MediaPlayer mp8 = MediaPlayer.create(this, R.raw.nu);
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt.setText(string2[2]);
                mp8.start();
            }
        });
        Button nine = (Button) this.findViewById(R.id.btn9);
        final MediaPlayer mp9 = MediaPlayer.create(this, R.raw.ne);
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt.setText(string2[3]);
                mp9.start();
            }
        });
        Button ten = (Button) this.findViewById(R.id.btn10);
        final MediaPlayer mp10 = MediaPlayer.create(this, R.raw.no);
        ten.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                txt.setText(string2[4]);
                mp10.start();
            }
        });

    }
    public void goBack(View view){
        Intent myIntent = new Intent(Chapter1_11_3.this, Chapter1_11.class);
        Chapter1_11_3.this.startActivity(myIntent);
        finish();
    }
    @Override
    public void onBackPressed() {
        startActivity(new Intent(Chapter1_11_3.this, Chapter1_11.class));
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_activity, menu);

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
