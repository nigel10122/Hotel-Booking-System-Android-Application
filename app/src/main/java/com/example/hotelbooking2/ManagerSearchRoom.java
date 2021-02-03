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

public class ManagerSearchRoom extends AppCompatActivity implements View.OnClickListener {

    private Button SearchForRoom;
    ListView listView;
    private ProgressDialog progressDialog;
    private EditText editTextHotel,editTextroomtype, editTextcheckindate, editTextcheckoutdate;
    ManagerRoomsAdapter adapter;
    public static ArrayList<Rooms> roomsArrayList = new ArrayList<>();

    Rooms rooms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager_search_room);


        SearchForRoom = (Button) findViewById(R.id.SearchForRoom);

        editTextHotel = (EditText) findViewById(R.id.Hotel);
        editTextroomtype = (EditText) findViewById(R.id.RoomType);
        editTextcheckindate = (EditText) findViewById(R.id.Checkindate);
        editTextcheckoutdate = (EditText) findViewById(R.id.Checkoutdate);

        listView = findViewById(R.id.myListView);
        adapter = new ManagerRoomsAdapter(this,roomsArrayList);
        listView.setAdapter(adapter);
        SearchForRoom.setOnClickListener(this);

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please wait...");

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {

                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                ProgressDialog progressDialog = new ProgressDialog(view.getContext());

                CharSequence[] dialogItem = {"View Details","Modify Room"};
                builder.setTitle(roomsArrayList.get(position).gethotel());
                builder.setItems(dialogItem, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        switch (i){

                            case 0 :
                                startActivity(new Intent(getApplicationContext(),ManagerViewRoomDetails.class).putExtra("position",position));

                                break;

                            case 1 :
                                startActivity(new Intent(getApplicationContext(),ManagerModifyRoomDetails.class).putExtra("position",position));

                                break;




                        }

                    }
                });

                builder.create().show();


            }
        });
    }

    public void searhrooms() {

        final String hotel = editTextHotel.getText().toString().trim();
        final String roomtype = editTextroomtype.getText().toString().trim();
        final String checkindate = editTextcheckindate.getText().toString().trim();
        final String checkoutdate = editTextcheckoutdate.getText().toString().trim();

        progressDialog.show();
        StringRequest request = new StringRequest(Request.Method.POST, Constants.URL__MANAGER_VIEW_ROOM_LIST, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                progressDialog.dismiss();
                roomsArrayList.clear();
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    String success = jsonObject.getString("success");
                    JSONArray jsonArray = jsonObject.getJSONArray("rooms");

                    if (success.equals("1")) {
                        for (int i = 0; i < jsonArray.length(); i++) {

                            JSONObject object = jsonArray.getJSONObject(i);

                            String id = object.getString("id");
                            String hotel = object.getString("hotel");
                            String roomtype = object.getString("roomtype");
                            String numberofrooms = object.getString("numberofrooms");
                            String numberofadults = object.getString("numberofadults");
                            String numberofchildren = object.getString("numberofchildren");
                            String checkindate = object.getString("checkindate");
                            String checkoutdate = object.getString("checkoutdate");
                            String price = object.getString("price");
                            String distance = object.getString("distance");
                            String amenities = object.getString("amenities");
                            String hotelmanagercontact = object.getString("hotelmanagercontact");
                            String confirmationnumber = object.getString("confirmationnumber");
                            String totalnumberofrooms = object.getString("totalnumberofrooms");
                            String availablerooms = object.getString("availablerooms");
                            String unavailablerooms = object.getString("unavailablerooms");
                            String availability = object.getString("availability");
                            String weekendprice = object.getString("weekendprice");
                            String roomnumber = object.getString("roomnumber");


                            rooms = new Rooms(id, hotel, roomtype, numberofrooms, numberofadults, numberofchildren, checkindate, checkoutdate, price, distance, amenities, hotelmanagercontact,confirmationnumber,totalnumberofrooms,availablerooms,unavailablerooms,availability,weekendprice,roomnumber);
                            roomsArrayList.add(rooms);
                            adapter.notifyDataSetChanged();
                        }


                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(ManagerSearchRoom.this, error.getMessage(), Toast.LENGTH_SHORT).show();
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
    public void onClick (View view){
        if (view == SearchForRoom) {
            searhrooms();
        }
    }
}

