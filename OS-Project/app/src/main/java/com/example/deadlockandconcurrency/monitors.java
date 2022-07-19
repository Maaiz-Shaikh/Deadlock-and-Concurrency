package com.example.deadlockandconcurrency;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

class Monitor{
    String status[] = {"Thinking","Thinking","Thinking","Thinking","Thinking"};

    boolean isThinking(int i){
        if(status[i].equalsIgnoreCase("thinking")){
            return true;
        }
        return false;
    }

    boolean isEating(int i){
        if(status[i].equalsIgnoreCase("eating")){
            return true;
        }
        return false;
    }

    boolean test(int i){
        if(status[i].equalsIgnoreCase("hungry")){
            if(!status[(i+4)%5].equalsIgnoreCase("eating") && !status[(i+1)%5].equalsIgnoreCase("eating")){
                status[i] = "Eating";
                return true;
            }
            return false;
        }
        return false;
    }
}

public class monitors extends AppCompatActivity {

    Monitor obj = new Monitor();

//    boolean p0think = true;
//    boolean p1think = true;
//    boolean p2think = true;
//    boolean p3think = true;
//    boolean p4think = true;
//
//    boolean p0hungry = false;
//    boolean p1hungry = false;
//    boolean p2hungry = false;
//    boolean p3hungry = false;
//    boolean p4hungry = false;
//
//    boolean p0eating = false;
//    boolean p1eating = false;
//    boolean p2eating = false;
//    boolean p3eating = false;
//    boolean p4eating = false;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monitors);

        TextView p0h = findViewById(R.id.p0hungry);
        TextView p1h = findViewById(R.id.p1hungry);
        TextView p2h = findViewById(R.id.p2hungry);
        TextView p3h = findViewById(R.id.p3hungry);
        TextView p4h = findViewById(R.id.p4hungry);


        TextView p0t = findViewById(R.id.p0thinking);
        TextView p1t = findViewById(R.id.p1thinking);
        TextView p2t = findViewById(R.id.p2thinking);
        TextView p3t = findViewById(R.id.p3thinking);
        TextView p4t = findViewById(R.id.p4thinking);


        TextView p0e = findViewById(R.id.p0eating);
        TextView p1e = findViewById(R.id.p1eating);
        TextView p2e = findViewById(R.id.p2eating);
        TextView p3e = findViewById(R.id.p3eating);
        TextView p4e = findViewById(R.id.p4eating);




        p0t.setText("●");
        p1t.setText("●");
        p2t.setText("●");
        p3t.setText("●");
        p4t.setText("●");




        Button p0 = findViewById(R.id.p0);
        Button p1 = findViewById(R.id.p1);
        Button p2 = findViewById(R.id.p2);
        Button p3 = findViewById(R.id.p3);
        Button p4 = findViewById(R.id.p4);
        Button b5 = findViewById(R.id.button3);



        p0.setOnClickListener(new View.OnClickListener() {
                                  @Override
                                  public void onClick(View view) {
                                      if(obj.isThinking(0))
                                      {
                                          p0t.setText("");
                                          p0h.setText("●");
                                          obj.status[0] = "Hungry";
                                      }
                                      else if(obj.test(0))
                                      {
                                          p0h.setText("");
                                          p0e.setText("●");
                                          obj.status[0] = "Eating";
                                      }
                                      else if(obj.isEating(0))
                                      {
                                          p0t.setText("●");
                                          p0e.setText("");
                                          obj.status[0] = "Thinking";
                                      }
                                  }
                              }
        );
        p1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(obj.isThinking(1))
                {
                    p1t.setText("");
                    p1h.setText("●");
                    obj.status[1] = "Hungry";
                }
                else if(obj.test(1))
                {
                    p1h.setText("");
                    p1e.setText("●");
                    obj.status[1] = "Eating";
                }
                else if(obj.isEating(1))
                {
                    p1t.setText("●");
                    p1e.setText("");
                    obj.status[1] = "Thinking";
                }

            }
        });
        p2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(obj.isThinking(2))
                {
                    p2t.setText("");
                    p2h.setText("●");
                    obj.status[2] = "Hungry";
                }
                else if(obj.test(2))
                {
                    p2h.setText("");
                    p2e.setText("●");
                    obj.status[2] = "Eating";
                }
                else if(obj.isEating(2))
                {
                    p2t.setText("●");
                    p2e.setText("");
                    obj.status[2] = "Thinking";
                }
            }
        });
        p3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(obj.isThinking(3))
                {
                    p3t.setText("");
                    p3h.setText("●");
                    obj.status[3] = "Hungry";
                }
                else if(obj.test(3))
                {
                    p3h.setText("");
                    p3e.setText("●");
                    obj.status[3] = "Eating";
                }
                else if(obj.isEating(3))
                {
                    p3t.setText("●");
                    p3e.setText("");
                    obj.status[3] = "Thinking";
                }
            }
        });
        p4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(obj.isThinking(4))
                {
                    p4t.setText("");
                    p4h.setText("●");
                    obj.status[4] = "Hungry";
                }
                else if(obj.test(4))
                {
                    p4h.setText("");
                    p4e.setText("●");
                    obj.status[4] = "Eating";
                }
                else if(obj.isEating(4))
                {
                    p4t.setText("●");
                    p4e.setText("");
                    obj.status[4] = "Thinking";
                }
            }
        });

        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for(int i=0; i<5; i++){
                    obj.status[i] = "Thinking";
                }

                p0h.setText("");
                p1h.setText("");
                p2h.setText("");
                p3h.setText("");
                p4h.setText("");


                p0e.setText("");
                p1e.setText("");
                p2e.setText("");
                p3e.setText("");
                p4e.setText("");


                p0t.setText("●");
                p1t.setText("●");
                p2t.setText("●");
                p3t.setText("●");
                p4t.setText("●");

            }
        });
//        p0.setOnClickListener(new View.OnClickListener() {
//                                  @Override
//                                  public void onClick(View view) {
//                                    if(p0think)
//                                    {
//                                        p0t.setText("");
//                                        p0h.setText("●");
//                                        p0hungry= true;
//                                        p0think = false;
//                                    }
//                                    else if(p0hungry==true && p4eating==false && p1eating==false)
//                                    {
//                                        p0h.setText("");
//                                        p0e.setText("●");
//                                        p0eating = true;
//                                        p0hungry =false;
//                                    }
//                                    else if(p0eating == true)
//                                    {
//                                        p0t.setText("●");
//                                        p0e.setText("");
//
//                                        p0think = true;
//                                        p0eating =false;
//                                    }
//                                  }
//                              }
//        );
//        p1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if(p1think)
//                {
//                    p1t.setText("");
//                    p1h.setText("●");
//                    p1hungry= true;
//                    p1think = false;
//                }
//                else if(p1hungry==true && p0eating==false && p2eating==false)
//                {
//                    p1h.setText("");
//                    p1e.setText("●");
//                    p1eating = true;
//                    p1hungry =false;
//                }
//                else if(p1eating == true)
//                {
//                    p1t.setText("●");
//                    p1e.setText("");
//
//                    p1think = true;
//                    p1eating =false;
//                }
//            }
//        });
//        p2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if(p2think)
//                {
//                    p2t.setText("");
//                    p2h.setText("●");
//                    p2hungry=true;
//                    p2think = false;
//                }
//                else if(p2hungry == true && p1eating==false && p3eating==false)
//                {
//                    p2h.setText("");
//                    p2e.setText("●");
//                    p2eating =true;
//                    p2hungry = false;
//                }
//                else if(p2eating==true)
//                {
//                    p2e.setText("");
//                    p2t.setText("●");
//
//                    p2think = true;
//                    p2eating =false;
//
//                }
//            }
//        });
//        p3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if(p3think)
//                {
//                    p3t.setText("");
//                    p3h.setText("●");
//                    p3hungry = true;
//                    p3think = false;
//                }
//                else if(p3hungry == true && p2eating==false && p4eating==false)
//                {
//                    p3h.setText("");
//                    p3e.setText("●");
//                    p3eating =true;
//                    p3hungry = false;
//                }
//                else if(p3eating==true)
//                {
//                    p3e.setText("");
//                    p3t.setText("●");
//
//                    p3think = true;
//                    p3eating =false;
//
//                }
//            }
//        });
//        p4.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if(p4think)
//                {
//                    p4t.setText("");
//                    p4h.setText("●");
//                    p4hungry = true;
//                    p4think = false;
//                }
//                else if(p4hungry == true && p3eating==false && p0eating==false)
//                {
//                    p4h.setText("");
//                    p4e.setText("●");
//                    p4eating =true;
//                    p4hungry = false;
//                }
//                else if(p4eating==true)
//                {
//                    p4e.setText("");
//                    p4t.setText("●");
//
//                    p4think = true;
//                    p4eating =false;
//
//                }
//            }
//        });
//
//        b5.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                p0h.setText("");
//                p0e.setText("");
//                p1h.setText("");
//                p1e.setText("");
//                p2h.setText("");
//                p3h.setText("");
//                p4h.setText("");
//                p2e.setText("");
//                p3e.setText("");
//                p4e.setText("");
//
//
//                p0t.setText("●");
//                p1t.setText("●");
//                p2t.setText("●");
//                p3t.setText("●");
//                p4t.setText("●");
//
//            }
//        });


    }
}