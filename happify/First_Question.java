package com.skygoal.happify;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

/**
 * Created by ncr99 on 12/13/2017.
 */

public class First_Question extends Activity {

    RadioButton firstsometime,firstoften,firstnever;
    RadioButton secondsometime,secondoften,secondnever;
    RadioButton thirdsometime,thirdoften,thirdnever;
    RadioButton fourthsometime,fourthoften,fourthnever;
    RadioButton fifthsometime,fifthoften,fifthnever;
    RadioButton sixsometime,sixoften,sixnever;
    RadioButton sevensometime,sevenoften,sevennever;
    Button calculate;
    RadioGroup group1;
    RadioGroup group2;
    RadioGroup group3;
    RadioGroup group4;
    RadioGroup group5;
    RadioGroup group6;
    RadioGroup group7;

    int ans1;
    int ans2=0;
    int ans3=0;
    int ans4=0;
    int ans5=0;
    int ans6=0;
    int ans7=0;

    public String a1;
    String a2;
    String a3;
    String a4;
    String a5;
    String a6;
    String a7;

    int ans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_step_ques);

        group1 = findViewById(R.id.ccgroup1);

        firstoften = findViewById(R.id.RN_often1);
        firstsometime = findViewById(R.id.RN_Sometimes1);
        firstnever = findViewById(R.id.RN_Never1);

        secondoften = findViewById(R.id.RN_often2);
        secondsometime = findViewById(R.id.RN_Sometimes2);
        secondnever = findViewById(R.id.RN_Never2);

        thirdoften = findViewById(R.id.RN_often3);
        thirdsometime = findViewById(R.id.RN_Sometimes3);
        thirdnever = findViewById(R.id.RN_Never3);

        fourthoften = findViewById(R.id.RN_often4);
        fourthsometime = findViewById(R.id.RN_Sometimes4);
        fourthnever = findViewById(R.id.RN_Never4);

        fifthoften = findViewById(R.id.RN_often5);
        fifthsometime = findViewById(R.id.RN_Sometimes5);
        fifthnever = findViewById(R.id.RN_Never5);

        sixoften = findViewById(R.id.RN_often6);
        sixsometime = findViewById(R.id.RN_Sometimes6);
        sixnever = findViewById(R.id.RN_Never6);

        sevenoften = findViewById(R.id.RN_often7);
        sevensometime = findViewById(R.id.RN_Sometimes7);
        sevennever = findViewById(R.id.RN_Never7);

        calculate = findViewById(R.id.RN_calculate);



        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(firstoften.isChecked()){
                    ans1= 2;

                }else if(firstsometime.isChecked()){
                    ans1 = 1;

                }else {
                    ans1 = 0;

                }

                if(secondoften.isChecked()){
                    ans2 = 2;
                }else if(secondsometime.isChecked()){
                    ans2 = 1;
                }else {
                    ans2 = 0;
                }

                if(thirdoften.isChecked()){
                    ans3 = 2;
                }else if(thirdsometime.isChecked()){
                    ans3 = 1;
                }else {
                    ans3 = 0;
                }

                if(fourthoften.isChecked()){
                    ans4 = 2;
                }else if(fourthsometime.isChecked()){
                    ans4 = 1;
                }else {
                    ans4 = 0;
                }

                if(fifthoften.isChecked()){
                    ans5 = 2;
                }else if(fifthsometime.isChecked()){
                    ans5 = 1;
                }else {
                    ans5 = 0;
                }

                if(sixoften.isChecked()){
                    ans6 = 2;
                }else if(sixsometime.isChecked()){
                    ans6 = 1;
                }else {
                    ans6 = 0;
                }

                if(sevenoften.isChecked()){
                    ans7 = 2;
                }else if(sevensometime.isChecked()){
                    ans7 = 1;
                }else {
                    ans7 = 0;
                }
                ans = ans1+ans2+ans3+ans4+ans5+ans6+ans7;
                String answerstring = String.valueOf(ans);
                if(ans<=7){
                    Intent i = new Intent(getApplicationContext(),Anxiety_Level.class);
                    startActivity(i);
                }
                else if(ans>=8){
                    Intent i = new Intent(getApplicationContext(),Moderate_Level.class);
                    startActivity(i);
                }

            }
        });





    }


}
