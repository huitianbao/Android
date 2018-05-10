package com.example.intent2;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by 16221 on 2018/2/8.
 */

public class Sec extends AppCompatActivity {
    private TextView textView;
    private Button button_sec;

    private Intent intent;
    private Bundle bundle;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sec);
        textView=(TextView)findViewById(R.id.textView_sec);
        button_sec=(Button)findViewById(R.id.button_sec);

        intent=getIntent();
        bundle=intent.getExtras();

        button_sec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(0x717,intent);//通过别人传过来的意图反向回去
                finish();
            }
        });

    }
    private void addIntent(){//把第三个中部分内容加到第二个页面传过来的bundle
        bundle.putString("sec_textview",textView.getText().toString());
        intent.putExtras(bundle);
    }


}
