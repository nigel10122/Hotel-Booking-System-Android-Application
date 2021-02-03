package com.example.hotelbooking2;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GuestUpcomingList extends AppCompatActivity implements View.OnClickListener  {


    ReservationsAdapter reservationsadapter;
    public static ArrayList<Reservations> reservationsArrayList = new ArrayList<>();
    ListView listView;

    Reservations reservations;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guest_upcominglist);
        viewreservationlist();


        listView = findViewById(R.id.myListView);
        reservationsadapter = new ReservationsAdapter(this,reservationsArrayList);
        listView.setAdapter(reservationsadapter);



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {

                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                ProgressDialog progressDialog = new ProgressDialog(view.getContext());

                CharSequence[] dialogItem = {"View Details", "Modify Reservation", "Cancel Reservation"};
                builder.setTitle(reservationsArrayList.get(position).gethotel());
                builder.setItems(dialogItem, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        switch (i){

                            case 0 :
                                startActivity(new Intent(getApplicationContext(),GuestViewUpcomingReservation.class).putExtra("position",position));

                                break;

                            case 1:

                                startActivity(new Intent(getApplicationContext(),GuestModifyReservation.class).putExtra("position",position));

                                break;

                            case 2:
                                /*cancelreservation(position);*/

                                startActivity(new Intent(getApplicationContext(),GuestCancelReservation.class).putExtra("position",position));

                                break;


                        }

                    }
                });

                builder.create().show();


            }
        });
    }

/*    public void cancelreservation(final int position) {

        StringRequest request = new StringRequest(Request.Method.POST, Constants.URL_VIEW_RESERVATION_LIST, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {


                if (response.equalsIgnoreCase("Reservation Cancelled")) {
                    Toast.makeText(GuestUpcomingList.this, "Reservation Cancelled Succesfully", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(GuestUpcomingList.this, "Reservation Not Cancelled", Toast.LENGTH_SHORT).show();
                }


            }


        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(GuestUpcomingList.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }){

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("id", String.valueOf(position));



                return params;

            }};
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);

    }*/





    public void viewreservationlist() {



        StringRequest request = new StringRequest(Request.Method.POST, Constants.URL_VIEW_RESERVATION_LIST, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                reservationsArrayList.clear();
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    String success = jsonObject.getString("success");
                    JSONArray jsonArray = jsonObject.getJSONArray("reservation");

                    if (success.equals("1")) {
                        for (int i = 0; i < jsonArray.length(); i++) {

                            JSONObject object = jsonArray.getJSONObject(i);

                            String id = object.getString("id");
                            String hotel = object.getString("hotel");
                            String roomtype = object.getString("roomtype");
                            String numberofrooms = object.getString("numberofrooms");
                            String numberofadults = object.getString("numberofadults");
                            String checkindate = object.getString("checkindate");
                            String checkoutdate = object.getString("checkoutdate");
                            String price = object.getString("price");
                            String amenities = object.getString("amenities");
                            String hotelmanagercontact = object.getString("hotelmanagercontact");
                            String confirmationnumber = object.getString("confirmationnumber");
                            String lastname = object.getString("lastname");
                            String firstname = object.getString("firstname");

                            reservations = new Reservations(id, hotel, roomtype, numberofrooms, numberofadults,  checkindate, checkoutdate, price, amenities, hotelmanagercontact,confirmationnumber,lastname,firstname);
                            reservationsArrayList.add(reservations);
                            reservationsadapter.notifyDataSetChanged();
                        }


                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(GuestUpcomingList.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }) {



        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);
    }


    @Override
    public void onClick(View view) {

        }
    }


