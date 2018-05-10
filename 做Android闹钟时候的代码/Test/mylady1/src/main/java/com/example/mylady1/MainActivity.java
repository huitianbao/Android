package com.example.mylady1;

import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Notification;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private Button btn_data1;
    private Button btn_data2;
    private Button btn_data3;
    private Button btn_data4;
    private Button btn_data5;
    private Button btn_data6;
    private Button btn_data7;

    private Button btn_time1;
    private Button btn_time2;
    private Button btn_time3;
    private Button btn_time4;
    private Button btn_time5;
    private Button btn_time6;
    private Button btn_time7;

    private Button btn_cancel1;
    private Button btn_cancel2;
    private Button btn_cancel3;
    private Button btn_cancel4;
    private Button btn_cancel5;
    private Button btn_cancel6;
    private Button btn_cancel7;



    private Button btn_conf;
    private Button btn_quit;

    private AlarmManager alarmManager;
    private PendingIntent pi;
    private Calendar calendar=Calendar.getInstance();

    private int c_hour,c_min;
    private int d_year,d_month,d_day;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        btn_data1 = (Button) findViewById(R.id.button_data1);
        btn_data2 = (Button) findViewById(R.id.button_data2);
        btn_data3 = (Button) findViewById(R.id.button_data3);
        btn_data4 = (Button) findViewById(R.id.button_data4);
        btn_data5 = (Button) findViewById(R.id.button_data5);
        btn_data6 = (Button) findViewById(R.id.button_data6);
        btn_data7 = (Button) findViewById(R.id.button_data7);

        btn_time1 = (Button) findViewById(R.id.button_time1);
        btn_time2 = (Button) findViewById(R.id.button_time2);
        btn_time3 = (Button) findViewById(R.id.button_time3);
        btn_time4 = (Button) findViewById(R.id.button_time4);
        btn_time5 = (Button) findViewById(R.id.button_time5);
        btn_time6 = (Button) findViewById(R.id.button_time6);
        btn_time7 = (Button) findViewById(R.id.button_time7);


        btn_cancel1=(Button)findViewById(R.id.button_cancel1);
        btn_cancel2=(Button)findViewById(R.id.button_cancel2);
        btn_cancel3=(Button)findViewById(R.id.button_cancel3);
        btn_cancel4=(Button)findViewById(R.id.button_cancel4);
        btn_cancel5=(Button)findViewById(R.id.button_cancel5);
        btn_cancel6=(Button)findViewById(R.id.button_cancel6);
        btn_cancel7=(Button)findViewById(R.id.button_cancel7);





        btn_data1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDataDialog(btn_data1);
            }
        });

        btn_data2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDataDialog(btn_data2);
            }
        });

        btn_data3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDataDialog(btn_data3);
            }
        });

        btn_data4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDataDialog(btn_data4);
            }
        });

        btn_data5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDataDialog(btn_data5);
            }
        });

        btn_data6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDataDialog(btn_data6);
            }
        });

        btn_data7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDataDialog(btn_data7);
            }
        });
        ///--------------------------------------------------------------------------------------------------

        btn_time1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showTimePickerDialog(btn_time1);
            }
        });

        btn_time2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showTimePickerDialog(btn_time2);
            }
        });

        btn_time3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showTimePickerDialog(btn_time3);
            }
        });

        btn_time4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showTimePickerDialog(btn_time4);
            }
        });

        btn_time5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showTimePickerDialog(btn_time5);
            }
        });

        btn_time6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showTimePickerDialog(btn_time6);
            }
        });

        btn_time7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showTimePickerDialog(btn_time7);
            }
        });

        btn_cancel1.setOnClickListener(new View.OnClickListener() {
            long t;
            @Override
            public void onClick(View view) {
               // t=calendar_set(btn_data1,btn_time1);


                t=calendar_set2();
                bindViews_tt(t);
               Toast.makeText(getApplicationContext(),"clicked ",Toast.LENGTH_LONG).show();
            }

        });




    }




    private void showTimePickerDialog(final Button button) {
        final Calendar mCalendar = Calendar.getInstance();
        TimePickerDialog dialog = new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int i, int i1) {
                mCalendar.set(Calendar.HOUR, i);
                mCalendar.set(Calendar.MINUTE, i1);
/*
                SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日HH:mm");
                Toast.makeText(getApplicationContext(), "" + format.format(mCalendar.getTime()), Toast.LENGTH_SHORT).show();
*/
                //button.setText(i + ":" + i1);
                if(i>=0&i<=9){
                    if (i1>=0&i1<=9){
                        button.setText("0"+i+":"+"0"+i1);
                    }else{
                        button.setText("0"+i+":"+i1);
                    }
                }else {
                    if(i1>=0&i1<=9){
                        button.setText(i+":"+"0"+i1);
                    }else {
                        button.setText(i+":"+i1);
                    }
                }
                Toast.makeText(getApplicationContext(), "the time you set is " + i + ":" + i1, Toast.LENGTH_SHORT).show();
            }
        }, mCalendar.get(Calendar.HOUR), mCalendar.get(Calendar.MINUTE), true);
        dialog.show();

    }

    //--------------------------------------------------------------------------------------------------------------------------------------------------------------------
    private void showDataDialog(final Button button) {
        Calendar calendar = Calendar.getInstance();
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
        }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH));
        //设置时间范围
//        dateDialog.getDatePicker().setMinDate(CalendarUtil.GetLastMonthDate().getTimeInMillis());
        datePickerDialog.getDatePicker().setMinDate(calendar.getTimeInMillis());
        datePickerDialog.show();
    }
    private long StringToLong(String time) {
        //String time=btn_data1.getText().toString();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy年MM月dd日HH:ss");
        Date date=new Date();
        //date=simpleDateFormat.parse(time);
        try{
            date = simpleDateFormat.parse(time);
        } catch(ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Log.i("long",""+date.getTime());
        return date.getTime();
    }

private long calendar_set2(){
    calendar.set(Calendar.YEAR,d_year);
    calendar.set(Calendar.MONTH,d_month);
    calendar.set(Calendar.DAY_OF_MONTH,d_day);
    calendar.set(Calendar.HOUR_OF_DAY,c_hour);
    calendar.set(Calendar.MINUTE,c_min);
    calendar.set(Calendar.SECOND,0);
    calendar.set(Calendar.MILLISECOND,0);
    return calendar.getTimeInMillis();
}

    private long calendar_set1(Button button1,Button button2){
        String time=button1.getText().toString()+button2.getText().toString();
        String year,month,day,hour,min;
        Log.i("time",time);
        year=time.substring(0,4);
        Log.i("year",year);
        month=time.substring(5,7);
        Log.i("month",month);
        day=time.substring(8,10);
        Log.i("day",day);
        hour=time.substring(11,13);
        Log.i("hour",hour);
        min=time.substring(14,16);
        Log.i("min",min);//   经过验证，确实得到了我想要的时间

        calendar.set(Calendar.YEAR,Integer.parseInt(year));
        calendar.set(Calendar.MONTH,Integer.parseInt(month));
        calendar.set(Calendar.DAY_OF_MONTH,Integer.parseInt(day));
        calendar.set(Calendar.HOUR_OF_DAY,Integer.parseInt(hour));
        calendar.set(Calendar.MINUTE,Integer.parseInt(min));
        calendar.set(Calendar.SECOND,0);
        calendar.set(Calendar.MILLISECOND,0);
        return calendar.getTimeInMillis();



    }

    private void bindViews_tt(long tt) {

        alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        Intent intent = new Intent(MainActivity.this, ClockActivity.class);
        pi = PendingIntent.getActivity(MainActivity.this, 0, intent, 0);
        alarmManager.set(AlarmManager.RTC_WAKEUP,tt, pi);


    }




}

