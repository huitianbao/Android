package com.example.clock2;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    Button setTime;
    AlarmManager aManager;
    Calendar currentTime = Calendar.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 获取程序界面的按钮
        setTime = (Button) findViewById(R.id.button_settime);
        // 获取AlarmManager对象
        aManager = (AlarmManager) getSystemService(
                Service.ALARM_SERVICE);
        // 为“设置闹铃”按钮绑定监听器。
        setTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // Calendar currentTime = Calendar.getInstance();
                // 创建一个TimePickerDialog实例，并把它显示出来。
                new TimePickerDialog(MainActivity.this, 0, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int i, int i1) {
                        // 指定启动AlarmActivity组件
                        Intent intent = new Intent();
                        intent.setAction("com.example.clock2.ACTION");
                        // 创建PendingIntent对象
                        PendingIntent pi = PendingIntent.getActivity(MainActivity.this, 0, intent, 0);

                        Calendar c = Calendar.getInstance();
                        // 根据用户选择时间来设置Calendar对象
                        c.set(Calendar.HOUR_OF_DAY, i);
                        c.set(Calendar.MINUTE, i1);
                        // 设置AlarmManager将在Calendar对应的时间启动指定组件
                        aManager.set(AlarmManager.RTC_WAKEUP,
                                c.getTimeInMillis(), pi);
                        // 显示闹铃设置成功的提示信息
                        Toast.makeText(MainActivity.this, "闹铃设置成功啦"
                                , Toast.LENGTH_SHORT).show();

                    }
                }, currentTime.get(Calendar.HOUR_OF_DAY), currentTime
                        .get(Calendar.MINUTE), false).show();
            }

        });
    }
}
