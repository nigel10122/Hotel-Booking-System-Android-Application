package com.example.hotelbooking2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class AdminViewUser extends AppCompatActivity {

    private TextView textViewUsername, textViewUserEmail,textViewUserlastname,textViewUserfirstname,textViewUsernumber,textViewUseraddress;
    int position;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_view_user);

        textViewUsername = (TextView) findViewById(R.id.Username);
        textViewUserEmail = (TextView) findViewById(R.id.Email);
        textViewUserlastname = (TextView) findViewById(R.id.Lastname);
        textViewUserfirstname = (TextView) findViewById(R.id.Firstname);
        textViewUsernumber = (TextView) findViewById(R.id.Phone);
        textViewUseraddress = (TextView) findViewById(R.id.Address);

        Intent intent = getIntent();
        position = intent.getExtras().getInt("position");

        textViewUserEmail.setText(AdminSearchForUser.usersarraylist.get(position).getemail());
        textViewUsername.setText(AdminSearchForUser.usersarraylist.get(position).getusername());
        textViewUserlastname.setText(AdminSearchForUser.usersarraylist.get(position).getlastname());
        textViewUserfirstname.setText(AdminSearchForUser.usersarraylist.get(position).getfirstname());
        textViewUsernumber.setText(AdminSearchForUser.usersarraylist.get(position).getnumber());
        textViewUseraddress.setText(AdminSearchForUser.usersarraylist.get(position).getaddress());


    }







}