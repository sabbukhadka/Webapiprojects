package com.example.assignment_bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
private EditText height, weight;
private TextView result;
private Button btnbmi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        weight = findViewById(R.id.weight);
        height = findViewById(R.id.height);
        result = findViewById(R.id.answer);
        btnbmi = findViewById(R.id.btncalculate);
        btnbmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateBMI();
            }
        });
    }
        public void calculateBMI() {
            String heightStr = height.getText().toString();
            String weightStr = weight.getText().toString();

            if (heightStr != null && !"".equals(heightStr)
                    && weightStr != null && !"".equals(weightStr)) {
                float heightvalue = Float.parseFloat(heightStr) / 100;
                float weightvalue = Float.parseFloat(weightStr);
                float bmi = weightvalue / (heightvalue * heightvalue);
                displayBMI(bmi);


            }

        }

        private void displayBMI(float bmi) {
            String bmilabel = "";
            if (Float.compare(bmi, 15f) <= 0) {
                bmilabel = getString(R.string.very_severely_underweight);
            } else if (Float.compare(bmi, 15f) > 0 && Float.compare(bmi, 16f) <= 0) {
                bmilabel = getString(R.string.severely_underweight);
            } else if (Float.compare(bmi, 16f) > 0 && Float.compare(bmi, 18.5f) <= 0) {
                bmilabel = getString(R.string.underweight);

            } else if (Float.compare(bmi, 18.5f) > 0 && Float.compare(bmi, 25f) <= 0) {
                bmilabel = getString(R.string.normal);

            } else if (Float.compare(bmi, 25f) > 0 && Float.compare(bmi, 30f) <= 0) {
                bmilabel = getString(R.string.overweight);

            } else if (Float.compare(bmi, 30f) > 0 && Float.compare(bmi, 35f) <= 0) {
                bmilabel = getString(R.string.obese_class_i);

            } else if (Float.compare(bmi, 35f) > 0 && Float.compare(bmi, 40f) <= 0) {
                bmilabel = getString(R.string.obese_class_ii);

            } else {
                bmilabel = getString(R.string.obese_class_iii);
            }
            bmilabel = bmi + "\n\n" + bmilabel;
            result.setText(bmilabel);

//        btnbmi.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                bmi();
//            }
//        });
//    }
//    private void bmi() {
//        float c, d, e;
//        c = Float.parseFloat(height.getText().toString()) / 100;
//        d = Float.parseFloat(weight.getText().toString());
//        e = c / (c * c);
//        result.setText("" + c);
//
//        if (c <= 18.8) {
//            Toast.makeText(getApplicationContext(), "You are underweight", Toast.LENGTH_SHORT).show();
//        } else if ((c >= 18.8) && (c < 25)) {
//            Toast.makeText(getApplicationContext(), "You are Normal", Toast.LENGTH_SHORT).show();
//        } else if (c >= 25) {
//            Toast.makeText(getApplicationContext(), "You are Overweight", Toast.LENGTH_SHORT).show();
//        }
}}
