package com.example.intent3;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.Serializable;

/**
 * Created by 16221 on 2018/2/8.
 */

public class SecondActivity extends AppCompatActivity {
    private Button button_sec;
    private TextView textView_sec;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        button_sec=(Button)findViewById(R.id.button_sec);
        textView_sec=(TextView)findViewById(R.id.textView_second);
        Intent intent = getIntent();

        //反序列化数据对象
        Serializable se = intent.getSerializableExtra("key");
        if(se instanceof DataBean){
            //获取到携带数据的DataBean对象db
            DataBean db = (DataBean) se;
            textView_sec.setText(db.getName()+"==="+db.getSex());
        }


        button_sec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SecondActivity.this,MainActivity.class);
                DataBean bean = new DataBean();
                //通过set方法把数据保存到DataBean对象中
                bean.setName("hhhhhh");
                bean.setSex("nnnn");
                intent.putExtra("key2", bean);
                startActivity(intent);
            }
        });
    }
}
