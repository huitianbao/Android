package com.example.wjj2;

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

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private Button button_day1;
    private Button button_day2;
    private Button button_day3;
    private Button button_day4;
    private Button button_day5;
    private Button button_day6;
    private Button button_day7;

    private Button button_time1;
    private Button button_time2;
    private Button button_time3;
    private Button button_time4;
    private Button button_time5;
    private Button button_time6;
    private Button button_time7;

    private Button button_cancel1;
    private Button button_cancel2;
    private Button button_cancel3;
    private Button button_cancel4;
    private Button button_cancel5;
    private Button button_cancel6;
    private Button button_cancel7;


    private Button button_comfirm;
    private Button button_cancel;


    Calendar tcalendar = Calendar.getInstance();  // time
    Calendar dcalendar = Calendar.getInstance();  // data


    String dt1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        button_day1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDataDialog(button_day1);
            }
        });
        button_day2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDataDialog(button_day2);
            }
        });
        button_day3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDataDialog(button_day3);
            }
        });
        button_day4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDataDialog(button_day4);
            }
        });
        button_day5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDataDialog(button_day5);
            }
        });
        button_day6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDataDialog(button_day6);
            }
        });

        button_day7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDataDialog(button_day7);
            }
        });

        button_time1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showTimeDialog(button_time1);
            }
        });

        button_time2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showTimeDialog(button_time2);
            }
        });

        button_time3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showTimeDialog(button_time3);
            }
        });

        button_time4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showTimeDialog(button_time4);
            }
        });

        button_time5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showTimeDialog(button_time5);
            }
        });

        button_time6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showTimeDialog(button_time6);
            }
        });


        button_time7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showTimeDialog(button_time7);
            }
        });

        button_comfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        button_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


        button_cancel1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                bindViews(get_dt1());


            }
        });


        button_cancel2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


        button_cancel3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


        button_cancel4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


        button_cancel5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


        button_cancel6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


        button_cancel7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


        button_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }


    private void init() {
        button_day1 = (Button) findViewById(R.id.button_day1);
        button_day2 = (Button) findViewById(R.id.button_day2);
        button_day3 = (Button) findViewById(R.id.button_day3);
        button_day4 = (Button) findViewById(R.id.button_day4);
        button_day5 = (Button) findViewById(R.id.button_day5);
        button_day6 = (Button) findViewById(R.id.button_day6);
        button_day7 = (Button) findViewById(R.id.button_day7);

        button_time1 = (Button) findViewById(R.id.button_time1);
        button_time2 = (Button) findViewById(R.id.button_time2);
        button_time3 = (Button) findViewById(R.id.button_time3);
        button_time4 = (Button) findViewById(R.id.button_time4);
        button_time5 = (Button) findViewById(R.id.button_time5);
        button_time6 = (Button) findViewById(R.id.button_time6);
        button_time7 = (Button) findViewById(R.id.button_time7);

        button_cancel1 = (Button) findViewById(R.id.button_cancel1);
        button_cancel2 = (Button) findViewById(R.id.button_cancel2);
        button_cancel3 = (Button) findViewById(R.id.button_cancel3);
        button_cancel4 = (Button) findViewById(R.id.button_cancel4);
        button_cancel5 = (Button) findViewById(R.id.button_cancel5);
        button_cancel6 = (Button) findViewById(R.id.button_cancel6);
        button_cancel7 = (Button) findViewById(R.id.button_cancel7);


        button_cancel = (Button) findViewById(R.id.button_quit);
        button_comfirm = (Button) findViewById(R.id.button_confirm);

    }

    private void showDataDialog(final Button button) {
        DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this, AlertDialog.THEME_HOLO_LIGHT, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                // TODO Auto-generated method stub
                int mYear = year;
                int mMonth = month;
                int mDay = day;


                //更新EditText控件日期 小于10加0
                button.setText(new StringBuilder()
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

    private void showTimeDialog(final Button button) {
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
                        button.setText("0" + i + ":" + "0" + i1);
                    } else {
                        button.setText("0" + i + ":" + i1);
                    }
                } else {
                    if (i1 >= 0 & i1 <= 9) {
                        button.setText(i + ":" + "0" + i1);
                    } else {
                        button.setText(i + ":" + i1);
                    }
                }

                //Toast.makeText(getApplicationContext(), "the time you set is " + button.getText(), Toast.LENGTH_SHORT).show();
            }
        }, tcalendar.get(Calendar.HOUR), tcalendar.get(Calendar.MINUTE), true);
        dialog.show();

    }

    private long get_dt1() {
        dt1 = button_day1.getText().toString() + button_time1.getText().toString();
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
        calendar.set(Calendar.DAY_OF_MONTH,Integer.parseInt(day));
        calendar.set(Calendar.HOUR_OF_DAY, Integer.parseInt(hour));
        calendar.set(Calendar.MINUTE, Integer.parseInt(min));
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        Log.i("longs","the sy long time is "+calendar.getTimeInMillis());
        Toast.makeText(getApplicationContext(),"the long is "+calendar.getTimeInMillis()+"",Toast.LENGTH_LONG).show();
        return calendar.getTimeInMillis();
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

    private String LongToString(long time) {
        Date d = new Date(time);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日HH:mm");
        return simpleDateFormat.format(d);
    }


    private void bindViews(long tt) {

        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        Intent intent = new Intent(MainActivity.this, ClockActivity.class);
        PendingIntent pi = PendingIntent.getActivity(MainActivity.this, 0, intent, 0);
        alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), pi);
    }


}
