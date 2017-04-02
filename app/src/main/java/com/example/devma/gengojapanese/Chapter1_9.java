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

import com.google.firebase.auth.FirebaseAuth;

public class Chapter1_9 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter1_9);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setLogo(R.drawable.gengo_logo);
        actionBar.setDisplayUseLogoEnabled(true);

        TextView txt1 = (TextView)findViewById(R.id.textview1);
        TextView txt2 = (TextView)findViewById(R.id.textview2);
        TextView txt3 = (TextView)findViewById(R.id.textview3);
        TextView txt4 = (TextView)findViewById(R.id.textview4);
        TextView txt5 = (TextView)findViewById(R.id.textview5);

        Resources res = getResources();
        String[] str = res.getStringArray(R.array.MAtoMO);

        txt1.setText(str[0]);
        txt2.setText(str[1]);
        txt3.setText(str[2]);
        txt4.setText(str[3]);
        txt5.setText(str[4]);


        Button six = (Button) this.findViewById(R.id.btn91);
        final MediaPlayer mp6 = MediaPlayer.create(this, R.raw.ma);
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mp6.start();
            }
        });
        Button seven = (Button) this.findViewById(R.id.btn92);
        final MediaPlayer mp7 = MediaPlayer.create(this, R.raw.mi);
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp7.start();
            }
        });
        Button eight = (Button) this.findViewById(R.id.btn93);
        final MediaPlayer mp8 = MediaPlayer.create(this, R.raw.mu);
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp8.start();
            }
        });
        Button nine = (Button) this.findViewById(R.id.btn94);
        final MediaPlayer mp9 = MediaPlayer.create(this, R.raw.me);
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp9.start();
            }
        });
        Button ten = (Button) this.findViewById(R.id.btn95);
        final MediaPlayer mp10 = MediaPlayer.create(this, R.raw.mo);
        ten.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp10.start();
            }
        });
    }

    public void nextPage(View view) {
        Intent myIntent = new Intent(Chapter1_9.this, Chapter1_11.class);
        Chapter1_9.this.startActivity(myIntent);
        finish();
    }    @Override
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
    public void onBackPressed() {
        startActivity(new Intent(Chapter1_9.this, Chapter1_8.class));
    }
}