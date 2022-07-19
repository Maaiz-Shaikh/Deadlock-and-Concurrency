package com.example.deadlockandconcurrency;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class IndexPage extends AppCompatActivity {

    Button algoButton;
    Button concurrencyButton;
    Button deadlockButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index_page);
        getSupportActionBar().setTitle("");

        algoButton = findViewById(R.id.algorithmsButton);
        algoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(IndexPage.this, algorithms.class);
                startActivity(intent);
            }
        });

        concurrencyButton = findViewById(R.id.concurrencyButton);
        concurrencyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(IndexPage.this, Concurrency.class);
                startActivity(intent);
            }
        });

        deadlockButton = findViewById(R.id.deadlockButton);
        deadlockButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(IndexPage.this, Deadlock.class);
                startActivity(intent);
            }
        });
    }

}