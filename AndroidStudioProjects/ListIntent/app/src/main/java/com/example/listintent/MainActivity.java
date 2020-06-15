package com.example.listintent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    public static final String country[]={
            "Nepal",
            "USA",
            "UK",
            "Bhutan",
            "Itlay",
            "Canada"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView countries = findViewById(R.id.countries);

        ArrayAdapter countryAdapter= new ArrayAdapter<>(
                this, // kunactivity ma dekaaune
                android.R.layout.simple_list_item_1,
                country

        );
        countries.setAdapter(countryAdapter); //cursor adapter

        HashMap<String,String> capitalcity = new HashMap<>();
        capitalcity.put("Nepal","Kathmandu");
        capitalcity.put("USA","Washington DC");
        capitalcity.put("Uk","London");
        capitalcity.put("Bhutan","Thimpu");
//        capitalcity.put("Itlay","Rome");
//        capitalcity.put("Canada","Ottawa");
//        System.out.println("oncreate method running");

//        Log.d(TAG, "Countries and Capitals:"+capitalcity);
       Log.i(TAG," oncreated method running");

    }
}
