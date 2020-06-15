package com.example.dictionaryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import java.io.PrintStream;

public class Add_word extends AppCompatActivity {
    EditText etWord, etMeaning;
    Button btnAddWord,btnreturn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_word);

        etWord = findViewById(R.id.etWord);
        etMeaning = findViewById(R.id.etMeaning);
        btnAddWord = findViewById(R.id.btnAddWord);
        btnreturn = findViewById(R.id.btnreturn);

        btnAddWord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Save();
            }
        });



        btnreturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Add_word.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void Save(){
        try {
            PrintStream printStream = new PrintStream(openFileOutput("words.txt",MODE_PRIVATE | MODE_APPEND));
            printStream.println(etWord.getText().toString()+"->"+etMeaning.getText().toString());
            Toast.makeText(this, "Saved to" + getFilesDir(), Toast.LENGTH_SHORT).show();

        }catch(IOException e){
            Log.d("Dictionary app","Error: "+e.toString());
            e.printStackTrace();
        }

    }
}
