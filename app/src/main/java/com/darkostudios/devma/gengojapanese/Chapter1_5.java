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

public class Chapter1_5 extends TransitionActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter1_5);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setLogo(R.drawable.gengo_logo);
        actionBar.setDisplayUseLogoEnabled(true);

        TextView txt1 = (TextView)findViewById(R.id.textview1);
        TextView txt2 = (TextView)findViewById(R.id.textview2);
        TextView txt3 = (TextView)findViewById(R.id.textview3);
        TextView txt4 = (TextView)findViewById(R.id.textview4);
        TextView txt5 = (TextView)findViewById(R.id.textview5);
        TextView txt6 = (TextView)findViewById(R.id.textview6);
        TextView txt7 = (TextView)findViewById(R.id.textview7);
        TextView txt8 = (TextView)findViewById(R.id.textview8);
        TextView txt9 = (TextView)findViewById(R.id.textview9);
        TextView txt10 = (TextView)findViewById(R.id.textview10);

        Resources res = getResources();
        String[] str = res.getStringArray(R.array.SAtoZO);

        txt1.setText(str[0]);
        txt2.setText(str[1]);
        txt3.setText(str[2]);
        txt4.setText(str[3]);
        txt5.setText(str[4]);
        txt6.setText(str[5]);
        txt7.setText(str[6]);
        txt8.setText(str[7]);
        txt9.setText(str[8]);
        txt10.setText(str[9]);

        Button one = (Button) this.findViewById(R.id.btn1);
        final MediaPlayer mp1 = MediaPlayer.create(this, R.raw.sa);
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp1.start();
            }
        });
        Button two = (Button) this.findViewById(R.id.btn2);
        final MediaPlayer mp2 = MediaPlayer.create(this, R.raw.shi);
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp2.start();
            }
        });
        Button three = (Button) this.findViewById(R.id.btn3);
        final MediaPlayer mp3 = MediaPlayer.create(this, R.raw.su);
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp3.start();
            }
        });
        Button four = (Button) this.findViewById(R.id.btn4);
        final MediaPlayer mp4 = MediaPlayer.create(this, R.raw.se);
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp4.start();
            }
        });
        Button five = (Button) this.findViewById(R.id.btn5);
        final MediaPlayer mp5 = MediaPlayer.create(this, R.raw.so);
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp5.start();
            }
        });
        Button six = (Button) this.findViewById(R.id.btn6);
        final MediaPlayer mp6 = MediaPlayer.create(this, R.raw.za);
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp6.start();
            }
        });
        Button seven = (Button) this.findViewById(R.id.btn7);
        final MediaPlayer mp7 = MediaPlayer.create(this, R.raw.zi);
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp7.start();
            }
        });
        Button eight = (Button) this.findViewById(R.id.btn8);
        final MediaPlayer mp8 = MediaPlayer.create(this, R.raw.zu);
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp8.start();
            }
        });
        Button nine = (Button) this.findViewById(R.id.btn9);
        final MediaPlayer mp9 = MediaPlayer.create(this, R.raw.ze);
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp9.start();
            }
        });
        Button ten = (Button) this.findViewById(R.id.btn10);
        final MediaPlayer mp10 = MediaPlayer.create(this, R.raw.zo);
        ten.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp10.start();
            }
        });
    }

    public void nextPage(View view) {
        Intent myIntent = new Intent(Chapter1_5.this, Chapter1_6.class);
        Chapter1_5.this.startActivity(myIntent);
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
    @Override
    public void onBackPressed() {
        startActivity(new Intent(Chapter1_5.this, Chapter1_3.class));
    }
}