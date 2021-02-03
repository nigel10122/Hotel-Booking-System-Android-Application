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

public class AdminSearchForManager extends AppCompatActivity implements View.OnClickListener{

    private Button SearchForUser;
    ListView listView;
    private ProgressDialog progressDialog;
    private EditText editTextSearchForUser;
    UsersAdapter adapter;
    public static ArrayList<Users> usersarraylist = new ArrayList<>();

    Users users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_searchuser_filter_manager);


        SearchForUser = (Button) findViewById(R.id.SearchForUser);

        editTextSearchForUser = (EditText) findViewById(R.id.SearchForUserLastname);
        editTextSearchForUser.setOnClickListener(this);

        listView = findViewById(R.id.myListView);
        adapter = new UsersAdapter(this,usersarraylist);
        listView.setAdapter(adapter);
        SearchForUser.setOnClickListener(this);

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please wait...");

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {

                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                ProgressDialog progressDialog = new ProgressDialog(view.getContext());

                CharSequence[] dialogItem = {"View Details","Delete User"};
                builder.setTitle(usersarraylist.get(position).getusername());
                builder.setItems(dialogItem, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        switch (i){

                            case 0 :
                                startActivity(new Intent(getApplicationContext(),AdminViewManager.class).putExtra("position",position));

                                break;


                                case 1:

                                startActivity(new Intent(getApplicationContext(),AdminDeleteManager.class).putExtra("position",position));

                                break;


                        }

                    }
                });

                builder.create().show();


            }
        });
    }

    public void adminsearchforuser() {


        final String lastname = editTextSearchForUser.getText().toString();

        progressDialog.show();
        StringRequest request = new StringRequest(Request.Method.POST, Constants.URL__ADMIN_SEARCH_MANAGER, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                progressDialog.dismiss();
                usersarraylist.clear();
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    String success = jsonObject.getString("success");
                    JSONArray jsonArray = jsonObject.getJSONArray("manager");

                    if (success.equals("1")) {
                        for (int i = 0; i < jsonArray.length(); i++) {

                            JSONObject object = jsonArray.getJSONObject(i);

                            String id = object.getString("id");
                            String username = object.getString("username");
                            String email = object.getString("email");
                            String lastname = object.getString("lastname");
                            String firstname = object.getString("firstname");
                            String number = object.getString("number");
                            String address = object.getString("address");
                            String role = object.getString("role");


                            users = new Users(id, username, email, lastname, firstname, number, address,role);
                            usersarraylist.add(users);
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
                Toast.makeText(AdminSearchForManager.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }) {


            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("lastname", lastname);


                return params;

            }

        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);
    }

    @Override
    public void onClick(View view) {
        if (view == SearchForUser)
            adminsearchforuser();
    }

}

