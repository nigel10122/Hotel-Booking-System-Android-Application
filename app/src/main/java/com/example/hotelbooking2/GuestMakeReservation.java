package com.example.hotelbooking2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class GuestMakeReservation extends AppCompatActivity implements View.OnClickListener {
    private EditText textViewhotelname, textViewprice, textViewdistance,textViewamenities;
    private Button MakeReservation;
    int position;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guest_makereservations);

/*
        if(SharedPrefManagerSearchRooms.getInstance(this).hassearchedroom()){
            finish();
            startActivity(new Intent(this, GuestReservationOutput.class));
            return;
        }
*/


        MakeReservation = (Button) findViewById(R.id.MakeReservation);
        MakeReservation.setOnClickListener(this);

        textViewhotelname = (EditText) findViewById(R.id.hotel);
        textViewprice = (EditText) findViewById(R.id.price);
        textViewdistance = (EditText) findViewById(R.id.distance);
        textViewamenities = (EditText) findViewById(R.id.amenities);

        Intent intent = getIntent();
        position = intent.getExtras().getInt("position");

 /*       progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please wait...");*/

        textViewhotelname.setText(GuestSearchRoomsNew.roomsArrayList.get(position).gethotel());
        textViewprice.setText(GuestSearchRoomsNew.roomsArrayList.get(position).getprice());
        textViewdistance.setText(GuestSearchRoomsNew.roomsArrayList.get(position).getdistance());
        textViewamenities.setText(GuestSearchRoomsNew.roomsArrayList.get(position).getamenities());


        }



    private void makereservation(){

        final String hotel = textViewhotelname.getText().toString().trim();
        final String price = textViewprice.getText().toString().trim();
        final String distance = textViewdistance.getText().toString().trim();
        final String amenities = textViewamenities.getText().toString().trim();




        progressDialog.show();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, Constants.URL_MAKE_RESERVATION, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                progressDialog.dismiss();
                try {
                    JSONObject obj = new JSONObject(response);
                    if(!obj.getBoolean("error")){
                        SharedPrefManagerSearchRooms.getInstance(getApplicationContext())
                                .makereservation(
                                        obj.getInt("id"),
                                        obj.getString("hotel"),
                                        obj.getString("roomtype"),
                                        obj.getString("numberofrooms"),
                                        obj.getString("numberofadults"),
                                        obj.getString("numberofchildren"),
                                        obj.getString("checkindate"),
                                        obj.getString("checkoutdate"),
                                        obj.getString("price"),
                                        obj.getString("distance"),
                                        obj.getString("amenities"),
                                        obj.getString("hotelmanagercontact"),
                                        obj.getString("confirmationnumber")

                                );
                        startActivity(new Intent(getApplicationContext(), GuestReservationOutput.class));
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
                params.put("hotel", hotel);
                params.put("price", price);
                params.put("distance", distance);
                params.put("amenities", amenities);




                return params;
            }

        };

        RequestHandler.getInstance(this).addToRequestQueue(stringRequest);
    }




    @Override
    public void onClick(View view) {
        if(view == MakeReservation){
                makereservation();
        }

    }
}