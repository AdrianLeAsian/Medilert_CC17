package com.example.medilert;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import java.util.Calendar;

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
        medication1.setOnClickListener(v -> {
            // Set alarm for Morning Medication
            setAlarm("Morning Medication");
        });

        medication2.setOnClickListener(v -> {
            // Set alarm for Evening Medication
            setAlarm("Evening Medication");
        });
    }

    private void setAlarm(String medicationName) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 8); // Set default hour
        calendar.set(Calendar.MINUTE, 0); // Set default minute
        calendar.set(Calendar.SECOND, 0);

        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(this, AlarmReceiver.class);
        intent.putExtra("medicationName", medicationName);

        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, medicationName.hashCode(), intent, PendingIntent.FLAG_UPDATE_CURRENT);
        alarmManager.setExact(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);

        Toast.makeText(this, medicationName + " alarm set for 8:00 AM", Toast.LENGTH_SHORT).show();
    }
}