package com.example.bmi_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView result;
    private EditText height, weight;
    private Button btncalculate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        weight = findViewById(R.id.weight);
        height = findViewById(R.id.height);
        result = findViewById(R.id.resultbmi);

        btncalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bmi();
            }
        });
    }

    private void bmi() {
        float c, d, e;
        c = Float.parseFloat(height.getText().toString()) / 100;
        d = Float.parseFloat(weight.getText().toString());
        e = c / (c * c);
        result.setText("" + c);

        if (c <= 18.8) {
            Toast.makeText(getApplicationContext(), "You are underweight", Toast.LENGTH_SHORT).show();
        } else if ((c >= 18.8) && (c < 25)) {
            Toast.makeText(getApplicationContext(), "You are Normal", Toast.LENGTH_SHORT).show();
        } else if (c >= 25) {
            Toast.makeText(getApplicationContext(), "You are Overweight", Toast.LENGTH_SHORT).show();
        }

    }
}
