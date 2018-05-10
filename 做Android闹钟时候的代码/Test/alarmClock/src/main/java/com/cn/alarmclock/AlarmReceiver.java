package com.cn.alarmclock;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class AlarmReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {   
		String action = intent.getAction() ;
		String data = intent.getDataString() ;
		String scheme = intent.getScheme() ;
		System.out.println("action = "+action+" data = "+data +" scheme = "+scheme);
        Toast.makeText(context, "你设置的闹钟时间到了", Toast.LENGTH_LONG).show();   
    }   

}
