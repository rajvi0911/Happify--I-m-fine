package com.skygoal.happify;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class SessionManager {

    SharedPreferences pref;
    Editor editor;
    Editor punchout;
    Context _context;
    int PRIVATE_MODE = 0;
    public static final String MyPreferences = "MyPrefs";
    SharedPreferences sharedPreferences;
    private static final String PREF_NAME = "loginpreference";
    private static final String IS_LOGIN = "IsLoggedIn";


    public static final String KEY_EMAIL = "email";
    public static final String KEY_PASSWORD = "password";
    public static final String KEY_SALES_ID = "sales_user_id";
    public static final String KEY_TOKEN = "token";
    public static final String KEY_DISTRIBUTOR_ID = "distributor_id";
    public static final String KEY_SALES_DISTRIBUTOR_ID = "distributor_id";
    public static final String KEY_YEAR_ID = "filter_by_year";
    public static String KEY_PUNCH_ID = "punch_id";

    public SessionManager(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);

    }

    public void createLoginSession(String email, String password, String sales_user_id, String token ) {
        editor = pref.edit();
        editor.putBoolean(IS_LOGIN, true);
        editor.putString(KEY_EMAIL, email);
        editor.putString(KEY_PASSWORD, password);
        editor.putString(KEY_SALES_ID, sales_user_id);
        editor.putString(KEY_TOKEN, token);

        editor.commit();
    }

    public void createdistributorSession(String email, String password, String token, String distributor_id) {
        editor = pref.edit();
        editor.putBoolean(IS_LOGIN, true);
        editor.putString(KEY_EMAIL, email);
        editor.putString(KEY_PASSWORD, password);
        editor.putString(KEY_DISTRIBUTOR_ID, distributor_id);
        editor.putString(KEY_TOKEN, token);

        editor.commit();
    }

    public void createdistributorforsalesuser(String distributor_id) {
        editor = pref.edit();
        editor.putString(KEY_SALES_DISTRIBUTOR_ID, distributor_id);
        editor.commit();
    }

    public void createyearsave(String year_id) {
        editor = pref.edit();
        editor.putString(KEY_YEAR_ID, year_id);
        editor.commit();
    }

    public void createpunchinsession(String punch_id) {
        punchout = pref.edit();
        punchout.putString(KEY_PUNCH_ID, punch_id);

        punchout.commit();
    }


    public void checkLogin() {
        if (this.isLoggedIn()) {

            Intent i = new Intent(_context, RegisterNow.class);

            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            _context.startActivity(i);
        }else
        {
            Intent i = new Intent(_context, Login.class);
            _context.startActivity(i);
        }
    }

    public String getsalesiddetaila() {
       String user;
        user=pref.getString(KEY_SALES_ID, null);
        return user;
    }

    public String getpunchdetails() {
        String user;
        user=pref.getString(KEY_PUNCH_ID, null);
        return user;
    }

    public String getyear() {
        String user;
        user=pref.getString(KEY_YEAR_ID, null);
        return user;
    }

    public String gettokendetails() {
        String user;
        user=pref.getString(KEY_TOKEN, null);
        return user;
    }

    public String getdistributoriddetails() {
        String user;
        user=pref.getString(KEY_DISTRIBUTOR_ID, null);
        return user;
    }

    public String getsalesdistributoriddetails() {
        String user;
        user=pref.getString(KEY_SALES_DISTRIBUTOR_ID, null);
        return user;
    }


    public void logoutUser() {


        punchout.putString(KEY_PUNCH_ID, null);
        punchout.commit();
        Intent i = new Intent(_context, RegisterNow.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        _context.startActivity(i);
    }

    public boolean isLoggedIn() {
        return pref.getBoolean(IS_LOGIN, false);
    }


}
