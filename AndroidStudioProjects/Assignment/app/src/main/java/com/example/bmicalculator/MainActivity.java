package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button BMI, EMI, calculator;
// private TextView   result;
// private EditText height, weight;
// private Button btncalculate;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BMI = findViewById(R.id.Bmi);
        EMI = findViewById(R.id.btnEmi);
        calculator = findViewById(R.id.calculatorapp);

        BMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(MainActivity.this, bmi_calculator.class);
                startActivity(in);
            }
        });

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

//        weight =findViewById(R.id.weight);
//
//        height =findViewById(R.id.height);
//        result = findViewById(R.id.result);
//
//
//
//        }
//    public void openCalculator(){
//        Intent intent = new Intent(this, Calculator.class);
//        startActivity(intent);
//
//    }
//btncalculate.setOnClickListener(new View.OnClickListener() {
//    @Override
//    public void onClick(View v) {
//float weight = Float.parseFloat((weight.getText().To) )
//    }
//});

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

    }
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
        }*/

    /*}*/
}
