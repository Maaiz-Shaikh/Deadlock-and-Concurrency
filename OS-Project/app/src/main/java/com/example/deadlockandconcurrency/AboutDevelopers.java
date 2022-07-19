package com.example.deadlockandconcurrency;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AboutDevelopers extends AppCompatActivity {
    Button vivek;
    Button maaiz;
    Button kris;
    Button prince;
    Button dhruv;

    private String vivekLink = "https://www.linkedin.com/in/lakhani-vivek-a7290b1ba/";
    private String maaizLink = "https://www.linkedin.com/in/maaiz03/";
    private String krisLink = "https://www.linkedin.com/in/kris-narola-5260b0200/";
    private String princeLink = "https://www.linkedin.com/in/prince-narola-0b85b2204/";
    private String dhruvLink = "https://www.linkedin.com/in/dhruv-lunagariya-6907aa201/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_developers);
        getSupportActionBar().setTitle("");


        vivek=findViewById(R.id.button4);
        setDevelopersButton(vivek,vivekLink);

        maaiz=findViewById(R.id.button5);
        setDevelopersButton(maaiz, maaizLink);

        kris=findViewById(R.id.button6);
        setDevelopersButton(kris,krisLink);

        prince=findViewById(R.id.button7);
        setDevelopersButton(prince,princeLink);

        dhruv=findViewById(R.id.button8);
        setDevelopersButton(dhruv,dhruvLink);


    }

    private void gotoUrl(String s) {
        Uri uri= Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }

    public void setDevelopersButton(Button developersButton, String link){
        developersButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                gotoUrl(link);
            }
        });
    }
}