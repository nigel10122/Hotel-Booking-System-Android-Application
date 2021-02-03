package com.example.hotelbooking2;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
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

public class AdminDeleteManager extends AppCompatActivity implements View.OnClickListener {
    private TextView textViewUsername, textViewUserEmail,textViewUserlastname,textViewUserfirstname,textViewUsernumber,textViewUseraddress;
    int position;
    private ProgressDialog progressDialog;
    private Button Deleteprofile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_delete_manager);

        textViewUsername = (TextView) findViewById(R.id.Username);
        textViewUserEmail = (TextView) findViewById(R.id.Email);
        textViewUserlastname = (TextView) findViewById(R.id.Lastname);
        textViewUserfirstname = (TextView) findViewById(R.id.Firstname);
        textViewUsernumber = (TextView) findViewById(R.id.Phone);
        textViewUseraddress = (TextView) findViewById(R.id.Address);

        Intent intent = getIntent();
        position = intent.getExtras().getInt("position");

        Deleteprofile = (Button) findViewById(R.id.DeleteProfile);
        Deleteprofile.setOnClickListener(this);

        progressDialog = new ProgressDialog(this);


        textViewUserEmail.setText(AdminSearchForManager.usersarraylist.get(position).getemail());
        textViewUsername.setText(AdminSearchForManager.usersarraylist.get(position).getusername());
        textViewUserlastname.setText(AdminSearchForManager.usersarraylist.get(position).getlastname());
        textViewUserfirstname.setText(AdminSearchForManager.usersarraylist.get(position).getfirstname());
        textViewUsernumber.setText(AdminSearchForManager.usersarraylist.get(position).getnumber());
        textViewUseraddress.setText(AdminSearchForManager.usersarraylist.get(position).getaddress());

    }

    public void admindeletemanagerprofile() {

        final String username = textViewUsername.getText().toString().trim();


        progressDialog.setMessage("Deleting Profile");
        progressDialog.show();
        StringRequest request = new StringRequest(Request.Method.POST, Constants.URL__ADMIN_DELETE_MANAGER, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(AdminDeleteManager.this,response,Toast.LENGTH_SHORT).show();
                startActivity(new Intent(AdminDeleteManager.this,AdminSearchForManager.class));
                progressDialog.dismiss();


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(AdminDeleteManager.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();
            }
        }) {


            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("username", username);



                return params;

            }

        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);
    }



    @Override
    public void onClick(View view) {
        if(view == Deleteprofile){
            admindeletemanagerprofile();

        }

    }







}