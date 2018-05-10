package com.example.intent3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity {
    private TextView textView01;
    private Button button01;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView01=(TextView)findViewById(R.id.textView_main);
        button01=(Button)findViewById(R.id.button_main);


        button01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                DataBean bean = new DataBean();
                //通过set方法把数据保存到DataBean对象中
                bean.setName("啦啦");
                bean.setSex("男");
                intent.putExtra("key", bean);
                startActivity(intent);
            }
        });

        receive();
    }
    private void receive() {
        Intent intent = getIntent();
        //反序列化数据对象
        Serializable se = intent.getSerializableExtra("key2");
        if (se instanceof DataBean) {
            //获取到携带数据的DataBean对象db
            DataBean db = (DataBean) se;
            textView01.setText(db.getName() + "++++++++" + db.getSex());
        }
    }
}


