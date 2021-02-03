package com.example.hotelbooking2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class UsersAdapter extends ArrayAdapter<Users> {

    Context context;
    List<Users> arrayListUsers;
    public UsersAdapter(@NonNull Context context, List<Users> arrayListUsers) {
        super(context, R.layout.custom_list_item_admin_search,arrayListUsers);

        this.context = context;
        this.arrayListUsers = arrayListUsers;


    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_list_item_admin_search,null,true);

       /* TextView ID = view.findViewById(R.id.ID_number);*/
        TextView username = view.findViewById(R.id.username);
        TextView role = view.findViewById(R.id.Role);



      /*  ID.setText(arrayListRooms.get(position).getRoomId());*/
        username.setText(arrayListUsers.get(position).getusername());
        role.setText(arrayListUsers.get(position).getrole());





        return view;
    }
}
