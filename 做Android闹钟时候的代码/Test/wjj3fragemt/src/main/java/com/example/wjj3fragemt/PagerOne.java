package com.example.wjj3fragemt;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

import static android.content.Context.ALARM_SERVICE;

/**
 * Created by 16221 on 2018/2/10.
 */

public class PagerOne extends Fragment{
    private AlarmManager alarmManager;
    private PendingIntent pi;
    private Calendar calendar=Calendar.getInstance();
    private TimePicker timePicker;
    private DatePicker datePicker;
    private Button button_con;
    private Button button_cal;
    private int c_hour,c_min;
    private int d_year,d_month,d_day;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootview=inflater.inflate(R.layout.pager_one, container, false);
        datePicker=(DatePicker)rootview.findViewById(R.id.my_datePicker);
        timePicker=(TimePicker)rootview.findViewById(R.id.my_timePicker);
        button_con=(Button)rootview.findViewById(R.id.button_con);
        button_cal=(Button)rootview.findViewById(R.id.button_cancel);

        timePicker.setIs24HourView(true);

        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker timePicker, int i, int i1) {

                c_hour=i;
                c_min=i1;
                Toast toast2= Toast.makeText(getActivity(),"您选择的时间:"+c_hour+":"+c_min,Toast.LENGTH_LONG);
                showMyToast(toast2,1*1000);
            }

        });

        button_cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cancel_set();

                //Intent intent=new Intent(PagerOne.this,MainActivity.class);
                DataTime dataTime=new DataTime();
                dataTime.setRest("今天休息");

                //intent.putExtra("msg11", dataTime);
                //startActivity(intent);
            }
        });

        return rootview;


    }

    private void cancel_set(){
        alarmManager = (AlarmManager) getContext().getSystemService(ALARM_SERVICE);

       //Intent intent = new Intent(SelectActivity1.this, ClockActivity.class);
        Intent intent=new Intent();
        pi = PendingIntent.getActivity(PagerOne., 0, intent, 0);
        alarmManager.cancel(pi);
    }

    private void bindViews(long tt) {


        alarmManager = (AlarmManager)getContext().getSystemService(ALARM_SERVICE);

        Intent intent = new Intent();
        pi = PendingIntent.getActivity(PagerOne.this, 0, intent, 0);
        alarmManager.set(AlarmManager.RTC_WAKEUP,tt, intent);
    }


    private long calendar_set(){
        long time;
        calendar.set(Calendar.YEAR,d_year);
        calendar.set(Calendar.MONTH,d_month);
        calendar.set(Calendar.DAY_OF_MONTH,d_day);
        calendar.set(Calendar.HOUR_OF_DAY,c_hour);
        calendar.set(Calendar.MINUTE,c_min);
        calendar.set(Calendar.SECOND,0);
        calendar.set(Calendar.MILLISECOND,0);
        time=calendar.getTimeInMillis();

        return time;


    }

    public void showMyToast(final Toast toast, final int cnt) {
        final Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                toast.show();
            }
        }, 0, 1000);
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                toast.cancel();
                timer.cancel();
            }
        }, cnt );
    }



}
