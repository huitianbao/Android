package com.example.wjj1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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

    private String ser1="msg1";
    private String ser11="msg11";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();


        btn_day1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {fun_intent1();
            }
        });

        btn_day2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fun_intent2();
            }
        });

        btn_day3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fun_intent3();
            }
        });


        btn_day4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fun_intent4();
            }
        });


        btn_day5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fun_intent5();
            }
        });


        btn_day6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fun_intent6();
            }
        });


        btn_day7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fun_intent7();
            }
        });
        receive1();
        receive11();

        receive2();
        receive22();

        receive3();
        receive33();

        receive4();
        receive44();

        receive5();
        receive55();

        receive6();
        receive66();

        receive7();
        receive77();



    }


    //==============================================================================================
    private void receive1(){
        Intent intentr1 = getIntent();
        if(intentr1!=null){
            Log.i("intentr1","intentr1 is not null");
            Log.i("intentr1","intentr1 is "+intentr1);


        }else {
            Log.i("intentr1","intentr1 is null");
        }
        //反序列化数据对象
        Serializable se = intentr1.getSerializableExtra("msg1");
        if(se instanceof DataTime){
            //获取到携带数据的DataBean对象db
            DataTime db = (DataTime) se;
            Log.i("1name",db.getName());
            btn_day1.setText(db.getYear()+"-"+db.getMonth()+"-"+db.getDay()+"-"+db.getHour()+":"+db.getMin());
        }
    }

    private void receive11() {
        Intent intentr1 = getIntent();
        //反序列化数据对象
        Serializable se = intentr1.getSerializableExtra("msg11");
        if (se instanceof DataTime) {
            //获取到携带数据的DataBean对象db
            DataTime db = (DataTime) se;
            Log.i("11name","11name is "+db.getName());
            btn_day1.setText(db.getRest());
        }
    }

//==================================================================================================
private void receive2(){
    Intent intentr2 = getIntent();
    if(intentr2!=null){
        Log.i("intentr2","intentr2 is not null");
        Log.i("intentr2","intentr2 is "+intentr2);

    }else {
        Log.i("intentr2","intentr2 is null");
    }

    //反序列化数据对象
    Serializable se = intentr2.getSerializableExtra("msg2");
    if(se instanceof DataTime){// 为什么这里没有被执行到呢？？？？？？？？？？？？？？？？？？？？？？？？
        Log.i("ex1","----------------ex1");
        //获取到携带数据的DataBean对象db
        DataTime db = (DataTime) se;
        Log.i("ex2","----------------ex2");
        Log.i("2name","2name is "+db.getName());
        btn_day2.setText(db.getYear()+"-"+db.getMonth()+"-"+db.getDay()+"-"+db.getHour()+":"+db.getMin());
        Log.i("ex3","----------------ex3");


    }
}

    private void receive22() {
        Intent intent = getIntent();
        //反序列化数据对象
        Serializable se2 = intent.getSerializableExtra("msg22");
        if (se2 instanceof DataTime) {
            //获取到携带数据的DataBean对象db
            DataTime db2 = (DataTime) se2;
            Log.i("22name","22name is "+db2.getName());
            btn_day2.setText(db2.getRest());
        }
    }

    //==============================================================================================
    private void receive3(){
        Intent intent = getIntent();
        //反序列化数据对象
        Serializable se = intent.getSerializableExtra("msg3");
        if(se instanceof DataTime){
            //获取到携带数据的DataBean对象db
            DataTime db = (DataTime) se;
            btn_day3.setText(db.getYear()+"-"+db.getMonth()+"-"+db.getDay()+"-"+db.getHour()+":"+db.getMin());
        }
    }

    private void receive33() {
        Intent intent = getIntent();
        //反序列化数据对象
        Serializable se = intent.getSerializableExtra("msg33");
        if (se instanceof DataTime) {
            //获取到携带数据的DataBean对象db
            DataTime db = (DataTime) se;
            btn_day3.setText(db.getRest());
        }
    }
//==================================================================================================
private void receive4(){
    Intent intent = getIntent();
    //反序列化数据对象
    Serializable se = intent.getSerializableExtra("msg4");
    if(se instanceof DataTime){
        //获取到携带数据的DataBean对象db
        DataTime db = (DataTime) se;
        btn_day4.setText(db.getYear()+"-"+db.getMonth()+"-"+db.getDay()+"-"+db.getHour()+":"+db.getMin());
    }
}

    private void receive44() {
        Intent intent = getIntent();
        //反序列化数据对象
        Serializable se = intent.getSerializableExtra("msg44");
        if (se instanceof DataTime) {
            //获取到携带数据的DataBean对象db
            DataTime db = (DataTime) se;
            btn_day4.setText(db.getRest());
        }
    }

    //==============================================================================================

    private void receive5(){
        Intent intent = getIntent();
        //反序列化数据对象
        Serializable se = intent.getSerializableExtra("msg5");
        if(se instanceof DataTime){
            //获取到携带数据的DataBean对象db
            DataTime db = (DataTime) se;
            btn_day5.setText(db.getYear()+"-"+db.getMonth()+"-"+db.getDay()+"-"+db.getHour()+":"+db.getMin());
        }
    }

    private void receive55() {
        Intent intent = getIntent();
        //反序列化数据对象
        Serializable se = intent.getSerializableExtra("msg55");
        if (se instanceof DataTime) {
            //获取到携带数据的DataBean对象db
            DataTime db = (DataTime) se;
            btn_day5.setText(db.getRest());
        }
    }

    //==============================================================================================

    private void receive6(){
        Intent intent = getIntent();
        //反序列化数据对象
        Serializable se = intent.getSerializableExtra("msg6");
        if(se instanceof DataTime){
            //获取到携带数据的DataBean对象db
            DataTime db = (DataTime) se;
            btn_day6.setText(db.getYear()+"-"+db.getMonth()+"-"+db.getDay()+"-"+db.getHour()+":"+db.getMin());
        }
    }

    private void receive66() {
        Intent intent = getIntent();
        //反序列化数据对象
        Serializable se = intent.getSerializableExtra("msg66");
        if (se instanceof DataTime) {
            //获取到携带数据的DataBean对象db
            DataTime db = (DataTime) se;
            btn_day6.setText(db.getRest());
        }
    }


    //==============================================================================================

    private void receive7(){
        Intent intent = getIntent();
        //反序列化数据对象
        Serializable se = intent.getSerializableExtra("msg7");
        if(se instanceof DataTime){
            //获取到携带数据的DataBean对象db
            DataTime db = (DataTime) se;
            btn_day7.setText(db.getYear()+"-"+db.getMonth()+"-"+db.getDay()+"-"+db.getHour()+":"+db.getMin());
        }
    }

    private void receive77() {
        Intent intent = getIntent();
        //反序列化数据对象
        Serializable se = intent.getSerializableExtra("msg77");
        if (se instanceof DataTime) {
            //获取到携带数据的DataBean对象db
            DataTime db = (DataTime) se;
            btn_day7.setText(db.getRest());
        }
    }

    //==============================================================================================


    private void fun_intent1() {
        intent1 = new Intent(MainActivity.this, SelectActivity1.class);
        startActivity(intent1);
    }

    private void fun_intent2() {
        intent2 = new Intent(MainActivity.this, SelectActivity2.class);
        startActivity(intent2);
    }

    private void fun_intent3() {
        intent3 = new Intent(MainActivity.this, SelectActivity3.class);
        startActivity(intent3);
    }

    private void fun_intent4() {
        intent4 = new Intent(MainActivity.this, SelectActivity4.class);
        startActivity(intent4);
    }

    private void fun_intent5() {
        intent5 = new Intent(MainActivity.this, SelectActivity5.class);
        startActivity(intent5);
    }

    private void fun_intent6() {
        intent6 = new Intent(MainActivity.this, SelectActivity6.class);
        startActivity(intent6);
    }


    private void fun_intent7() {
        intent7 = new Intent(MainActivity.this, SelectActivity7.class);
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
