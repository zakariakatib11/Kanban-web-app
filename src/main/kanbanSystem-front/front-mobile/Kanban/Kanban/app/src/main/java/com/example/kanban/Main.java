package com.example.kanban;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class Main extends AppCompatActivity {

    private AppCompatButton getstartedButton; // Renamed for better clarity

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.landing_page);

        // Retrieve a reference to the get started button from the XML layout
        getstartedButton = findViewById(R.id.getstarted);

        // Add an event listener to detect clicks on the get started button using a lambda expression
        getstartedButton.setOnClickListener(v -> goToNextPage());
    }

    // Method to transition to the next activity
    private void goToNextPage() {
        Intent intent = new Intent(Main.this, Login_main_controller.class);
        startActivity(intent);
        finish();  // Finish the current activity
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_profile) {
            // Handle profile icon click
            // You can open a profile activity or show a dialog for profile settings
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
