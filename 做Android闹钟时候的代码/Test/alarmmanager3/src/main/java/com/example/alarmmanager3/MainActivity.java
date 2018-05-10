 package com.example.alarmmanager3;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

 public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btn_set;
    private Button btn_cancel;
    private AlarmManager alarmManager;
    private PendingIntent pi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindViews();
    }

     private void bindViews() {
         btn_set = (Button) findViewById(R.id.button_set_clock);
         btn_cancel = (Button) findViewById(R.id.button_close_colck);
         alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

         Intent intent = new Intent(MainActivity.this, ClockActivity.class);
         pi = PendingIntent.getActivity(MainActivity.this, 0, intent, 0);

         btn_set.setOnClickListener(this);
         btn_cancel.setOnClickListener(this);

     }

     @Override
     public void onClick(View view) {
         switch (view.getId()){
             case R.id.button_set_clock:
                 Calendar currentTime = Calendar.getInstance();
                 new TimePickerDialog(MainActivity.this, 0,
                         new TimePickerDialog.OnTimeSetListener() {
                             @Override
                             public void onTimeSet(TimePicker view,
                                                   int hourOfDay, int minute) {
                                 //设置当前时间
                                 Calendar c = Calendar.getInstance();
                                 c.setTimeInMillis(System.currentTimeMillis());
                                 // 根据用户选择的时间来设置Calendar对象
                                 c.set(Calendar.HOUR, hourOfDay);
                                 c.set(Calendar.MINUTE, minute);
                                 // ②设置AlarmManager在Calendar对应的时间启动Activity
                                 alarmManager.set(AlarmManager.RTC_WAKEUP, c.getTimeInMillis(), pi);
                                 Log.e("HEHE",c.getTimeInMillis()+"");   //这里的时间是一个unix时间戳
                                 // 提示闹钟设置完毕:
                                 Toast.makeText(MainActivity.this, "闹钟设置完毕~"+ hourOfDay+":"+minute,
                                         Toast.LENGTH_SHORT).show();
                             }
                         }, currentTime.get(Calendar.HOUR_OF_DAY), currentTime
                         .get(Calendar.MINUTE), false).show();
                 btn_cancel.setVisibility(View.VISIBLE);
                 break;
             case R.id.button_close_colck:
                 alarmManager.cancel(pi);
                 btn_cancel.setVisibility(View.GONE);
                 Toast.makeText(MainActivity.this, "闹钟已取消", Toast.LENGTH_SHORT)
                         .show();
                 break;
         }
     }
 }
