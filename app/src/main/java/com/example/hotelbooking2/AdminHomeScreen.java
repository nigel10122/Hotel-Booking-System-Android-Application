package com.example.hotelbooking2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class AdminHomeScreen extends AppCompatActivity implements View.OnClickListener {

    private Button SearchForGuest,Logout,Profile,SearchForManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_home);

        SearchForGuest = (Button) findViewById(R.id.SearchForGuest);
        SearchForGuest.setOnClickListener(this);
        SearchForManager = (Button) findViewById(R.id.SearchForManager);
        SearchForManager.setOnClickListener(this);
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
        switch (item.getItemId()) {
            case R.id.menuLogout:
                SharedPrefManager.getInstance(this).logout();
                finish();
                startActivity(new Intent(this, LoginActivity.class));
                break;
            case R.id.menuSettings:
                Toast.makeText(this, "You clicked settings", Toast.LENGTH_LONG).show();
                break;
            case R.id.menuprofile:
                startActivity(new Intent(this, ProfileActivityAdmin.class));
                break;
        }
        return true;
    }

    @Override
    public void onClick(View view) {
        if (view == SearchForGuest) {
            startActivity(new Intent(this, AdminSearchForUser.class));
        }
        if (view == Profile) {
            startActivity(new Intent(this,ProfileActivityAdmin.class));
        }
        if (view == Logout) {
            SharedPrefManagerAdmin.getInstance(this).logout();
            finish();
            startActivity(new Intent(this, LoginActivityAdmin.class));
        }
        if (view == SearchForManager) {
            startActivity(new Intent(this,AdminSearchForManager.class));
        }

    }
}