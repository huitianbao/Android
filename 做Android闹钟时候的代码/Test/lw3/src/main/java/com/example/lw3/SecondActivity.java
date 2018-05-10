package com.example.lw3;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by 16221 on 2018/2/8.
 */

public class SecondActivity extends AppCompatActivity {
    private TextView textView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acctivity_second);
        textView=(TextView)findViewById(R.id.textView_second);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        /*
        String name = bundle.getString("name");
        int age = bundle.getInt("age");
        float weight = bundle.getFloat("weight");
        textView.setText(name+","+age+","+weight);
        */

        String receive=bundle.getString("send");
        textView.setText(receive);
    }
}
