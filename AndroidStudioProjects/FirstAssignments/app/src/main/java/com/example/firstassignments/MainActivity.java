package com.example.firstassignments;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button BMI, EMI, calculator;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BMI = findViewById(R.id.btnBmi);
        EMI = findViewById(R.id.btnEmi);
        calculator = findViewById(R.id.calculatorapp);


        EMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new  Intent (MainActivity.this,emi_calculator.class);
                startActivity(in);
            }
        });

        calculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new  Intent (MainActivity.this,Calculator.class);
                startActivity(in);

            }
        });
        BMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(MainActivity.this, bmi_calculator.class);
                startActivity(in);
            }
        });

    }
}
