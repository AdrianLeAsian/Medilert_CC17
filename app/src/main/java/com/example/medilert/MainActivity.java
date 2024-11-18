package com.example.medilert;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText usernameInput, passwordInput;
    private Button loginButton;
    private TextView forgotPasswordLink;
    private ImageView goButton, fbButton, appleButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        usernameInput = findViewById(R.id.username_input);
        passwordInput = findViewById(R.id.password_input);
        loginButton = findViewById(R.id.login_button);
        forgotPasswordLink = findViewById(R.id.forgotPasswordLink);
        goButton = findViewById(R.id.goButton);
        fbButton = findViewById(R.id.fbButton);
        appleButton = findViewById(R.id.appleButton);

        // Login button click handler
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameInput.getText().toString().trim();
                String password = passwordInput.getText().toString().trim();

                // Basic validation
                if (username.isEmpty()) {
                    usernameInput.setError("Username is required");
                    usernameInput.requestFocus();
                    return;
                }

                if (password.isEmpty()) {
                    passwordInput.setError("Password is required");
                    passwordInput.requestFocus();
                    return;
                }

                // For demo, proceed to Dashboard
                Intent intent = new Intent(MainActivity.this, Dashboard.class);
                intent.putExtra("username", username);
                startActivity(intent);
                finish();
            }
        });

        // Social login buttons click handlers
        View.OnClickListener socialLoginListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String provider = "";
                if (v.getId() == R.id.goButton) {
                    provider = "Google";
                } else if (v.getId() == R.id.fbButton) {
                    provider = "Facebook";
                } else if (v.getId() == R.id.appleButton) {
                    provider = "Apple";
                }
                Toast.makeText(MainActivity.this, provider + " login clicked", Toast.LENGTH_SHORT).show();
            }
        };

        goButton.setOnClickListener(socialLoginListener);
        fbButton.setOnClickListener(socialLoginListener);
        appleButton.setOnClickListener(socialLoginListener);

        // Forgot password link handler
        forgotPasswordLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Forgot password clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }
}