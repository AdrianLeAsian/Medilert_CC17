package com.example.medilert;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class Medication_Reminder extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medication_reminder);

        // Initialize views
        ImageButton backButton = findViewById(R.id.backButton);
        CardView medication1 = findViewById(R.id.medication1);
        CardView medication2 = findViewById(R.id.medication2);

        // Back button click handler
        backButton.setOnClickListener(v -> finish());

        // Medication reminder clicks
        medication1.setOnClickListener(v -> Toast.makeText(Medication_Reminder.this,
                "Morning Medication: Remember to take with food!",
                Toast.LENGTH_LONG).show());

        medication2.setOnClickListener(v -> Toast.makeText(Medication_Reminder.this,
                "Evening Medication: Take before going to bed!",
                Toast.LENGTH_LONG).show());
    }
}