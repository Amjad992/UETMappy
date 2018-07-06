package com.amjadmajed.uetmappy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class SearchHelpActivity extends AppCompatActivity {

    Button goSearchHelpButton1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchhelp);

        goSearchHelpButton1 = (Button) findViewById(R.id.goSearchHelpButton1);
        View.OnClickListener findClickListenerSearchHelp2 = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent navigation_intent = new Intent(SearchHelpActivity.this, HelpActivity.class);
                startActivity(navigation_intent);
                HelpActivity.helpActivity.finish();
            }
        };
        goSearchHelpButton1.setOnClickListener(findClickListenerSearchHelp2);
    }

}
