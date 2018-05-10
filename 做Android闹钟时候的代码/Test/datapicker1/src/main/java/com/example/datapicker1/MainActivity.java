package com.example.datapicker1;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    DatePicker dp1;
    private int year1;
    private int month1;
    private int day1;
    private int hour;
    private int min;
    private TextView tv1=(TextView)findViewById(R.id.tv1);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

           //dp1.setCalendarViewShown(false);



    }

    private void initData()
    {
        Calendar c =Calendar.getInstance();
        year1 = c.get(Calendar.YEAR);
        c.add(Calendar.MONTH, 1);
        month1 = c.get(Calendar.MONTH);
        day1 = c.get(Calendar.DAY_OF_MONTH);
        tv1.setText(year1+"-"+month1+"-"+day1);

        dp1.init(dp1.getYear(), dp1.getMonth(), dp1.getDayOfMonth(), new DatePicker.OnDateChangedListener() {

            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear,
                                      int dayOfMonth) {
                // TODO Auto-generated method stub
                year1 = year;
                month1 = monthOfYear+1;
                day1 = dayOfMonth;

                StringBuffer lend_time = new StringBuffer();
                lend_time.append(year1);
                lend_time.append("-");
                lend_time.append(month1);
                lend_time.append("-");
                lend_time.append(day1);

                tv1.setText(lend_time);
            }
        });

    }




}

