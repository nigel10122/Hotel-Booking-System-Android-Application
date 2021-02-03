package com.example.hotelbooking2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ManagerViewReservationDetails extends AppCompatActivity {
    private TextView textViewlastname,textViewfirstname,textViewhotelname,textViewconfirmationnumber,textViewprice,textViewroomtype,textViewnumberofrooms,textViewnumberofadults,textViewcheckindate,textViewamenities,textViewhotelmanagercontact,textViewcheckoutdate;
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager_view_reservation_details);


        Intent intent = getIntent();
        position = intent.getExtras().getInt("position");

        textViewlastname = (TextView) findViewById(R.id.Lastname);
        textViewfirstname = (TextView) findViewById(R.id.Firstname);
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


        textViewlastname.setText(ManagerViewReservationListing.reservationsArrayList.get(position).getlastname());
        textViewfirstname.setText(ManagerViewReservationListing.reservationsArrayList.get(position).getfirstname());
        textViewhotelname.setText(ManagerViewReservationListing.reservationsArrayList.get(position).gethotel());
        textViewroomtype.setText(ManagerViewReservationListing.reservationsArrayList.get(position).getroomtype());
        textViewprice.setText(ManagerViewReservationListing.reservationsArrayList.get(position).getprice());
        textViewamenities.setText(ManagerViewReservationListing.reservationsArrayList.get(position).getamenities());
        textViewnumberofrooms.setText(ManagerViewReservationListing.reservationsArrayList.get(position).getnumberofrooms());
        textViewnumberofadults.setText(ManagerViewReservationListing.reservationsArrayList.get(position).getnumberofadults());
        textViewcheckindate.setText(ManagerViewReservationListing.reservationsArrayList.get(position).getcheckindate());
        textViewcheckoutdate.setText(ManagerViewReservationListing.reservationsArrayList.get(position).getcheckoutdate());
        textViewhotelmanagercontact.setText(ManagerViewReservationListing.reservationsArrayList.get(position).gethotelmanagercontact());
        textViewconfirmationnumber.setText(ManagerViewReservationListing.reservationsArrayList.get(position).getconfirmationnumber());
    }
}