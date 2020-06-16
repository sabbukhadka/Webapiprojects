package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
private EditText user, pass; // variable identified
private Button  login;
private CheckBox check;
SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        user= findViewById(R.id.user);// widgets ko refer linupaaryo jati pani 6
        pass = findViewById(R.id.pass);
        check = findViewById(R.id.check);
        login = findViewById(R.id.login);
        SharedPreferences saveddata = getSharedPreferences("User", Context.MODE_PRIVATE);

      //  System.out.println(saveddata.getString("username", " ").isEmpty());
       // System.out.println("-----Shared Preferences ----"+saveddata.getString("username", " "));
        if (saveddata.getString("username", " ").isEmpty()){
            check.setChecked(false);
//            user.setText("");
//            pass.setText("");
        }else {
            user.setText(saveddata.getString("username", ""));
            pass.setText(saveddata.getString("username", ""));
            check.setChecked(true);
        }

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                if ( boolean response.equals(true)){

                    if (check.isChecked()) {
                        String use = user.getText().toString();
                        String pwd = pass.getText().toString();

                        sharedPreferences = getSharedPreferences("Username", MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("username", use);
                        editor.putString("password", pwd);
                        editor.commit();
                        Toast.makeText(MainActivity.this, " Checkbox checked", Toast.LENGTH_SHORT).show();
                    } else {
                        sharedPreferences = getSharedPreferences("User", 0);
                        sharedPreferences.edit().clear().commit();

                        Toast.makeText(MainActivity.this, " Checkbox  not checked", Toast.LENGTH_SHORT).show();
                    }
//                }else{
//            }
//                }
            }
        });
    }
}
