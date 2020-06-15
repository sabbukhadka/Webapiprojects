package com.example.firstassignments;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Calculator extends AppCompatActivity {
    private Button zero;
    private Button one;
    private Button two;
    private Button three;
    private Button four;
    private Button five;
    private Button six;
    private Button seven;
    private Button eight;
    private Button nine;
    private Button add;
    private Button sub;
    private Button mul;
    private Button div;
    private Button equal;
    private Button clear;
    private TextView calculateTextView;
    private TextView result;
    private final char ADDITION = '+';
    private final char SUBTRACTION = '-';
    private final char MULTIPLICATION = '*';
    private final char DIVISION = '/';
    private final char EQU = 0;
    private double val1= Double.NaN;
    private double val2;
    private char ACTION;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);



        setupUIViews();

        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateTextView.setText(calculateTextView.getText().toString() + "0");
            }
        });

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateTextView.setText(calculateTextView.getText().toString() + "1");
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateTextView.setText(calculateTextView.getText().toString() + "2");
            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateTextView.setText(calculateTextView.getText().toString() + "3");
            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateTextView.setText(calculateTextView.getText().toString() + "4");
            }
        });

        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateTextView.setText(calculateTextView.getText().toString() + "5");
            }
        });

        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateTextView.setText(calculateTextView.getText().toString() + "6");
            }
        });

        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateTextView.setText(calculateTextView.getText().toString() + "7");
            }
        });

        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateTextView.setText(calculateTextView.getText().toString() + "8");
            }
        });

        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateTextView.setText(calculateTextView.getText().toString() + "9");
            }
        });

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                ACTION = SUBTRACTION;
                result.setText(String.valueOf(val1) + "-");
                calculateTextView.setText(null);
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                ACTION = ADDITION;
                result.setText(String.valueOf(val1) + "+");
                calculateTextView.setText(null);
            }
        });

        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                ACTION = MULTIPLICATION;
                result.setText(String.valueOf(val1) + "*");
                calculateTextView.setText(null);
            }
        });

        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                ACTION = DIVISION;
                result.setText(String.valueOf(val1) + "/");
                calculateTextView.setText(null);
            }
        });

        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                ACTION = EQU;
                result.setText(result.getText().toString() + String.valueOf(val2) + "=" + String.valueOf(val1));
                // 5 + 4 = 9
                calculateTextView.setText(null);
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(calculateTextView.getText().length() > 0){
                    CharSequence name = calculateTextView.getText().toString();
                    calculateTextView.setText(name.subSequence(0, name.length()-1));
                }
                else{
                    val1 = Double.NaN;
                    val2 = Double.NaN;
                    calculateTextView.setText(null);
                    result.setText(null);
                }
            }
        });

    }

    private void setupUIViews(){

        one = (Button)findViewById(R.id.btn1);
        zero = (Button)findViewById(R.id.btn0);
        two = (Button)findViewById(R.id.btn2);
        three = (Button)findViewById(R.id.btn3);
        four = (Button)findViewById(R.id.btn4);
        five = (Button)findViewById(R.id.btn5);
        six = (Button)findViewById(R.id.btn6);
        seven = (Button)findViewById(R.id.btn7);
        eight = (Button)findViewById(R.id.btn8);
        nine = (Button)findViewById(R.id.btn9);
        add = (Button)findViewById(R.id.btnadd);
        sub = (Button)findViewById(R.id.btnsub);
        mul = (Button)findViewById(R.id.btnmul);
        div = (Button)findViewById(R.id.btndivide);
        equal = (Button)findViewById(R.id.btnequal);
        calculateTextView = (TextView)findViewById(R.id.tvControl);
        result = (TextView)findViewById(R.id.tvResult);
        clear = (Button)findViewById(R.id.btnclear);
    }

    private void compute(){
        if(!Double.isNaN(val1)){
            val2 = Double.parseDouble(calculateTextView.getText().toString());

            switch(ACTION){
                case ADDITION:
                    val1 = val1 + val2;
                    break;
                case SUBTRACTION:
                    val1 = val1 - val2;
                    break;
                case MULTIPLICATION:
                    val1 = val1 * val2;
                    break;
                case DIVISION:
                    val1 = val1 / val2;
                    break;
                case EQU:
                    break;
            }
        }
        else{
            val1 = Double.parseDouble(calculateTextView.getText().toString());
        }
    }
}







//        button0 = (Button) findViewById(R.id.button0);
//        button1 = (Button) findViewById(R.id.button1);
//        button2 = (Button) findViewById(R.id.button2);
//        button3 = (Button) findViewById(R.id.button3);
//        button4 = (Button) findViewById(R.id.button4);
//        button5 = (Button) findViewById(R.id.button5);
//        button6 = (Button) findViewById(R.id.button6);
//        button7 = (Button) findViewById(R.id.button7);
//        button8 = (Button) findViewById(R.id.button8);
//        button9 = (Button) findViewById(R.id.button9);
//        button10 = (Button) findViewById(R.id.button10);
//        buttonAdd = (Button) findViewById(R.id.buttonadd);
//        buttonSub = (Button) findViewById(R.id.buttonsub);
//        buttonMul = (Button) findViewById(R.id.buttonmul);
//        buttonDivision = (Button) findViewById(R.id.buttondiv);
//        buttonC = (Button) findViewById(R.id.buttonC);
//        buttonEqual = (Button) findViewById(R.id.buttoneql);
//        calculatorEditText = (EditText) findViewById(R.id.edt1);

//        button1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                calculatorEditText.setText(calculatorEditText.getText() + "1");
//            }
//        });
//
//
//
//        button2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                calculatorEditText.setText(calculatorEditText.getText() + "2");
//            }
//        });
//
//        button3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                calculatorEditText.setText(calculatorEditText.getText() + "3");
//            }
//        });
//
//        button4.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                calculatorEditText.setText(calculatorEditText.getText() + "4");
//            }
//        });
//
//        button5.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                calculatorEditText.setText(calculatorEditText.getText() + "5");
//            }
//        });
//
//        button6.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                calculatorEditText.setText(calculatorEditText.getText() + "6");
//            }
//        });
//
//        button7.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                calculatorEditText.setText(calculatorEditText.getText() + "7");
//            }
//        });
//
//        button8.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                calculatorEditText.setText(calculatorEditText.getText() + "8");
//            }
//        });
//
//        button9.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                calculatorEditText.setText(calculatorEditText.getText() + "9");
//            }
//        });
//
//        button0.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                calculatorEditText.setText(calculatorEditText.getText() + "0");
//            }
//        });
//
//        buttonAdd.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                if (calculatorEditText == null) {
//                    calculatorEditText.setText("");
//                } else {
//                    mValueOne = Float.parseFloat(calculatorEditText.getText() + "");
//                    calculatorAddition = true;
//                    calculatorEditText.setText(null);
//                }
//            }
//        });
//
//        buttonSub.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mValueOne = Float.parseFloat(calculatorEditText.getText() + "");
//                mSubtract = true;
//                calculatorEditText.setText(null);
//            }
//        });
//
//        buttonMul.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mValueOne = Float.parseFloat(calculatorEditText.getText() + "");
//                calculatorMultiplication = true;
//                calculatorEditText.setText(null);
//            }
//        });
//
//        buttonDivision.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mValueOne = Float.parseFloat(calculatorEditText.getText() + "");
//                calculatorDivision = true;
//                calculatorEditText.setText(null);
//            }
//        });
//
//        buttonEqual.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mValueTwo = Float.parseFloat(calculatorEditText.getText() + "");
//
//                if (calculatorAddition == true) {
//                    calculatorEditText.setText(mValueOne + mValueTwo + "");
//                    calculatorAddition = false;
//                }
//
//                if (mSubtract == true) {
//                    calculatorEditText.setText(mValueOne - mValueTwo + "");
//                    mSubtract = false;
//                }
//
//                if (calculatorMultiplication == true) {
//                    calculatorEditText.setText(mValueOne * mValueTwo + "");
//                    calculatorMultiplication = false;
//                }
//
//                if (calculatorDivision == true) {
//                    calculatorEditText.setText(mValueOne / mValueTwo + "");
//                    calculatorDivision = false;
//                }
//            }
//        });
//
//        buttonC.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                calculatorEditText.setText("");
//            }
//        });
//
//        button10.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                calculatorEditText.setText(calculatorEditText.getText() + ".");
//            }
//        });

