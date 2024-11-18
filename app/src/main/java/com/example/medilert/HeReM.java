package com.example.medilert;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class HeReM extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_reminder);

        // Initialize views
        ImageButton backButton = findViewById(R.id.backButton);
        CardView reminder1 = findViewById(R.id.reminder1);
        CardView reminder2 = findViewById(R.id.reminder2);

        // Back button click handler
        backButton.setOnClickListener(v -> finish());

        // Demo reminder clicks
        reminder1.setOnClickListener(v -> Toast.makeText(HeReM.this,
                "Medicine Reminder: Time to take your medication!",
                Toast.LENGTH_LONG).show());

        reminder2.setOnClickListener(v -> Toast.makeText(HeReM.this,
                "Health Alert: Time for your health check!",
                Toast.LENGTH_LONG).show());
    }
}