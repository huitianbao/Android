package com.example.intent1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by 16221 on 2018/2/8.
 */

public class ThirdActivity extends AppCompatActivity {
    private Button but1;
    private TextView txt1;
    private TextView txt2;
    private TextView txt3;
    private Intent intent;
    private Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        initView();
        addIntent();
        butOnClick();
    }

    private void initView(){
        but1=(Button) findViewById(R.id.main3_but1);
        txt1=(TextView)findViewById(R.id.main3_txt1);
        txt2=(TextView)findViewById(R.id.main3_txt2);
        txt3=(TextView)findViewById(R.id.main3_txt3);
        intent=getIntent();
        bundle=intent.getExtras();
    }

    private void butOnClick(){
        but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(0x717,intent);//通过别人传过来的意图反向回去
                //finish();
            }
        });
    }

    private void addIntent(){//把第三个中部分内容加到第二个页面传过来的bundle
        bundle.putString("main3_txt3",txt3.getText().toString());
        intent.putExtras(bundle);
    }
}
