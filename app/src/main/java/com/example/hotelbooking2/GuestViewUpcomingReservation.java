package com.example.hotelbooking2;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;

import android.view.View;

import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class GuestViewUpcomingReservation extends AppCompatActivity {
    private TextView textViewhotelname,textViewconfirmationnumber,textViewprice,textViewroomtype,textViewnumberofrooms,textViewnumberofadults,textViewcheckindate,textViewamenities,textViewhotelmanagercontact,textViewcheckoutdate;
    int position;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guest_viewupcomingreservation);

        Intent intent = getIntent();
        position = intent.getExtras().getInt("position");

        textViewhotelname = (TextView) findViewById(R.id.Hotel_name);
        textViewroomtype = (TextView) findViewById(R.id.Hotel_room_type);
        textViewprice = (TextView) findViewById(R.id.Hotel_price);
        textViewamenities = (TextView) findViewById(R.id.Hotel_amenities);
        textViewnumberofrooms = (TextView) findViewById(R.id.Hotel_number_of_rooms);
        textViewnumberofadults = (TextView) findViewById(R.id.Hotel_number_of_guests);
        textViewcheckindate = (TextView) findViewById(R.id.Hotel_check_in_date);
        textViewcheckoutdate = (TextView) findViewById(R.id.Hotel_check_out_date);
        textViewhotelmanagercontact = (TextView) findViewById(R.id.Hotel_manager_contact);
        textViewconfirmationnumber = (TextView) findViewById(R.id.Hotel_Confirmation_number);


        textViewhotelname.setText(GuestUpcomingList.reservationsArrayList.get(position).gethotel());
        textViewroomtype.setText(GuestUpcomingList.reservationsArrayList.get(position).getroomtype());
        textViewprice.setText(GuestUpcomingList.reservationsArrayList.get(position).getprice());
        textViewamenities.setText(GuestUpcomingList.reservationsArrayList.get(position).getamenities());
        textViewnumberofrooms.setText(GuestUpcomingList.reservationsArrayList.get(position).getnumberofrooms());
        textViewnumberofadults.setText(GuestUpcomingList.reservationsArrayList.get(position).getnumberofadults());
        textViewcheckindate.setText(GuestUpcomingList.reservationsArrayList.get(position).getcheckindate());
        textViewcheckoutdate.setText(GuestUpcomingList.reservationsArrayList.get(position).getcheckoutdate());
        textViewhotelmanagercontact.setText(GuestUpcomingList.reservationsArrayList.get(position).gethotelmanagercontact());
        textViewconfirmationnumber.setText(GuestUpcomingList.reservationsArrayList.get(position).getconfirmationnumber());
    }







}