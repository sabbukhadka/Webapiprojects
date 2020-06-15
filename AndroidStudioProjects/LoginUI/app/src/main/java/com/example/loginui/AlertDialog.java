package com.example.loginui;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class AlertDialog extends AppCompatActivity
      implements  DatePickerDialog.OnDateSetListener
{
    Button close;


   Spinner sCountry;
//AutoCompleteTextView sCountry;//  for androidautocompletetextview
    private TextView tvDOB;
    private  Button open;
androidx.appcompat.app.AlertDialog.Builder builder;

    private String[] languages={
            "C","C#","reactjs"," Java", " python"," Ruby", "ASP.net"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_dialog);

//        tvDOB =findViewById(R.id.tvDOB);
//        tvDOB.setOnClickListener(new View.OnClickListener() {
//                                     @Override
//                                     public void onClick(View v) {
//
//                                     }
//                                 });
//        private void loadDatePicker(){
//            final Calendar c= Calendar.getInstance();
//            int year =c.get(Calendar.YEAR);
//            int month =c.get(Calendar.MONTH);
//            int day =c.get(Calendar.DAY_OF_MONTH);
//            DatePickerDialog datePickerDialog = new DatePickerDialog(
//                    this,
//                    this, year, month, day
//            )
//            datePickerDialog.show();
//        }
/*android autocompletetextview code to  populate string array*/
//        sCountry=findViewById(R.id.actv);
//        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<>(
//                this,
//                android.R.layout.select_dialog_item,
//                languages
//        );
//        sCountry.setAdapter(stringArrayAdapter);
//        sCountry.setThreshold(1);// WILL START FROM 1ST CHARACTER

        sCountry=findViewById(R.id.country);
        open = findViewById(R.id.btnopen);

        open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AlertDialog.this,SecondActivity.class);
intent.putExtra("message","this is message from first activity");

                startActivity(intent);
            }
        });

   String countries[]={"Nepal","Austria", "Bali","Spain", " UK"};
        ArrayAdapter adapter= new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                countries
        );
        sCountry.setAdapter(adapter);
        sCountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String count = sCountry.getSelectedItem().toString();
             Toast.makeText(AlertDialog.this,"you  have selected:"+count,Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                System.out.println("no item selected");
            }
        });
//        sCountry.setOnItemClickListener(new AdapterView.OnItemSelectedListener() {
//                                            @Override
//                                            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                                                String count = sCountry.getSelectedItem().toString();
//                                                Toast.makeText(AlertDialog.this,"you  have selected:"+count,Toast.LENGTH_LONG).show();
//                                            }
//
//                                            @Override
//                                            public void onNothingSelected(AdapterView<?> parent) {
//System.out.println("no item selected");
//                                            }
//                                        });


        close= findViewById(R.id.alert);
        builder= new  androidx.appcompat.app.AlertDialog.Builder(this);

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder.setMessage("are you sure")
                        .setPositiveButton("Yes ", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();// completes the lifecycle of activity and closes the app
                                Toast.makeText(getApplicationContext(),"You have to clicked yes button", Toast.LENGTH_LONG).show();

                            }
                        })
                        .setNegativeButton(" No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //action for no button
                                dialog.cancel();
                                Toast.makeText(getApplicationContext(),"You have to clicked No button", Toast.LENGTH_LONG).show();
                            }
                        });
                //creating or displaying alert dialog
                androidx.appcompat.app.AlertDialog alert =builder.create();
                alert.setTitle("Alert example");
                alert.setIcon(R.drawable.ic_launcher_background);
                alert.show();


            }
        });




    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
String date="DAY/MONTH/YEAR:"+month+ "/"+dayOfMonth+ "/"+year+"/";
    }
}
