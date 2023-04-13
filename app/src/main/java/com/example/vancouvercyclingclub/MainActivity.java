package com.example.vancouvercyclingclub;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner spinnerCities=findViewById(R.id.cities);
        ArrayAdapter<CharSequence>adapter=ArrayAdapter.createFromResource(this, R.array.cities, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinnerCities.setAdapter(adapter);
        Button computeCostButton = findViewById(R.id.computeCost);
        computeCostButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText editText = findViewById(R.id.numberOfAthletes);
                TextView textView = findViewById(R.id.resultText);
                Spinner spinner = (Spinner)findViewById(R.id.cities);

                String city = spinner.getSelectedItem().toString();

                Integer athletes = Integer.parseInt(editText.getText().toString());

                if(!athletes.equals("")) {
                   Integer totalFees = (int)(athletes * 725) ;
                    textView.setText(String.valueOf(city) +" race team fee is $"+String.valueOf(totalFees));
                }
                else {
                    textView.setText("You didn't enter any value!");
                }


            }
        });

    }


}