package com.example.dictionaryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.Key;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private  ListView lstDictionary;
    private  Map<String, String> dictionary;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lstDictionary = findViewById(R.id.lstDictionary);
        dictionary = new HashMap<>();


        //calling method to read file
        readFromFile();

       ArrayAdapter adapter = new ArrayAdapter<>(
               this,
               android.R.layout.simple_list_item_1,
               new ArrayList<>(dictionary.keySet())
       );

        lstDictionary.setAdapter(adapter);
        lstDictionary.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String key = parent.getItemAtPosition(position).toString();
                String meaning = dictionary.get(key);
                Intent intent = new Intent(MainActivity.this, Meaning.class);
                intent.putExtra("word",key);
                intent.putExtra("meaning",meaning);
                startActivity(intent);
            }
        });
    }
    private  void readFromFile(){
        try {
                FileInputStream fos = openFileInput("words.txt"); //reading txt file
                InputStreamReader isr = new InputStreamReader(fos); // it reads bytes and decodes characters using a specified charset
                BufferedReader br = new BufferedReader(isr);//used to read the text from a character-based input stream
                String line;
                while ((line = br.readLine()) != null) {
                    String[] parts = line.split("->");
                    dictionary.put(parts[0], parts[1]);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }


    }
}