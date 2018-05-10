package com.example.intent2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private EditText editText1;
    private EditText editText2;
    private TextView textView_main;
    private Bundle bundleFromSec;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=(Button)findViewById(R.id.button_jump);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,Sec.class);
                Bundle bundle2=new Bundle();
                bundle2.putString("first_1",editText1.getText().toString());
                bundle2.putString("first_2",editText2.getText().toString());

                intent.putExtras(bundle2);//这里测试一下用之前的可不可以
                startActivityForResult(intent,0x717);

            }
        });


    }
    @Override
    protected void onActivityResult(int requestCode,int resultCode,Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if(resultCode==0x717){
            bundleFromSec=data.getExtras();  //--------------------------------------------------------
            textView_main.setText(bundleFromSec.getString("sec_textview"));

//            txt3.setText(bundleFrom3.getString("main3_txt3"));
//            txt1.setText(bundleFrom3.getString("first_1"));
//            txt2.setText(bundleFrom3.getString("first_2"));
        }
    }


}
