package com.example.words;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.words.adapter.WordAdapter;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        String letter = intent.getStringExtra("a");


        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setAdapter(new WordAdapter(this, letter));
    }
}