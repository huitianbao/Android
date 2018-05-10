package com.example.daohanglan;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by 16221 on 2018/1/28.
 */

public class Fragment_Home extends Fragment{
private  Button button_home;
private TextView textView_home;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       // View rootview=super.onCreateView(inflater, container, savedInstanceState);
        View rootview=inflater.inflate(R.layout.activity_home,container,false);
       // Button button_home=(Button)rootview.findViewById(R.id.ac_home_btn);
        //final TextView textView_home=(TextView)rootview.findViewById(R.id.ac_home_tv);

        button_home=(Button)rootview.findViewById(R.id.ac_home_btn);
        textView_home=(TextView)rootview.findViewById(R.id.ac_home_tv);
        button_home.setOnClickListener(new Listener());



        return rootview;
    }
    class Listener implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.ac_home_btn:
                    textView_home.setText("dddddddddddddd_home");

            }
        }
    }



}
