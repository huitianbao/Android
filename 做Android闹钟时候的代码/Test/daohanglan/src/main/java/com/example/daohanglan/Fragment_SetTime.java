package com.example.daohanglan;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by 16221 on 2018/1/28.
 */

public class Fragment_SetTime extends Fragment{
//    private TextView textView_settime;
//    private Button button_settime;

    @Nullable

      TextView textView_settime;
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootview=inflater.inflate(R.layout.activity_settime,container,false);
        textView_settime=(TextView)rootview.findViewById(R.id.ac_settime_tv);
        Button button_settime=(Button)rootview.findViewById(R.id.ac_settime_btn);
        button_settime.setOnClickListener(new Listener());


        return rootview;
    }

    class Listener implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.ac_settime_btn:
                    textView_settime.setText("dddddddddddddd_set time");

            }
        }
    }
}
