package com.example.hotelbooking2;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
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

public class ManagerViewReservationListing extends AppCompatActivity implements View.OnClickListener  {

    private EditText editTextHotel,editTextroomtype,editTextcheckindate, editTextcheckoutdate;
    ManagerReservationsAdapter reservationsadapter;
    public static ArrayList<Reservations> reservationsArrayList = new ArrayList<>();
    ListView listView;
    private Button Managerviewreservation;

    Reservations reservations;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager_view_reservation_listing);


        editTextHotel = (EditText) findViewById(R.id.Hotel);
        editTextroomtype = (EditText) findViewById(R.id.RoomType);
        editTextcheckindate = (EditText) findViewById(R.id.Checkindate);
        editTextcheckoutdate = (EditText) findViewById(R.id.Checkoutdate);

        Managerviewreservation = (Button) findViewById(R.id.Managerviewreservation);
        Managerviewreservation.setOnClickListener(this);

        listView = findViewById(R.id.myListView);
        reservationsadapter = new ManagerReservationsAdapter(this,reservationsArrayList);
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
                                startActivity(new Intent(getApplicationContext(),ManagerViewReservationDetails.class).putExtra("position",position));

                                break;

                            case 1:

                                startActivity(new Intent(getApplicationContext(),ManagerModifyReservation.class).putExtra("position",position));

                                break;

                            case 2:

                                startActivity(new Intent(getApplicationContext(),ManagerCancelReservation.class).putExtra("position",position));

                                break;


                        }

                    }
                });

                builder.create().show();


            }
        });
    }






    public void viewreservationlist() {

        final String hotel = editTextHotel.getText().toString().trim();
        final String roomtype = editTextroomtype.getText().toString().trim();
        final String checkindate = editTextcheckindate.getText().toString().trim();
        final String checkoutdate = editTextcheckoutdate.getText().toString().trim();


        StringRequest request = new StringRequest(Request.Method.POST, Constants.URL__MANAGER_VIEW_RESERVATION, new Response.Listener<String>() {
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
                Toast.makeText(ManagerViewReservationListing.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }) {


            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("hotel", hotel);
                params.put("roomtype", roomtype);
                params.put("checkindate", checkindate);
                params.put("checkoutdate", checkoutdate);


                return params;

            }



        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);
    }


    @Override
    public void onClick(View view) {
        if(view == Managerviewreservation)
        {
            viewreservationlist();
        }


    }
}


