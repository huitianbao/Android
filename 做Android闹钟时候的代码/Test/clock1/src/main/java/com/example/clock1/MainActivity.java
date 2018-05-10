package com.example.clock1;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private AlarmManager alarmManager;
    private Button button_settime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button_settime=(Button)findViewById(R.id.button_setclock);
        button_settime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alarmOne(view);
            }
        });

        //获取闹钟的管理者
        alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
    }


    public  void  alarmOne(View view){
        //获取当前系统的时间
        Calendar calendar=Calendar.getInstance();
        int hour=calendar.get(Calendar.HOUR_OF_DAY);
        int minute=calendar.get(Calendar.MINUTE);
        //弹出时间对话框
        TimePickerDialog timePickerDialog=new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                Calendar c=Calendar.getInstance();
                c.set(Calendar.HOUR_OF_DAY,hourOfDay);
                c.set(Calendar.MINUTE,minute);
                //时间一到，发送广播（闹钟响了）
                Intent intent=new Intent();
                intent.setAction("com.pxd.alarmandnotice.RING");
                //将来时态的跳转
                PendingIntent pendingIntent=PendingIntent.getBroadcast(MainActivity.this,0x101,intent,0);
                //设置闹钟
                alarmManager.set(AlarmManager.RTC_WAKEUP,c.getTimeInMillis(),pendingIntent);
            }
        },hour,minute,true);
        timePickerDialog.show();
    }
}
