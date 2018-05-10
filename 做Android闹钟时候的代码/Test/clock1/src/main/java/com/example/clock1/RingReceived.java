package com.example.clock1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;


/**
 * Created by 16221 on 2018/2/2.
 */

public class RingReceived extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if("com.pxd.alarmandnotice.RING".equals(intent.getAction())){
            Log.i("test","闹钟响了");
         // Toast.makeText(com.example.clock1.RingReceived.this,"闹钟响了",Toast.LENGTH_LONG).show();
            //跳转到Activity n //广播接受者中（跳转Activity）
            Intent intent1=new Intent(context,RingActivity.class);
            //给Intent设置标志位
            intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent1);
        }
    }
}

