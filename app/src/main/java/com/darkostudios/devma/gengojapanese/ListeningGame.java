package com.example.devma.gengojapanese;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ListeningGame extends AppCompatActivity {

    public static final String mypreference = "mypref";
    public String stringCounter = "counterKey";
    public static int counter = 0;
    SharedPreferences sharedpreferences;

    public Random rnd = new Random();
    public int[] soundFiles = new int[]{R.raw.a, R.raw.i, R.raw.u, R.raw.e, R.raw.o, R.raw.ka, R.raw.ki, R.raw.ku, R.raw.ke, R.raw.ko, R.raw.ga, R.raw.gi, R.raw.gu, R.raw.ge, R.raw.go};
    public int[] btns_orange = new int[]{R.drawable.a_orange, R.drawable.i_orange, R.drawable.u_orange, R.drawable.e_orange, R.drawable.o_orange, R.drawable.ka_orange, R.drawable.ki_orange, R.drawable.ku_orange, R.drawable.ke_orange, R.drawable.ko_orange, R.drawable.ga_orange, R.drawable.gi_orange, R.drawable.gu_orange, R.drawable.ge_orange, R.drawable.go_orange};
    private int[] btns_green = new int[]{R.drawable.a_green, R.drawable.i_green, R.drawable.u_green, R.drawable.e_green, R.drawable.o_green, R.drawable.ka_green, R.drawable.ki_green, R.drawable.ku_green, R.drawable.ke_green, R.drawable.ko_green, R.drawable.ga_green, R.drawable.gi_green, R.drawable.gu_green, R.drawable.ge_green, R.drawable.go_green};
    private int[] mButtons = new int[]{R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4, R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9};
    public int y;

    List<Integer> numbers = new ArrayList<>();


    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listening_game);

        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        sharedpreferences = getSharedPreferences(mypreference,
                Context.MODE_PRIVATE);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setLogo(R.drawable.gengo_logo);
        actionBar.setDisplayUseLogoEnabled(true);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        for (int i = 0; i < soundFiles.length; i++) {
            numbers.add(i);
        }

        setBoard();
    }

    public int getRand() {

        int arrIndex = (int) ((double) numbers.size() * Math.random());
        int x = numbers.get(arrIndex);
        numbers.remove(arrIndex);
        return x;

    }

    public void setBoard() {

        counter++;
        stringCounter = Integer.toString(counter);

        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(mypreference, stringCounter);
        editor.commit();
        Toast.makeText(this.getBaseContext(), stringCounter,
                Toast.LENGTH_SHORT).show();
        y = getRand();
        Button one = (Button) findViewById(R.id.practice1);
        final MediaPlayer mp1 = MediaPlayer.create(this, soundFiles[y]);
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp1.start();

            }
        });

        final int ans = rnd.nextInt(mButtons.length);

        final ImageButton button1 = (ImageButton) findViewById(R.id.btn1);
        final ImageButton button2 = (ImageButton) findViewById(R.id.btn2);
        final ImageButton button3 = (ImageButton) findViewById(R.id.btn3);
        final ImageButton button4 = (ImageButton) findViewById(R.id.btn4);
        final ImageButton button5 = (ImageButton) findViewById(R.id.btn5);
        final ImageButton button6 = (ImageButton) findViewById(R.id.btn6);
        final ImageButton button7 = (ImageButton) findViewById(R.id.btn7);
        final ImageButton button8 = (ImageButton) findViewById(R.id.btn8);
        final ImageButton button9 = (ImageButton) findViewById(R.id.btn9);

        findViewById(mButtons[ans]).setBackgroundResource(btns_orange[y]);

        for (int i = 0; i < mButtons.length; i++) {
            if(mButtons[ans] != mButtons[i])
            findViewById(mButtons[i]).setBackgroundResource(btns_orange[getRand()]);
        }

        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                findViewById(mButtons[ans]).setBackgroundResource(btns_green[y]);

                button1.setEnabled(false);
                button2.setEnabled(false);
                button3.setEnabled(false);
                button4.setEnabled(false);
                button5.setEnabled(false);
                button6.setEnabled(false);
                button7.setEnabled(false);
                button8.setEnabled(false);
                button9.setEnabled(false);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        resetGame();
                    }
                }, 700);
            }
        });


        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                findViewById(mButtons[ans]).setBackgroundResource(btns_green[y]);

                button1.setEnabled(false);
                button2.setEnabled(false);
                button3.setEnabled(false);
                button4.setEnabled(false);
                button5.setEnabled(false);
                button6.setEnabled(false);
                button7.setEnabled(false);
                button8.setEnabled(false);
                button9.setEnabled(false);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        resetGame();
                    }
                }, 700);

            }
        });


        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                findViewById(mButtons[ans]).setBackgroundResource(btns_green[y]);

                button1.setEnabled(false);
                button2.setEnabled(false);
                button3.setEnabled(false);
                button4.setEnabled(false);
                button5.setEnabled(false);
                button6.setEnabled(false);
                button7.setEnabled(false);
                button8.setEnabled(false);
                button9.setEnabled(false);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        resetGame();
                    }
                }, 700);

            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                findViewById(mButtons[ans]).setBackgroundResource(btns_green[y]);

                button1.setEnabled(false);
                button2.setEnabled(false);
                button3.setEnabled(false);
                button4.setEnabled(false);
                button5.setEnabled(false);
                button6.setEnabled(false);
                button7.setEnabled(false);
                button8.setEnabled(false);
                button9.setEnabled(false);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        resetGame();
                    }
                }, 700);

            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                findViewById(mButtons[ans]).setBackgroundResource(btns_green[y]);

                button1.setEnabled(false);
                button2.setEnabled(false);
                button3.setEnabled(false);
                button4.setEnabled(false);
                button5.setEnabled(false);
                button6.setEnabled(false);
                button7.setEnabled(false);
                button8.setEnabled(false);
                button9.setEnabled(false);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        resetGame();
                    }
                }, 700);

            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                findViewById(mButtons[ans]).setBackgroundResource(btns_green[y]);

                button1.setEnabled(false);
                button2.setEnabled(false);
                button3.setEnabled(false);
                button4.setEnabled(false);
                button5.setEnabled(false);
                button6.setEnabled(false);
                button7.setEnabled(false);
                button8.setEnabled(false);
                button9.setEnabled(false);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        resetGame();
                    }
                }, 700);

            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                findViewById(mButtons[ans]).setBackgroundResource(btns_green[y]);

                button1.setEnabled(false);
                button2.setEnabled(false);
                button3.setEnabled(false);
                button4.setEnabled(false);
                button5.setEnabled(false);
                button6.setEnabled(false);
                button7.setEnabled(false);
                button8.setEnabled(false);
                button9.setEnabled(false);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        resetGame();
                    }
                }, 700);

            }
        });


        button8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                findViewById(mButtons[ans]).setBackgroundResource(btns_green[y]);

                button1.setEnabled(false);
                button2.setEnabled(false);
                button3.setEnabled(false);
                button4.setEnabled(false);
                button5.setEnabled(false);
                button6.setEnabled(false);
                button7.setEnabled(false);
                button8.setEnabled(false);
                button9.setEnabled(false);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        resetGame();
                    }
                }, 700);

            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                findViewById(mButtons[ans]).setBackgroundResource(btns_green[y]);

                button1.setEnabled(false);
                button2.setEnabled(false);
                button3.setEnabled(false);
                button4.setEnabled(false);
                button5.setEnabled(false);
                button6.setEnabled(false);
                button7.setEnabled(false);
                button8.setEnabled(false);
                button9.setEnabled(false);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        resetGame();
                    }
                }, 700);

            }
        });

    }

    public void resetGame() {

        sharedpreferences = getSharedPreferences(mypreference,
                Context.MODE_PRIVATE);

        if (stringCounter == "0" || stringCounter == "1" || stringCounter == "2" || stringCounter == "3" || stringCounter == "4" || stringCounter == "5") {
            startActivity(new Intent(this, ListeningGame.class));
            finish();
        } else {
            startActivity(new Intent(this, Chapter1_4.class));
            finish();

        }
    }

    @Override
    public void onBackPressed() {
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

