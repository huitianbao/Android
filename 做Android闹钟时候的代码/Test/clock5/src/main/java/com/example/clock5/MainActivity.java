package com.example.clock5;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    //Properties
    private Button msetButton;
    private Button mcancelButton;
    private AlermReceiver uIReceiver;
    private TextView mTextView;
    //就用了Java的日历
    private Calendar calendar;
    /** Called when the activity is first created. */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calendar = Calendar.getInstance();
        mTextView = (TextView)this.findViewById(R.id.myTextView);
        msetButton = (Button)this.findViewById(R.id.button_settime);
        mcancelButton = (Button)findViewById(R.id.button_cancel);
        msetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calendar.setTimeInMillis(System.currentTimeMillis());
                int hour = calendar.get(Calendar.HOUR_OF_DAY);
                int minute = calendar.get(Calendar.MINUTE);
                new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int i, int i1) {
                        calendar.setTimeInMillis(System.currentTimeMillis());
                        //set(f, value) changes field f to value.
                        calendar.set(Calendar.HOUR_OF_DAY, i);
                        calendar.set(Calendar.MINUTE, i1);
                        calendar.set(Calendar.SECOND, 0);
                        calendar.set(Calendar.MILLISECOND, 0);
                        Intent intent = new Intent(MainActivity.this, AlermReceiver.class);
                        intent.putExtra("music", true);
                        PendingIntent pendingIntent = PendingIntent.getBroadcast(MainActivity.this, 0, intent, 0);
                        AlarmManager am;
                        //获取系统进程
                        am = (AlarmManager)getSystemService(ALARM_SERVICE);
                        am.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);
                        //设置周期！！
                        am.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()+(10*1000), (24*60*60*1000), pendingIntent);
                        String tmps = "设置闹钟时间为："+format(i)+":"+format(i1);
                        mTextView.setText(tmps);
                    }
                },hour,minute,true).show();
            }
                });


        mcancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AlermReceiver.class);
                intent.putExtra("music", true);
                PendingIntent pendingIntent = PendingIntent.getBroadcast(MainActivity.this, 0, intent, 0);
                AlarmManager am;
                //获取系统进程
                am = (AlarmManager)getSystemService(ALARM_SERVICE);
                //cancel
                am.cancel(pendingIntent);
                mTextView.setText("取消了！");

        }
        });

    }

    private String format(int x) {
        String s = ""+x;
        if(s.length() == 1)
            s = "0"+s;
        return s;
    }

}
