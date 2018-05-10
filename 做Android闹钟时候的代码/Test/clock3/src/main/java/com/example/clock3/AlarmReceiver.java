package com.example.clock3;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 16221 on 2018/2/3.
 */

public class AlarmReceiver extends BroadcastReceiver {
    String soundPath = Environment.getExternalStorageDirectory() + "/";
    Context mContext;

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "闹铃响了, 可以做点事情了~~", Toast.LENGTH_LONG).show();
        Log.d("AlarmRecever", "闹铃响了");
        mContext = context;
        //=====================状态栏提示 start =================
        //设置通知内容并开启
        NotificationManager manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        List<String> list = getSDCardMusic(context);

        //下班闹铃的响应
        if (intent.getAction().equals("com.example.clock3.action.outwork")) {
            Notification notification1 = new Notification.Builder(context)
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setContentTitle("下班时间到了")
                    .setContentText("下班时间到了，记得打卡")
                    .setWhen(System.currentTimeMillis())
                    .setContentIntent(getDefaultIntent(PendingIntent.FLAG_UPDATE_CURRENT))
                    .build();
            if (list != null && list.size() != 0) {
                notification1.sound = Uri.parse(list.get(0));
            } else {
                notification1.defaults |= Notification.DEFAULT_SOUND;
            }
            //设置声音循环播放
            notification1.flags |= Notification.FLAG_INSISTENT;
            notification1.defaults |= Notification.DEFAULT_VIBRATE;
            notification1.defaults |= Notification.DEFAULT_LIGHTS;
            manager.notify(2, notification1);
        }
        //护眼闹铃的响应
        else if (intent.getAction().equals("com.example.clock3.action.eyes")) {
            Notification notification = new Notification.Builder(context)
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setContentTitle("用电脑的时间过长！")
                    .setContentText("用电脑时间有点长，眼睛需要好好休息一下。")
                    .setWhen(System.currentTimeMillis())
                    //当用Notification.FLAG_AUTO_CANCEL时，点击通知栏后,通知栏自动消失（不是通知栏消息消失）
                    //用PendingIntent.FLAG_UPDATE_CURRENT)时，点击通知栏消息后，消息消失
                    .setContentIntent(getDefaultIntent(PendingIntent.FLAG_UPDATE_CURRENT))
                    .build();


              /*
         * 添加声音可以使用默认声音，也可以自定义声音，也可以用系统声音
         * */

            if (list != null && list.size() != 0) {
                notification.sound = Uri.parse(list.get(0));
                Log.d("AlarmReceiver", "musicName=" + list.get(0));
            } else {
                notification.defaults |= Notification.DEFAULT_SOUND;
            }

            //设置声音循环播放
            notification.flags |= Notification.FLAG_INSISTENT;

        /*
        * 添加振动，可以添加默认的振动defaults，也可以添加自定义振动vibrate
        * 另外还需要注意一点：使用振动器时需要权限，如下：
        * <uses-permission android:name="android.permission.VIBRATE"></uses-permission>
        * */
            notification.defaults |= Notification.DEFAULT_VIBRATE;


             /*
        * 设置灯光
        * */
            notification.defaults |= Notification.DEFAULT_LIGHTS;
//        notification.contentIntent = PendingIntent.getActivity()
            //不起作用
            notification.flags |= Notification.FLAG_AUTO_CANCEL;

            manager.notify(1, notification);// 这个notification 的 id 设为1023


        }
    }

    //获取设备SD卡中的歌曲路径
    public List<String> getSDCardMusic(Context context) {
        String musicName;
        int isMusic;
        Cursor cursor = context.getContentResolver().query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, null, null, null,
                MediaStore.Audio.Media.DEFAULT_SORT_ORDER);
        List<String> musics = new ArrayList<>();
        for (int i = 0; i < cursor.getCount(); i++) {
            cursor.moveToNext();
            musicName = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.DATA));
//            Log.d("AlarmReceiver","musicName="+musicName);
            isMusic = cursor.getInt(cursor.getColumnIndex(MediaStore.Audio.Media.IS_MUSIC));
            if (isMusic != 0) {
                musics.add(musicName);
            }
        }
        return musics;
    }

    public PendingIntent getDefaultIntent(int flags) {
        PendingIntent pendingIntent = PendingIntent.getActivity(mContext, 1, new Intent(), flags);
        return pendingIntent;

    }

}

