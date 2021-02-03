package com.example.hotelbooking2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class AdminModifyUser extends AppCompatActivity implements View.OnClickListener{
    private EditText EditTextUsername, EditTextUserEmail,EditTextUserlastname,EditTextUserfirstname,EditTextUsernumber,EditTextUseraddress;
    int position;
    private ProgressDialog progressDialog;
    private Button modifyProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_modify_user);


        EditTextUsername = (EditText) findViewById(R.id.Username);
        EditTextUserEmail = (EditText) findViewById(R.id.Email);
        EditTextUserlastname = (EditText) findViewById(R.id.Lastname);
        EditTextUserfirstname = (EditText) findViewById(R.id.Firstname);
        EditTextUsernumber = (EditText) findViewById(R.id.Phone);
        EditTextUseraddress = (EditText) findViewById(R.id.Address);

        modifyProfile = (Button) findViewById(R.id.ModifyProfile);
        modifyProfile.setOnClickListener(this);


        Intent intent = getIntent();
        position = intent.getExtras().getInt("position");

        progressDialog = new ProgressDialog(this);

        EditTextUserEmail.setText(AdminSearchForUser.usersarraylist.get(position).getemail());
        EditTextUsername.setText(AdminSearchForUser.usersarraylist.get(position).getusername());
        EditTextUserlastname.setText(AdminSearchForUser.usersarraylist.get(position).getlastname());
        EditTextUserfirstname.setText(AdminSearchForUser.usersarraylist.get(position).getfirstname());
        EditTextUsernumber.setText(AdminSearchForUser.usersarraylist.get(position).getnumber());
        EditTextUseraddress.setText(AdminSearchForUser.usersarraylist.get(position).getaddress());


    }

    public void adminmodifyuserprofile() {

        final String email = EditTextUserEmail.getText().toString().trim();
        final String username = EditTextUsername.getText().toString().trim();
        final String lastname = EditTextUserlastname.getText().toString().trim();
        final String firstname = EditTextUserfirstname.getText().toString().trim();
        final String address = EditTextUseraddress.getText().toString().trim();
        final String number = EditTextUsernumber.getText().toString().trim();


        progressDialog.setMessage("Updating");
        progressDialog.show();

        StringRequest request = new StringRequest(Request.Method.POST, Constants.URL__ADMIN_MODIFY_USER, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(AdminModifyUser.this,response,Toast.LENGTH_SHORT).show();
                startActivity(new Intent(AdminModifyUser.this,AdminSearchForUser.class));
                progressDialog.dismiss();


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(AdminModifyUser.this, error.getMessage(), Toast.LENGTH_SHORT).show();
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
    public void onClick(View view) {
        if(view == modifyProfile){
            adminmodifyuserprofile();

        }

    }



}