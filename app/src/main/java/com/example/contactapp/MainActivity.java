package com.example.contactapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.github.javafaker.Faker;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Faker faker = new Faker();
        ArrayList<String> data = new ArrayList<String>();
        for(int i = 0; i < 50; i++){
            data.add(faker.name().fullName());
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.recycle_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        ContactAdapter myAdapter = new ContactAdapter(data);
        recyclerView.setAdapter(myAdapter);
    }
}