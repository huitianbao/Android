package com.example.service2;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by 16221 on 2018/2/5.
 */

class HelloteacherService extends Service {
    HelloteacherService2 hs2;
    private String TAG = "HelloteacherService";

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG, "-->>onCreate");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG, "-->>onStartCommand-->>" + startId);
        flags = START_STICKY;

        //启用前台服务，主要是startForeground()
        Notification notification = new Notification(R.mipmap.ic_launcher, "用电脑时间过长了！白痴！"
                , System.currentTimeMillis());
        notification.setLatestEventInfo(this, "快去休息！！！",
                "一定保护眼睛,不然遗传给孩子，老婆跟别人跑啊。", null);
        notification.
        //设置通知默认效果
        notification.flags = Notification.FLAG_SHOW_LIGHTS;
        startForeground(1, notification);

        AlarmManager manager = (AlarmManager) getSystemService(ALARM_SERVICE);
        //读者可以修改此处的Minutes从而改变提醒间隔时间
        //此处是设置每隔55分钟启动一次
        //这是55分钟的毫秒数
        int Minutes = 55 * 60 * 1000;
        //SystemClock.elapsedRealtime()表示1970年1月1日0点至今所经历的时间
        long triggerAtTime = SystemClock.elapsedRealtime() + Minutes;
        //此处设置开启AlarmReceiver这个Service
        Intent i = new Intent(this, Alarmreceiver.class);
        PendingIntent pi = PendingIntent.getBroadcast(this, 0, i, 0);
        //ELAPSED_REALTIME_WAKEUP表示让定时任务的出发时间从系统开机算起，并且会唤醒CPU。
        manager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP, triggerAtTime, pi);

        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.i(TAG, "-->>onBind");
        return null;
    }

    @Override
    public void onDestroy() {
        Log.i(TAG, "-->>onDestroy");
        super.onDestroy();
    }
}
