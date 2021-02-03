package com.example.hotelbooking2;

import android.content.Context;
import android.content.SharedPreferences;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;



public class SharedPrefManager {

    private static SharedPrefManager mInstance;
    private static Context mCtx;

    private static final String SHARED_PREF_NAME = "mysharedpref12";
    private static final String KEY_USERNAME = "username";
    private static final String KEY_USER_EMAIL = "useremail";
    private static final String KEY_USER_ID = "userid";
    private static final String KEY_USER_LAST_NAME = "userlastname";
    private static final String KEY_USER_FIRST_NAME = "userfirstname";
    private static final String KEY_USER_NUMBER = "usernumber";
    private static final String KEY_USER_ADDRESS = "useraddress";
    private static final String KEY_USER_CREDIT_CARD_TYPE = "creditcardtype";
    private static final String KEY_USER_CREDIT_CARD_NUMBER = "creditcardnumber";
    private static final String KEY_USER_NAME_ON_CARD = "nameoncard";
    private static final String KEY_USER_EXPIRY_DATE = "expirydate";
    private static final String KEY_USER_BILLING_ADDRESS = "billingaddress";


    private SharedPrefManager(Context context) {
        mCtx = context;

    }

    public static synchronized SharedPrefManager getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new SharedPrefManager(context);
        }
        return mInstance;
    }

    public boolean userLogin(int id, String username, String email, String last_name , String first_name, String number, String address, String creditcardtype, String creditcardnumber, String nameoncard, String expirydate, String billingaddress ) {

        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putInt(KEY_USER_ID, id);
        editor.putString(KEY_USER_EMAIL, email);
        editor.putString(KEY_USERNAME, username);
        editor.putString(KEY_USER_LAST_NAME, last_name);
        editor.putString(KEY_USER_FIRST_NAME, first_name);
        editor.putString(KEY_USER_NUMBER, number);
        editor.putString(KEY_USER_ADDRESS, address);
        editor.putString(KEY_USER_CREDIT_CARD_TYPE, creditcardtype);
        editor.putString(KEY_USER_CREDIT_CARD_NUMBER, creditcardnumber);
        editor.putString(KEY_USER_NAME_ON_CARD, nameoncard);
        editor.putString(KEY_USER_EXPIRY_DATE, expirydate);
        editor.putString(KEY_USER_BILLING_ADDRESS, billingaddress);
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



    public String getUserCreditCardType(){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_USER_CREDIT_CARD_TYPE, null);
    }

    public String getUserCreditCardNumber(){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_USER_CREDIT_CARD_NUMBER, null);
    }

    public String getUserNameOnCard(){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_USER_NAME_ON_CARD, null);
    }


    public String getUserExpiryDate(){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_USER_EXPIRY_DATE, null);
    }

    public String getUserBillingAddress(){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_USER_BILLING_ADDRESS, null);
    }
}
