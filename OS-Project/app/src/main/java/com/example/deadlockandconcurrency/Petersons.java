package com.example.deadlockandconcurrency;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

//Time Complexity : O(1)
//Space Complexity : O(1)

public class Petersons extends AppCompatActivity {
    int j = 0;
    boolean p0 = false;
    boolean p1 = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_petersons);


            TextView c0 = findViewById(R.id.p0hungry);
            TextView f0 = findViewById(R.id.p0eating);
            TextView c1 = findViewById(R.id.p1hungry);
            TextView f1 = findViewById(R.id.p1eating);


            Button b0 = findViewById(R.id.p0);
            Button b1 = findViewById(R.id.p1);
            Button b2 = findViewById(R.id.button3);
            b0.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View view) {
                                          if(j==0 && p1== false){
                                              c0.setText("●");
                                              p0 = true;
                                          }
                                          if(j==1 && p0 == true){
                                              c0.setText("");
                                              f0.setText("●");
                                              j=0;
                                              p1 = true;
                                              p0 = false;
                                          }
                                          if(j == 0 && p1 == false){
                                              j =1;
                                          }
                                          if(j==1&&p0==false){
                                              Toast.makeText(Petersons.this, "Turn variable is 1 & {T,F}", Toast.LENGTH_SHORT).show();
                                          }
                                      }
                                  }
            );
            b1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(j==0 && p0 == false){

                        c1.setText("●");

                        p1 = true;

                    }
                    if(j==1 && p1 == true){
                        c1.setText("");
                        f1.setText("●");
                        p1 = false;
                        p0 = true;
                        j=0;
                    }
                    if(j==0 && p0 == false){
                        j = 1;

                    }
                    if(j==1&&p1==false){
                        Toast.makeText(Petersons.this, "Turn variable is 0 & {T,F}", Toast.LENGTH_SHORT).show();
                    }
                }
            });

            b2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    j = 0;
                    p0 = p1 = false;
                    c0.setText("");
                    f0.setText("");
                    c1.setText("");
                    f1.setText("");
                }
            });
    }

}