package com.example.service2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by 16221 on 2018/2/5.
 */

class Alarmreceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("arui.alarm.action")) {
            Intent i = new Intent();
            i.setClass(context, HelloteacherService.class);
            // 启动service
            // 多次调用startService并不会启动多个service 而是会多次调用onStart
            context.startService(i);
        }
    }
}
