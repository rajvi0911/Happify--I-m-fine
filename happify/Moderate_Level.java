package com.skygoal.happify;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Toast;

/**
 * Created by ncr99 on 12/18/2017.
 */

public class Moderate_Level extends Activity {

    LinearLayout mques1;
    LinearLayout mques2;
    LinearLayout mques3;
    LinearLayout mques4;
    LinearLayout mques5;

    RadioButton m1quesr1;
    RadioButton m1quesr2;

    RadioButton m2quesr1;
    RadioButton m2quesr2;

    RadioButton m3quesr1;
    RadioButton m3quesr2;

    RadioButton m4quesr1;
    RadioButton m4quesr2;

    RadioButton m5quesr1;
    RadioButton m5quesr2;
    Button next;

    String send1 = "selected1";
    String send2 = "selected2";
    String send3 = "selected3";
    String send4 = "selected4";
    String send5 = "selected5";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.moderate_ques);

        mques1 = findViewById(R.id.mques1_layout);
        mques2 = findViewById(R.id.mques2_layout);
        mques3 = findViewById(R.id.mques3_layout);
        mques4 = findViewById(R.id.mques4_layout);
        mques5 = findViewById(R.id.mques5_layout);

        m1quesr1 = findViewById(R.id.mques1_radio_yes);
        m1quesr2 = findViewById(R.id.mques1_radio_no);

        m2quesr1 = findViewById(R.id.mques2_radio_yes);
        m2quesr2 = findViewById(R.id.mques2_radio_no);

        m3quesr1 = findViewById(R.id.mques3_radio_yes);
        m3quesr2 = findViewById(R.id.mques3_radio_no);

        m4quesr1 = findViewById(R.id.mques4_radio_yes);
        m4quesr2 = findViewById(R.id.mques4_radio_no);

        m5quesr1 = findViewById(R.id.mques5_radio_yes);
        m5quesr2 = findViewById(R.id.mques5_radio_no);

        next = findViewById(R.id.next_btn);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (m1quesr1.isChecked()) {
                    Intent i = new Intent(getApplicationContext(),Moderate_Level_Question.class);
                    i.putExtra("selected",send1);
                    startActivity(i);

                } else if (m1quesr2.isChecked()) {
                    mques1.setVisibility(View.GONE);
                    mques2.setVisibility(View.VISIBLE);
                }

                if (m2quesr1.isChecked()) {
                    Intent i = new Intent(getApplicationContext(),Moderate_Level_Question.class);
                    i.putExtra("selected",send2);
                    startActivity(i);
                }
                else if(m2quesr2.isChecked()){
                    mques2.setVisibility(View.GONE);
                    mques3.setVisibility(View.VISIBLE);
                }

                if (m3quesr1.isChecked()) {
                    Intent i = new Intent(getApplicationContext(),Moderate_Level_Question.class);
                    i.putExtra("selected",send3);
                    startActivity(i);
                }
                else if(m3quesr2.isChecked()){
                    mques3.setVisibility(View.GONE);
                    mques4.setVisibility(View.VISIBLE);
                }

                if (m4quesr1.isChecked()) {
                    Intent i = new Intent(getApplicationContext(),Moderate_Level_Question.class);
                    i.putExtra("selected",send4);
                    startActivity(i);
                }
                else if(m4quesr2.isChecked()){
                    mques4.setVisibility(View.GONE);
                    mques5.setVisibility(View.VISIBLE);
                }

                if (m5quesr1.isChecked()) {
                    Intent i = new Intent(getApplicationContext(),Moderate_Level_Question.class);
                    i.putExtra("selected",send5);
                    startActivity(i);
                }
                else if(m5quesr2.isChecked()){
                   Toast.makeText(getApplicationContext(),"You Are On Anxiety Level",Toast.LENGTH_LONG).show();
                }


            }
        });


    }
}
