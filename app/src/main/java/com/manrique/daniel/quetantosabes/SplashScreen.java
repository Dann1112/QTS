package com.manrique.daniel.quetantosabes;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;


public class SplashScreen extends Activity {

    // Set the duration of the splash screen in milliseconds
    private static final long SPLASH_SCREEN_DELAY = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Force portrait orientation
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        setContentView(R.layout.splash_screen);

        TimerTask task = new TimerTask() {
            @Override
            public void run() {

                // Start the next activity
                Intent mainIntent = new Intent().setClass(
                        SplashScreen.this, MainActivity.class);
                startActivity(mainIntent);

                // Close the activity so the user won't able to go back this
                // activity pressing Back button
                finish();
            }
        };

        // Simulate a long loading process on application startup.
        Timer timer = new Timer();
        timer.schedule(task, SPLASH_SCREEN_DELAY);
    }

}
