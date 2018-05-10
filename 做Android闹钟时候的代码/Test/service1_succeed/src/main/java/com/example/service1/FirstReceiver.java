package com.example.service1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by 16221 on 2018/2/5.
 */

public class FirstReceiver extends BroadcastReceiver {
    private static final String TAG = "FirstReceiver";
    @Override
    public void onReceive(Context context, Intent intent) {
//先获得传过来的MSG
        String msg = intent.getStringExtra("first");
        Log.i(TAG, "R-FirstRecever："+msg);

        //更改广播数据
        Bundle bundle = new Bundle();
        bundle.putString("msg", msg + "@FirstReceiver");
        setResultExtras(bundle);
    }
}
