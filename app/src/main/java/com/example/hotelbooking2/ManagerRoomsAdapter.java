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

public class ManagerRoomsAdapter extends ArrayAdapter<Rooms> {

    Context context;
    List<Rooms> arrayListRooms;
    public ManagerRoomsAdapter(@NonNull Context context, List<Rooms> arrayListRooms) {
        super(context, R.layout.custom_list_item_manager_rooms,arrayListRooms);

        this.context = context;
        this.arrayListRooms = arrayListRooms;


    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_list_item_manager_rooms,null,true);

        TextView RoomType = view.findViewById(R.id.roomtype);
        TextView NumberofRooms = view.findViewById(R.id.totalnumberofrooms);
        TextView Price = view.findViewById(R.id.price);



        RoomType.setText(arrayListRooms.get(position).getroomtype());
        NumberofRooms.setText(arrayListRooms.get(position).gettotalnumberofrooms());
        Price.setText(arrayListRooms.get(position).getprice());


        return view;
    }
}
