package com.ayusheg.launcherlock;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class startOnBoot extends Service {

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }
}