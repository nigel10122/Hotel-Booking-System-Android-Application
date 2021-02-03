package com.example.hotelbooking2;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class ModifyGuestProfileActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText EditTextUsername, EditTextUserEmail,EditTextUserlastname,EditTextUserfirstname,EditTextUsernumber,EditTextUseraddress,EditTextCreditCardType,EditTextCreditCardNumber,EditTextNameonCard,EditTextExpiryDate,EditTextBillingAddress;
    private Button ModifyProfile;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guest_modify_profile);

        if(!SharedPrefManager.getInstance(this).isLoggedIn()){
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
        EditTextCreditCardType = (EditText) findViewById(R.id.CreditCardType);
        EditTextCreditCardNumber = (EditText) findViewById(R.id.CreditCardNumber);
        EditTextNameonCard = (EditText) findViewById(R.id.NameonCard);
        EditTextExpiryDate = (EditText) findViewById(R.id.ExpiryDate);
        EditTextBillingAddress = (EditText) findViewById(R.id.BillingAddress);


        EditTextUserEmail.setText(SharedPrefManager.getInstance(this).getUserEmail());
        EditTextUsername.setText(SharedPrefManager.getInstance(this).getUsername());
        EditTextUserlastname.setText(SharedPrefManager.getInstance(this).getUserLast_name());
        EditTextUserfirstname.setText(SharedPrefManager.getInstance(this).getUserFirst_name());
        EditTextUsernumber.setText(SharedPrefManager.getInstance(this).getUserNumber());
        EditTextUseraddress.setText(SharedPrefManager.getInstance(this).getUserAddress());
        EditTextCreditCardType.setText(SharedPrefManager.getInstance(this).getUserCreditCardType());
        EditTextCreditCardNumber.setText(SharedPrefManager.getInstance(this).getUserCreditCardNumber());
        EditTextNameonCard.setText(SharedPrefManager.getInstance(this).getUserNameOnCard());
        EditTextExpiryDate.setText(SharedPrefManager.getInstance(this).getUserExpiryDate());
        EditTextBillingAddress.setText(SharedPrefManager.getInstance(this).getUserBillingAddress());
    }



    public void modifyguestprofile() {

        final String email = EditTextUserEmail.getText().toString().trim();
        final String username = EditTextUsername.getText().toString().trim();
        final String lastname = EditTextUserlastname.getText().toString().trim();
        final String firstname = EditTextUserfirstname.getText().toString().trim();
        final String address = EditTextUseraddress.getText().toString().trim();
        final String number = EditTextUsernumber.getText().toString().trim();
        final String creditcardtype = EditTextCreditCardType.getText().toString().trim();
        final String creditcardnumber = EditTextCreditCardNumber.getText().toString().trim();
        final String nameoncard = EditTextNameonCard.getText().toString().trim();
        final String expirydate = EditTextExpiryDate.getText().toString().trim();
        final String billingaddress = EditTextBillingAddress.getText().toString().trim();


        progressDialog.setMessage("Updating");
        progressDialog.show();

        StringRequest request = new StringRequest(Request.Method.POST, Constants.URL__MODIFY_GUEST_PROFILE, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Toast.makeText(ModifyGuestProfileActivity.this, "User Profile Modified , Login again to view changes", Toast.LENGTH_LONG).show();
                SharedPrefManager.getInstance(ModifyGuestProfileActivity.this).logout();
                finish();
                /*startActivity(new Intent(ModifyGuestProfileActivity.this, LoginActivity.class));
*/
                progressDialog.dismiss();


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(ModifyGuestProfileActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
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
                params.put("creditcardtype", creditcardtype);
                params.put("creditcardnumber", creditcardnumber);
                params.put("nameoncard", nameoncard);
                params.put("expirydate", expirydate);
                params.put("billingaddress", billingaddress);



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
            modifyguestprofile();

        }
    }

}
