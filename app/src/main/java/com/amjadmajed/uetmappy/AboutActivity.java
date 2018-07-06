package com.amjadmajed.uetmappy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class AboutActivity extends AppCompatActivity {

    Button goAboutButton1;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_about);

            goAboutButton1 = (Button) findViewById(R.id.goAboutButton1);
            View.OnClickListener findClickListenerAbout1 = new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent navigation_intent = new Intent(AboutActivity.this, MainActivity.class);
                    startActivity(navigation_intent);
                    MainActivity.mainActivityObject.finish();
                }
            };
            goAboutButton1.setOnClickListener(findClickListenerAbout1);
        }
    }
