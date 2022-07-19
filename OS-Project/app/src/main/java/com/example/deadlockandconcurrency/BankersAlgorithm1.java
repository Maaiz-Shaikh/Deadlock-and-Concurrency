package com.example.deadlockandconcurrency;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class BankersAlgorithm1 extends AppCompatActivity {
    EditText getNumberOfProcesses;
    EditText getNumberOfResources;
    Button nextButton1;

    private int numberOfProcesses;
    private int numberOfResources;

    public int getNumberOfProcesses(){
        return numberOfProcesses;
    }

    public int getNumberOfResources(){
        return numberOfResources;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        /*
         * This page take number of process & number of resources as input
         * and pass the values to Bankers Algorithm page 2
         */
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bankers_algorithm1);

        getNumberOfProcesses = findViewById(R.id.editTextNumber1);
        getNumberOfResources = findViewById(R.id.editTextNumber2);
        nextButton1 = findViewById(R.id.banext);
        setNextButton(nextButton1);
    }

    /*
     * Function to store numbers of process & numbers of resource on click of next button
     * Time complexity : O(1)
     * Space complexity : O(1)
     */
    public void setNextButton(@NonNull Button nextButton){
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberOfProcesses = Integer.parseInt(getNumberOfProcesses.getText().toString());
                numberOfResources = Integer.parseInt(getNumberOfResources.getText().toString());
                if(numberOfResources<=0 || numberOfProcesses<=0){
                    Toast.makeText(BankersAlgorithm1.this, "Invalid Inputs", Toast.LENGTH_SHORT).show();
                }else if(numberOfResources>0 && numberOfProcesses>0){
                    Toast.makeText(BankersAlgorithm1.this, "No of Process : "+numberOfProcesses+", No of Resource : "+numberOfResources, Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(BankersAlgorithm1.this,BankersAlgorithmPage2.class);
                    intent.putExtra("resources",getNumberOfResources());
                    intent.putExtra("process",getNumberOfProcesses());
                    startActivity(intent);
                }else{
                    Toast.makeText(BankersAlgorithm1.this, "Please provide inputs values", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


}