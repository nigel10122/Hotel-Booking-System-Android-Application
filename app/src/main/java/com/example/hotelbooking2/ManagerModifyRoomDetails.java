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

public class ManagerModifyRoomDetails extends AppCompatActivity implements View.OnClickListener {


    private EditText EditTexthotelname,EditTextweekdayprice,EditTextroomtype,EditTexttotalnumberofrooms,EditTextweekendprice,EditTextavailablerooms,EditTextcheckindate,EditTextamenities,EditTexthotelmanagercontact,EditTextcheckoutdate,EditTextunavailablerooms,EditTextavailability,EditTextroomnumber;
    private Button ModifyRoom;
    private int position;
    private ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager_modify_room_details);


        ModifyRoom = (Button) findViewById(R.id.ModifyRoom);
        ModifyRoom.setOnClickListener(this);

        Intent intent = getIntent();
        position = intent.getExtras().getInt("position");

        progressDialog = new ProgressDialog(this);


        EditTexthotelname = (EditText) findViewById(R.id.Hotel_name);
        EditTextroomnumber = (EditText) findViewById(R.id.Room_Number);
        EditTextroomtype = (EditText) findViewById(R.id.Hotel_room_type);
        EditTextweekdayprice = (EditText) findViewById(R.id.Weekday_price);
        EditTextweekendprice = (EditText) findViewById(R.id.Weekend_price);
        EditTexttotalnumberofrooms = (EditText) findViewById(R.id.Total_rooms);
        EditTextavailablerooms= (EditText) findViewById(R.id.Available_rooms);
        EditTextunavailablerooms = (EditText) findViewById(R.id.Unavailable_rooms);
        EditTextavailability = (EditText) findViewById(R.id.Availability);
        EditTextcheckindate = (EditText) findViewById(R.id.Hotel_check_in_date);
        EditTextcheckoutdate = (EditText) findViewById(R.id.Hotel_check_out_date);
        EditTextamenities = (EditText) findViewById(R.id.Hotel_amenities);
        EditTexthotelmanagercontact = (EditText) findViewById(R.id.Hotel_manager_contact);


        EditTexthotelname.setText(ManagerSearchRoom.roomsArrayList.get(position).gethotel());
        EditTextroomnumber.setText(ManagerSearchRoom.roomsArrayList.get(position).getroomnumber());
        EditTextroomtype.setText(ManagerSearchRoom.roomsArrayList.get(position).getroomtype());
        EditTextweekdayprice.setText(ManagerSearchRoom.roomsArrayList.get(position).getprice());
        EditTextweekendprice.setText(ManagerSearchRoom.roomsArrayList.get(position).getweekendprice());
        EditTexttotalnumberofrooms.setText(ManagerSearchRoom.roomsArrayList.get(position).gettotalnumberofrooms());
        EditTextavailablerooms.setText(ManagerSearchRoom.roomsArrayList.get(position).getavailablerooms());
        EditTextunavailablerooms.setText(ManagerSearchRoom.roomsArrayList.get(position).getunavailablerooms());
        EditTextavailability.setText(ManagerSearchRoom.roomsArrayList.get(position).getavailability());
        EditTextcheckindate.setText(ManagerSearchRoom.roomsArrayList.get(position).getcheckindate());
        EditTextcheckoutdate.setText(ManagerSearchRoom.roomsArrayList.get(position).getcheckoutdate());
        EditTextamenities.setText(ManagerSearchRoom.roomsArrayList.get(position).getamenities());
        EditTexthotelmanagercontact.setText(ManagerSearchRoom.roomsArrayList.get(position).gethotelmanagercontact());


    }

    public void modifyroomdetails() {

        final String hotelname = EditTexthotelname.getText().toString().trim();
        final String roomnumber = EditTextroomnumber.getText().toString().trim();
        final String roomtype = EditTextroomtype.getText().toString().trim();
        final String price = EditTextweekdayprice.getText().toString().trim();
        final String weekendprice = EditTextweekendprice.getText().toString().trim();
        final String totalnumberofrooms = EditTexttotalnumberofrooms.getText().toString().trim();
        final String availablerooms = EditTextavailablerooms.getText().toString().trim();
        final String unavailablerooms = EditTextunavailablerooms.getText().toString().trim();
        final String availability = EditTextavailability.getText().toString().trim();
        final String checkindate = EditTextcheckindate.getText().toString().trim();
        final String checkoutdate = EditTextcheckoutdate.getText().toString().trim();
        final String amenities = EditTextamenities.getText().toString().trim();
        final String hotelmanagercontact = EditTexthotelmanagercontact.getText().toString().trim();


        progressDialog.setMessage("Updating");
        progressDialog.show();

        StringRequest request = new StringRequest(Request.Method.POST, Constants.URL__MANAGER_MODIFY_ROOM, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(ManagerModifyRoomDetails.this,response,Toast.LENGTH_SHORT).show();
                /*startActivity(new Intent(ManagerModifyRoomDetails.this,GuestUpcomingList.class));*/
                progressDialog.dismiss();


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(ManagerModifyRoomDetails.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();
            }
        }) {


            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("hotel", hotelname);
                params.put("roomtype", roomtype);
                params.put("roomnumber", roomnumber);
                params.put("totalnumberofrooms", totalnumberofrooms);
                params.put("availablerooms", availablerooms);
                params.put("unavailablerooms", unavailablerooms);
                params.put("availability", availability);
                params.put("checkindate", checkindate);
                params.put("checkoutdate", checkoutdate);
                params.put("price", price);
                params.put("weekendprice", weekendprice);
                params.put("amenities", amenities);
                params.put("hotelmanagercontact", hotelmanagercontact);



                return params;
            }

        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);
    }



    @Override
    public void onClick(View view) {
        if(view == ModifyRoom){
            modifyroomdetails();

        }

    }
}