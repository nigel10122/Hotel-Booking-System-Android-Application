package com.example.hotelbooking2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.icu.text.Transliterator;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class ManagerModifyReservation extends AppCompatActivity implements View.OnClickListener {


    private EditText EditTextlastname,EditTextfirstname,EditTexthotelname,EditTextconfirmationnumber,EditTexthotelmanagercontact,EditTextprice,EditTextroomtype,EditTextnumberofrooms,EditTextnumberofadults,EditTextcheckindate,EditTextamenities,EditTextcheckoutdate;
    private Button ModifyReservation;
    private int position;
    private ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager_modify_reservation);


        ModifyReservation = (Button) findViewById(R.id.ModifyReservation);
        ModifyReservation.setOnClickListener(this);


        Intent intent = getIntent();
        position = intent.getExtras().getInt("position");

        progressDialog = new ProgressDialog(this);

        EditTextlastname = (EditText) findViewById(R.id.Lastname);
        EditTextfirstname = (EditText) findViewById(R.id.Firstname);
        EditTexthotelname = (EditText) findViewById(R.id.Hotel_name);
        EditTextroomtype = (EditText) findViewById(R.id.Hotel_room_type);
        EditTextprice = (EditText) findViewById(R.id.Hotel_price);
        EditTextamenities = (EditText) findViewById(R.id.Hotel_amenities);
        EditTextnumberofrooms = (EditText) findViewById(R.id.Hotel_number_of_rooms);
        EditTextnumberofadults = (EditText) findViewById(R.id.Hotel_number_of_guests);
        EditTextcheckindate = (EditText) findViewById(R.id.Hotel_check_in_date);
        EditTextcheckoutdate = (EditText) findViewById(R.id.Hotel_check_out_date);
        EditTextconfirmationnumber = (EditText) findViewById(R.id.Hotel_Confirmation_number);
        EditTexthotelmanagercontact = (EditText) findViewById(R.id.Hotel_manager_contact);





        EditTextlastname.setText(ManagerViewReservationListing.reservationsArrayList.get(position).getlastname());
        EditTextfirstname.setText(ManagerViewReservationListing.reservationsArrayList.get(position).getfirstname());
        EditTexthotelname.setText(ManagerViewReservationListing.reservationsArrayList.get(position).gethotel());
        EditTextroomtype.setText(ManagerViewReservationListing.reservationsArrayList.get(position).getroomtype());
        EditTextprice.setText(ManagerViewReservationListing.reservationsArrayList.get(position).getprice());
        EditTextamenities.setText(ManagerViewReservationListing.reservationsArrayList.get(position).getamenities());
        EditTextnumberofrooms.setText(ManagerViewReservationListing.reservationsArrayList.get(position).getnumberofrooms());
        EditTextnumberofadults.setText(ManagerViewReservationListing.reservationsArrayList.get(position).getnumberofadults());
        EditTextcheckindate.setText(ManagerViewReservationListing.reservationsArrayList.get(position).getcheckindate());
        EditTextcheckoutdate.setText(ManagerViewReservationListing.reservationsArrayList.get(position).getcheckoutdate());
        EditTextconfirmationnumber.setText(ManagerViewReservationListing.reservationsArrayList.get(position).getconfirmationnumber());
        EditTexthotelmanagercontact.setText(ManagerViewReservationListing.reservationsArrayList.get(position).gethotelmanagercontact());
    }

    public void modifyreservation() {

        final String hotelname = EditTexthotelname.getText().toString().trim();
        final String roomtype = EditTextroomtype.getText().toString().trim();
        final String numberofrooms = EditTextnumberofrooms.getText().toString().trim();
        final String numberofadults = EditTextnumberofadults.getText().toString().trim();
        final String checkindate = EditTextcheckindate.getText().toString().trim();
        final String checkoutdate = EditTextcheckoutdate.getText().toString().trim();
        final String price = EditTextprice.getText().toString().trim();
        final String amenities = EditTextamenities.getText().toString().trim();
        final String confirmationnumber = EditTextconfirmationnumber.getText().toString().trim();
        final String hotelmanagercontact = EditTexthotelmanagercontact.getText().toString().trim();
        final String lastname = EditTextlastname.getText().toString().trim();
        final String firstname = EditTextfirstname.getText().toString().trim();


        progressDialog.setMessage("Updating");
        progressDialog.show();

        StringRequest request = new StringRequest(Request.Method.POST, Constants.URL_MANAGER_MODIFY_RESERVATION, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(ManagerModifyReservation.this,response,Toast.LENGTH_SHORT).show();
               /* startActivity(new Intent(ManagerModifyReservation.this,ManagerModifyReservation.class));*/
                progressDialog.dismiss();


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(ManagerModifyReservation.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();
            }
        }) {


            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("hotel", hotelname);
                params.put("roomtype", roomtype);
                params.put("numberofrooms", numberofrooms);
                params.put("numberofadults", numberofadults);
                params.put("checkindate", checkindate);
                params.put("checkoutdate", checkoutdate);
                params.put("price", price);
                params.put("amenities", amenities);
                params.put("hotelmanagercontact", hotelmanagercontact);
                params.put("confirmationnumber", confirmationnumber);
                params.put("lastname", lastname);
                params.put("firstname", firstname);


                return params;
            }

        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);
    }



    @Override
    public void onClick(View view) {
        if(view == ModifyReservation){
            modifyreservation();

        }

    }
}