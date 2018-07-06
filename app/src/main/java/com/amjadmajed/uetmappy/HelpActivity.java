package com.amjadmajed.uetmappy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class HelpActivity extends AppCompatActivity {

    Button goHelpButton1,goHelpButton2;
    public static Activity helpActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        helpActivity = this;

        goHelpButton1 = (Button) findViewById(R.id.goHelpButton1);
        View.OnClickListener findClickListenerHelp1 = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent navigation_intent = new Intent(HelpActivity.this, SearchHelpActivity.class);
                startActivity(navigation_intent);
            }
        };
        goHelpButton1.setOnClickListener(findClickListenerHelp1);

        goHelpButton2 = (Button) findViewById(R.id.goHelpButton2);
        View.OnClickListener findClickListenerHelp2 = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent navigation_intent = new Intent(HelpActivity.this, MainActivity.class);
                startActivity(navigation_intent);
                MainActivity.mainActivityObject.finish();
                finish();

            }
        };
        goHelpButton2.setOnClickListener(findClickListenerHelp2);
    }

    @Override
    public void onBackPressed()
    {
        finish();
    }

}
