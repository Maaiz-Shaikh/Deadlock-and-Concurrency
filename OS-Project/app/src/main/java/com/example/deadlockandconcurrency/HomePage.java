package com.example.deadlockandconcurrency;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class HomePage extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;

    private Button startButton;

    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.my_drawer_layout);
        sidebarNavigation(drawerLayout);


        startButton = findViewById(R.id.startButton);
        setStartButton(startButton);


        navigationView = findViewById(R.id.navigationView);
        sidebarNavigationItemOnClick(navigationView);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    //Sidebar Navigation Code
    public void sidebarNavigation(DrawerLayout drawerLayout){
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    //Code when click on items of sidebar navigation
    public void sidebarNavigationItemOnClick(NavigationView navigationView){
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_aboutApp:
                        Intent intent1 = new Intent(HomePage.this, aboutapp.class);
                        startActivity(intent1);
                        return true;

                    case R.id.nav_aboutDevelopers:
                        Intent intent = new Intent(HomePage.this, AboutDevelopers.class);
                        startActivity(intent);
                        return true;
                }
                return true;
            }
        });
    }

    //Start Button Code
    public void setStartButton(Button startButton){
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomePage.this, IndexPage.class);
                startActivity(intent);
            }
        });
    }

}