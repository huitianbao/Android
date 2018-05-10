package com.example.server3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button mBtStartFrontService;
    private Button mBtStopFrontService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mBtStartFrontService = (Button) findViewById(R.id.button_start_service);
        mBtStopFrontService = (Button) findViewById(R.id.button_stop_service);
        mBtStartFrontService.setOnClickListener(this);
        mBtStopFrontService.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent2 = new Intent(MainActivity.this, MyService2.class);
        switch (view.getId()) {
            case R.id.button_start_service:
                startService(intent2);
                break;
            case R.id.button_stop_service:
                stopService(intent2);
                break;
        }
    }
}
