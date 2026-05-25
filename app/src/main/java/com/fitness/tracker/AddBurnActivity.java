package com.fitness.tracker;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AddBurnActivity extends AppCompatActivity {

    private EditText amountInput;
    private Button saveButton;
    private Button cancelButton;
    private DataStorage storage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_burn);

        // Connect to layout views
        amountInput = findViewById(R.id.amountInput);
        saveButton = findViewById(R.id.saveButton);
        cancelButton = findViewById(R.id.cancelButton);

        // Create storage object
        storage = new DataStorage(this);

        // When user clicks Save button
        saveButton.setOnClickListener(v -> saveBurn());

        // When user clicks Cancel button
        cancelButton.setOnClickListener(v -> finish());
    }

    private void saveBurn() {
        // Get what the user typed
        String input = amountInput.getText().toString();

        // Check if user entered something
        if (input.isEmpty()) {
            Toast.makeText(this, "Please enter an amount!", Toast.LENGTH_SHORT).show();
            return;
        }

        // Convert text to number
        int amount = Integer.parseInt(input);

        // Check if amount is positive
        if (amount <= 0) {
            Toast.makeText(this, "Enter a number greater than 0!", Toast.LENGTH_SHORT).show();
            return;
        }

        // Save the burn amount
        storage.saveBurnAmount(amount);

        // Show success message
        Toast.makeText(this, "Exercise saved!", Toast.LENGTH_SHORT).show();

        // Go back to home screen
        finish();
    }
}
