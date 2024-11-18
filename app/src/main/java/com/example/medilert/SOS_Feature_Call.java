package com.example.medilert;

import android.os.Bundle;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;


public class SOS_Feature_Call extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sos_feature_call);

        // Initialize back button
        ImageButton backButton = findViewById(R.id.backButton);

        // Back button click handler
        backButton.setOnClickListener(v -> {
            // Return to previous screen
            finish();
        });
    }
}