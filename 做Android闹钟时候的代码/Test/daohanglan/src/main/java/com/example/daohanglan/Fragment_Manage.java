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

public class Fragment_Manage extends Fragment {
    private Button button_manage;
    private TextView textView_manage;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        //View rootview=super.onCreateView(inflater, container, savedInstanceState);
        View rootview = inflater.inflate(R.layout.activity_manage, container, false);

        button_manage = (Button) rootview.findViewById(R.id.ac_manage_btn);
        textView_manage = (TextView) rootview.findViewById(R.id.ac_manage_tv);
        button_manage.setOnClickListener(new Listener());

        return rootview;
    }

    class Listener implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.ac_manage_btn:
                    textView_manage.setText("dddddddddddddd_manage");

            }
        }
    }

}




    /*
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.ac_manage_btn:
                textView_manage.setText("after click ");
        }
    }

}
*/
