package com.example.medilert;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class Dashboard extends AppCompatActivity {
    private TextView welcomeText;
    private TextView username;
    private CardView medicationCard;
    private CardView alertsCard;
    private CardView locatorCard;
    private CardView callCard;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        // Initialize views
        welcomeText = findViewById(R.id.welcomeText);
        username = findViewById(R.id.username);
        medicationCard = findViewById(R.id.dashCard);
        alertsCard = findViewById(R.id.dashCard2);
        locatorCard = findViewById(R.id.dashCard1);
        callCard = findViewById(R.id.dashCard3);

        // Get username from intent if passed from login/register
        String userDisplayName = getIntent().getStringExtra("username");
        if (userDisplayName != null && !userDisplayName.isEmpty()) {
            username.setText("Hi, " + userDisplayName);
        }

        // Set click listeners for cards
        medicationCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Dashboard.this, "Medication Reminder clicked", Toast.LENGTH_SHORT).show();
            }
        });

        alertsCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dashboard.this, HeReM.class);
                startActivity(intent);
            }
        });

        locatorCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Launch Emergency Map activity
                Intent intent = new Intent(Dashboard.this, Emergency_MAP.class);
                startActivity(intent);
            }
        });

        callCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Launch SOS Feature activity
                Intent intent = new Intent(Dashboard.this, SOS_Feature.class);
                startActivity(intent);
            }
        });
    }
}