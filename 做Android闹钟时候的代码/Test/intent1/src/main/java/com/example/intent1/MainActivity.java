package com.example.intent1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button but1;
    private TextView txt1;
    private TextView txt2;
    private TextView txt3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        butOnClick();

    }
    private void initView(){
        but1=(Button) findViewById(R.id.main1_but1);
        txt1=(TextView)findViewById(R.id.main1_txt1);
        txt2=(TextView)findViewById(R.id.main1_txt2);
        txt3=(TextView)findViewById(R.id.main1_txt3);
    }

    private void butOnClick(){
        but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,SecondActivity.class);
                Bundle bundle=new Bundle();
                String s_txt1=txt1.getText().toString();
                String s_txt2=txt1.getText().toString();
                String s_txt3=txt1.getText().toString();
                bundle.putString("first",s_txt1);
                bundle.putString("second",s_txt2);
                bundle.putString("third",s_txt3);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
}
