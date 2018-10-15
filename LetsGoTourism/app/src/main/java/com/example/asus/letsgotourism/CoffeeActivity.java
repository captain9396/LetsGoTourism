package com.example.asus.letsgotourism;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class CoffeeActivity extends AppCompatActivity {



    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef;



    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<PoliceItem> policeItemList;


    private TextView headlineTextView;
    private String cityName;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coffee);


        String comingFrom = getIntent().getStringExtra("FROM");



        myRef = database.getReference(comingFrom);
        headlineTextView = (TextView) findViewById(R.id.headline);
        if (comingFrom.equals("police")){
            headlineTextView.setText("Police Stations");
        }
        else if (comingFrom.equals("gas")){
            headlineTextView.setText("Filling Stations");
        }
        else if (comingFrom.equals("hospital")){
            headlineTextView.setText("Hospitals");
        }




        recyclerView = (RecyclerView) findViewById(R.id.police_list);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        policeItemList = new ArrayList<>();


        try {
            LocataionHandler l = new LocataionHandler(getApplicationContext());
            Location location = l.getLocation();
            if (location != null) {
                double latitude = location.getLatitude();
                double longitude = location.getLongitude();
                Geocoder geocoder = new Geocoder(this, Locale.getDefault());
                List<Address> addresses = geocoder.getFromLocation(latitude, longitude, 1);
                cityName = addresses.get(0).getAddressLine(0);
//                    String stateName = addresses.get(0).getAddressLine(1);
//                    String countryName = addresses.get(0).getAddressLine(2);
//                Toast.makeText(this, "Lat = " + latitude + "\n Long = " + longitude + "\n"+cityName, Toast.LENGTH_LONG).show();
            }
        }catch (Exception e){

        }



        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                HashMap<String, String> val = (HashMap) dataSnapshot.getValue();
                String text = "";
                policeItemList.clear();
                for (Map.Entry<String, String> entry : val.entrySet()){
                    text = entry.getValue();
                    String[] parts = {"", "", "", ""};
                    parts = text.split(" ");
                    PoliceItem policeItem = new PoliceItem(parts[0], parts[1], parts[2], parts[3]);
                    if (cityName.toLowerCase().contains(parts[0].toLowerCase())){
                        policeItemList.add(policeItem);
                    }

                }
                adapter = new PoliceAdapter(policeItemList, CoffeeActivity.this);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
}
