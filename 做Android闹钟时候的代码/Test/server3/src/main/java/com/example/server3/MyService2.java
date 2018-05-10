package com.example.server3;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by 16221 on 2018/2/5.
 */

public class MyService2 extends Service{
    private static final String TAG = MyService2.class.getSimpleName();

    private MyBinder mBinder = new MyBinder();
    //private NotificationManager notificationManager=new NotificationManager();

    @Override
    public void onCreate() {
        Log.i(TAG, "onCreate");
        frontService();
        super.onCreate();
    }
    /**
     * 前台服务
     */
    private void frontService() {
        /*
        Notification notification = new Notification(R.mipmap.ic_launcher,
                "Notification", System.currentTimeMillis());
                */

        //notification.setLatestEventInfo(this, "Title", "Content", pendingIntent);
        NotificationManager notificationManager=(NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        //------------------------------------------------------------------------------------------
        Notification.Builder builder=new Notification.Builder(MyService2.this);
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setContentTitle("Tiltle");
        builder.setContentText("Content 点击查看详细内容");
        builder.setWhen(System.currentTimeMillis());
        builder.setDefaults(Notification.DEFAULT_ALL);
        builder.setAutoCancel(true);

        Intent notificationIntent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0,
                notificationIntent, 0);

        builder.setContentIntent(pendingIntent);

        Notification notification1=builder.build();
       // notificationManager.notify(124,notification1);


        //------------------------------------------------------------------------------------------
        startForeground(1, notification1);
        Log.d(TAG, "onCreate() executed");
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {

        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG, "onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Log.i(TAG, "onDestroy");
        super.onDestroy();
    }

    class MyBinder extends Binder {

        public void toDo() {
            Log.i(TAG, "toDo");
        }
    }
}
