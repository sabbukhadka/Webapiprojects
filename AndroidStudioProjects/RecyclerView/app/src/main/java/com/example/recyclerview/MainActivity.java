package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.provider.ContactsContract;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

recyclerView = findViewById(R.id.recylerview);

// create alist of contacts
        List<Contacts> contactsList = new ArrayList<>();

        contactsList.add(new  Contacts(" Saughat malla","9860096025", R.drawable.back));
        contactsList.add(new  Contacts(" Saughat malla","9860096025", R.drawable.back));
        contactsList.add(new  Contacts(" Saughat malla","9860096025", R.drawable.back));
        contactsList.add(new  Contacts(" Saughat malla","9860096025", R.drawable.back));
//
        ContactsAdapter contactsAdapter = new ContactsAdapter(this,contactsList);
        recyclerView.setAdapter(contactsAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
