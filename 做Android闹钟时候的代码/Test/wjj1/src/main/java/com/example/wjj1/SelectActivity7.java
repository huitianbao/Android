package com.example.wjj1;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by 16221 on 2018/2/8.
 */

public class SelectActivity7 extends AppCompatActivity {

    private AlarmManager alarmManager;
    private PendingIntent pi;
    private Calendar calendar=Calendar.getInstance();
    private TimePicker timePicker;
    private DatePicker datePicker;
    private Button button_con;
    private Button button_cal;
    private int c_hour,c_min;
    private int d_year,d_month,d_day;
    private Date date;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // requestWindowFeature(Window.FEATURE_NO_TITLE);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);// 真机
        setContentView(R.layout.activity_selectactivity7);

        datePicker=(DatePicker)findViewById(R.id.my_datePicker);
        timePicker=(TimePicker)findViewById(R.id.my_timePicker);
        button_con=(Button)findViewById(R.id.button_con);
        button_cal=(Button)findViewById(R.id.button_cancel);

        timePicker.setIs24HourView(true);
        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker timePicker, int i, int i1) {

                c_hour=i;
                c_min=i1;
                Toast toast2= Toast.makeText(SelectActivity7.this,"您选择的时间:"+c_hour+":"+c_min,Toast.LENGTH_LONG);
                showMyToast(toast2,1*1000);
            }

        });


        long time=System.currentTimeMillis();
        calendar.setTimeInMillis(time);

        d_year=calendar.get(Calendar.YEAR);
        d_month=calendar.get(Calendar.MONTH);
        d_day=calendar.get(Calendar.HOUR_OF_DAY);

        date=new Date(d_year-1900,d_month,d_day,c_hour,c_min,0);


        datePicker.init(d_year,d_month,d_day, new DatePicker.OnDateChangedListener(){

            @Override
            public void onDateChanged(DatePicker datePicker, int i, int i1, int i2) {
                int month_tmp;
                SelectActivity7.this.d_year = i;
                SelectActivity7.this.d_month = i1;
                SelectActivity7.this.d_day = i2;

                month_tmp=d_month+1;


                Toast toast1=Toast.makeText(SelectActivity7.this, "您选择的日期：" + d_year + "年  "
                        + month_tmp + "月  " + d_day + "日", Toast.LENGTH_SHORT);
                showMyToast(toast1,1*1000);

            }
        });
        button_con.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                long t=calendar_set();
                bindViews(t);

                //send message
                int tmp_month=d_month+1;
                Intent intent=new Intent(SelectActivity7.this,MainActivity.class);
                DataTime dataTime=new DataTime();
                dataTime.setYear(d_year);
                dataTime.setMonth(tmp_month);
                dataTime.setDay(d_day);
                dataTime.setHour(c_hour);
                dataTime.setMin(c_min);
                dataTime.setName("SelectActivity7");
                intent.putExtra("msg7", dataTime);
                startActivity(intent);



                Toast toast1=Toast.makeText(SelectActivity7.this, "您选择的日期：" + d_year + "年  "
                        + (d_month+1)+ "月  " + d_day + "日"+c_hour+":"+c_min, Toast.LENGTH_SHORT);
                showMyToast(toast1,1*1000);




            }
        });


        button_cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cancel_set();

                Intent intent=new Intent(SelectActivity7.this,MainActivity.class);
                DataTime dataTime=new DataTime();
                dataTime.setRest("今天休息");

                intent.putExtra("msg77", dataTime);
                startActivity(intent);
            }
        });

    }

    private void cancel_set(){
        alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

        Intent intent = new Intent(SelectActivity7.this, ClockActivity.class);
        pi = PendingIntent.getActivity(SelectActivity7.this, 0, intent, 0);
        alarmManager.cancel(pi);
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



    private void bindViews(long tt) {


        alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

        Intent intent = new Intent(SelectActivity7.this, ClockActivity.class);
        pi = PendingIntent.getActivity(SelectActivity7.this, 0, intent, 0);
        alarmManager.set(AlarmManager.RTC_WAKEUP,tt, pi);
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
