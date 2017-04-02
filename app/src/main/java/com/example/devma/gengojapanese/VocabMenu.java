package com.example.devma.gengojapanese;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ExpandableListView.OnGroupExpandListener;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class VocabMenu extends AppCompatActivity {

        private static ExpandableListView expandableListView;
        private static ExpandableListAdapter adapter;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_vocab_menu);
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
            expandableListView = (ExpandableListView) findViewById(R.id.simple_expandable_listview);

            // Setting group indicator null for custom indicator
            expandableListView.setGroupIndicator(null);

            setItems();
            setListener();

        }

        // Setting headers and childs to expandable listview
        void setItems() {

            // Array list for header
            ArrayList<String> header = new ArrayList<String>();

            // Array list for child items
            List<String> child1 = new ArrayList<String>();
            List<String> child2 = new ArrayList<String>();
            List<String> child3 = new ArrayList<String>();
            List<String> child4 = new ArrayList<String>();
            List<String> child5 = new ArrayList<String>();
            List<String> child6 = new ArrayList<String>();

            // Hash map for both header and child
            HashMap<String, List<String>> hashMap = new HashMap<String, List<String>>();

            // Adding headers to list
            for (int i = 1; i < 7; i++) {
                header.add("Chapter " + i);

            }

            child1.add("Main Vocabulary");
            child1.add("Countries");
            child1.add("Majors");
            child1.add("Occupations");
            child1.add("Family");

            child2.add("Pronouns");
            child2.add("Food");
            child2.add("Things");
            child2.add("Places");
            child2.add("Countries");
            child2.add("Majors");
            child2.add("Family");
            child2.add("Money Matters");
            child2.add("Expressions");

            child3.add("Nouns");
            child3.add("U-Verbs");
            child3.add("Ru-Verbs");
            child3.add("Irregular Verbs");
            child3.add("Adjectives");
            child3.add("Adverbs");
            child3.add("Expressions");

            child4.add("Nouns");
            child4.add("U-Verbs");
            child4.add("Ru-Verbs");
            child4.add("Adverbs & Other Expressions");
            child4.add("Location Words");

            child5.add("Nouns");
            child5.add("い-Adjectives");
            child5.add("な-Adjectives");
            child5.add("U-Verbs");
            child5.add("Ru-Verbs");
            child5.add("Adverbs & Other Expressions");

            child6.add("Nouns");
            child6.add("な-Adjectives");
            child6.add("U-Verbs");
            child6.add("Ru-Verbs");
            child6.add("Irregular Verbs");
            child6.add("Adverbs & Other Expressions");
            child6.add("Location Words");


            // Adding header and childs to hash map
            hashMap.put(header.get(0), child1);
            hashMap.put(header.get(1), child2);
            hashMap.put(header.get(2), child3);
            hashMap.put(header.get(3), child4);
            hashMap.put(header.get(4), child5);
            hashMap.put(header.get(5), child6);

            adapter = new ExpandableListAdapter(VocabMenu.this, header, hashMap);

            // Setting adpater over expandablelistview
            expandableListView.setAdapter(adapter);
        }

        // Setting different listeners to expandablelistview
        void setListener() {

            // This listener will show toast on group click
            expandableListView.setOnGroupClickListener(new OnGroupClickListener() {

                @Override
                public boolean onGroupClick(ExpandableListView listview, View view,
                                            int group_pos, long id) {

                    return false;
                }
            });

            // This listener will expand one group at one time
            // You can remove this listener for expanding all groups
            expandableListView
                    .setOnGroupExpandListener(new OnGroupExpandListener() {

                        // Default position
                        int previousGroup = -1;

                        @Override
                        public void onGroupExpand(int groupPosition) {
                            if (groupPosition != previousGroup)

                                // Collapse the expanded group
                                expandableListView.collapseGroup(previousGroup);
                            previousGroup = groupPosition;
                        }

                    });

            // This listener will show toast on child click
            expandableListView.setOnChildClickListener(new OnChildClickListener() {

                @Override
                public boolean onChildClick(ExpandableListView listview, View view,
                                            int groupPos, int childPos, long id) {

                   if(groupPos == 0 && childPos == 0){
                       startActivity(new Intent(getApplicationContext(), CardViewActivity.class));
                   }
                    if(groupPos == 0 && childPos == 1){
                        startActivity(new Intent(getApplicationContext(), Ch1_Vocab_Countries.class));
                    }
                    if(groupPos == 0 && childPos == 2){
                        startActivity(new Intent(getApplicationContext(), Ch1_Vocab_Majors.class));
                    }
                    if(groupPos == 0 && childPos == 3){
                        startActivity(new Intent(getApplicationContext(), Ch1_Vocab_Occupations.class));
                    }
                    if(groupPos == 0 && childPos == 4){
                        startActivity(new Intent(getApplicationContext(), Ch1_Vocab_Family.class));
                    }

                    return false;
                }
            });
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
