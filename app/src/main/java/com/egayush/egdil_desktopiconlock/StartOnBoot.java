package com.egayush.egdil_desktopiconlock;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class StartOnBoot extends Service {

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }
}