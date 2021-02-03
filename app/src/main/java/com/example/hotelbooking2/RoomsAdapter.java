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

public class RoomsAdapter extends ArrayAdapter<Rooms> {

    Context context;
    List<Rooms> arrayListRooms;
    public RoomsAdapter(@NonNull Context context, List<Rooms> arrayListRooms) {
        super(context, R.layout.custom_list_item,arrayListRooms);

        this.context = context;
        this.arrayListRooms = arrayListRooms;


    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_list_item,null,true);

       /* TextView ID = view.findViewById(R.id.ID_number);*/
        TextView Hotelname = view.findViewById(R.id.txt_hotel_name);
        TextView Price = view.findViewById(R.id.price);
        TextView Distance = view.findViewById(R.id.distance);
        TextView Amenities = view.findViewById(R.id.amenities);

      /*  ID.setText(arrayListRooms.get(position).getRoomId());*/
        Hotelname.setText(arrayListRooms.get(position).gethotel());
        Price.setText(arrayListRooms.get(position).getprice());
        Distance.setText(arrayListRooms.get(position).getdistance());
        Amenities.setText(arrayListRooms.get(position).getamenities());


        return view;
    }
}
