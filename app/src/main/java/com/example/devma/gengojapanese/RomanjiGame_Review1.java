package com.example.devma.gengojapanese;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by devma on 4/1/2017.
 */

public class RomanjiGame_Review1 extends AppCompatActivity{
    public static final String PREFS = "examplePrefs";

    public static int counter = 0;
    String stringCounter;
    SharedPreferences example;

    public Random rnd = new Random();
    public String[] question = new String[]{"NAMAE", "MADO", "SHIZUKA", "DOU", "TSUKI", "EIGO"};
    public String[] question_eng = new String[]{"\"Name\"", "\"Window\"", "\"Quiet; peaceful\"", "\"Road\"", "\"Moon; month\"", "\"English Language\""};
    public String[] answers = new String[]{"なまえ", "まど", "しずか", "どう", "つき", "えいご"};
    public String[] fill1 = new String[]{"かたち", "つくえ", "ちいき"};
    public String[] fill2 = new String[]{"まえ", "かく", "たち"};
    public String[] fill3 = new String[]{"しめす", "だいち", "ざいこ"};
    public String[] fill4 = new String[]{"えか", "ぞう", "ごう"};
    public String[] fill5 = new String[]{"きく", "たか", "てつ"};
    public String[] fill6 = new String[]{"ちかく", "えいが", "えがく"};
    private int[] mButtons = new int[]{R.id.ans1, R.id.ans2, R.id.ans3, R.id.ans4};

    public int y;

    final int ans = rnd.nextInt(mButtons.length);

    List<Integer> numbers = new ArrayList<>();

    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_romanji_game);

        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        example = getSharedPreferences(PREFS, counter);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        for (int i = 0; i < 3; i++) {
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

        //Toast.makeText(RomanjiGame.this, stringCounter,
        //        Toast.LENGTH_LONG).show();

        //y = getRand();
        final TextView romanji = (TextView) findViewById(R.id.romaji);
        final TextView english = (TextView) findViewById(R.id.romanji_eng);
        final Button button1 = (Button) findViewById(R.id.ans1);
        final Button button2 = (Button) findViewById(R.id.ans2);
        final Button button3 = (Button) findViewById(R.id.ans3);
        final Button button4 = (Button) findViewById(R.id.ans4);

        if(counter == 1) {
            button1.setText(answers[0]);
            romanji.setText(question[0]);
            english.setText(question_eng[0]);
            button2.setText(fill1[getRand()]);
            button3.setText(fill1[getRand()]);
            button4.setText(fill1[getRand()]);
        } else if (counter == 2){
            button4.setText(answers[1]);
            romanji.setText(question[1]);
            english.setText(question_eng[1]);
            button1.setText(fill2[getRand()]);
            button2.setText(fill2[getRand()]);
            button3.setText(fill2[getRand()]);
        }else if (counter == 3){
            button2.setText(answers[2]);
            romanji.setText(question[2]);
            english.setText(question_eng[2]);
            button1.setText(fill3[getRand()]);
            button3.setText(fill3[getRand()]);
            button4.setText(fill3[getRand()]);
        }else if (counter == 4){
            button1.setText(answers[3]);
            romanji.setText(question[3]);
            english.setText(question_eng[3]);
            button2.setText(fill4[getRand()]);
            button3.setText(fill4[getRand()]);
            button4.setText(fill4[getRand()]);
        }else if (counter == 5){
            button3.setText(answers[4]);
            romanji.setText(question[4]);
            english.setText(question_eng[4]);
            button1.setText(fill5[getRand()]);
            button2.setText(fill5[getRand()]);
            button4.setText(fill5[getRand()]);
        }else if (counter == 6){
            button4.setText(answers[5]);
            romanji.setText(question[5]);
            english.setText(question_eng[5]);
            button1.setText(fill6[getRand()]);
            button2.setText(fill6[getRand()]);
            button3.setText(fill6[getRand()]);
        }

        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                button1.setEnabled(false);
                button2.setEnabled(false);
                button3.setEnabled(false);
                button4.setEnabled(false);

                if(counter == 1) {
                    button1.setBackgroundResource(R.drawable.buttoncolor);
                } else if (counter == 2){
                    button4.setBackgroundResource(R.drawable.buttoncolor);
                }else if (counter == 3){
                    button2.setBackgroundResource(R.drawable.buttoncolor);
                }else if (counter == 4){
                    button1.setBackgroundResource(R.drawable.buttoncolor);
                }else if (counter == 5){
                    button3.setBackgroundResource(R.drawable.buttoncolor);
                }else if (counter == 6){
                    button4.setBackgroundResource(R.drawable.buttoncolor);
                }

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        resetGame();
                    }
                }, 1000);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                if(counter == 1) {
                    button1.setBackgroundResource(R.drawable.buttoncolor);
                } else if (counter == 2){
                    button4.setBackgroundResource(R.drawable.buttoncolor);
                }else if (counter == 3){
                    button2.setBackgroundResource(R.drawable.buttoncolor);
                }else if (counter == 4){
                    button1.setBackgroundResource(R.drawable.buttoncolor);
                }else if (counter == 5){
                    button3.setBackgroundResource(R.drawable.buttoncolor);
                }else if (counter == 6){
                    button4.setBackgroundResource(R.drawable.buttoncolor);
                }

                button1.setEnabled(false);
                button2.setEnabled(false);
                button3.setEnabled(false);
                button4.setEnabled(false);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        resetGame();
                    }
                }, 1000);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                if(counter == 1) {
                    button1.setBackgroundResource(R.drawable.buttoncolor);
                } else if (counter == 2){
                    button4.setBackgroundResource(R.drawable.buttoncolor);
                }else if (counter == 3){
                    button2.setBackgroundResource(R.drawable.buttoncolor);
                }else if (counter == 4){
                    button1.setBackgroundResource(R.drawable.buttoncolor);
                }else if (counter == 5){
                    button3.setBackgroundResource(R.drawable.buttoncolor);
                }else if (counter == 6){
                    button4.setBackgroundResource(R.drawable.buttoncolor);
                }

                button1.setEnabled(false);
                button2.setEnabled(false);
                button3.setEnabled(false);
                button4.setEnabled(false);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        resetGame();
                    }
                }, 1000);
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                if(counter == 1) {
                    button1.setBackgroundResource(R.drawable.buttoncolor);
                } else if (counter == 2){
                    button4.setBackgroundResource(R.drawable.buttoncolor);
                }else if (counter == 3){
                    button2.setBackgroundResource(R.drawable.buttoncolor);
                }else if (counter == 4){
                    button1.setBackgroundResource(R.drawable.buttoncolor);
                }else if (counter == 5){
                    button3.setBackgroundResource(R.drawable.buttoncolor);
                }else if (counter == 6){
                    button4.setBackgroundResource(R.drawable.buttoncolor);
                }

                button1.setEnabled(false);
                button2.setEnabled(false);
                button3.setEnabled(false);
                button4.setEnabled(false);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        resetGame();
                    }
                }, 1000);
            }
        });
    }
    public void resetGame() {

        if (stringCounter == "0" || stringCounter == "1" || stringCounter == "2" || stringCounter == "3" || stringCounter == "4" || stringCounter == "5") {
            startActivity(new Intent(this, RomanjiGame_Review1.class));
            finish();
        } else {
            startActivity(new Intent(this, Chapter1_12.class));
            finish();
        }
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