package com.example.janandroid;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.widget.Toast;

public class AirplaneModeChangeReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

            if (isAirplaneModeEnabled(context.getApplicationContext())) {
                Toast.makeText(context, "Airplane mode is enabled", Toast.LENGTH_SHORT).show();
                // Airplane mode is enabled
            } else {
                Toast.makeText(context, "Airplane mode is disabled", Toast.LENGTH_SHORT).show();
                // Airplane mode is disabled
            }

    }
    private static boolean isAirplaneModeEnabled(Context context) {
            return Settings.Global.getInt(context.getContentResolver(), Settings.Global.AIRPLANE_MODE_ON, 0) != 0;
    }
}
