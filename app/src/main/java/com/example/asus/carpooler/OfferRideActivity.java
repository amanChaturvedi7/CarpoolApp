/**
 * Copyright (c) 2016 Pooja, SriHarsha
 * This code is available under the "MIT License".
 * Please see the file LICENSE in this distribution
 * for license terms.
 */
package com.example.asus.carpooler;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class OfferRideActivity extends AppCompatActivity{


    private Button offerBtn;
    private AutoCompleteTextView srcEditText, destEditText;
    private EditText timeEditText, dateEditText, vehEditText;
    private DatabaseReference databaseRides;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offer_ride);

        srcEditText = findViewById(R.id.source_location_editText);
        destEditText = findViewById(R.id.destination_location_editText);
        timeEditText = findViewById(R.id.time_editText);
        dateEditText = findViewById(R.id.date_editText);
        vehEditText = findViewById(R.id.vehicle_editText);

        databaseRides = FirebaseDatabase.getInstance().getReference("Rides");

        offerBtn = findViewById(R.id.offer_ride_details_btn);
        offerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addRide();
            }
        });
    }

    private void addRide() {
        String src = srcEditText.getText().toString();
        String dest = destEditText.getText().toString();
        String time = timeEditText.getText().toString();
        String date = dateEditText.getText().toString();
        String veh = vehEditText.getText().toString();
        String id = databaseRides.push().getKey();

        RideInfo rideInfo = new RideInfo(id, src, dest, time, date, veh);

        databaseRides.child(id).setValue(rideInfo);

        Toast.makeText(this, "Ride Added", Toast.LENGTH_SHORT).show();

    }
}


