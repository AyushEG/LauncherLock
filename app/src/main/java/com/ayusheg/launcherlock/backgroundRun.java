package com.ayusheg.launcherlock;

import android.app.IntentService;
import android.content.Intent;

public class backgroundRun extends IntentService {
    // Must create a default constructor
    public backgroundRun() {
        // Used to name the worker thread, important only for debugging.
        super("backgroundRun");
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