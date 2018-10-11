package com.example.asus.letsgotourism;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import java.util.Hashtable;


public class Homepage extends AppCompatActivity implements View.OnClickListener {

    private Button nearbyButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        //Remove title bar

        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

//Remove notification bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_homepage);


        nearbyButton = (Button) findViewById(R.id.nearby_button);
        nearbyButton.setOnClickListener(this);

    }


    public void onClick(View view) {
        if (view == nearbyButton) startNearbyActivity();
    }


    private void startNearbyActivity(){
        Intent myIntent = new Intent(this, NearByActivity.class);
        startActivity(myIntent);
    }


}
