package com.fitness.tracker;

import android.content.Context;
import android.content.SharedPreferences;

public class DataStorage {
    
    private SharedPreferences preferences;
    private static final String PREF_NAME = "FitnessData";
    
    public DataStorage(Context context) {
        preferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }
    
    // Save food amount for today
    public void saveFoodAmount(int amount) {
        int current = getFoodAmount();
        preferences.edit().putInt("food_today", current + amount).apply();
    }
    
    // Get total food for today
    public int getFoodAmount() {
        return preferences.getInt("food_today", 0);
    }
    
    // Save burn amount for today
    public void saveBurnAmount(int amount) {
        int current = getBurnAmount();
        preferences.edit().putInt("burn_today", current + amount).apply();
    }
    
    // Get total burn for today
    public int getBurnAmount() {
        return preferences.getInt("burn_today", 0);
    }
    
    // Reset daily data (call at midnight)
    public void resetDailyData() {
        preferences.edit().putInt("food_today", 0).apply();
        preferences.edit().putInt("burn_today", 0).apply();
    }
}
