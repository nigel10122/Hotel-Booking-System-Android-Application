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

public class ReservationsAdapter extends ArrayAdapter<Reservations> {

    Context context;
    List<Reservations> arrayListReservations;
    public ReservationsAdapter(@NonNull Context context, List<Reservations> arrayListReservations) {
        super(context, R.layout.custom_list_item_reservations,arrayListReservations);

        this.context = context;
        this.arrayListReservations = arrayListReservations;


    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_list_item_reservations,null,true);


        TextView Hotelname = view.findViewById(R.id.txt_hotel_name);
        TextView CheckinDate = view.findViewById(R.id.checkindate);



        Hotelname.setText(arrayListReservations.get(position).gethotel());
        CheckinDate.setText(arrayListReservations.get(position).getcheckindate());



        return view;
    }
}
