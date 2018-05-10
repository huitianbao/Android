package com.example.wjj5;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;


public class MainActivity extends AppCompatActivity {

    private AlarmManager alarmManager1;
    private AlarmManager alarmManager2;
    private AlarmManager alarmManager3;
    private AlarmManager alarmManager4;
    private AlarmManager alarmManager5;
    private AlarmManager alarmManager6;
    private AlarmManager alarmManager7;

    private PendingIntent pi1;
    private PendingIntent pi2;
    private PendingIntent pi3;
    private PendingIntent pi4;
    private PendingIntent pi5;
    private PendingIntent pi6;
    private PendingIntent pi7;

    private Calendar calendar1 = Calendar.getInstance();
    private Calendar calendar2 = Calendar.getInstance();
    private Calendar calendar3 = Calendar.getInstance();
    private Calendar calendar4 = Calendar.getInstance();
    private Calendar calendar5 = Calendar.getInstance();
    private Calendar calendar6 = Calendar.getInstance();
    private Calendar calendar7 = Calendar.getInstance();


    private TimePicker timePicker1;
    private TimePicker timePicker2;
    private TimePicker timePicker3;
    private TimePicker timePicker4;
    private TimePicker timePicker5;
    private TimePicker timePicker6;
    private TimePicker timePicker7;


    private DatePicker datePicker1;
    private DatePicker datePicker2;
    private DatePicker datePicker3;
    private DatePicker datePicker4;
    private DatePicker datePicker5;
    private DatePicker datePicker6;
    private DatePicker datePicker7;

    private Button button_con1;
    private Button button_con2;
    private Button button_con3;
    private Button button_con4;
    private Button button_con5;
    private Button button_con6;
    private Button button_con7;

    private int c_hour1, c_min1;
    private int c_hour2, c_min2;
    private int c_hour3, c_min3;
    private int c_hour4, c_min4;
    private int c_hour5, c_min5;
    private int c_hour6, c_min6;
    private int c_hour7, c_min7;

    private int d_year1, d_month1, d_day1;
    private int d_year2, d_month2, d_day2;
    private int d_year3, d_month3, d_day3;
    private int d_year4, d_month4, d_day4;
    private int d_year5, d_month5, d_day5;
    private int d_year6, d_month6, d_day6;
    private int d_year7, d_month7, d_day7;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // requestWindowFeature(Window.FEATURE_NO_TITLE);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);// 真机
        setContentView(R.layout.activity_main);

        datePicker1 = (DatePicker) findViewById(R.id.my_datePicker1);
        datePicker2 = (DatePicker) findViewById(R.id.my_datePicker2);
        datePicker3 = (DatePicker) findViewById(R.id.my_datePicker3);
        datePicker4 = (DatePicker) findViewById(R.id.my_datePicker4);
        datePicker5 = (DatePicker) findViewById(R.id.my_datePicker5);
        datePicker6 = (DatePicker) findViewById(R.id.my_datePicker6);
        datePicker7 = (DatePicker) findViewById(R.id.my_datePicker7);

        timePicker1 = (TimePicker) findViewById(R.id.my_timePicker1);
        timePicker2 = (TimePicker) findViewById(R.id.my_timePicker2);
        timePicker3 = (TimePicker) findViewById(R.id.my_timePicker3);
        timePicker4 = (TimePicker) findViewById(R.id.my_timePicker4);
        timePicker5 = (TimePicker) findViewById(R.id.my_timePicker5);
        timePicker6 = (TimePicker) findViewById(R.id.my_timePicker6);
        timePicker7 = (TimePicker) findViewById(R.id.my_timePicker7);


        button_con1 = (Button) findViewById(R.id.button_confirm1);
        button_con2 = (Button) findViewById(R.id.button_confirm2);
        button_con3 = (Button) findViewById(R.id.button_confirm3);
        button_con4 = (Button) findViewById(R.id.button_confirm4);
        button_con5 = (Button) findViewById(R.id.button_confirm5);
        button_con6 = (Button) findViewById(R.id.button_confirm6);
        button_con7 = (Button) findViewById(R.id.button_confirm7);


        timePicker1.setIs24HourView(true);
        timePicker2.setIs24HourView(true);
        timePicker3.setIs24HourView(true);
        timePicker4.setIs24HourView(true);
        timePicker5.setIs24HourView(true);
        timePicker6.setIs24HourView(true);
        timePicker7.setIs24HourView(true);

        //111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111
        timePicker1.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker timePicker, int i, int i1) {
                c_hour1 = i;
                c_min1 = i1;
                Toast toast2 = Toast.makeText(MainActivity.this, "您选择的时间:" + c_hour1 + ":" + c_min1, Toast.LENGTH_LONG);
                showMyToast(toast2, 1 * 1000);
            }

        });


        calendar1.setTimeInMillis(System.currentTimeMillis());
        d_year1 = calendar1.get(Calendar.YEAR);
        d_month1 = calendar1.get(Calendar.MONTH);
        d_day1 = calendar1.get(Calendar.HOUR_OF_DAY);


        datePicker1.init(d_year1, d_month1, d_day1, new DatePicker.OnDateChangedListener() {

            @Override
            public void onDateChanged(DatePicker datePicker, int i, int i1, int i2) {
                int month_tmp;
                MainActivity.this.d_year1 = i;
                MainActivity.this.d_month1 = i1;
                MainActivity.this.d_day1 = i2;
                month_tmp = d_month1 + 1;

                Toast toast1 = Toast.makeText(MainActivity.this, "您选择的日期：" + d_year1 + "年  "
                        + month_tmp + "月  " + d_day1 + "日", Toast.LENGTH_SHORT);
                showMyToast(toast1, 1 * 1000);

            }
        });
        button_con1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                long t = calendar_set1();
                bindViews1(t);
                Toast toast1 = Toast.makeText(MainActivity.this, "您选择的日期：" + d_year1 + "年  "
                        + (d_month1 + 1) + "月  " + d_day1 + "日" + c_hour1 + ":" + c_min1, Toast.LENGTH_SHORT);
                showMyToast(toast1, 1 * 1000);


            }
        });
        //1111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111

//222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222
        timePicker2.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker timePicker, int i, int i1) {
                c_hour2 = i;
                c_min2 = i1;
                Toast toast2 = Toast.makeText(MainActivity.this, "您选择的时间:" + c_hour2 + ":" + c_min2, Toast.LENGTH_LONG);
                showMyToast(toast2, 1 * 1000);
            }

        });


        calendar2.setTimeInMillis(System.currentTimeMillis());
        d_year2 = calendar2.get(Calendar.YEAR);
        d_month2 = calendar2.get(Calendar.MONTH);
        d_day2 = calendar2.get(Calendar.HOUR_OF_DAY);


        datePicker2.init(d_year2, d_month2, d_day2, new DatePicker.OnDateChangedListener() {

            @Override
            public void onDateChanged(DatePicker datePicker, int i, int i1, int i2) {
                int month_tmp;
                MainActivity.this.d_year2 = i;
                MainActivity.this.d_month2 = i1;
                MainActivity.this.d_day2 = i2;
                month_tmp = d_month2 + 1;

                Toast toast1 = Toast.makeText(MainActivity.this, "您选择的日期：" + d_year2 + "年  "
                        + month_tmp + "月  " + d_day2 + "日", Toast.LENGTH_SHORT);
                showMyToast(toast1, 1 * 1000);

            }
        });
        button_con2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                long t = calendar_set2();
                bindViews2(t);  //==============================================================================================
                Toast toast1 = Toast.makeText(MainActivity.this, "您选择的日期：" + d_year2 + "年  "
                        + (d_month2 + 1) + "月  " + d_day2 + "日" + c_hour2 + ":" + c_min2, Toast.LENGTH_SHORT);
                showMyToast(toast1, 1 * 1000);

            }
        });

        //222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222

        //333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333
        timePicker3.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker timePicker, int i, int i1) {
                c_hour3 = i;
                c_min3 = i1;
                Toast toast2 = Toast.makeText(MainActivity.this, "您选择的时间:" + c_hour3 + ":" + c_min3, Toast.LENGTH_LONG);
                showMyToast(toast2, 1 * 1000);
            }

        });

/*
        long time=System.currentTimeMillis();
        calendar1.setTimeInMillis(time);
        */
        calendar3.setTimeInMillis(System.currentTimeMillis());
        d_year3 = calendar3.get(Calendar.YEAR);
        d_month3 = calendar3.get(Calendar.MONTH);
        d_day3 = calendar3.get(Calendar.HOUR_OF_DAY);


        datePicker3.init(d_year3, d_month3, d_day3, new DatePicker.OnDateChangedListener() {

            @Override
            public void onDateChanged(DatePicker datePicker, int i, int i1, int i2) {
                int month_tmp;
                MainActivity.this.d_year3 = i;
                MainActivity.this.d_month3 = i1;
                MainActivity.this.d_day3 = i2;
                month_tmp = d_month3 + 1;

                Toast toast1 = Toast.makeText(MainActivity.this, "您选择的日期：" + d_year3 + "年  "
                        + month_tmp + "月  " + d_day3 + "日", Toast.LENGTH_SHORT);
                showMyToast(toast1, 1 * 1000);

            }
        });
        button_con3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                long t = calendar_set3();
                bindViews3(t);  //==============================================================================================
                Toast toast1 = Toast.makeText(MainActivity.this, "您选择的日期：" + d_year3 + "年  "
                        + (d_month3 + 1) + "月  " + d_day3 + "日" + c_hour3 + ":" + c_min3, Toast.LENGTH_SHORT);
                showMyToast(toast1, 1 * 1000);


            }
        });

        //333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333


        //4444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444
        timePicker4.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker timePicker, int i, int i1) {
                c_hour4 = i;
                c_min4 = i1;
                Toast toast2 = Toast.makeText(MainActivity.this, "您选择的时间:" + c_hour4 + ":" + c_min4, Toast.LENGTH_LONG);
                showMyToast(toast2, 1 * 1000);
            }

        });


        calendar4.setTimeInMillis(System.currentTimeMillis());
        d_year4 = calendar4.get(Calendar.YEAR);
        d_month4 = calendar4.get(Calendar.MONTH);
        d_day4 = calendar4.get(Calendar.HOUR_OF_DAY);


        datePicker4.init(d_year4, d_month4, d_day4, new DatePicker.OnDateChangedListener() {

            @Override
            public void onDateChanged(DatePicker datePicker, int i, int i1, int i2) {
                int month_tmp;
                MainActivity.this.d_year4 = i;
                MainActivity.this.d_month4 = i1;
                MainActivity.this.d_day4 = i2;

                month_tmp = d_month4 + 1;

                Toast toast1 = Toast.makeText(MainActivity.this, "您选择的日期：" + d_year4 + "年  "
                        + month_tmp + "月  " + d_day4 + "日", Toast.LENGTH_SHORT);
                showMyToast(toast1, 1 * 1000);

            }
        });
        button_con4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                long t = calendar_set4();//============================================================================================
                bindViews4(t);  //==============================================================================================
                Toast toast1 = Toast.makeText(MainActivity.this, "您选择的日期：" + d_year4 + "年  "
                        + (d_month4 + 1) + "月  " + d_day4 + "日" + c_hour4 + ":" + c_min4, Toast.LENGTH_SHORT);
                showMyToast(toast1, 1 * 1000);

            }
        });


        //44444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444


        //5555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555

        timePicker5.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker timePicker, int i, int i1) {
                c_hour5 = i;
                c_min5 = i1;
                Toast toast2 = Toast.makeText(MainActivity.this, "您选择的时间:" + c_hour5 + ":" + c_min5, Toast.LENGTH_LONG);
                showMyToast(toast2, 1 * 1000);
            }

        });


        calendar5.setTimeInMillis(System.currentTimeMillis());
        d_year5 = calendar5.get(Calendar.YEAR);
        d_month5 = calendar5.get(Calendar.MONTH);
        d_day5 = calendar5.get(Calendar.HOUR_OF_DAY);


        datePicker5.init(d_year5, d_month5, d_day5, new DatePicker.OnDateChangedListener() {

            @Override
            public void onDateChanged(DatePicker datePicker, int i, int i1, int i2) {
                int month_tmp;
                MainActivity.this.d_year5 = i;
                MainActivity.this.d_month5 = i1;
                MainActivity.this.d_day5 = i2;

                month_tmp = d_month5 + 1;

                Toast toast1 = Toast.makeText(MainActivity.this, "您选择的日期：" + d_year5 + "年  "
                        + month_tmp + "月  " + d_day5 + "日", Toast.LENGTH_SHORT);
                showMyToast(toast1, 1 * 1000);

            }
        });
        button_con5.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                long t = calendar_set5();//============================================================================================
                bindViews5(t);  //==============================================================================================
                Toast toast1 = Toast.makeText(MainActivity.this, "您选择的日期：" + d_year5 + "年  "
                        + (d_month5 + 1) + "月  " + d_day5 + "日" + c_hour5 + ":" + c_min5, Toast.LENGTH_SHORT);
                showMyToast(toast1, 1 * 1000);

            }
        });


        //555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555

        //6666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666

        timePicker6.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker timePicker, int i, int i1) {
                c_hour6 = i;
                c_min6 = i1;
                Toast toast2 = Toast.makeText(MainActivity.this, "您选择的时间:" + c_hour6 + ":" + c_min6, Toast.LENGTH_LONG);
                showMyToast(toast2, 1 * 1000);
            }

        });


        calendar6.setTimeInMillis(System.currentTimeMillis());
        d_year6 = calendar6.get(Calendar.YEAR);
        d_month6 = calendar6.get(Calendar.MONTH);
        d_day6 = calendar6.get(Calendar.HOUR_OF_DAY);


        datePicker6.init(d_year6, d_month6, d_day6, new DatePicker.OnDateChangedListener() {

            @Override
            public void onDateChanged(DatePicker datePicker, int i, int i1, int i2) {
                int month_tmp;
                MainActivity.this.d_year6 = i;
                MainActivity.this.d_month6 = i1;
                MainActivity.this.d_day6 = i2;
                month_tmp = d_month6 + 1;

                Toast toast1 = Toast.makeText(MainActivity.this, "您选择的日期：" + d_year6 + "年  "
                        + month_tmp + "月  " + d_day6 + "日", Toast.LENGTH_SHORT);
                showMyToast(toast1, 1 * 1000);

            }
        });
        button_con6.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                long t = calendar_set6();//============================================================================================
                bindViews6(t);  //==============================================================================================
                Toast toast1 = Toast.makeText(MainActivity.this, "您选择的日期：" + d_year6 + "年  "
                        + (d_month6 + 1) + "月  " + d_day6 + "日" + c_hour6 + ":" + c_min6, Toast.LENGTH_SHORT);
                showMyToast(toast1, 1 * 1000);

            }
        });

        //66666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666


        //777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777

        timePicker7.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker timePicker, int i, int i1) {
                c_hour7 = i;
                c_min7 = i1;
                Toast toast2 = Toast.makeText(MainActivity.this, "您选择的时间:" + c_hour7 + ":" + c_min7, Toast.LENGTH_LONG);
                showMyToast(toast2, 1 * 1000);
            }

        });


        calendar7.setTimeInMillis(System.currentTimeMillis());
        d_year7 = calendar7.get(Calendar.YEAR);
        d_month7 = calendar7.get(Calendar.MONTH);
        d_day7 = calendar7.get(Calendar.HOUR_OF_DAY);


        datePicker7.init(d_year7, d_month7, d_day7, new DatePicker.OnDateChangedListener() {

            @Override
            public void onDateChanged(DatePicker datePicker, int i, int i1, int i2) {
                int month_tmp;
                MainActivity.this.d_year7 = i;
                MainActivity.this.d_month7 = i1;
                MainActivity.this.d_day7 = i2;

                month_tmp = d_month7 + 1;


                Toast toast1 = Toast.makeText(MainActivity.this, "您选择的日期：" + d_year7 + "年  "
                        + month_tmp + "月  " + d_day7 + "日", Toast.LENGTH_SHORT);
                showMyToast(toast1, 1 * 1000);

            }
        });
        button_con7.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                long t = calendar_set7();//============================================================================================
                bindViews7(t);  //==============================================================================================
                Toast toast1 = Toast.makeText(MainActivity.this, "您选择的日期：" + d_year7 + "年  "
                        + (d_month7 + 1) + "月  " + d_day7 + "日" + c_hour7 + ":" + c_min7, Toast.LENGTH_SHORT);
                showMyToast(toast1, 1 * 1000);


            }
        });


        //7777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777
    }

    //=1111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111

    private long calendar_set1() {
        long time;
        calendar1.set(Calendar.YEAR, d_year1);
        calendar1.set(Calendar.MONTH, d_month1);
        calendar1.set(Calendar.DAY_OF_MONTH, d_day1);
        calendar1.set(Calendar.HOUR_OF_DAY, c_hour1);
        calendar1.set(Calendar.MINUTE, c_min1);
        calendar1.set(Calendar.SECOND, 0);
        calendar1.set(Calendar.MILLISECOND, 0);
        time = calendar1.getTimeInMillis();
        return time;


    }


    private void bindViews1(long tt) {
        alarmManager1 = (AlarmManager) getSystemService(ALARM_SERVICE);
        Intent intent = new Intent(MainActivity.this, ClockActivity.class);
        pi1 = PendingIntent.getActivity(MainActivity.this, 1, intent, 0);
        alarmManager1.set(AlarmManager.RTC_WAKEUP, tt, pi1);
    }

//11111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111

    //2222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222
    private long calendar_set2() {
        long time;
        calendar2.set(Calendar.YEAR, d_year2);
        calendar2.set(Calendar.MONTH, d_month2);
        calendar2.set(Calendar.DAY_OF_MONTH, d_day2);
        calendar2.set(Calendar.HOUR_OF_DAY, c_hour2);
        calendar2.set(Calendar.MINUTE, c_min2);
        calendar2.set(Calendar.SECOND, 0);
        calendar2.set(Calendar.MILLISECOND, 0);
        time = calendar2.getTimeInMillis();
        return time;

    }


    private void bindViews2(long tt) {
        alarmManager2 = (AlarmManager) getSystemService(ALARM_SERVICE);
        Intent intent = new Intent(MainActivity.this, ClockActivity.class);
        pi2 = PendingIntent.getActivity(MainActivity.this, 2, intent, 0);
        alarmManager2.set(AlarmManager.RTC_WAKEUP, tt, pi2);
    }
    //2222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222

    //3333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333
    private long calendar_set3() {
        long time;
        calendar3.set(Calendar.YEAR, d_year3);
        calendar3.set(Calendar.MONTH, d_month3);
        calendar3.set(Calendar.DAY_OF_MONTH, d_day3);
        calendar3.set(Calendar.HOUR_OF_DAY, c_hour3);
        calendar3.set(Calendar.MINUTE, c_min3);
        calendar3.set(Calendar.SECOND, 0);
        calendar3.set(Calendar.MILLISECOND, 0);
        time = calendar3.getTimeInMillis();
        return time;

    }


    private void bindViews3(long tt) {
        alarmManager3 = (AlarmManager) getSystemService(ALARM_SERVICE);
        Intent intent = new Intent(MainActivity.this, ClockActivity.class);
        pi3 = PendingIntent.getActivity(MainActivity.this, 3, intent, 0);
        alarmManager3.set(AlarmManager.RTC_WAKEUP, tt, pi3);
    }


    //3333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333

    //4444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444
    private long calendar_set4() {
        long time;
        calendar4.set(Calendar.YEAR, d_year4);
        calendar4.set(Calendar.MONTH, d_month4);
        calendar4.set(Calendar.DAY_OF_MONTH, d_day4);
        calendar4.set(Calendar.HOUR_OF_DAY, c_hour4);
        calendar4.set(Calendar.MINUTE, c_min4);
        calendar4.set(Calendar.SECOND, 0);
        calendar4.set(Calendar.MILLISECOND, 0);
        time = calendar4.getTimeInMillis();
        return time;


    }


    private void bindViews4(long tt) {
        alarmManager4 = (AlarmManager) getSystemService(ALARM_SERVICE);
        Intent intent = new Intent(MainActivity.this, ClockActivity.class);
        pi4 = PendingIntent.getActivity(MainActivity.this, 4, intent, 0);
        alarmManager4.set(AlarmManager.RTC_WAKEUP, tt, pi4);
    }

    //4444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444

    //555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555

    private long calendar_set5() {
        long time;
        calendar5.set(Calendar.YEAR, d_year5);
        calendar5.set(Calendar.MONTH, d_month5);
        calendar5.set(Calendar.DAY_OF_MONTH, d_day5);
        calendar5.set(Calendar.HOUR_OF_DAY, c_hour5);
        calendar5.set(Calendar.MINUTE, c_min5);
        calendar5.set(Calendar.SECOND, 0);
        calendar5.set(Calendar.MILLISECOND, 0);
        time = calendar5.getTimeInMillis();
        return time;

    }


    private void bindViews5(long tt) {

        alarmManager5 = (AlarmManager) getSystemService(ALARM_SERVICE);
        Intent intent = new Intent(MainActivity.this, ClockActivity.class);
        pi5 = PendingIntent.getActivity(MainActivity.this, 5, intent, 0);
        alarmManager5.set(AlarmManager.RTC_WAKEUP, tt, pi5);
    }

    //555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555

    //66666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666

    private long calendar_set6() {
        long time;
        calendar6.set(Calendar.YEAR, d_year6);
        calendar6.set(Calendar.MONTH, d_month6);
        calendar6.set(Calendar.DAY_OF_MONTH, d_day6);
        calendar6.set(Calendar.HOUR_OF_DAY, c_hour6);
        calendar6.set(Calendar.MINUTE, c_min6);
        calendar6.set(Calendar.SECOND, 0);
        calendar6.set(Calendar.MILLISECOND, 0);
        time = calendar6.getTimeInMillis();
        return time;


    }


    private void bindViews6(long tt) {


        alarmManager6 = (AlarmManager) getSystemService(ALARM_SERVICE);

        Intent intent = new Intent(MainActivity.this, ClockActivity.class);
        pi6 = PendingIntent.getActivity(MainActivity.this, 6, intent, 0);
        alarmManager6.set(AlarmManager.RTC_WAKEUP, tt, pi6);
    }

    //666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666

    //7777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777

    private long calendar_set7() {
        long time;
        calendar7.set(Calendar.YEAR, d_year7);
        calendar7.set(Calendar.MONTH, d_month7);
        calendar7.set(Calendar.DAY_OF_MONTH, d_day7);
        calendar7.set(Calendar.HOUR_OF_DAY, c_hour7);
        calendar7.set(Calendar.MINUTE, c_min7);
        calendar7.set(Calendar.SECOND, 0);
        calendar7.set(Calendar.MILLISECOND, 0);
        time = calendar7.getTimeInMillis();
        return time;


    }


    private void bindViews7(long tt) {


        alarmManager7 = (AlarmManager) getSystemService(ALARM_SERVICE);

        Intent intent = new Intent(MainActivity.this, ClockActivity.class);
        pi7 = PendingIntent.getActivity(MainActivity.this, 7, intent, 0);
        alarmManager7.set(AlarmManager.RTC_WAKEUP, tt, pi7);
    }


    //77777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777
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
        }, cnt);
    }
}

