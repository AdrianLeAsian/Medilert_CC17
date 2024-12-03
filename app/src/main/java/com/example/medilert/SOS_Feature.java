package com.example.medilert;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class SOS_Feature extends AppCompatActivity {
    private Button sosButton;
    private static final String CHANNEL_ID = "sos_alert_channel";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sos_feature);

        // Initialize views
        sosButton = findViewById(R.id.sosButton);
        ImageButton backButton = findViewById(R.id.backButton);

        // Create notification channel
        createNotificationChannel();

        // SOS button click handler
        sosButton.setOnClickListener(v -> {
            // Show toast message
            Toast.makeText(SOS_Feature.this,
                    "Emergency alert sent! Help is on the way.",
                    Toast.LENGTH_LONG).show();

            // Launch the calling screen activity
            Intent intent = new Intent(SOS_Feature.this, SOS_Feature_Call.class);
            startActivity(intent);

            // Send notification
            sendSOSNotification();

            // Disable the button to prevent multiple alerts
            sosButton.setEnabled(false);
            sosButton.setText("Alert Sent");
        });

        // Back button click handler
        backButton.setOnClickListener(v -> {
            // Return to the previous screen
            finish();
        });
    }

    // Method to send the SOS notification
    private void sendSOSNotification() {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(android.R.drawable.ic_dialog_alert)
                .setContentTitle("SOS Alert")
                .setContentText("Help is on the way!")
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setAutoCancel(true);

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        notificationManager.notify(1, builder.build()); // Notification ID is 1
    }

    // Method to create the notification channel (required for Android 8.0+)
    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "SOS Alert Channel";
            String description = "Channel for SOS notifications";
            int importance = NotificationManager.IMPORTANCE_HIGH;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);

            // Register the channel with the system
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }
}
