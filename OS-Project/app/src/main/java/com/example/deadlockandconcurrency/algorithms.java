package com.example.deadlockandconcurrency;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class algorithms extends AppCompatActivity {

    Button petersonSimulate;
    Button bankerSimulate;
    Button monitorSimulate;
    Button pcSimulate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_algorithum);

        petersonSimulate = findViewById(R.id.button4);
        petersonSimulate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(algorithms.this, Petersons.class);
                startActivity(intent);
            }
        });

        bankerSimulate = findViewById(R.id.button5);
        bankerSimulate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(algorithms.this, BankersAlgorithm1.class);
                startActivity(intent);
            }
        });

        pcSimulate = findViewById(R.id.button6);
        pcSimulate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(algorithms.this, ProducerConsumer.class);
                startActivity(intent);
            }
        });

        monitorSimulate = findViewById(R.id.button7);
        monitorSimulate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(algorithms.this, monitors.class);
                startActivity(intent);
            }
        });

    }
}