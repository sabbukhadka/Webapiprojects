package com.example.firstassignments;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class bmi_calculator extends AppCompatActivity {
    private TextView txtbmi;
    private EditText txtheight, txtweight;
    private Button btncalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi_calculator);


        txtweight = findViewById(R.id.weight);
        txtheight = findViewById(R.id.height);
        btncalculate =findViewById(R.id.btnbmi);
        txtbmi = findViewById(R.id.resultbmi);

        btncalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bmi();
            }
        });
    }


    private void bmi() {
//        float heightvalue, weightvalue, answer;
        float heightvalue = Float.parseFloat(txtheight.getText().toString()) ;
        float weightvalue = Float.parseFloat(txtweight.getText().toString());

       float answer = weightvalue / (heightvalue * heightvalue);
        txtbmi.setText(String.valueOf(answer));
        if(answer < 18.5) {
            txtbmi.setText("Your BMI:"+answer+" \nunderweight ");


        } else if ((answer < 18.5) && (answer <= 24.5)) {
            txtbmi.setText("Your BMI:"+answer+" \nNormalweight ");


        } else if (answer <24.5   && answer<=29.9){
            txtbmi.setText("Your BMI:"+answer+" \nOverweight ");


        }

    }
}















//    btncalculate.setOnClickListener(new View.OnClickListener() {
//        @Override
//        public void onClick(View v) {
//            calculateBMI(v);
//        }
//    });

//    }

// Toast.makeText(bmi_calculator.this, "You are underweight", Toast.LENGTH_SHORT).show();
//         Toast.makeText(bmi_calculator.this, "You are Normal/ Healthy", Toast.LENGTH_SHORT).show();
//         Toast.makeText(bmi_calculator.this, "You are Overweight", Toast.LENGTH_SHORT).show();
//txtbmi.setText("Your BMI:"+txtbmi+" \nUnder weight ");
//        txtbmi.setText("Your BMI:"+txtbmi+" \nNormal weight ");
//        txtbmi.setText("Your BMI:"+txtbmi+" \nOver weight ");
//    public void calculateBMI(View v) {
//String heightStr = height.getText().toString();
//        String weightStr = weight.getText().toString();
//        if (heightStr!=null && !"".equals(heightStr)
//        && weightStr !=null && !"".equals(weightStr)){
//            float  heightvalue = Float.parseFloat(heightStr) /100;
//            float    weightvalue = Float.parseFloat(weightStr);
//            float bmi = weightvalue/(heightvalue* heightvalue);
//            displayBMI(bmi);
//
//
//        }
//
//    }
//    private  void displayBMI(float bmi){
//        String bmilabel = "";
//        if (Float.compare(bmi, 15f) <= 0) {
//            bmilabel = getString(R.string.very_severely_underweight);
//        }else if (Float.compare(bmi, 15f) >0 && Float.compare(bmi, 16f) <=0) {
//            bmilabel = getString(R.string.severely_underweight);
//        }else if (Float.compare(bmi, 16f) >0 && Float.compare(bmi, 18.5f) <=0){
//            bmilabel = getString(R.string.underweight);
//
//        }
//        else if (Float.compare(bmi, 18.5f) >0 && Float.compare(bmi, 25f) <=0){
//            bmilabel = getString(R.string.normal);
//
//        }
//        else if (Float.compare(bmi, 25f) >0 && Float.compare(bmi, 30f) <=0){
//            bmilabel = getString(R.string.overweight);
//
//        }
//        else if (Float.compare(bmi, 30f) >0 && Float.compare(bmi, 35f) <=0){
//            bmilabel = getString(R.string.obese_class_i);
//
//        }
//        else if (Float.compare(bmi, 35f) >0 && Float.compare(bmi, 40f) <=0){
//            bmilabel = getString(R.string.obese_class_ii);
//
//        }else {
//            bmilabel = getString(R.string.obese_class_iii);
//        }
//        bmilabel =bmi + "\n\n" +bmilabel;
//        result.setText(bmilabel);


         //   }
/*    private void CalculateBMI(){
        float    weight = Float.parseFloat((weight.().Tostring()));
        float    height = Float.parseFloat((weight.getText().Tostring()));
        BMImodel bmi = new  BMImodel(weight, height);
        float result = bmim.getWeight() .(bmim.getHeight() *bmim.getHeiht());
        if (result<10.5){
            txtBMI.setText("Your BMI:"+result+" \nunderweight ");

        }
       else if (result<10.5  && result<=24.9 ){
            txtBMI.setText("Your BMI:"+result+" \nNormal weight ");
            Toast.makeText(MainActivity. this, "Normal weight", Toast.LENGTH_LONG).show();
        }
        else if (result<25  && result<=29.9 ){
            txtBMI.setText("Your BMI:"+result+" \nOver weight ");
            Toast.makeText(MainActivity. this, "Overweight", Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(MainActivity. this, "correct your vale", Toast.LENGTH_LONG).show();
        }*/ //if (answer < 18.5) {
//        txtbmi.setText("Your BMI:"+txtbmi+" \nUnder weight ");
//        Toast.makeText(bmi_calculator.this, "You are underweight", Toast.LENGTH_SHORT).show();
////            Toast.makeText(getApplicationContext(), "You are underweight", Toast.LENGTH_SHORT).show();
//        } else if ((answer < 18.5) && (answer <= 24.5)) {
//        txtbmi.setText("Your BMI:"+txtbmi+" \nNormal ");
//        Toast.makeText(bmi_calculator.this, "You are Normal/ Healthy", Toast.LENGTH_SHORT).show();
////            Toast.makeText(getApplicationContext(), "You are Normal/ Healthy", Toast.LENGTH_SHORT).show();
//        } else if (answer <25   && answer<=29.9) {
//        txtbmi.setText("Your BMI:"+txtbmi+" \nUnder weight ");
//        Toast.makeText(bmi_calculator.this, "You are Overweight", Toast.LENGTH_SHORT).show();
//            Toast.makeText(getApplicationContext(), "You are Overweight", Toast.LENGTH_SHORT).show();

/*}*/