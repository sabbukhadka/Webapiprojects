package com.example.loginui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RelativeLayout extends AppCompatActivity implements View.OnClickListener {
EditText username, password;
Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relative_layout);
        username= findViewById(R.id.username);
        password=findViewById(R.id.etpwd);
        submit=findViewById(R.id.btnclick);
        submit.setOnClickListener(this);
//        submit.setOnClickListener(new View.OnClickListener() {
//                              @Override
//                              public void onClick(View v) {
//String  user = username.getText().toString();
//                                  Toast toast= Toast.makeText(RelativeLayout.this, "Your username is:"+user,Toast.LENGTH_LONG);
//                                  toast.show();
//
//                                  toast.setGravity
//                                          ( Gravity.TOP|Gravity.CENTER, 0,0);
//                              }
//                          });


    }

    @Override
    public void onClick(View v) {
        String  user = username.getText().toString();
        Toast toast= Toast.makeText(RelativeLayout.this, "Your username is:"+user,Toast.LENGTH_LONG);
        toast.show();

        toast.setGravity
                ( Gravity.TOP|Gravity.CENTER, 0,0);
    }
}
