package com.example.hotelbooking2;

import android.content.Context;
import android.content.SharedPreferences;

import com.android.volley.Response;


public class SharedPrefManagerSearchRooms {

    private static SharedPrefManagerSearchRooms mInstance;
    private static Context mCtx;

    private static final String SHARED_PREF_NAME = "mysharedpref12";
    private static final String KEY_ROOM_ID = "id";
    private static final String KEY_HOTEL = "hotel";
    private static final String KEY_ROOM_TYPE = "roomtype";
    private static final String KEY_NUMBER_OF_ROOMS = "numberofrooms";
    private static final String KEY_NUMBER_OF_ADULTS = "numberofadults";
    private static final String KEY_NUMBER_OF_CHILDREN = "numberofchildren";
    private static final String KEY_CHECK_IN_DATE = "checkindate";
    private static final String KEY_CHECK_OUT_DATE = "checkoutdate";
    private static final String KEY_PRICE = "price";
    private static final String KEY_DISTANCE = "distance";
    private static final String KEY_AMENITIES = "amenities";
    private static final String KEY_HOTEL_MANAGER_CONTACT = "hotelmanagercontact";
    private static final String KEY_CONFIRMATIONNUMBER = "confirmationnumber";


    public SharedPrefManagerSearchRooms(Context context) {
        mCtx = context;

    }


    public static synchronized SharedPrefManagerSearchRooms getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new SharedPrefManagerSearchRooms(context);
        }
        return mInstance;
    }

    public boolean makereservation(int id, String hotel, String roomtype, String numberofrooms , String numberofadults, String numberofchildren, String checkindate, String checkoutdate, String price, String distance, String amenities, String hotelmanagercontact, String confirmationnumber) {

        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putInt(KEY_ROOM_ID, id);
        editor.putString(KEY_ROOM_TYPE, roomtype);
        editor.putString(KEY_HOTEL, hotel);
        editor.putString(KEY_NUMBER_OF_ROOMS, numberofrooms);
        editor.putString(KEY_NUMBER_OF_ADULTS, numberofadults);
        editor.putString(KEY_NUMBER_OF_CHILDREN, numberofchildren);
        editor.putString(KEY_CHECK_IN_DATE, checkindate);
        editor.putString(KEY_CHECK_OUT_DATE, checkoutdate);
        editor.putString(KEY_PRICE, price);
        editor.putString(KEY_DISTANCE, distance);
        editor.putString(KEY_AMENITIES, amenities);
        editor.putString(KEY_HOTEL_MANAGER_CONTACT, hotelmanagercontact);
        editor.putString(KEY_CONFIRMATIONNUMBER, confirmationnumber);
        editor.apply();

        return true;
    }

/*    public boolean hassearchedroom() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        if (sharedPreferences.getString(KEY_HOTEL, null) != null) {
            return true;
        }
        return false;
    }*/

    public String getRoomid() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_ROOM_ID, null);
    }

    public String gethotel() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_HOTEL, null);
    }

    public String getroomtype() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_ROOM_TYPE, null);
    }

    public String getnumberofrooms() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_NUMBER_OF_ROOMS, null);
    }

    public String getnumberofadults(){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_NUMBER_OF_ADULTS, null);
    }

    public String getNumberofchildren(){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_NUMBER_OF_CHILDREN, null);
    }

    public String getCheckindate(){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_CHECK_IN_DATE, null);
    }

    public String getCheckoutdate(){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_CHECK_OUT_DATE, null);
    }

    public String getPrice(){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_PRICE, null);
    }

    public String getDistance(){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_DISTANCE, null);
    }

    public String getAmenities(){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_AMENITIES, null);
    }

    public String getHotelManagerContact(){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_HOTEL_MANAGER_CONTACT, null);
    }

    public String getConfirmationNumber(){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_CONFIRMATIONNUMBER, null);
    }
}
