package com.example.medilert;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.medilert.R;

public class Dashboard extends AppCompatActivity {
    private TextView welcomeText, username;
    private CardView medicationCard, alertsCard, locatorCard, callCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        // Initialize views
        welcomeText = findViewById(R.id.welcomeText);
        username = findViewById(R.id.username);
        medicationCard = findViewById(R.id.dashCard);
        alertsCard = findViewById(R.id.dashCard1);
        locatorCard = findViewById(R.id.dashCard1);
        callCard = findViewById(R.id.dashCard1);

        // Get username from intent if passed from login/register
        String userDisplayName = getIntent().getStringExtra("username");
        if (userDisplayName != null && !userDisplayName.isEmpty()) {
            username.setText("Hi, " + userDisplayName);
        }

        // Set click listeners for cards
        medicationCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Demo toast message
                Toast.makeText(Dashboard.this, "Medication Reminder clicked", Toast.LENGTH_SHORT).show();
            }
        });

        alertsCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Demo toast message
                Toast.makeText(Dashboard.this, "Health Alerts clicked", Toast.LENGTH_SHORT).show();
            }
        });

        locatorCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Demo toast message
                Toast.makeText(Dashboard.this, "Emergency Services Locator clicked", Toast.LENGTH_SHORT).show();
            }
        });

        callCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Demo toast message
                Toast.makeText(Dashboard.this, "Call for Help clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }
}