package com.example.myproject;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class InternetReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String status=CheckInternet.getNetworkInfo(context);
        if(status.equals("connected"))
            Toast.makeText(context.getApplicationContext(), "is connected", Toast.LENGTH_SHORT).show();
        else if(status.equals("disconnected"))
            Toast.makeText(context.getApplicationContext(), "is connected", Toast.LENGTH_SHORT).show();
    }
}
