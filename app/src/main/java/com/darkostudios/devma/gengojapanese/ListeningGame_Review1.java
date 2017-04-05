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

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by devma on 4/1/2017.
 */

public class ListeningGame_Review1 extends AppCompatActivity {

    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String stringCounter = "counterKey";

    // public static final String PREFS = "examplePrefs";

    public static int counter = 0;
    //String stringCounter;
    // SharedPreferences pref1;
    SharedPreferences sharedpreferences;

    public Random rnd = new Random();
    public int[] soundFiles = new int[]{R.raw.a, R.raw.i, R.raw.u, R.raw.e, R.raw.o, R.raw.ka, R.raw.ki, R.raw.ku, R.raw.ke, R.raw.ko, R.raw.ga, R.raw.gi, R.raw.gu, R.raw.ge, R.raw.go, R.raw.sa, R.raw.shi, R.raw.su, R.raw.se, R.raw.so, R.raw.za, R.raw.zi, R.raw.zu, R.raw.ze, R.raw.zo,R.raw.ta, R.raw.chi, R.raw.tsu, R.raw.te, R.raw.to,R.raw.da, R.raw.di, R.raw.du, R.raw.de, R.raw.do1, R.raw.ma, R.raw.mi, R.raw.mu, R.raw.me, R.raw.mo, R.raw.na, R.raw.ni, R.raw.nu, R.raw.ne, R.raw.no};
    public int[] btns_orange = new int[]{R.drawable.a_orange, R.drawable.i_orange, R.drawable.u_orange, R.drawable.e_orange, R.drawable.o_orange, R.drawable.ka_orange, R.drawable.ki_orange, R.drawable.ku_orange, R.drawable.ke_orange, R.drawable.ko_orange, R.drawable.ga_orange, R.drawable.gi_orange, R.drawable.gu_orange, R.drawable.ge_orange, R.drawable.go_orange, R.drawable.sa_orange, R.drawable.shi_orange, R.drawable.su_orange, R.drawable.se_orange, R.drawable.so_orange, R.drawable.za_orange, R.drawable.zi_orange, R.drawable.zu_orange, R.drawable.ze_orange, R.drawable.zo_orange, R.drawable.ta_orange, R.drawable.chi_orange, R.drawable.tsu_orange, R.drawable.te_orange, R.drawable.to_orange, R.drawable.da_orange, R.drawable.di_orange, R.drawable.du_orange, R.drawable.de_orange, R.drawable.do_orange, R.drawable.ma_orange, R.drawable.mi_orange, R.drawable.mu_orange, R.drawable.me_orange, R.drawable.mo_orange, R.drawable.na_orange, R.drawable.ni_orange, R.drawable.nu_orange, R.drawable.ne_orange, R.drawable.no_orange};
    //private int[] btns_red = new int[]{R.drawable.a_red, R.drawable.i_red, R.drawable.u_red, R.drawable.e_red, R.drawable.o_red, R.drawable.ka_red, R.drawable.ki_red, R.drawable.ku_red, R.drawable.ke_red, R.drawable.ko_red};
    private int[] btns_green = new int[]{R.drawable.a_green, R.drawable.i_green, R.drawable.u_green, R.drawable.e_green, R.drawable.o_green, R.drawable.ka_green, R.drawable.ki_green, R.drawable.ku_green, R.drawable.ke_green, R.drawable.ko_green, R.drawable.ga_green, R.drawable.gi_green, R.drawable.gu_green, R.drawable.ge_green, R.drawable.go_green, R.drawable.sa_green, R.drawable.shi_green, R.drawable.su_green, R.drawable.se_green, R.drawable.so_green, R.drawable.za_green, R.drawable.zi_green, R.drawable.zu_green, R.drawable.ze_green, R.drawable.zo_green, R.drawable.ta_green, R.drawable.chi_green, R.drawable.tsu_green, R.drawable.te_green, R.drawable.to_green, R.drawable.da_green, R.drawable.di_green, R.drawable.du_green, R.drawable.de_green, R.drawable.do_green, R.drawable.ma_green, R.drawable.mi_green, R.drawable.mu_green, R.drawable.me_green, R.drawable.mo_green, R.drawable.na_green, R.drawable.ni_green, R.drawable.nu_green, R.drawable.ne_green, R.drawable.no_green};
    private int[] mButtons = new int[]{R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4, R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9};
    public int y;
    public int noise = rnd.nextInt(soundFiles.length);
    final int ans = rnd.nextInt(mButtons.length);

    List<Integer> numbers = new ArrayList<>();
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listening_game);

        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);


        ActionBar actionBar = getSupportActionBar();
        actionBar.setLogo(R.drawable.gengo_logo);
        actionBar.setDisplayUseLogoEnabled(true);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        for (int i = 0; i < soundFiles.length; i++) {
            numbers.add(i);
        }


        //setAns();
        setBoard();
    }

    public int getRand() {

        int arrIndex = (int) ((double) numbers.size() * Math.random());
        int x = numbers.get(arrIndex);
        numbers.remove(arrIndex);
        return x;

    }

    public void setBoard() {

        SharedPreferences.Editor editor = sharedpreferences.edit();

        counter++;
        String x = Integer.toString(counter);

        editor.putString(stringCounter, x);
        editor.commit();

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

        if (stringCounter == "0" || stringCounter == "1" || stringCounter == "2" || stringCounter == "3" || stringCounter == "4" || stringCounter == "5") {
            startActivity(new Intent(this, ListeningGame_Review1.class));
            finish();
        } else {
            startActivity(new Intent(this, RomanjiGame_Review1.class));
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