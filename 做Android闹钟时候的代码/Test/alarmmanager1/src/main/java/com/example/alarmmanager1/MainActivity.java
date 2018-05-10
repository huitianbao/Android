package com.example.alarmmanager1;

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
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {



    private Button btn_start;
    private Button btn_stop;
    private TextView textView_show_current_time;
    private TextView textView_show_set_time;


    @Override
    protected void onCreate(final Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        //显示当前时间
        showcurrenttime();


        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }

        });

        btn_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }


    //获取当前时间
    private void showcurrenttime() {

        final Calendar mCalendar = Calendar.getInstance();
        int hour, min;

        hour = mCalendar.get(Calendar.HOUR_OF_DAY);
        min = mCalendar.get(Calendar.MINUTE);
        textView_show_current_time.setText(hour + ":" + min);


    }
/*

    private void showTimePickerDialog() {
        final Calendar mCalendar = Calendar.getInstance();
        long time=System.currentTimeMillis();

        TimePickerDialog dialog = new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int i, int i1) {
                mCalendar.set(Calendar.HOUR, i);
                mCalendar.set(Calendar.MINUTE, i1);
               // mCalendar.setTimeInMillis(time);

/*
                SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日HH:mm");
                Toast.makeText(getApplicationContext(), "" + format.format(mCalendar.getTime()), Toast.LENGTH_SHORT).show();

                textView_show_set_time.setText(i+":"+i1);

                Toast.makeText(getApplicationContext(), "the time you set is "+i+":"+i1 , Toast.LENGTH_SHORT).show();
            }
        }, mCalendar.get(Calendar.HOUR), mCalendar.get(Calendar.MINUTE), true);
        dialog.show();

    }
    */


    private void init() {
        btn_start = (Button) findViewById(R.id.button_start);
        btn_stop = (Button) findViewById(R.id.button_stop);
        textView_show_current_time = (TextView) findViewById(R.id.textView_currentTime);
        textView_show_set_time = (TextView) findViewById(R.id.textView_show_time_you_set);


    }


}
