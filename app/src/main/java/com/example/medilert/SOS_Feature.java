package com.example.medilert;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class SOS_Feature extends AppCompatActivity {
    private Button sosButton;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sos_feature);

        // Initialize views
        sosButton = findViewById(R.id.sosButton);
        ImageButton backButton = findViewById(R.id.backButton);

        // SOS button click handler
        sosButton.setOnClickListener(v -> {
            // Show toast message
            Toast.makeText(SOS_Feature.this,
                    "Emergency alert sent! Help is on the way.",
                    Toast.LENGTH_LONG).show();

            // Launch the calling screen activity
            Intent intent = new Intent(SOS_Feature.this, SOS_Feature_Call.class);
            startActivity(intent);

            // The button could be disabled after pressing to prevent multiple alerts
            sosButton.setEnabled(false);
            sosButton.setText("Alert Sent");
        });

        // Back button click handler
        backButton.setOnClickListener(v -> {
            // Return to previous screen
            finish();
        });
    }
}