package com.example.service1;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.net.Inet4Address;


public class MainActivity extends AppCompatActivity {

private Button btn_send;
private Button btn_first;
private Button btn_second;
private Button btn_my;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_send=(Button)findViewById(R.id.button_send);
        btn_first=(Button)findViewById(R.id.button_first);
        btn_second=(Button)findViewById(R.id.button_second);
        btn_my=(Button)findViewById(R.id.button_my);


        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                send();
            }
        });

        btn_first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent("android.intent.action.FIRST");
                intent.putExtra("first","this is btn_first_listener");
                sendOrderedBroadcast(intent,"harvic.broadcast.perssion");
            }
        });

        btn_second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent("android.intent.action.SECOND");
                intent.putExtra("second","this is btn_second_listener");
                sendOrderedBroadcast(intent,"harvic.broadcast.perssion");
            }
        });

        btn_my.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent("android.intent.action.MY");
                intent.putExtra("my","this is btn_my_listener");
                sendOrderedBroadcast(intent,"harvic.broadcast.perssion");


            }
        });


    }

    public void send() {

        Intent intent = new Intent("android.intent.action.MY_BROADCAST");
        intent.putExtra("msg", "hello receiver.");
        sendOrderedBroadcast(intent, "harvic.broadcast.perssion");
    }

}
