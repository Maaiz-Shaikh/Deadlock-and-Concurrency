package com.example.deadlockandconcurrency;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class BankersAlgorithmPage2 extends AppCompatActivity {
    EditText availableResource;
    EditText allocatedResource;
    EditText maximumResource;

    Button nextButton;
    Button addButton1;
    Button addButton2;

    String getAvailableResource;
    String getAllocatedResource;
    String getMaximumResource;

    int clicks1 = 0;
    int clicks2 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bankers_algorithm_page2);
        /*
         * This page take values of available resources, allocated resources & maximum resources as input
         * and calculate whether their is deadlock or not
         * If there is deadlock it will pass check = -1 to BankersAlgorithmPage3
         * else it will pass check = 1 to BankersAlgorithmPage3
         */

        Intent intent = getIntent();
        int noOfResources = intent.getIntExtra("resources", 1);
        int noOfProcess = intent.getIntExtra("process", 1);
        int[] availableResourceArray = new int[noOfResources];
        int[][] allocatedResourceArray = new int[noOfProcess][noOfResources];
        int[][] maximumResourceArray = new int[noOfProcess][noOfResources];
        int[] safeSequence = new int[noOfProcess];


        availableResource = findViewById(R.id.editTextNumber4);


        //next button is used to store all values and move to next page
        nextButton = findViewById(R.id.button3);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getAvailableResource = availableResource.getText().toString();
                String[] spaceSeperatedAvailableResource = getAvailableResource.split(" ");
                for(int i=0; i<noOfResources; i++){
                    availableResourceArray[i] = Integer.parseInt(spaceSeperatedAvailableResource[i]);
                }

                int check = bankersAlgorithm(noOfProcess, noOfResources, maximumResourceArray, allocatedResourceArray, availableResourceArray, safeSequence);
                Toast.makeText(BankersAlgorithmPage2.this, "check variable "+check, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(BankersAlgorithmPage2.this, BankersAlgorithmPage3.class);
                intent.putExtra("check", check);
                intent.putExtra("safeSequence",safeSequence);
                startActivity(intent);

            }
        });

        // add button 1 is used add allocated resources
        allocatedResource = findViewById(R.id.editTextNumber5);
        addButton1 = findViewById(R.id.button);
        addButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(clicks1 >= noOfProcess){
                    Toast.makeText(BankersAlgorithmPage2.this, "Can't add more values", Toast.LENGTH_SHORT).show();
                }else {
                    allocatedResource.setHint("Enter space separated Integer values");
                    getAllocatedResource = allocatedResource.getText().toString();
                    String[] spaceSeparatedAllocatedResource = getAllocatedResource.split(" ");
                    for (int i = 0; i < noOfResources; i++) {
                        allocatedResourceArray[clicks1][i] = Integer.parseInt(spaceSeparatedAllocatedResource[i]);
                    }
                    Toast.makeText(BankersAlgorithmPage2.this, "Allocated Resource : " + allocatedResourceArray[clicks1][0], Toast.LENGTH_SHORT).show();
                    clicks1++;
                    allocatedResource.setText("");
                }
            }
        });


        // add button 2 is used to add maximum resources to every process
        maximumResource = findViewById(R.id.editTextNumber);
        addButton2 = findViewById(R.id.p1);
        addButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(clicks2 >= noOfProcess){
                    Toast.makeText(BankersAlgorithmPage2.this, "Can't add more values", Toast.LENGTH_SHORT).show();
                }else {
                    maximumResource.setHint("Enter space separated Integer values");
                    getMaximumResource = maximumResource.getText().toString();
                    String[] spaceSeparatedMaximumResource = getMaximumResource.split(" ");
                    for (int i = 0; i < noOfResources; i++) {
                        maximumResourceArray[clicks2][i] = Integer.parseInt(spaceSeparatedMaximumResource[i]);
                    }
                    Toast.makeText(BankersAlgorithmPage2.this, "Maximum Resource : " + maximumResourceArray[clicks2][0], Toast.LENGTH_SHORT).show();
                    clicks2++;
                    maximumResource.setText("");
                }
            }
        });

    }

    /*
     * Bankers algorithm function will return integer to check safety and if it is safe, safeSequenceArray is made
     * which will provide safe sequence
     * Time complexity : O(n*n*m)
     *
     */
    public int bankersAlgorithm(int process, int resource, int[][] max, int[][] alloc, int[] avail, int[] safesequence){
        int noOfProcess = process;
        int noOfResource = resource;
        int[][] need = new int[noOfProcess][noOfResource];
        int[][] maximumResourceArray = max;
        int[][] allocatedResourceArray = alloc;
        int[] availableResourceArray = avail;
        int[] safeSequence = safesequence;
        int check;

        calculateNeed(noOfProcess, noOfResource, need, maximumResourceArray, allocatedResourceArray);
        check = isSafe(noOfProcess, noOfResource, availableResourceArray, need, safeSequence, allocatedResourceArray);
        return check;
    }

    /*
     * Time Complexity : O(n*n*m)
     * isSafe function is used to check whether given input result in safe state or not
     * by returning integer value
     * If return value is -1 it is not safe otherwise it is safe
     */
    public int isSafe(int noOfProcess, int noOfResource, int[] avail, int[][] need, int[] safeSequence, int[][] alloc){
        int n = noOfProcess;
        int m = noOfResource;
        int check;
        int count = 0;
        boolean visited[] = new boolean[n];
        int[] work = avail;

        for(int i=0; i<n; i++){
            visited[i] = false;
        }

        while(count<n){
            boolean flag = false;
            for (int i=0; i<n; i++){
                if(visited[i] == false){
                    int j;
                    for(j=0; j<m; j++){
                        if(need[i][j] > work[j]){
                            break;
                        }
                    }
                    if(j == m){
                        safeSequence[count++] = i;
                        visited[i] = true;
                        flag = true;
                        for(j=0; j<m; j++){
                            work[j] = alloc[i][j] + work[j];
                        }
                    }
                }
            }
            if(flag == false){
                break;
            }
        }
        if(count < n){
            check = -1;
        }else{
            check = 1;
        }
        return check;
    }



    /*
     * Time complexity : O(n*m)
     * calculateNeed is used to calculate need matrix using input provided
     */
    public void calculateNeed(int process, int resource, int[][] need, int[][] max, int[][] alloc){
        int n = process;
        int m = resource;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                need[i][j] = max[i][j] - alloc[i][j];
            }
        }
    }

}