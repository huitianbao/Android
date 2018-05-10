package com.example.datapicker4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private DatePicker datePicker;
    private TextView textView;

    private int year;
    private int month;
    private int day;
    private Calendar calendar=Calendar.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        datePicker = (DatePicker) findViewById(R.id.my_datePicker);
        textView = (TextView) findViewById(R.id.my_textView);

        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);

        datePicker.init(year, month, day, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker datePicker, int i, int i1, int i2) {
                MainActivity.this.year = i;
                MainActivity.this.month = i1;
                MainActivity.this.day = i2;
                Toast.makeText(MainActivity.this, "您选择的日期：" + year + "年  "
                        + month + "月  " + day + "日", Toast.LENGTH_SHORT).show();
                showDate(year,month,day);
            }
        });
        /*
        datePicker.getDayOfMonth();
        datePicker.getMonth();
        datePicker.getYear();

        */


    }
        // 定义在EditText中显示当前日期、时间的方法
        private void showDate(int year, int month, int day)
        {
            textView.setText("您选择的日期和时间为：" + year + "年"+ (month+1) + "月" + day + "日  ");
        }

    }

