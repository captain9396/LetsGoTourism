package com.example.asus.letsgotourism;

import android.Manifest;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.Locale;

public class NearByActivity extends AppCompatActivity implements View.OnClickListener {


    Button coffeeButton;
    Button gasButton;
    Button hopitalButton;


    TextView locationTextView;
    Button locationButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_near_by);
        coffeeButton = (Button) findViewById(R.id.coffee_button);
        gasButton  = (Button) findViewById(R.id.gas_button);
        hopitalButton = (Button) findViewById(R.id.hospital_button);

        ActivityCompat.requestPermissions(NearByActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 123);
        locationButton = (Button) findViewById(R.id.location_button);







        coffeeButton.setOnClickListener(this);
        gasButton.setOnClickListener(this);
        hopitalButton.setOnClickListener(this);
        locationButton.setOnClickListener(this);
    }


    public void onClick(View view) {
        if (view == coffeeButton) startCoffeeActivity();
        else if (view == gasButton) startgasActivity();
        else if (view == hopitalButton) startHospitalActivity();
        else if (view == locationButton){
            try {
                LocataionHandler l = new LocataionHandler(getApplicationContext());
                Location location = l.getLocation();
                if (location != null) {
                    double latitude = location.getLatitude();
                    double longitude = location.getLongitude();
                    Geocoder geocoder = new Geocoder(this, Locale.getDefault());
                    List<Address> addresses = geocoder.getFromLocation(latitude, longitude, 1);
                    String cityName = addresses.get(0).getAddressLine(0);
                    Toast.makeText(this, "Lat = " + latitude + "\n Long = " + longitude + "\n"+cityName, Toast.LENGTH_LONG).show();
                }
            }catch (Exception e){

            }
        }
    }


    private void startCoffeeActivity(){
        Intent myIntent = new Intent(this, CoffeeActivity.class);
        myIntent.putExtra("FROM",  "police");
        startActivity(myIntent);
    }

    private void startgasActivity(){
        Intent myIntent = new Intent(this, CoffeeActivity.class);
        myIntent.putExtra("FROM",  "gas");
        startActivity(myIntent);
    }


    private void startHospitalActivity(){
        Intent myIntent = new Intent(this, CoffeeActivity.class);
        myIntent.putExtra("FROM",  "hospital");
        startActivity(myIntent);
    }
}
