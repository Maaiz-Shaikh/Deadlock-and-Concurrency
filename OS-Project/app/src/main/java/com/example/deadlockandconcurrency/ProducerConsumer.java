package com.example.deadlockandconcurrency;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/* Producer Consumer Algorithm using Semaphore */
// time complexity is O(n)
public class ProducerConsumer extends AppCompatActivity {
    // making object of palette
    private ArrayList<String> items;
    private ArrayAdapter<String> itemadapter;
    private ListView listview;
    private Button button;
    private Button button1;
    private Button button2;
    private Button button3;
    private EditText buffer;
    private EditText Consumer_Consume;
    private EditText Producer_Produce;
    // Assigning the Counting Semaphore Variable
    int in = 0;
    int bs = 1;

    int j = 0;
    int m = 0;
    int t_buffer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_producer_consumer);
        listview = findViewById(R.id.listview);
        button = findViewById(R.id.button2);
        button1 = findViewById(R.id.button4);
        button2 = findViewById(R.id.button1);
        button3 = findViewById(R.id.Reset);
        Consumer_Consume = findViewById(R.id.consumer_consume);
        buffer = findViewById(R.id.buffer);
        Producer_Produce = findViewById(R.id.producer_produce);
// Taking input of the Size of Buffer
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String buffersize = buffer.getText().toString();
                t_buffer = Integer.parseInt(buffersize);
                Toast.makeText(ProducerConsumer.this, "total Buffer is "+t_buffer, Toast.LENGTH_SHORT).show();
            }
        });





// Taking input of the number of item that producer produce
// time complexity is O(n)
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {




                String p_i = Producer_Produce.getText().toString();
                int producer_item = Integer.parseInt(p_i);



                if(bs == 1) {
                    binarydown();
                    for (int i = 0; i < producer_item; i++) {


                        if (in == t_buffer || in > t_buffer) {
                            Toast.makeText(ProducerConsumer.this, "Buffer is Full", Toast.LENGTH_SHORT).show();
                            break;
                        } else {

                            item_produce(view);
                            up();


                        }

                    }
                    binaryup();
                }
                else{
                    Toast.makeText(ProducerConsumer.this, "Process Cannot be Preempted", Toast.LENGTH_SHORT).show();
                }
            }
        });
// taking input of the item that consumer consume
// time complexity is O(n)
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String c_c = Consumer_Consume.getText().toString();
                int consumer_consume = Integer.parseInt(c_c);

                if(bs == 1) {
                    binarydown();

                    for (int i = 0; i < consumer_consume; i++) {

                        if (in == 0 || in < 0) {
                            Toast.makeText(ProducerConsumer.this, "Buffer is Empty", Toast.LENGTH_SHORT).show();
                            in = 0;

                        } else {
                            item_consume(view);
                            down();
                        }
                    }
                    binaryup();
                }
                else{
                    Toast.makeText(ProducerConsumer.this, "Process Cannot be Preempted", Toast.LENGTH_SHORT).show();
                }
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reset(view);
            }
        });



        items = new ArrayList<>();
        itemadapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,items);
        listview.setAdapter(itemadapter);
        setUpLisetviewListner();

    }
    // Making ListView in the Main Activity
    public void setUpLisetviewListner(){
        listview.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Context context = getApplicationContext();
                Toast.makeText(context,"Item Removed",Toast.LENGTH_LONG).show();
                items.remove(i);
                itemadapter.notifyDataSetChanged();
                return true;
            }
        });
    }
// Function show  the producer produce item  in the listview

    void item_produce(View view){
        String text = "P-" + j;
        itemadapter.add(text);
        j++;

    }
    // Function show the item Consume by consumer
    void item_consume(View view){
        String text = "P-" + m;
        itemadapter.remove(text);
        m++;

    }
    // Reset all the input
    void reset(View View){
        Toast.makeText(ProducerConsumer.this, "Reset Complete", Toast.LENGTH_SHORT).show();
        itemadapter.clear();
        buffer.setText("");
        Consumer_Consume.setText("");
        Producer_Produce.setText("");
        j = 0;
        m = 0;
        in = 0;
    }
    //Counting Semaphore Functions
    void down(){
        in--;

    }
    void up(){
        in++;

    }

    //Binary Semaphore Functions
    void binarydown(){
        bs = 0;
    }
    void binaryup(){
        bs = 1;
    }
}