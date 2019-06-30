package com.ngangavictor.spinnerimage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

import com.ngangavictor.spinnerimage.adapter.CustomAdapter;

public class MainActivity extends AppCompatActivity {
    String[] countryNames;
    int[] countryFlags;
    Spinner spinner;
    Boolean isUserInteracting = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = findViewById(R.id.spinner);

        countryNames = new String[]{"Argentina","Burundi","Kenya,Tanzania","Uganda","Brazil","Canada","Germany"};
        countryFlags = new int[]{
          R.drawable.ar, R.drawable.bi,R.drawable.ke,R.drawable.tz,R.drawable.ug,R.drawable.br,R.drawable.ca,R.drawable.de
        };

        CustomAdapter customAdapter = new CustomAdapter(MainActivity.this,countryNames,countryFlags);
        spinner.setAdapter(customAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (isUserInteracting){
                Toast.makeText(MainActivity.this,countryNames[position],Toast.LENGTH_LONG).show();
            }}

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



    }

    @Override
    public void onUserInteraction() {
        super.onUserInteraction();
        isUserInteracting=true;
    }
}
