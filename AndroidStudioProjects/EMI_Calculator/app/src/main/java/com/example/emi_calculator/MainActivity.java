package com.example.emi_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
EditText interest, no_of_month, result, loanamount;
Button calculate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        interest = findViewById(R.id.);
        no_of_month =findViewById(R.id.monthly);
        result = findViewById(R.id.result);
         calculate = findViewById(R.id.btncalc);
         calculate.setOnClickListener((View)-> {calculateEMI () }) ;
    }
     private     void calculateEMI(){

        double loan = Double.parseDouble(loanamount.getText().toString());
         double rate = Double.parseDouble(interest.getText().toString());
         double month = Double.parseDouble(no_of_month.getText().toString());

         EMImodel emimodel = new  EMImodel (loan,rate, month);
         double p = emimodel.getLoan();
         double r =emimodel.getInterest()/12/100;
         double n =emimodel.getNo_of_month();
         double resultemi = p*r*Math.pow(1+ r,n)/ (Math.pow(1+ r,n) -1);
         String output = String.format("0.2f", resultemi);
         result.setText("RS:" +output);


     }
}
