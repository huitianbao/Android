package com.example.wjj4;

import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private Button button_data;
    private Button button_time;
    private Button button_con;
    private Calendar dcalendar = Calendar.getInstance();
    private Calendar tcalendar = Calendar.getInstance();
    private AlarmManager alarmManager;
    private PendingIntent pi;

    private String dt1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button_data = (Button) findViewById(R.id.button_date);
        button_time = (Button) findViewById(R.id.button_time);
        button_con = (Button) findViewById(R.id.button_con);


        button_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this, AlertDialog.THEME_HOLO_LIGHT, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int day) {
                        // TODO Auto-generated method stub
                        int mYear = year;
                        int mMonth = month;
                        int mDay = day;


                        //更新EditText控件日期 小于10加0
                        button_data.setText(new StringBuilder()
                                .append(mYear)
                                .append("年")
                                .append((mMonth + 1) < 10 ? "0" + (mMonth + 1) : (mMonth + 1))
                                .append("月")
                                .append((mDay < 10) ? "0" + mDay : mDay)
                                .append("日"));


                    }


                }, dcalendar.get(Calendar.YEAR), dcalendar.get(Calendar.MONTH),
                        dcalendar.get(Calendar.DAY_OF_MONTH));
                //设置时间范围
//        dateDialog.getDatePicker().setMinDate(CalendarUtil.GetLastMonthDate().getTimeInMillis());
                datePickerDialog.getDatePicker().setMinDate(dcalendar.getTimeInMillis());
                datePickerDialog.show();
            }
        });


        button_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimePickerDialog dialog = new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int i, int i1) {
                        tcalendar.set(Calendar.HOUR, i);
                        tcalendar.set(Calendar.MINUTE, i1);
/*
                SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日HH:mm");
                Toast.makeText(getApplicationContext(), "" + format.format(mCalendar.getTime()), Toast.LENGTH_SHORT).show();
*/
                        //button.setText(i + ":" + i1);
                        if (i >= 0 & i <= 9) {
                            if (i1 >= 0 & i1 <= 9) {
                                button_time.setText("0" + i + ":" + "0" + i1);
                            } else {
                                button_time.setText("0" + i + ":" + i1);
                            }
                        } else {
                            if (i1 >= 0 & i1 <= 9) {
                                button_time.setText(i + ":" + "0" + i1);
                            } else {
                                button_time.setText(i + ":" + i1);
                            }
                        }

                        //Toast.makeText(getApplicationContext(), "the time you set is " + button.getText(), Toast.LENGTH_SHORT).show();
                    }
                }, tcalendar.get(Calendar.HOUR), tcalendar.get(Calendar.MINUTE), true);
                dialog.show();
            }
        });


        button_con.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                get_dt1();
               // bindViews(time);
            }
        });


    }


    private void get_dt1() {
        dt1 = button_data.getText().toString() + button_time.getText().toString();
        String year, month, day, hour, min;
        year = dt1.substring(0, 4);
        month = dt1.substring(5, 7);
        day = dt1.substring(8, 10);
        hour = dt1.substring(11, 13);
        min = dt1.substring(14, 16);

        Log.i("string", "the dt1 is" + dt1 + "\n" + "year is" + year + "\n" + "month is" + month + "\n" + "day is" + day + "\n" + "hour is" + hour + "\n" + "min is" + min);
        long time_long = StringToLong(dt1);
        Log.i("long", "the my long time is " + time_long);

        // Toast.makeText(getApplicationContext(), time_long + "", Toast.LENGTH_LONG);
        // Toast.makeText(getApplicationContext(), dt1, Toast.LENGTH_LONG).show();
        Calendar calendar = Calendar.getInstance();

        calendar.set(Calendar.YEAR, Integer.parseInt(year));

        calendar.set(Calendar.MONTH, Integer.parseInt(month));
        calendar.set(Calendar.DAY_OF_MONTH, Integer.parseInt(day));
        calendar.set(Calendar.HOUR_OF_DAY, Integer.parseInt(hour));
        calendar.set(Calendar.MINUTE, Integer.parseInt(min));
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        Log.i("ca","year is"+year+"month is "+month+"day is "+day+"hour is "+hour+"min is "+min);
        Log.i("longs", "the sy long time is " + calendar.getTimeInMillis());
        Toast.makeText(getApplicationContext(), "the long is " + calendar.getTimeInMillis() + "", Toast.LENGTH_LONG).show();
        //return calendar.getTimeInMillis();
        alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

        Intent intent = new Intent(MainActivity.this, ClockActivity.class);
        pi = PendingIntent.getActivity(MainActivity.this, 0, intent, 0);
        alarmManager.set(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis(), pi);
    }


    //=========================================================================
    private long StringToLong(String time) {
        //String time=btn_data1.getText().toString();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日HH:mm");
        Date date = new Date();
        //date=simpleDateFormat.parse(time);
        try {
            date = simpleDateFormat.parse(time);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return date.getTime();
    }


    private void bindViews(long tt) {


        alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

        Intent intent = new Intent(MainActivity.this, ClockActivity.class);
        pi = PendingIntent.getActivity(MainActivity.this, 0, intent, 0);
        alarmManager.set(AlarmManager.RTC_WAKEUP, tt, pi);
    }
}
