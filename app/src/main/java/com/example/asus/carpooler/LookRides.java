package com.example.asus.carpooler;

import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class LookRides extends AppCompatActivity {

    private static final String TAG = "ViewRidesDatabase";

    private ListView listViewRides;
    private DatabaseReference databaseRides;
    private ArrayList<RideInfo> rideList;
    private Toolbar lookRidesToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_look_rides);

        lookRidesToolbar = findViewById(R.id.available_rides_toolbar);
        setSupportActionBar(lookRidesToolbar);
        getSupportActionBar().setTitle("Available Rides");

        databaseRides = FirebaseDatabase.getInstance().getReference("Rides");

        listViewRides = findViewById(R.id.listViewRides);
        rideList = new ArrayList<>();

    }

    @Override
    protected void onStart() {
        super.onStart();

        databaseRides.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                rideList.clear();
                showData(dataSnapshot);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private void showData(DataSnapshot dataSnapshot) {
        for(DataSnapshot ds : dataSnapshot.getChildren()){
            RideInfo ride = ds.getValue(RideInfo.class);
            rideList.add(0, ride);
        }

        RideList adapter = new RideList(LookRides.this, rideList);
        listViewRides.setAdapter(adapter);
    }
}
