package com.example.loginui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Bundle bundle =getIntent().getExtras();


        if(bundle!=null){
        String msg =bundle.getString( "mesage");
            Toast.makeText(this," Message is:"+msg,Toast.LENGTH_LONG).show();
    }else{
            Toast.makeText(this,"No Message",Toast.LENGTH_LONG).show();
        }
}}
