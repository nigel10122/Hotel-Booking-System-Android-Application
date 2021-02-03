package com.example.hotelbooking2;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.app.ProgressDialog;
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
import org.json.JSONException;
import org.json.JSONObject;
import java.util.HashMap;
import java.util.Map;

public class Registeruser extends AppCompatActivity implements View.OnClickListener {


    private EditText editTextUsername, editTextEmail, editTextPassword,editTextLastname,editTextFirstname,editTextAddress,editTextNumber,editTextCreditCardType,editTextCreditCardNumber,editTextNameonCard,editTextExpiryDate,editTextBillingAddress;
    private Button buttonRegister;
    private ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_user);

        editTextEmail = (EditText) findViewById(R.id.Email);
        editTextUsername = (EditText) findViewById(R.id.Username);
        editTextPassword = (EditText) findViewById(R.id.Password);
        editTextLastname =  (EditText) findViewById(R.id.Lastname);
        editTextFirstname = (EditText) findViewById(R.id.Firstname);
        editTextAddress = (EditText) findViewById(R.id.Address);
        editTextNumber = (EditText) findViewById(R.id.Phone);
        editTextCreditCardType = (EditText) findViewById(R.id.CreditCardType);
        editTextCreditCardNumber = (EditText) findViewById(R.id.CreditCardNumber);
        editTextNameonCard = (EditText) findViewById(R.id.NameonCard);
        editTextExpiryDate = (EditText) findViewById(R.id.ExpiryDate);
        editTextBillingAddress = (EditText) findViewById(R.id.BillingAddress);



        buttonRegister = (Button) findViewById(R.id.Register);

        progressDialog = new ProgressDialog(this);

        buttonRegister.setOnClickListener(this);

    }

    private void registerUser() {
        final String email = editTextEmail.getText().toString().trim();
        final String username = editTextUsername.getText().toString().trim();
        final String password = editTextPassword.getText().toString().trim();
        final String lastname = editTextLastname.getText().toString().trim();
        final String firstname = editTextFirstname.getText().toString().trim();
        final String address = editTextAddress.getText().toString().trim();
        final String number = editTextNumber.getText().toString().trim();
        final String creditcardtype = editTextCreditCardType.getText().toString().trim();
        final String creditcardnumber = editTextCreditCardNumber.getText().toString().trim();
        final String nameoncard = editTextNameonCard.getText().toString().trim();
        final String expirydate = editTextExpiryDate.getText().toString().trim();
        final String billingaddress = editTextBillingAddress.getText().toString().trim();

        progressDialog.setMessage("Registering user...");
        progressDialog.show();

        StringRequest stringRequest = new StringRequest(Request.Method.POST,
                Constants.URL_REGISTER,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        progressDialog.dismiss();

                        try {
                            JSONObject jsonObject = new JSONObject(response);

                            Toast.makeText(getApplicationContext(), jsonObject.getString("message"), Toast.LENGTH_LONG).show();

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        progressDialog.hide();
                        Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("username", username);
                params.put("email", email);
                params.put("password", password);
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



       RequestHandler.getInstance(this).addToRequestQueue(stringRequest);


    }

    @Override
    public void onClick(View view) {
        if (view == buttonRegister)
            registerUser();
    }
}
