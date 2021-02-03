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

public class GuestCancelReservation extends AppCompatActivity implements View.OnClickListener {


    private TextView TextViewhotelname,TextViewconfirmationnumber,TextViewhotelmanagercontact,TextViewprice,TextViewroomtype,TextViewnumberofrooms,TextViewnumberofadults,TextViewcheckindate,TextViewamenities,TextViewcheckoutdate;
    private Button CancelReservation;
    private int position;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guest_cancel_reservation);


        CancelReservation = (Button) findViewById(R.id.CancelReservation);
        CancelReservation.setOnClickListener(this);


        TextViewhotelname = (TextView) findViewById(R.id.Hotel_name);
        TextViewroomtype = (TextView) findViewById(R.id.Hotel_room_type);
        TextViewprice = (TextView) findViewById(R.id.Hotel_price);
        TextViewamenities = (TextView) findViewById(R.id.Hotel_amenities);
        TextViewnumberofrooms = (TextView) findViewById(R.id.Hotel_number_of_rooms);
        TextViewnumberofadults = (TextView) findViewById(R.id.Hotel_number_of_guests);
        TextViewcheckindate = (TextView) findViewById(R.id.Hotel_check_in_date);
        TextViewcheckoutdate = (TextView) findViewById(R.id.Hotel_check_out_date);
        TextViewconfirmationnumber = (TextView) findViewById(R.id.Hotel_Confirmation_number);
        TextViewhotelmanagercontact = (TextView) findViewById(R.id.Hotel_manager_contact);

        Intent intent = getIntent();
        position = intent.getExtras().getInt("position");

        progressDialog = new ProgressDialog(this);


        TextViewhotelname.setText(GuestUpcomingList.reservationsArrayList.get(position).gethotel());
        TextViewroomtype.setText(GuestUpcomingList.reservationsArrayList.get(position).getroomtype());
        TextViewprice.setText(GuestUpcomingList.reservationsArrayList.get(position).getprice());
        TextViewamenities.setText(GuestUpcomingList.reservationsArrayList.get(position).getamenities());
        TextViewnumberofrooms.setText(GuestUpcomingList.reservationsArrayList.get(position).getnumberofrooms());
        TextViewnumberofadults.setText(GuestUpcomingList.reservationsArrayList.get(position).getnumberofadults());
        TextViewcheckindate.setText(GuestUpcomingList.reservationsArrayList.get(position).getcheckindate());
        TextViewcheckoutdate.setText(GuestUpcomingList.reservationsArrayList.get(position).getcheckoutdate());
        TextViewconfirmationnumber.setText(GuestUpcomingList.reservationsArrayList.get(position).getconfirmationnumber());
        TextViewhotelmanagercontact.setText(GuestUpcomingList.reservationsArrayList.get(position).gethotelmanagercontact());
    }

    public void cancelreservation() {

        final String confirmationnumber = TextViewconfirmationnumber.getText().toString().trim();


        progressDialog.setMessage("Cancelling Reservation");
        progressDialog.show();
        StringRequest request = new StringRequest(Request.Method.POST, Constants.URL__CANCEL_RESERVATION, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(GuestCancelReservation.this,response,Toast.LENGTH_SHORT).show();
                startActivity(new Intent(GuestCancelReservation.this,GuestUpcomingList.class));
                progressDialog.dismiss();


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(GuestCancelReservation.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();
            }
        }) {


            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("confirmationnumber", confirmationnumber);



                return params;

            }

        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);
    }



    @Override
    public void onClick(View view) {
        if(view == CancelReservation){
            cancelreservation();

        }

    }
}