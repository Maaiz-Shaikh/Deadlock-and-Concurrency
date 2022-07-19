package com.example.deadlockandconcurrency;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class BankersAlgorithmPage3 extends AppCompatActivity {
    TextView safeUnsafe;
    TextView processSequence;
    Button restartButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bankers_algorithm_page3);
        /*
         * This page get value of check and safeSequenceArray from BankersAlgorithmPage2
         * and display appropriate result
         */

        Intent intent = getIntent();
        int check = intent.getIntExtra("check",-1);
        int[] safeSequenceArray = intent.getIntArrayExtra("safeSequence");

        safeUnsafe = findViewById(R.id.textView);
        processSequence = findViewById(R.id.textView2);
        if(check!=-1){
            safeUnsafe.setText("Safe");
            processSequence.setText("Process sequence\n");
            for(int i=0; i<safeSequenceArray.length-1; i++){
                processSequence.append("P"+safeSequenceArray[i]+" -> ");
            }
            processSequence.append("P"+safeSequenceArray[safeSequenceArray.length-1]);
            //processSequence.setText(for(int ele : safeSequenceArray) ele + " ");
        }else{
            safeUnsafe.setText("Unsafe");
            processSequence.setText("No process sequence is possible");
        }

        // Restart Button will direct us to BankersAlgorithmPage1
        restartButton = findViewById(R.id.restartButton);
        restartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BankersAlgorithmPage3.this, BankersAlgorithm1.class);
                startActivity(intent);

            }
        });

    }
}