package com.example.clock3;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;
import java.util.TimeZone;

public class MainActivity extends AppCompatActivity {
    private final static String TAG = MainActivity.class.getSimpleName();
    private TimePicker timePicker;
    private Button mButton1,mButton2,mButtonCancel,mButtonCancel1;
    private int mHour = -1;
    private int mMinute = -1;
    public static final long DAY = 1000L*60*60*24;
    Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContext = MainActivity.this;

        //获取当前时间
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        if(mHour == -1&& mMinute == -1){
            mHour = calendar.get(Calendar.HOUR_OF_DAY);
            mMinute = calendar.get(Calendar.MINUTE);
        }

        timePicker = (TimePicker) findViewById(R.id.timePicker);
        timePicker.setCurrentHour(mHour);
        timePicker.setCurrentMinute(mMinute);
        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker timePicker, int i, int i1) {
                mHour = i;
                mMinute = i1;
            }
        });
        mButton1 = (Button) findViewById(R.id.normal_button);
        //设置下班闹铃
        mButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AlarmReceiver.class);
                intent.setAction("com.example.clock3.action.outwork");//?????????????????????????????????????????????????????????????????????????????????????????????
                PendingIntent pendingIntent = PendingIntent.getBroadcast(MainActivity.this,0,intent,0);

                long firstTime = SystemClock.elapsedRealtime();//开机之后到现在的运行时间
                long systemTime = System.currentTimeMillis();
                //设置闹铃时间
                Calendar calendar1 = Calendar.getInstance();
                calendar1.setTimeInMillis(System.currentTimeMillis());
                calendar1.setTimeZone(TimeZone.getTimeZone("GMT+8"));
                calendar1.set(Calendar.MINUTE,mMinute);
                calendar1.set(Calendar.HOUR_OF_DAY,mHour);
                calendar1.set(Calendar.SECOND,0);
                calendar1.set(Calendar.MILLISECOND,0);
                //选择的每天的定时时间即下班时间
                long selectTime = calendar1.getTimeInMillis();
                //如果当前时间大于设置的时间，那么从第二天的设定时间开始
                if(systemTime > selectTime){
                    Toast.makeText(mContext,"设置的时间小于当前时间",Toast.LENGTH_SHORT).show();
                    calendar1.add(Calendar.DAY_OF_MONTH,1);
                    selectTime = calendar1.getTimeInMillis();
                }

                //计算现在时间到设置时间的时间差
                long diffTime1 = selectTime - systemTime;
                firstTime += diffTime1;

                //进行闹铃注册
                AlarmManager manager = (AlarmManager) getSystemService(ALARM_SERVICE);
                manager.setRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP,firstTime,5*60*1000,pendingIntent);
                Toast.makeText(mContext,"设置下班提醒成功！",Toast.LENGTH_SHORT).show();
            }
        });

        //重复闹铃
        mButton2 = (Button) findViewById(R.id.repeating_button);
        mButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext,AlarmReceiver.class);
                intent.setAction("com.example.clock3.action.eyes");
                PendingIntent sender = PendingIntent.getBroadcast(mContext,0,intent,0);

                long firstTime = SystemClock.elapsedRealtime();//开机之后到现在的运行时间
                long systemTime = System.currentTimeMillis();

                Calendar calendar2 = Calendar.getInstance();
                calendar2.setTimeInMillis(System.currentTimeMillis());
                calendar2.setTimeZone(TimeZone.getTimeZone("GMT+8"));
                calendar2.set(Calendar.MINUTE,mMinute);
                calendar2.set(Calendar.HOUR_OF_DAY,mHour);
                calendar2.set(Calendar.SECOND,0);
                calendar2.set(Calendar.MILLISECOND,0);


                //选择的每天定时时间
                long selectTime = calendar2.getTimeInMillis();
                //如果当前时间大于设置的时间，那么从第二天的设定时间开始
                if(systemTime > selectTime){
                    Toast.makeText(mContext,"设置的时间小于当前时间",Toast.LENGTH_SHORT).show();
                    calendar2.add(Calendar.DAY_OF_MONTH,1);
                    selectTime = calendar2.getTimeInMillis();
                }
                //计算现在时间到设置时间的时间差
                long difTime = selectTime - systemTime;
                //不管将不将此句注释掉，都是每隔一分钟闹铃响一次。
                firstTime += difTime;

                //进行闹铃注册
                AlarmManager manager = (AlarmManager) getSystemService(ALARM_SERVICE);

                //                //第一个参数int type指定定时服务的类型，该参数接受如下值：
//                /*ELAPSED_REALTIME： 在指定的延时过后，发送广播，但不唤醒设备（闹钟在睡眠状态下不可用）。如果在系统休眠时闹钟触发，它将不会被传递，直到下一次设备唤醒。
//                *ELAPSED_REALTIME_WAKEUP： 在指定的延时过后，发送广播，并唤醒设备（即使关机也会执行operation所对应的组件）
//                * RTC：在指定的时刻，发送广播，但不唤醒设备，如果在系统休眠时闹钟触发，它将不会被传递，直到下一次设备唤醒（闹钟在睡眠状态下不可用）。
//                * RTC_WAKEUP：在指定的时刻，发送广播，并唤醒设备，即使系统关机也会执行 operation所对应的组件
//                * */
                //AlarmManager.ELAPSED_REALTIME_WAKEUP真实时间流逝闹钟，当闹钟发躰时唤醒手机休眠；
                //第二个参数表示闹钟首次执行时间
//                /*
//                * 第三个参数设为60*1000以下时，都是一分钟提醒一次。
//                * 第三个参数intervalTime为闹钟间隔，内置的几个变量如下：
//                * INTERVAL_DAY：      设置闹钟，间隔一天
//                * INTERVAL_HALF_DAY：  设置闹钟，间隔半天
//                * INTERVAL_FIFTEEN_MINUTES：设置闹钟，间隔15分钟
//                * INTERVAL_HALF_HOUR：     设置闹钟，间隔半个小时
//                * INTERVAL_HOUR：  设置闹钟，间隔一个小时
//                * */
                manager.setRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP,firstTime,45*60*1000,sender);
                Log.i(TAG,"time ="+difTime+",selectTime="+selectTime+",systemTime="+systemTime+",firstTime="+firstTime);
                Toast.makeText(mContext,"设置护眼闹铃成功！",Toast.LENGTH_SHORT).show();

            }
        });


        //取消护眼闹铃
        mButtonCancel = (Button) findViewById(R.id.cancel_button);
        mButtonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext,AlarmReceiver.class);
                intent.setAction("com.example.commuting.action.eyes");
                PendingIntent sender = PendingIntent.getBroadcast(mContext,0,intent,0);
                //取消闹铃
                AlarmManager am = (AlarmManager) getSystemService(ALARM_SERVICE);
                am.cancel(sender);
                Toast.makeText(mContext,"取消护眼闹铃成功！",Toast.LENGTH_SHORT).show();
            }
        });

        //取消下班闹铃
        mButtonCancel1 = (Button) findViewById(R.id.cancel_button1);
        mButtonCancel1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext,AlarmReceiver.class);
                intent.setAction("com.example.commuting.action.clock3");
                PendingIntent sender = PendingIntent.getBroadcast(mContext,0,intent,0);
                //取消闹铃
                AlarmManager am = (AlarmManager) getSystemService(ALARM_SERVICE);
                am.cancel(sender);
                Toast.makeText(mContext,"取消下班闹铃成功！",Toast.LENGTH_SHORT).show();
            }
        });

    }
}
