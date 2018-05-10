package com.example.intent1;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by 16221 on 2018/2/8.
 */

public class SecondActivity extends AppCompatActivity {
    private Button but1;
    private TextView txt1;
    private TextView txt2;
    private TextView txt3;
    private Intent intent;
    private Bundle bundle;
    private Bundle bundleFrom3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        initView();
        intent=getIntent();
        bundle=intent.getExtras();
        change_txt();
        butOnclick();
    }

    private void initView(){
        but1=(Button) findViewById(R.id.main2_but1);
        txt1=(TextView)findViewById(R.id.main2_txt1);
        txt2=(TextView)findViewById(R.id.main2_txt2);
        txt3=(TextView)findViewById(R.id.main2_txt3);
    }

    private void change_txt(){//从第一个页面拿来的东西
        String s_txt1=bundle.getString("first");
        String s_txt2=bundle.getString("second");
        String s_txt3=bundle.getString("third");
        txt1.setText(s_txt1);
        txt2.setText(s_txt2);
        txt3.setText(s_txt3);
    }

    private void butOnclick(){//记录跳转前第二个页面的数据
        but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SecondActivity.this,ThirdActivity.class);
                Bundle bundle2=new Bundle();
                bundle2.putString("first_1",txt1.getText().toString());
                bundle2.putString("first_2",txt2.getText().toString());
                bundle2.putString("first_3",txt3.getText().toString());
                intent.putExtras(bundle2);//这里测试一下用之前的可不可以
                startActivityForResult(intent,0x717);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode,int resultCode,Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if(resultCode==0x717){
            bundleFrom3=data.getExtras();  //--------------------------------------------------------
            txt3.setText(bundleFrom3.getString("main3_txt3"));
            txt1.setText(bundleFrom3.getString("first_1"));
            txt2.setText(bundleFrom3.getString("first_2"));
        }
    }
}
