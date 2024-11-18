package com.example.medilert;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class Emergency_MAP extends AppCompatActivity {
    private ImageView mockMapView;
    private EditText searchLocation;
    private ImageView locationPin;
    private float currentZoom = 1.0f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergency_map);

        // Initialize views
        mockMapView = findViewById(R.id.mockMapView);
        searchLocation = findViewById(R.id.searchLocation);
        Button zoomInButton = findViewById(R.id.zoomInButton);
        Button zoomOutButton = findViewById(R.id.zoomOutButton);
        locationPin = findViewById(R.id.locationPin);

        // Search functionality
        searchLocation.setOnEditorActionListener((v, actionId, event) -> {
            String location = searchLocation.getText().toString();
            if (!location.isEmpty()) {
                simulateSearch(location);
                return true;
            }
            return false;
        });

        // Zoom controls
        zoomInButton.setOnClickListener(v -> {
            if (currentZoom < 2.0f) {
                currentZoom += 0.2f;
                mockMapView.setScaleX(currentZoom);
                mockMapView.setScaleY(currentZoom);
                Toast.makeText(this, "Zooming in", Toast.LENGTH_SHORT).show();
            }
        });

        zoomOutButton.setOnClickListener(v -> {
            if (currentZoom > 0.5f) {
                currentZoom -= 0.2f;
                mockMapView.setScaleX(currentZoom);
                mockMapView.setScaleY(currentZoom);
                Toast.makeText(this, "Zooming out", Toast.LENGTH_SHORT).show();
            }
        });

        // Location pin click handler
        locationPin.setOnClickListener(v -> Toast.makeText(this, "Current Location Selected", Toast.LENGTH_SHORT).show());
    }

    private void simulateSearch(String location) {
        // Simulate a search delay
        locationPin.animate()
                .translationX((float) (Math.random() * 100 - 50))
                .translationY((float) (Math.random() * 100 - 50))
                .setDuration(500)
                .start();

        Toast.makeText(this, "Searching for: " + location, Toast.LENGTH_SHORT).show();
    }
}