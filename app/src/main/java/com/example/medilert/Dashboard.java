package com.example.medilert;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class Dashboard extends AppCompatActivity {
    private TextView welcomeText;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        // Initialize views
        welcomeText = findViewById(R.id.welcomeText);
        TextView username = findViewById(R.id.username);
        @SuppressLint("CutPasteId") CardView medicationCard = findViewById(R.id.dashCard);
        @SuppressLint("CutPasteId") CardView alertsCard = findViewById(R.id.dashCard1);
        @SuppressLint("CutPasteId") CardView locatorCard = findViewById(R.id.dashCard);
        @SuppressLint("CutPasteId") CardView callCard = findViewById(R.id.dashCard1);

        // Get username from intent if passed from login/register
        String userDisplayName = getIntent().getStringExtra("username");
        if (userDisplayName != null && !userDisplayName.isEmpty()) {
            username.setText("Hi, " + userDisplayName);
        }

        // Set click listeners for cards
        medicationCard.setOnClickListener(v -> {
            // Demo toast message
            Toast.makeText(Dashboard.this, "Medication Reminder clicked", Toast.LENGTH_SHORT).show();
        });

        alertsCard.setOnClickListener(v -> {
            // Demo toast message
            Toast.makeText(Dashboard.this, "Health Alerts clicked", Toast.LENGTH_SHORT).show();
        });

        locatorCard.setOnClickListener(v -> {
            // Launch Emergency Map activity
            Intent intent = new Intent(Dashboard.this, Emergency_MAP.class);
            startActivity(intent);
        });

        callCard.setOnClickListener(v -> {
            // Launch SOS Feature activity
            Intent intent = new Intent(Dashboard.this, SOS_Feature.class);
            startActivity(intent);
        });
    }

    public TextView getWelcomeText() {
        return welcomeText;
    }

    public void setWelcomeText(TextView welcomeText) {
        this.welcomeText = welcomeText;
    }
}