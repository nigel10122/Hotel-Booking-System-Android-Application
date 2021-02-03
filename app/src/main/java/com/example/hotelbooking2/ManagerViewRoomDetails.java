package com.example.hotelbooking2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class ManagerViewRoomDetails extends AppCompatActivity {
    private TextView textViewhotelname,textViewweekdayprice,textViewroomtype,textViewtotalnumberofrooms,textViewweekendprice,textViewavailablerooms,textViewcheckindate,textViewamenities,textViewhotelmanagercontact,textViewcheckoutdate,textViewunavailablerooms,textViewavailability,textViewroomnumber;
    int position;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager_view_room_details);

        Intent intent = getIntent();
        position = intent.getExtras().getInt("position");

        textViewhotelname = (TextView) findViewById(R.id.Hotel_name);
        textViewroomnumber = (TextView) findViewById(R.id.Room_Number);
        textViewroomtype = (TextView) findViewById(R.id.Hotel_room_type);
        textViewweekdayprice = (TextView) findViewById(R.id.Weekday_price);
        textViewweekendprice = (TextView) findViewById(R.id.Weekend_price);
        textViewtotalnumberofrooms = (TextView) findViewById(R.id.Total_rooms);
        textViewavailablerooms= (TextView) findViewById(R.id.Available_rooms);
        textViewunavailablerooms = (TextView) findViewById(R.id.Unavailable_rooms);
        textViewavailability = (TextView) findViewById(R.id.Availability);
        textViewcheckindate = (TextView) findViewById(R.id.Hotel_check_in_date);
        textViewcheckoutdate = (TextView) findViewById(R.id.Hotel_check_out_date);
        textViewamenities = (TextView) findViewById(R.id.Hotel_amenities);
        textViewhotelmanagercontact = (TextView) findViewById(R.id.Hotel_manager_contact);






        textViewhotelname.setText(ManagerSearchRoom.roomsArrayList.get(position).gethotel());
        textViewroomnumber.setText(ManagerSearchRoom.roomsArrayList.get(position).getroomnumber());
        textViewroomtype.setText(ManagerSearchRoom.roomsArrayList.get(position).getroomtype());
        textViewweekdayprice.setText(ManagerSearchRoom.roomsArrayList.get(position).getprice());
        textViewweekendprice.setText(ManagerSearchRoom.roomsArrayList.get(position).getweekendprice());
        textViewtotalnumberofrooms.setText(ManagerSearchRoom.roomsArrayList.get(position).gettotalnumberofrooms());
        textViewavailablerooms.setText(ManagerSearchRoom.roomsArrayList.get(position).getavailablerooms());
        textViewunavailablerooms.setText(ManagerSearchRoom.roomsArrayList.get(position).getunavailablerooms());
        textViewavailability.setText(ManagerSearchRoom.roomsArrayList.get(position).getavailability());
        textViewcheckindate.setText(ManagerSearchRoom.roomsArrayList.get(position).getcheckindate());
        textViewcheckoutdate.setText(ManagerSearchRoom.roomsArrayList.get(position).getcheckoutdate());
        textViewamenities.setText(ManagerSearchRoom.roomsArrayList.get(position).getamenities());
        textViewhotelmanagercontact.setText(ManagerSearchRoom.roomsArrayList.get(position).gethotelmanagercontact());




    }
}