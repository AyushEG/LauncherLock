package com.ayusheg.launcherlock;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class onBootComplete extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        {
            if (intent.getAction().equalsIgnoreCase(Intent.ACTION_BOOT_COMPLETED)) {
                Intent serviceIntent = new Intent (context, startOnBoot.class);
                context.startService(serviceIntent);
            }
        }
    }
}