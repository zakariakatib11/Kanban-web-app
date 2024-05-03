package com.example.kanban;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText usernameEditText;
    private EditText passwordEditText;
    private AppCompatButton loginButton;

    // Test username and password values
    private static final String TEST_USERNAME = "testuser";
    private static final String TEST_PASSWORD = "testpassword";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        // Retrieve references to the username and password fields from the XML layout
        usernameEditText = findViewById(R.id.username);
        passwordEditText = findViewById(R.id.password);

        // Retrieve a reference to the login button from the XML layout
        loginButton = findViewById(R.id.login_button);

        // Add an event listener to detect clicks on the login button
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                if (validateCredentials(username, password)) {
                    goToNextPage();
                } else {
                    showError();
                }
            }
        });

    }

    // Method to validate login credentials
    private boolean validateCredentials(String username, String password) {
        return username.equals(TEST_USERNAME) && password.equals(TEST_PASSWORD);
    }

    // Method to transition to the next activity
    private void goToNextPage() {
        Intent intent = new Intent(LoginActivity.this, verification_code_controller.class);  // Ensure this is the correct class name
        startActivity(intent);
        finish();
    }

    // Method to show an error message if login information is invalid
    private void showError() {
        Toast.makeText(LoginActivity.this, "Erreur de connexion. Veuillez réessayer.", Toast.LENGTH_SHORT).show();
    }
}
