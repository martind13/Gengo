package com.example.devma.gengojapanese;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class Chapter1_14 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter1_14);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setLogo(R.drawable.gengo_logo);
        actionBar.setDisplayUseLogoEnabled(true);

        Button six = (Button) this.findViewById(R.id.btn141);
        final MediaPlayer mp6 = MediaPlayer.create(this, R.raw.ra);
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp6.start();
            }
        });
        Button seven = (Button) this.findViewById(R.id.btn142);
        final MediaPlayer mp7 = MediaPlayer.create(this, R.raw.ri);
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp7.start();
            }
        });
        Button eight = (Button) this.findViewById(R.id.btn143);
        final MediaPlayer mp8 = MediaPlayer.create(this, R.raw.ru);
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp8.start();
            }
        });
        Button nine = (Button) this.findViewById(R.id.btn144);
        final MediaPlayer mp9 = MediaPlayer.create(this, R.raw.re);
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp9.start();
            }
        });
        Button ten = (Button) this.findViewById(R.id.btn145);
        final MediaPlayer mp10 = MediaPlayer.create(this, R.raw.ro);
        ten.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp10.start();
            }
        });
    }

    public void nextPage(View view) {
        Intent myIntent = new Intent(Chapter1_14.this, Chapter1_15.class);
        Chapter1_14.this.startActivity(myIntent);
        finish();
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
    public void onBackPressed() {
        startActivity(new Intent(Chapter1_14.this, Chapter1_13.class));
    }
}