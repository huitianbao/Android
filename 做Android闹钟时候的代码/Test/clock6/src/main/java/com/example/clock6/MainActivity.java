package com.example.clock6;

import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private Button mSet;
    Calendar mCalendar = Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ObjectPool.mAlarmHelper = new AlarmHelper(this);
        mSet = (Button) findViewById(R.id.mSet);
        setListener();
    }

    public void setListener() {
        mSet.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mCalendar.setTimeInMillis(System.currentTimeMillis());
                int mHour = mCalendar.get(Calendar.HOUR_OF_DAY);
                int mMinute = mCalendar.get(Calendar.MINUTE);
                new TimePickerDialog(MainActivity.this,
                        new TimePickerDialog.OnTimeSetListener() {
                            public void onTimeSet(TimePicker view,
                                                  int hourOfDay, int minute) {
                                mCalendar.setTimeInMillis(System
                                        .currentTimeMillis());
                                mCalendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
                                mCalendar.set(Calendar.MINUTE, minute);
                                mCalendar.set(Calendar.SECOND, 0);
                                mCalendar.set(Calendar.MILLISECOND, 0);
                                ObjectPool.mAlarmHelper.openAlarm(32, "ddd",
                                        "ffff", mCalendar.getTimeInMillis());
                            }
                        }, mHour, mMinute, true).show();
            }
        });
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            showBackDialog();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }


    /** Give the tip when exit the application. */
    public void showBackDialog() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("提示")
                .setIcon(R.mipmap.ic_launcher)
                .setMessage("是否退出?")
                .setPositiveButton("退出",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,
                                                int which) {
                                System.exit(0);
                                android.os.Process
                                        .killProcess(android.os.Process
                                                .myPid());

                                dialog.dismiss();
                            }
                        })
                .setNegativeButton("取消",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,
                                                int which) {
                                dialog.dismiss();
                            }
                        });
        AlertDialog ad = builder.create();
        ad.show();
    }

}
