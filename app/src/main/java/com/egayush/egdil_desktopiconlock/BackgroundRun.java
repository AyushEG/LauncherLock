package com.egayush.egdil_desktopiconlock;

import android.app.IntentService;
import android.content.Intent;

public class BackgroundRun extends IntentService {
    // Must create a default constructor
    public BackgroundRun() {
        // Used to name the worker thread, important only for debugging.
        super("BackgroundRun");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        // Normally we would do some work here, like download a file.
        // For our sample, we just sleep for 5 seconds.
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            // Restore interrupt status.
            Thread.currentThread().interrupt();
        }
    }
}