package com.example.hotelbooking2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ManagerHomeScreen extends AppCompatActivity implements View.OnClickListener {

    private Button ViewReservationListing,Logout,Profile,SearchForRoom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manager_home);

        ViewReservationListing = (Button) findViewById(R.id.ViewReservationListing);
        ViewReservationListing.setOnClickListener(this);
        SearchForRoom = (Button) findViewById(R.id.SearchForRoom);
        SearchForRoom.setOnClickListener(this);
        Logout = (Button) findViewById(R.id.ButtonLogout);
        Logout.setOnClickListener(this);
        Profile = (Button) findViewById(R.id.Profile);
        Profile.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.menuLogout:
                SharedPrefManagerManager.getInstance(this).logout();
                finish();
                startActivity(new Intent(this, LoginActivity.class));
                break;
            case R.id.menuSettings:
                Toast.makeText(this, "You clicked settings", Toast.LENGTH_LONG).show();
                break;
            case R.id.menuprofile:
                startActivity(new Intent(this, ProfileActivityManager.class));
                break;
        }
        return true;
    }


    @Override
    public void onClick(View view) {
        if (view == ViewReservationListing) {
            startActivity(new Intent(this, ManagerViewReservationListing.class));
        }
        if (view == SearchForRoom) {
            startActivity(new Intent(this, ManagerSearchRoom.class));
        }
        if (view == Profile) {
            startActivity(new Intent(this,ProfileActivityManager.class));
        }
        if (view == Logout) {
            SharedPrefManagerManager.getInstance(this).logout();
            finish();
            startActivity(new Intent(this, LoginActivityManager.class));
        }
    }


}