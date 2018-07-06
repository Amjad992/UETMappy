package com.amjadmajed.uetmappy;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public static Activity mainActivityObject;
    Button goButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainActivityObject = this;


        if (isFirstTimeLunch()) {

            Intent help_intent = new Intent(this, HelpActivity.class);
            startActivity(help_intent);
        }


        goButton = (Button) findViewById(R.id.goButton);
        View.OnClickListener findClickListenerFav = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent navigation_intent = new Intent(MainActivity.this, NavigationActivity.class);
                startActivity(navigation_intent);
            }


        };
        goButton.setOnClickListener(findClickListenerFav);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.action_favourites:
                Intent favourites_intent = new Intent(this, FavouriteActivity.class);
                this.startActivity(favourites_intent);
                break;
            case R.id.action_about:
                Intent about_intent = new Intent(this, AboutActivity.class);
                this.startActivity(about_intent);
                break;
            case R.id.action_help:
                Intent help_intent = new Intent(this, HelpActivity.class);
                this.startActivity(help_intent);
                break;



            default:
                return super.onOptionsItemSelected(item);
        }

        return true;
    }

    boolean isFirstTimeLunch() {

        final String PREFS_NAME = "MyPrefsFile";

        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);

        if (settings.getBoolean("my_first_time", true)) {
            //the app is being launched for first time, do something
            Log.d("Comments", "First time");
            // first time task

            // record the fact that the app has been started at least once
            settings.edit().putBoolean("my_first_time", false).commit();
            return true;
        } else return false;
    }

}
