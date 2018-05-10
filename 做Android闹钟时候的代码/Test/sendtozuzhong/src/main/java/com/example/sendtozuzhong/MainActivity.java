package com.example.sendtozuzhong;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private Button btn_day1;
    private Button btn_day2;
    private Button btn_day3;
    private Button btn_day4;
    private Button btn_day5;
    private Button btn_day6;
    private Button btn_day7;

    private Button btn_confirm;
    private Button btn_cancel;

    private Intent intent1;
    private Intent intent2;
    private Intent intent3;
    private Intent intent4;
    private Intent intent5;
    private Intent intent6;
    private Intent intent7;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        btn_day1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //发送
                Intent intent = new Intent(MainActivity.this,SelectActivity1.class);
                startActivity(intent);



            }
        });

        btn_day2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //发送
                Intent intent = new Intent(MainActivity.this,SelectActivity1.class);
                startActivity(intent);
            }
        });

        btn_day3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //发送
                Intent intent = new Intent(MainActivity.this,SelectActivity1.class);
                startActivity(intent);
            }
        });


        btn_day4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //发送
                Intent intent = new Intent(MainActivity.this,SelectActivity1.class);
                startActivity(intent);
            }
        });


        btn_day5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //发送
                Intent intent = new Intent(MainActivity.this,SelectActivity1.class);
                startActivity(intent);
            }
        });


        btn_day6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //发送
                Intent intent = new Intent(MainActivity.this,SelectActivity1.class);
                startActivity(intent);
            }
        });


        btn_day7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //发送
                Intent intent = new Intent(MainActivity.this,SelectActivity1.class);
                startActivity(intent);
            }
        });
        receive1();
        receive11();

    }
    private void receive1(){
        Intent intent = getIntent();
        //反序列化数据对象
        Serializable se = intent.getSerializableExtra("msg1");
        if(se instanceof DataTime){
            //获取到携带数据的DataBean对象db
            DataTime db = (DataTime) se;
            btn_day1.setText(db.getYear()+"-"+db.getMonth()+"-"+db.getDay()+"-"+db.getHour()+":"+db.getMin());
        }
    }

    private void receive11(){
        Intent intent = getIntent();
        //反序列化数据对象
        Serializable se = intent.getSerializableExtra("msg11");
        if(se instanceof DataTime){
            //获取到携带数据的DataBean对象db
            DataTime db = (DataTime) se;
            btn_day1.setText(db.getRest());
        }

    }




    private void fun_intent1() {
        intent1 = new Intent(MainActivity.this, SelectActivity1.class);
        startActivity(intent1);
    }

    private void fun_intent2() {
        intent2 = new Intent(MainActivity.this, SelectActivity1.class);
        startActivity(intent2);
    }

    private void fun_intent3() {
        intent3 = new Intent(MainActivity.this, SelectActivity1.class);
        startActivity(intent3);
    }

    private void fun_intent4() {
        intent4 = new Intent(MainActivity.this, SelectActivity1.class);
        startActivity(intent4);
    }

    private void fun_intent5() {
        intent5 = new Intent(MainActivity.this, SelectActivity1.class);
        startActivity(intent5);
    }

    private void fun_intent6() {
        intent6 = new Intent(MainActivity.this, SelectActivity1.class);
        startActivity(intent6);
    }


    private void fun_intent7() {
        intent7 = new Intent(MainActivity.this, SelectActivity1.class);
        startActivity(intent7);
    }


    private void init() {
        btn_day1 = (Button) findViewById(R.id.button_day1);
        btn_day2 = (Button) findViewById(R.id.button_day2);
        btn_day3 = (Button) findViewById(R.id.button_day3);
        btn_day4 = (Button) findViewById(R.id.button_day4);
        btn_day5 = (Button) findViewById(R.id.button_day5);
        btn_day6 = (Button) findViewById(R.id.button_day6);
        btn_day7 = (Button) findViewById(R.id.button_day7);
        btn_confirm = (Button) findViewById(R.id.button_confirm);
        btn_cancel = (Button) findViewById(R.id.button_cancel);

    }


    private long stringToLong(String time) {
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

    private String longToString(long time){
        Date d = new Date(time);
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy年MM月dd日");
        return  simpleDateFormat.format(d);
    }





}
