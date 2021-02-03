package com.example.hotelbooking2;

import android.content.Context;
import android.content.SharedPreferences;


public class SharedPrefManagerAdmin {

    private static SharedPrefManagerAdmin mInstance;
    private static Context mCtx;

    private static final String SHARED_PREF_NAME = "mysharedpref12";
    private static final String KEY_USERNAME = "username";
    private static final String KEY_USER_EMAIL = "useremail";
    private static final String KEY_USER_ID = "userid";
    private static final String KEY_USER_LAST_NAME = "userlastname";
    private static final String KEY_USER_FIRST_NAME = "userfirstname";
    private static final String KEY_USER_NUMBER = "usernumber";
    private static final String KEY_USER_ADDRESS = "useraddress";



    private SharedPrefManagerAdmin(Context context) {
        mCtx = context;

    }

    public static synchronized SharedPrefManagerAdmin getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new SharedPrefManagerAdmin(context);
        }
        return mInstance;
    }

    public boolean userLogin(int id, String username, String email, String last_name , String first_name, String number, String address) {

        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putInt(KEY_USER_ID, id);
        editor.putString(KEY_USER_EMAIL, email);
        editor.putString(KEY_USERNAME, username);
        editor.putString(KEY_USER_LAST_NAME, last_name);
        editor.putString(KEY_USER_FIRST_NAME, first_name);
        editor.putString(KEY_USER_NUMBER, number);
        editor.putString(KEY_USER_ADDRESS, address);

        editor.apply();

        return true;
    }

    public boolean isLoggedIn() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        if (sharedPreferences.getString(KEY_USERNAME, null) != null) {
            return true;
        }
        return false;
    }

    public boolean logout() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
        return true;
    }


    public String getUsername() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_USERNAME, null);
    }

    public String getUserEmail() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_USER_EMAIL, null);
    }

    public String getUserLast_name() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_USER_LAST_NAME, null);
    }

    public String getUserFirst_name(){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_USER_FIRST_NAME, null);
    }

    public String getUserNumber(){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_USER_NUMBER, null);
    }

    public String getUserAddress(){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_USER_ADDRESS, null);
    }




}
