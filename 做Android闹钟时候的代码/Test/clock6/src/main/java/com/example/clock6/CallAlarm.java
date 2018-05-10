package com.example.clock6;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by 16221 on 2018/2/3.
 */

public class CallAlarm extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {
        intent.setClass(context, AlarmAlert.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }
}
