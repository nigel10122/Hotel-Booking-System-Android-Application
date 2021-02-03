package com.example.hotelbooking2;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class ModifyManagerProfileActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText EditTextUsername, EditTextUserEmail,EditTextUserlastname,EditTextUserfirstname,EditTextUsernumber,EditTextUseraddress;
    private Button ModifyProfile;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manager_modify_profile);

        if(!SharedPrefManagerManager.getInstance(this).isLoggedIn()){
            finish();
            startActivity(new Intent(this, LoginActivity.class));
        }


        ModifyProfile = (Button) findViewById(R.id.ModifyProfile);
        ModifyProfile.setOnClickListener(this);

        progressDialog = new ProgressDialog(this);

        EditTextUsername = (EditText) findViewById(R.id.Username);
        EditTextUserEmail = (EditText) findViewById(R.id.Email);
        EditTextUserlastname = (EditText) findViewById(R.id.Lastname);
        EditTextUserfirstname = (EditText) findViewById(R.id.Firstname);
        EditTextUsernumber = (EditText) findViewById(R.id.Phone);
        EditTextUseraddress = (EditText) findViewById(R.id.Address);



        EditTextUserEmail.setText(SharedPrefManagerManager.getInstance(this).getUserEmail());
        EditTextUsername.setText(SharedPrefManagerManager.getInstance(this).getUsername());
        EditTextUserlastname.setText(SharedPrefManagerManager.getInstance(this).getUserLast_name());
        EditTextUserfirstname.setText(SharedPrefManagerManager.getInstance(this).getUserFirst_name());
        EditTextUsernumber.setText(SharedPrefManagerManager.getInstance(this).getUserNumber());
        EditTextUseraddress.setText(SharedPrefManagerManager.getInstance(this).getUserAddress());

    }



    public void modifyprofile() {

        final String email = EditTextUserEmail.getText().toString().trim();
        final String username = EditTextUsername.getText().toString().trim();
        final String lastname = EditTextUserlastname.getText().toString().trim();
        final String firstname = EditTextUserfirstname.getText().toString().trim();
        final String address = EditTextUseraddress.getText().toString().trim();
        final String number = EditTextUsernumber.getText().toString().trim();



        progressDialog.setMessage("Updating");
        progressDialog.show();

        StringRequest request = new StringRequest(Request.Method.POST, Constants.URL__MANAGER_MODIFY_PROFILE, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Toast.makeText(ModifyManagerProfileActivity.this, "User Profile Modified , Login again to view changes", Toast.LENGTH_LONG).show();
                SharedPrefManager.getInstance(ModifyManagerProfileActivity.this).logout();
                finish();
                /*startActivity(new Intent(ModifyManagerProfileActivity.this, LoginActivity.class));*/

                progressDialog.dismiss();


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(ModifyManagerProfileActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();
            }
        }) {


            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("email", email);
                params.put("username", username);
                params.put("lastname", lastname);
                params.put("firstname", firstname);
                params.put("address", address);
                params.put("number", number);




                return params;
            }

        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);
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
                startActivity(new Intent(this, GuestHomeScreen.class));
                break;
        }
        return true;
    }

    @Override
    public void onClick(View view) {
        if(view == ModifyProfile){
            modifyprofile();

        }
    }

}
