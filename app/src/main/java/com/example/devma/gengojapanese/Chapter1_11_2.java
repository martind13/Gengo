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

public class Chapter1_11_2 extends AppCompatActivity {

    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter1_11_2);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setLogo(R.drawable.gengo_logo);
        actionBar.setDisplayUseLogoEnabled(true);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        final TextView txt = (TextView)findViewById(R.id.text);
        Resources res = getResources();
        final String[] string1 = res.getStringArray(R.array.SAtoZO);
        final String[] string2 = res.getStringArray(R.array.TAtoDO);

        Button one = (Button) this.findViewById(R.id.btn1);
        final MediaPlayer mp1 = MediaPlayer.create(this, R.raw.sa);
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt.setText(string1[0]);
                mp1.start();
            }
        });
        Button two = (Button) this.findViewById(R.id.btn2);
        final MediaPlayer mp2 = MediaPlayer.create(this, R.raw.shi);
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt.setText(string1[1]);
                mp2.start();
            }
        });
        Button three = (Button) this.findViewById(R.id.btn3);
        final MediaPlayer mp3 = MediaPlayer.create(this, R.raw.su);
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt.setText(string1[2]);
                mp3.start();
            }
        });
        Button four = (Button) this.findViewById(R.id.btn4);
        final MediaPlayer mp4 = MediaPlayer.create(this, R.raw.se);
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt.setText(string1[3]);
                mp4.start();
            }
        });
        Button five = (Button) this.findViewById(R.id.btn5);
        final MediaPlayer mp5 = MediaPlayer.create(this, R.raw.so);
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt.setText(string1[4]);
                mp5.start();
            }
        });
        Button six = (Button) this.findViewById(R.id.btn6);
        final MediaPlayer mp6 = MediaPlayer.create(this, R.raw.za);
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt.setText(string1[5]);
                mp6.start();
            }
        });
        Button seven = (Button) this.findViewById(R.id.btn7);
        final MediaPlayer mp7 = MediaPlayer.create(this, R.raw.zi);
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt.setText(string1[6]);
                mp7.start();
            }
        });
        Button eight = (Button) this.findViewById(R.id.btn8);
        final MediaPlayer mp8 = MediaPlayer.create(this, R.raw.zu);
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt.setText(string1[7]);
                mp8.start();
            }
        });
        Button nine = (Button) this.findViewById(R.id.btn9);
        final MediaPlayer mp9 = MediaPlayer.create(this, R.raw.ze);
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt.setText(string1[8]);
                mp9.start();
            }
        });
        Button ten = (Button) this.findViewById(R.id.btn10);
        final MediaPlayer mp10 = MediaPlayer.create(this, R.raw.zo);
        ten.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt.setText(string1[9]);
                mp10.start();
            }
        });

        Button one1 = (Button) this.findViewById(R.id.btn11);
        final MediaPlayer mp11 = MediaPlayer.create(this, R.raw.ta);
        one1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt.setText(string2[0]);
                mp11.start();
            }
        });
        Button two1 = (Button) this.findViewById(R.id.btn12);
        final MediaPlayer mp21 = MediaPlayer.create(this, R.raw.chi);
        two1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt.setText(string2[1]);
                mp21.start();
            }
        });
        Button three1 = (Button) this.findViewById(R.id.btn13);
        final MediaPlayer mp31 = MediaPlayer.create(this, R.raw.tsu);
        three1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt.setText(string2[2]);
                mp31.start();
            }
        });
        Button four1 = (Button) this.findViewById(R.id.btn14);
        final MediaPlayer mp41 = MediaPlayer.create(this, R.raw.te);
        four1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt.setText(string2[3]);
                mp41.start();
            }
        });
        Button five1 = (Button) this.findViewById(R.id.btn15);
        final MediaPlayer mp51 = MediaPlayer.create(this, R.raw.to);
        five1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt.setText(string2[4]);
                mp51.start();
            }
        });
        Button six1 = (Button) this.findViewById(R.id.btn16);
        final MediaPlayer mp61 = MediaPlayer.create(this, R.raw.da);
        six1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt.setText(string2[5]);
                mp61.start();
            }
        });
        Button seven1 = (Button) this.findViewById(R.id.btn17);
        final MediaPlayer mp71 = MediaPlayer.create(this, R.raw.di);
        seven1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt.setText(string2[6]);
                mp71.start();
            }
        });
        Button eight1 = (Button) this.findViewById(R.id.btn18);
        final MediaPlayer mp81 = MediaPlayer.create(this, R.raw.du);
        eight1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt.setText(string2[7]);
                mp81.start();
            }
        });
        Button nine1 = (Button) this.findViewById(R.id.btn19);
        final MediaPlayer mp91 = MediaPlayer.create(this, R.raw.de);
        nine1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt.setText(string2[8]);
                mp91.start();
            }
        });
        Button ten1 = (Button) this.findViewById(R.id.btn20);
        final MediaPlayer mp101 = MediaPlayer.create(this, R.raw.do1);
        ten1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt.setText(string2[9]);
                mp101.start();
            }
        });

    }
    public void goBack(View view){
        Intent myIntent = new Intent(Chapter1_11_2.this, Chapter1_11.class);
        Chapter1_11_2.this.startActivity(myIntent);
        finish();
    }
    @Override
    public void onBackPressed() {
        startActivity(new Intent(Chapter1_11_2.this, Chapter1_11.class));
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



