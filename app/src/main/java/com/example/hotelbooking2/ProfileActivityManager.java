package com.example.hotelbooking2;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivityManager extends AppCompatActivity implements View.OnClickListener {


    private TextView textViewUsername, textViewUserEmail,textViewUserlastname,textViewUserfirstname,textViewUsernumber,textViewUseraddress;
    private Button ModifyProfile;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_manager);

        if(!SharedPrefManagerManager.getInstance(this).isLoggedIn()){
            finish();
            startActivity(new Intent(this, LoginActivity.class));
        }

        textViewUsername = (TextView) findViewById(R.id.Username);
        textViewUserEmail = (TextView) findViewById(R.id.Email);
        textViewUserlastname = (TextView) findViewById(R.id.Lastname);
        textViewUserfirstname = (TextView) findViewById(R.id.Firstname);
        textViewUsernumber = (TextView) findViewById(R.id.Phone);
        textViewUseraddress = (TextView) findViewById(R.id.Address);

        ModifyProfile = (Button) findViewById(R.id.ModifyProfile);
        ModifyProfile.setOnClickListener(this);


        textViewUserEmail.setText(SharedPrefManagerManager.getInstance(this).getUserEmail());
        textViewUsername.setText(SharedPrefManagerManager.getInstance(this).getUsername());
        textViewUserlastname.setText(SharedPrefManagerManager.getInstance(this).getUserLast_name());
        textViewUserfirstname.setText(SharedPrefManagerManager.getInstance(this).getUserFirst_name());
        textViewUsernumber.setText(SharedPrefManagerManager.getInstance(this).getUserNumber());
        textViewUseraddress.setText(SharedPrefManagerManager.getInstance(this).getUserAddress());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.menuLogout:
                SharedPrefManager.getInstance(this).logout();
                finish();
                startActivity(new Intent(this, LoginActivity.class));
                break;
            case R.id.menuSettings:
                Toast.makeText(this, "You clicked settings", Toast.LENGTH_LONG).show();
                break;
            case R.id.menuhome:
                startActivity(new Intent(this, ManagerHomeScreen.class));
                break;
        }
        return true;
    }

    @Override
    public void onClick(View view) {
        if(view == ModifyProfile){
            startActivity(new Intent(this, ModifyManagerProfileActivity.class));
        }
    }
}
