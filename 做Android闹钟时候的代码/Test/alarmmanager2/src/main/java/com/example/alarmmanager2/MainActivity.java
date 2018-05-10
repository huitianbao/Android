package com.example.alarmmanager2;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    long static_time;
    private Button button_settime;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button_settime = (Button) findViewById(R.id.button_setTime);
        button_settime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar mCalendar = Calendar.getInstance();


                TimePickerDialog dialog = new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int i, int i1) {
                        mCalendar.set(Calendar.HOUR, i);
                        mCalendar.set(Calendar.MINUTE, i1);
                        static_time = mCalendar.getTimeInMillis();


                        Toast.makeText(getApplicationContext(), "the time you set is " + i + ":" + i1, Toast.LENGTH_SHORT).show();
                    }
                }, mCalendar.get(Calendar.HOUR), mCalendar.get(Calendar.MINUTE), true);
                dialog.show();

                alarm(view);
            }

            //-----------------------------------------------------------------------------------------------------------------------------

        });

    }

    public void alarm(View v) {
        AlarmManager am = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

        Intent intent = new Intent(this, AlarmService.class);
        intent.setAction(AlarmService.ACTION_ALARM);
        PendingIntent pendingIntent = PendingIntent.getService(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        if (Build.VERSION.SDK_INT < 19) {
            am.set(AlarmManager.RTC_WAKEUP, static_time, pendingIntent);
        } else {
            am.setExact(AlarmManager.RTC_WAKEUP, static_time, pendingIntent);
        }
    }
}


