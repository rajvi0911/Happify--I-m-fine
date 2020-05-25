package com.skygoal.happify;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

/**
 * Created by ncr99 on 12/18/2017.
 */

public class Moderate_Level_Question extends Activity {

    LinearLayout firstques_layout;
    LinearLayout secondques_layout;
    LinearLayout thirdques_layout;
    LinearLayout fourthques_layout;
    LinearLayout fifthques_layout;
    Button conclusion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.moderate_level_ques);

        firstques_layout = findViewById(R.id.mques1sub1_layout);
        secondques_layout = findViewById(R.id.mques2sub1_layout);
        thirdques_layout = findViewById(R.id.mques3sub1_layout);
        fourthques_layout = findViewById(R.id.mques4sub1_layout);
        fifthques_layout = findViewById(R.id.mques5sub1_layout);
        conclusion = findViewById(R.id.conclusion_btn);

        Intent i = getIntent();
        String selection = i.getStringExtra("selected");

        if (selection.equals("selected1")) {
            firstques_layout.setVisibility(View.VISIBLE);
        } else if (selection.equals("selected2")) {
            secondques_layout.setVisibility(View.VISIBLE);
        } else if (selection.equals("selected3")) {
            thirdques_layout.setVisibility(View.VISIBLE);
        } else if (selection.equals("selected4")) {
            fourthques_layout.setVisibility(View.VISIBLE);
        } else if (selection.equals("selected5")) {
            fifthques_layout.setVisibility(View.VISIBLE);
        }

        conclusion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(getApplicationContext(),Conclusion.class);
                startActivity(i);
            }
        });

    }

}
