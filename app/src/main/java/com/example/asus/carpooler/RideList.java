package com.example.asus.carpooler;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class RideList extends ArrayAdapter<RideInfo> {
    private Activity context;
    private List<RideInfo> rideList;

    public RideList(Activity context, List<RideInfo> rideList){
        super(context, R.layout.list_layout, rideList);
        this.context = context;
        this.rideList = rideList;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();

        View listViewItem = inflater.inflate(R.layout.list_layout, null, true);

        TextView textViewSrc = listViewItem.findViewById(R.id.textViewSrc);
        TextView textViewDest = listViewItem.findViewById(R.id.textViewDest);
        TextView textViewDate = listViewItem.findViewById(R.id.textViewDate);
        TextView textViewTime = listViewItem.findViewById(R.id.textViewTime);
        TextView textViewVeh = listViewItem.findViewById(R.id.textViewVeh);

        RideInfo rideInfo = rideList.get(position);
        textViewSrc.setText(rideInfo.getSrc());
        textViewDest.setText(rideInfo.getDest());
        textViewDate.setText(rideInfo.getDate());
        textViewTime.setText(rideInfo.getTime());
        textViewVeh.setText(rideInfo.getVeh());

        return listViewItem;
    }
}
