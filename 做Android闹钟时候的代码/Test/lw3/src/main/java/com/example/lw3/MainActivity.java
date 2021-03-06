package com.example.lw3;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
//                                                                                                                                                                                                                                                                                                                                                      package com.example.lw3;

public class MainActivity extends AppCompatActivity{
    private Button button_main;
    private EditText editText_main;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button_main=(Button)findViewById(R.id.button_main);
        editText_main=(EditText)findViewById(R.id.editText_main);

        button_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                /*
                bundle.putString("name", "乔峰");
                bundle.putInt("age", 40);
                bundle.putFloat("weight", 70.4f);
                */
                bundle.putString("send",editText_main.getText().toString());
                intent.putExtras(bundle);

                intent.setClass(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });
    }
}