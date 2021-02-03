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

public class ManagerReservationsAdapter extends ArrayAdapter<Reservations> {

    Context context;
    List<Reservations> arrayListReservations;
    public ManagerReservationsAdapter(@NonNull Context context, List<Reservations> arrayListReservations) {
        super(context, R.layout.custom_list_item_manager_reservations,arrayListReservations);

        this.context = context;
        this.arrayListReservations = arrayListReservations;


    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_list_item_manager_reservations,null,true);


        TextView Firstname = view.findViewById(R.id.First_name);
        TextView Roomtype = view.findViewById(R.id.Room_type);
        TextView CheckinDate = view.findViewById(R.id.check_in_date);



        Firstname.setText(arrayListReservations.get(position).getfirstname());
        Roomtype.setText(arrayListReservations.get(position).getroomtype());
        CheckinDate.setText(arrayListReservations.get(position).getcheckindate());



        return view;
    }
}
