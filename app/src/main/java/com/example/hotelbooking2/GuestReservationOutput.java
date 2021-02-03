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
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class GuestReservationOutput extends AppCompatActivity implements View.OnClickListener {

        private TextView textViewhotelname,textViewconfirmationnumber,textViewprice,textViewroomtype,
                         textViewnumberofrooms,textViewnumberofadults,textViewcheckindate,textViewamenities,
                         textViewhotelmanagercontact,textViewcheckoutdate,textViewLastName,textViewFirstName;
        private Button MakeReservation;
        int position;
        private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guest_reservation_output_screen);

/*
        if(!SharedPrefManagerSearchRooms.getInstance(this).hassearchedroom()){
            finish();
            startActivity(new Intent(this, GuestMakeReservation.class));
        }
*/

        Intent intent = getIntent();
        position = intent.getExtras().getInt("position");

        progressDialog = new ProgressDialog(this);

        MakeReservation = (Button) findViewById(R.id.MakeReservation);
        MakeReservation.setOnClickListener(this);

        textViewLastName = (TextView) findViewById(R.id.Lastname);
        textViewFirstName = (TextView) findViewById(R.id.Firstname);
        textViewhotelname = (TextView) findViewById(R.id.Hotel_name);
        textViewroomtype = (TextView) findViewById(R.id.Hotel_room_type);
        textViewprice = (TextView) findViewById(R.id.Hotel_price);
        textViewamenities = (TextView) findViewById(R.id.Hotel_amenities);
        textViewnumberofrooms = (TextView) findViewById(R.id.Hotel_number_of_rooms);
        textViewnumberofadults = (TextView) findViewById(R.id.Hotel_number_of_guests);
        textViewcheckindate = (TextView) findViewById(R.id.Hotel_check_in_date);
        textViewcheckoutdate = (TextView) findViewById(R.id.Hotel_check_out_date);
        textViewhotelmanagercontact = (TextView) findViewById(R.id.Hotel_manager_contact);
        textViewconfirmationnumber = (TextView) findViewById(R.id.Hotel_Confirmation_number);


        textViewLastName.setText(SharedPrefManager.getInstance(this).getUserLast_name());
        textViewFirstName.setText(SharedPrefManager.getInstance(this).getUserFirst_name());
        textViewhotelname.setText(GuestSearchRoomsNew.roomsArrayList.get(position).gethotel());
        textViewroomtype.setText(GuestSearchRoomsNew.roomsArrayList.get(position).getroomtype());
        textViewprice.setText(GuestSearchRoomsNew.roomsArrayList.get(position).getprice());
        textViewamenities.setText(GuestSearchRoomsNew.roomsArrayList.get(position).getamenities());
        textViewnumberofrooms.setText(GuestSearchRoomsNew.roomsArrayList.get(position).getnumberofrooms());
        textViewnumberofadults.setText(GuestSearchRoomsNew.roomsArrayList.get(position).getnumberofadults());
        textViewcheckindate.setText(GuestSearchRoomsNew.roomsArrayList.get(position).getcheckindate());
        textViewcheckoutdate.setText(GuestSearchRoomsNew.roomsArrayList.get(position).getcheckoutdate());
        textViewhotelmanagercontact.setText(GuestSearchRoomsNew.roomsArrayList.get(position).gethotelmanagercontact());
        textViewconfirmationnumber.setText(GuestSearchRoomsNew.roomsArrayList.get(position).getconfirmationnumber());

    }


    private void makereservation() {
        final String lastname = textViewLastName.getText().toString().trim();
        final String firstname = textViewFirstName.getText().toString().trim();
        final String hotel = textViewhotelname.getText().toString().trim();
        final String roomtype = textViewroomtype.getText().toString().trim();
        final String price = textViewprice.getText().toString().trim();
        final String amenities = textViewamenities.getText().toString().trim();
        final String numberofrooms = textViewnumberofrooms.getText().toString().trim();
        final String numberofadults = textViewnumberofadults.getText().toString().trim();
        final String checkindate = textViewcheckindate.getText().toString().trim();
        final String checkoutdate = textViewcheckoutdate.getText().toString().trim();
        final String hotelmanagercontact = textViewhotelmanagercontact.getText().toString().trim();
        final String confirmationnumber = textViewconfirmationnumber.getText().toString().trim();

        progressDialog.setMessage("Making reservation...");
        progressDialog.show();

        StringRequest stringRequest = new StringRequest(Request.Method.POST,
                Constants.URL_CONFIRM_RESERVATION,
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
                params.put("hotel", hotel);
                params.put("roomtype", roomtype);
                params.put("price", price);
                params.put("amenities", amenities);
                params.put("numberofrooms", numberofrooms);
                params.put("numberofadults", numberofadults);
                params.put("checkindate", checkindate);
                params.put("checkoutdate", checkoutdate);
                params.put("hotelmanagercontact", hotelmanagercontact);
                params.put("confirmationnumber", confirmationnumber);
                params.put("lastname", lastname);
                params.put("firstname", firstname);

                return params;
            }
        };



        RequestHandler.getInstance(this).addToRequestQueue(stringRequest);


    }

    @Override
    public void onClick(View view) {
        if (view == MakeReservation)
            makereservation();
        startActivity(new Intent(getApplicationContext(), GuestMakePayment.class));
    }
}
