package com.skygoal.happify;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by ncr99 on 12/13/2017.
 */

public class Login extends Activity {

    Button registers;
    Button login;
    EditText username;
    EditText password;

    String susername;
    String spassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        registers = findViewById(R.id.L_newuser);
        login = findViewById(R.id.L_Login);
        username = findViewById(R.id.L_Username);
        password = findViewById(R.id.L_Password);

        registers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), RegisterNow.class);
                startActivity(i);
            }
        });


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                susername = username.getText().toString().trim();
                spassword = password.getText().toString().trim();
                if (username.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Please Enter Your Username", Toast.LENGTH_LONG).show();
                } else if (password.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Please Enter Your PAssword", Toast.LENGTH_LONG).show();
                } else if (susername.equals("kenalinavik95@gmail.com") && (spassword.equals("kenali12345"))) {
                    Intent i = new Intent(getApplicationContext(), First_Question.class);
                    startActivity(i);
                } else if (susername.equals("rajvimehta1996@gmail.com") && (spassword.equals("rajvi12345"))) {
                    Intent i = new Intent(getApplicationContext(), First_Question.class);
                    startActivity(i);
                } else if (susername.equals("harnisha64@gmail.com") && (spassword.equals("harnisha12345"))) {
                    Intent i = new Intent(getApplicationContext(), First_Question.class);
                    startActivity(i);
                } else if (susername.equals("aangishah1996@gmail.com") && (spassword.equals("aangi12345"))) {
                    Intent i = new Intent(getApplicationContext(), First_Question.class);
                    startActivity(i);
                } else {
                    Toast.makeText(getApplicationContext(), "Password Or Username is Wrong", Toast.LENGTH_LONG).show();
                }

            }
        });


    }
}
