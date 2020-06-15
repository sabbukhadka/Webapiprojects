package com.example.emi_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class EMImodel extends AppCompatActivity {
private EditText loan;

    public EMImodel(double loan, double rate, double month) {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e_m_imodel);
    }


    public double getLoan() {
    }

    public double getInterest() {
    }

    public double getNo_of_month() {
    }
}
