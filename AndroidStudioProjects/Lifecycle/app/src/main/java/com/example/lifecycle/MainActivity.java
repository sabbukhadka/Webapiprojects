package com.example.lifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    public static  final  String Tag = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i(Tag, "Second Activity on create()");

        }
    @Override
    protected  void onRestart(){
        super.onRestart();
        Log.i(Tag, "Second Activity onStart()");

    }

        @Override
    protected  void onStart(){
        super.onStart();
        Log.i(Tag, "Second Activity onStart()");

    }
    @Override
    protected void onPause() {
        super.onPause();

        Log.i(Tag, "Second Activity on Pause()");

    }


    }

