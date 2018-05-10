package com.example.service2;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView fuction;
    private Button start;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //初始化控件
        init();
        //创建进程
        inProcess();


    }

    private void init() {
        start = (Button) findViewById(R.id.button_start);
        fuction = (TextView) findViewById(R.id.textView_fun);
        start.setOnClickListener(new StartOnClickListener());
        fuction.setOnClickListener(new FuctionOnClickListener());
    }

    //功能按钮监听实现函数
34

    private final class FuctionOnClickListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(MainActivity.this, FuctionActivity.class);
            startActivity(intent);
        }
    }


    //进程函数
    private void inProcess() {
        Intent intent = new Intent(MainActivity.this, HelloteacherService.class);
        startService(intent);
        Intent intent2 = new Intent(MainActivity.this, HelloteacherService2.class);
        startService(intent2);
    }

    private final class StartOnClickListener implements View.OnClickListener{

        @Override
        public void onClick(View view) {

        }
    }

}
