package com.example.implictintentexamples;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
private EditText etphone;
private Button dial, shoot;
private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        etphone =findViewById(R.id.etphone);
        dial = findViewById(R.id.dial);
          shoot =findViewById(R.id.shoot);
        imageView = findViewById(R.id.imageview);

        dial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
Dial();
            }
        });
        checkPermission();

        shoot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadCamera();
            }
        });
    }
    //for loading dial feature
        private void Dial(){
            Uri uri = Uri.parse("tel:"+etphone.getText().toString());
            Intent intent = new Intent(Intent.ACTION_DIAL, uri);
            startActivity(intent);
        }
        //for loading camera feature
    private  void loadCamera(){
        Intent intent= new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (intent.resolveActivity(getPackageManager()) !=null){
            startActivityForResult(intent,1);
        }
    }
    //check if required permission has granted by the user
    private  void checkPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]
                    {Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 0);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode==1 && resultCode ==RESULT_OK){
            Bundle extras = data.getExtras();
            Bitmap image = (Bitmap) extras.get("data");
            imageView.setImageBitmap(image);

        }
    super.onActivityResult(requestCode, resultCode, data);

    }
}

