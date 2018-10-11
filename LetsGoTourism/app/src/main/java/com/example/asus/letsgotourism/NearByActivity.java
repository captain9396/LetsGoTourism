package com.example.asus.letsgotourism;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NearByActivity extends AppCompatActivity implements View.OnClickListener {


    Button coffeeButton;
    Button gasButton;
    Button hopitalButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_near_by);
        coffeeButton = (Button) findViewById(R.id.coffee_button);
        gasButton  = (Button) findViewById(R.id.gas_button);
        hopitalButton = (Button) findViewById(R.id.hospital_button);


        coffeeButton.setOnClickListener(this);
        gasButton.setOnClickListener(this);
        hopitalButton.setOnClickListener(this);
    }


    public void onClick(View view) {
        if (view == coffeeButton) startCoffeeActivity();
        else if (view == gasButton) startgasActivity();
        else if (view == hopitalButton) startHospitalActivity();
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
