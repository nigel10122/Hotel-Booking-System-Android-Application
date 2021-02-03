package com.example.hotelbooking2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AdminViewManager extends AppCompatActivity {

    private TextView textViewUsername, textViewUserEmail,textViewUserlastname,textViewUserfirstname,textViewUsernumber,textViewUseraddress;
    int position;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_view_manager);

        textViewUsername = (TextView) findViewById(R.id.Username);
        textViewUserEmail = (TextView) findViewById(R.id.Email);
        textViewUserlastname = (TextView) findViewById(R.id.Lastname);
        textViewUserfirstname = (TextView) findViewById(R.id.Firstname);
        textViewUsernumber = (TextView) findViewById(R.id.Phone);
        textViewUseraddress = (TextView) findViewById(R.id.Address);

        Intent intent = getIntent();
        position = intent.getExtras().getInt("position");

        textViewUserEmail.setText(AdminSearchForManager.usersarraylist.get(position).getemail());
        textViewUsername.setText(AdminSearchForManager.usersarraylist.get(position).getusername());
        textViewUserlastname.setText(AdminSearchForManager.usersarraylist.get(position).getlastname());
        textViewUserfirstname.setText(AdminSearchForManager.usersarraylist.get(position).getfirstname());
        textViewUsernumber.setText(AdminSearchForManager.usersarraylist.get(position).getnumber());
        textViewUseraddress.setText(AdminSearchForManager.usersarraylist.get(position).getaddress());


    }







}