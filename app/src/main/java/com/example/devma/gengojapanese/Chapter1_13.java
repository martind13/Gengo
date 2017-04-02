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

public class Chapter1_13 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter1_13);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setLogo(R.drawable.gengo_logo);
        actionBar.setDisplayUseLogoEnabled(true);

        Button one = (Button) this.findViewById(R.id.btn131);
        final MediaPlayer mp1 = MediaPlayer.create(this, R.raw.ha);
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp1.start();
            }
        });
        Button two = (Button) this.findViewById(R.id.btn132);
        final MediaPlayer mp2 = MediaPlayer.create(this, R.raw.hi);
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp2.start();
            }
        });
        Button three = (Button) this.findViewById(R.id.btn133);
        final MediaPlayer mp3 = MediaPlayer.create(this, R.raw.fu);
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp3.start();
            }
        });
        Button four = (Button) this.findViewById(R.id.btn134);
        final MediaPlayer mp4 = MediaPlayer.create(this, R.raw.he);
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp4.start();
            }
        });
        Button five = (Button) this.findViewById(R.id.btn135);
        final MediaPlayer mp5 = MediaPlayer.create(this, R.raw.ho);
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp5.start();
            }
        });
        Button six = (Button) this.findViewById(R.id.btn136);
        final MediaPlayer mp6 = MediaPlayer.create(this, R.raw.ba);
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp6.start();
            }
        });
        Button seven = (Button) this.findViewById(R.id.btn137);
        final MediaPlayer mp7 = MediaPlayer.create(this, R.raw.bi);
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp7.start();
            }
        });
        Button eight = (Button) this.findViewById(R.id.btn138);
        final MediaPlayer mp8 = MediaPlayer.create(this, R.raw.bu);
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp8.start();
            }
        });
        Button nine = (Button) this.findViewById(R.id.btn139);
        final MediaPlayer mp9 = MediaPlayer.create(this, R.raw.be);
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp9.start();
            }
        });
        Button ten = (Button) this.findViewById(R.id.btn1310);
        final MediaPlayer mp10 = MediaPlayer.create(this, R.raw.bo);
        ten.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp10.start();
            }
        });
        Button eleven = (Button) this.findViewById(R.id.btn1311);
        final MediaPlayer mp11 = MediaPlayer.create(this, R.raw.pa);
        eleven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp11.start();
            }
        });
        Button twelve = (Button) this.findViewById(R.id.btn1312);
        final MediaPlayer mp12 = MediaPlayer.create(this, R.raw.pi);
        twelve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp12.start();
            }
        });
        Button thirteen = (Button) this.findViewById(R.id.btn1313);
        final MediaPlayer mp13 = MediaPlayer.create(this, R.raw.pu);
        thirteen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp13.start();
            }
        });
        Button fourteen = (Button) this.findViewById(R.id.btn1314);
        final MediaPlayer mp14 = MediaPlayer.create(this, R.raw.pe);
        fourteen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp14.start();
            }
        });
        Button fifteen = (Button) this.findViewById(R.id.btn1315);
        final MediaPlayer mp15 = MediaPlayer.create(this, R.raw.po);
        fifteen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp15.start();
            }
        });
    }

    public void nextPage(View view) {
        Intent myIntent = new Intent(Chapter1_13.this, Chapter1_14.class);
        Chapter1_13.this.startActivity(myIntent);
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
        startActivity(new Intent(Chapter1_13.this, Chapter1_12.class));
    }
}