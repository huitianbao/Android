package com.example.clocksimple;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
    Calendar mCalendar = Calendar.getInstance();  // time
    Calendar calendar = Calendar.getInstance();  // data
    Calendar upCalendar=Calendar.getInstance(); //update

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


    private Button btn_quit;
    private Button btn_conf;

    private static int my_year,my_month,my_day;



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

        btn_quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // sort();
            }
        });


    }

    private void showTimePickerDialog(final Button button) {
       // final Calendar mCalendar = Calendar.getInstance();
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

                Toast.makeText(getApplicationContext(), "the time you set is "+button.getText(), Toast.LENGTH_SHORT).show();
            }
        }, mCalendar.get(Calendar.HOUR), mCalendar.get(Calendar.MINUTE), true);
        dialog.show();

    }
    /*
//===============================================================================================================
    private void showDataDialog_one(final Button button){
        //Calendar calendar = Calendar.getInstance();

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
                        .append("-")
                        .append((mMonth + 1) < 10 ? 0 + (mMonth + 1) : (mMonth + 1))
                        .append("-")
                        .append((mDay < 10) ? 0 + mDay : mDay));
            }


        }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH));
        Toast.makeText(this,"hehe:"+calendar.get(Calendar.YEAR)+" "+calendar.get(Calendar.MONTH)+" "+calendar.get(Calendar.DAY_OF_MONTH),Toast.LENGTH_LONG).show();
        //设置时间范围
//        dateDialog.getDatePicker().setMinDate(CalendarUtil.GetLastMonthDate().getTimeInMillis());
        datePickerDialog.getDatePicker().setMinDate(calendar.getTimeInMillis());
        datePickerDialog.show();



    }
    */
    //--------------------------------------------------------------------------------------------------------------------------------------------------------------------
    private void showDataDialog(final Button button) {
       //String ret;
        //Calendar calendar = Calendar.getInstance();

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
                        .append((mMonth + 1) < 10 ? 0 + (mMonth + 1) : (mMonth + 1))
                        .append("月")
                        .append((mDay < 10) ? 0 + mDay : mDay)
                        .append("日"))
               ;
            }


        }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH));
        //设置时间范围
//        dateDialog.getDatePicker().setMinDate(CalendarUtil.GetLastMonthDate().getTimeInMillis());
        datePickerDialog.getDatePicker().setMinDate(calendar.getTimeInMillis());
        datePickerDialog.show();

        //Toast.makeText(getApplicationContext(), "the data you set is "+button.getText(), Toast.LENGTH_SHORT).show();


    }
/*
private void update_ca(){
        calendar.add(Calendar.DAY_OF_MONTH,1);
}
    private void order_data(){
        btn_data1.setText(calendar.get(Calendar.YEAR)+"-"+calendar.get(Calendar.MONTH)+"-"+calendar.get(Calendar.DAY_OF_MONTH));
        calendar.set(my_year,my_month,my_day);
        update_ca();
        btn_data2.setText(calendar.get(Calendar.YEAR)+"-"+calendar.get(Calendar.MONTH)+"-"+calendar.get(Calendar.DAY_OF_MONTH));

    }


*/
//=========================================================================
    private long StringToLong(String time) {
        //String time=btn_data1.getText().toString();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy年MM月dd日");
        Date date=new Date();
        //date=simpleDateFormat.parse(time);
        try{
            date = simpleDateFormat.parse(time);
        } catch(ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return date.getTime();
    }

    private String LongToString(long time){
        Date d = new Date(time);
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy年MM月dd日");
        return  simpleDateFormat.format(d);
    }



    private void sort(){
        long date=StringToLong(btn_data1.getText().toString());
        Calendar calendar=Calendar.getInstance();
        calendar.setTimeInMillis(date); //得到了 button 1 上的时间

        calendar.add(Calendar.DAY_OF_MONTH,1); // 把 button1 的时间加一天
        long date2=calendar.getTimeInMillis();
        String text2=LongToString(date2);

        btn_data2.setText(text2);
    }


}
