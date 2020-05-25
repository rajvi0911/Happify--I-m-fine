package com.skygoal.happify;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.widget.Toast;


public class SplashActivity extends Activity {

    private int STORAGE_PERMISSION_CODE = 23;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        if ((getIntent().getFlags() & Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT) != 0) {
            finish();
            return;
        }

        if (!isTaskRoot()) {
            finish();
            return;
        }

        Intent i = getIntent();

        if (ConnectionManager.isConnected(this)) {


            Thread timerThread = new Thread() {
                public void run() {
                    try {

                        sleep(4000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {

                        if (isCALLAllowed()) {
                            SessionManager sessionManager = new SessionManager(SplashActivity.this);
                            sessionManager.checkLogin();


                        } else {
                            requestStoragePermission();
                        }
                    }
                }
            };
            timerThread.start();

        } else {

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setCancelable(false);
            builder.setTitle("No Internet");
            builder.setMessage("Internet is required. Please Retry.");
            builder.setNegativeButton("Settings", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    startActivityForResult(new Intent(Settings.ACTION_SETTINGS), 0);
                    dialog.dismiss();
                    finish();
                }
            });

            builder.setPositiveButton("Retry", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    if (ConnectionManager.isConnected(SplashActivity.this)) {


                        Thread timerThread = new Thread() {
                            public void run() {
                                try {

                                    sleep(4000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                } finally {

                                    if (isCALLAllowed()) {
                                        SessionManager sessionManager = new SessionManager(SplashActivity.this);
                                        sessionManager.checkLogin();


                                    } else {
                                        requestStoragePermission();
                                    }
                                }
                            }
                        };
                        timerThread.start();

                    } else {

                        Toast.makeText(SplashActivity.this, "NetWork No Available", Toast.LENGTH_LONG).show();

                    }
                    dialog.dismiss();

                }
            });
            AlertDialog dialog = builder.create();
            dialog.show();
        }


    }


    private boolean isCALLAllowed() {

        int result = ContextCompat.checkSelfPermission(this, android.Manifest.permission.CALL_PHONE);


        if (result == PackageManager.PERMISSION_GRANTED)
            return true;


        return false;
    }

    private void requestStoragePermission() {

        if (ActivityCompat.shouldShowRequestPermissionRationale(this, android.Manifest.permission.CALL_PHONE)) {
        }


        ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.CALL_PHONE, Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.READ_CALL_LOG,Manifest.permission.WRITE_CALL_LOG}, STORAGE_PERMISSION_CODE);
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {


        if (requestCode == STORAGE_PERMISSION_CODE) {


            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                SessionManager sessionManager = new SessionManager(SplashActivity.this);
                sessionManager.checkLogin();


            } else {
                Toast.makeText(this, "Oops you just denied the permission", Toast.LENGTH_LONG).show();
                SessionManager sessionManager = new SessionManager(SplashActivity.this);
                sessionManager.checkLogin();
            }
        }
    }


}

