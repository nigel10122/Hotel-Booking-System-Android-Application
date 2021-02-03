package com.example.hotelbooking2;

import android.app.ProgressDialog;
import android.content.Intent;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView textViewUsername, textViewUserEmail,textViewUserlastname,textViewUserfirstname,textViewUsernumber,textViewUseraddress,textViewCreditCardType,textViewCreditCardNumber,textViewNameonCard,textViewExpiryDate,textViewBillingAddress;
    private Button UpdateProfile;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_guest);

        if(!SharedPrefManager.getInstance(this).isLoggedIn()){
            finish();
            startActivity(new Intent(this, LoginActivity.class));
        }




        textViewUsername = (TextView) findViewById(R.id.Username);
        textViewUserEmail = (TextView) findViewById(R.id.Email);
        textViewUserlastname = (TextView) findViewById(R.id.Lastname);
        textViewUserfirstname = (TextView) findViewById(R.id.Firstname);
        textViewUsernumber = (TextView) findViewById(R.id.Phone);
        textViewUseraddress = (TextView) findViewById(R.id.Address);
        textViewCreditCardType = (TextView) findViewById(R.id.CreditCardType);
        textViewCreditCardNumber = (TextView) findViewById(R.id.CreditCardNumber);
        textViewNameonCard = (TextView) findViewById(R.id.NameonCard);
        textViewExpiryDate = (TextView) findViewById(R.id.ExpiryDate);
        textViewBillingAddress = (TextView) findViewById(R.id.BillingAddress);

        UpdateProfile = (Button) findViewById(R.id.ModifyProfile);
        UpdateProfile.setOnClickListener(this);

        progressDialog = new ProgressDialog(this);

        textViewUserEmail.setText(SharedPrefManager.getInstance(this).getUserEmail());
        textViewUsername.setText(SharedPrefManager.getInstance(this).getUsername());
        textViewUserlastname.setText(SharedPrefManager.getInstance(this).getUserLast_name());
        textViewUserfirstname.setText(SharedPrefManager.getInstance(this).getUserFirst_name());
        textViewUsernumber.setText(SharedPrefManager.getInstance(this).getUserNumber());
        textViewUseraddress.setText(SharedPrefManager.getInstance(this).getUserAddress());
        textViewCreditCardType.setText(SharedPrefManager.getInstance(this).getUserCreditCardType());
        textViewCreditCardNumber.setText(SharedPrefManager.getInstance(this).getUserCreditCardNumber());
        textViewNameonCard.setText(SharedPrefManager.getInstance(this).getUserNameOnCard());
        textViewExpiryDate.setText(SharedPrefManager.getInstance(this).getUserExpiryDate());
        textViewBillingAddress.setText(SharedPrefManager.getInstance(this).getUserBillingAddress());
    }


    private void getuserprofile(){
        final String email = textViewUserEmail.getText().toString().trim();
        final String username = textViewUsername.getText().toString().trim();
       /* final String lastname = textViewUserlastname.getText().toString().trim();
        final String firstname = textViewUserfirstname.getText().toString().trim();
        final String address = textViewUseraddress.getText().toString().trim();
        final String number = textViewUsernumber.getText().toString().trim();
        final String creditcardtype = textViewCreditCardType.getText().toString().trim();
        final String creditcardnumber = textViewCreditCardNumber.getText().toString().trim();
        final String nameoncard = textViewNameonCard.getText().toString().trim();
        final String expirydate = textViewExpiryDate.getText().toString().trim();
        final String billingaddress = textViewBillingAddress.getText().toString().trim();*/

        progressDialog.show();

        StringRequest stringRequest = new StringRequest(
                Request.Method.POST,
                Constants.URL__GET_GUEST_PROFILE,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        progressDialog.dismiss();
                        try {
                            JSONObject obj = new JSONObject(response);
                            if(!obj.getBoolean("error")){
                                SharedPrefManager.getInstance(getApplicationContext())
                                        .userLogin(
                                                obj.getInt("id"),
                                                obj.getString("username"),
                                                obj.getString("email"),
                                                obj.getString("lastname"),
                                                obj.getString("firstname"),
                                                obj.getString("number"),
                                                obj.getString("address"),
                                                obj.getString("creditcardtype"),
                                                obj.getString("creditcardnumber"),
                                                obj.getString("nameoncard"),
                                                obj.getString("expirydate"),
                                                obj.getString("billingaddress")


                                        );
                                startActivity(new Intent(getApplicationContext(), ModifyGuestProfileActivity.class));
                                finish();
                            }else{
                                Toast.makeText(
                                        getApplicationContext(),
                                        obj.getString("message"),
                                        Toast.LENGTH_LONG
                                ).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        progressDialog.dismiss();

                        Toast.makeText(
                                getApplicationContext(),
                                error.getMessage(),
                                Toast.LENGTH_LONG
                        ).show();
                    }
                }
        ){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("email", email);
                params.put("username", username);
/*                params.put("lastname", lastname);
                params.put("firstname", firstname);
                params.put("address", address);
                params.put("number", number);
                params.put("creditcardtype", creditcardtype);
                params.put("creditcardnumber", creditcardnumber);
                params.put("hotelmanagercontact", nameoncard);
                params.put("nameoncard", expirydate);
                params.put("billingaddress", billingaddress);*/



                return params;
            }

        };

        RequestHandler.getInstance(this).addToRequestQueue(stringRequest);
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
    public void onClick (View view){
        if (view == UpdateProfile) {
            startActivity(new Intent(this, ModifyGuestProfileActivity.class));
        }
    }

}
