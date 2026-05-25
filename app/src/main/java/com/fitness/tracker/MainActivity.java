package com.fitness.tracker;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView goalText;
    private TextView foodText;
    private TextView burnText;
    private Button addFoodButton;
    private Button addBurnButton;
    private DataStorage storage;
    
    private static final int DAILY_GOAL = 2000; // grams

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Connect to layout views
        goalText = findViewById(R.id.goalText);
        foodText = findViewById(R.id.foodText);
        burnText = findViewById(R.id.burnText);
        addFoodButton = findViewById(R.id.addFoodButton);
        addBurnButton = findViewById(R.id.addBurnButton);

        // Create storage object
        storage = new DataStorage(this);

        // Show daily goal
        goalText.setText("Daily Goal: " + DAILY_GOAL + " grams");

        // When user clicks "Add Food" button
        addFoodButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AddFoodActivity.class);
            startActivity(intent);
        });

        // When user clicks "Add Exercise" button
        addBurnButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AddBurnActivity.class);
            startActivity(intent);
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Update the display whenever we come back to this screen
        updateDisplay();
    }

    private void updateDisplay() {
        int foodTotal = storage.getFoodAmount();
        int burnTotal = storage.getBurnAmount();
        
        foodText.setText("Food Consumed: " + foodTotal + " grams");
        burnText.setText("Calories Burned: " + burnTotal + " calories");
    }
}
