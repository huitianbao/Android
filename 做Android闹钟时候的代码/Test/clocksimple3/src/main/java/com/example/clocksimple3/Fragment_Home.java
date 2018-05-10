package com.example.clocksimple3;

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

public class Fragment_Home extends Fragment{


    @Nullable
    private Button button_home;
    private TextView textView_home;
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      //  return super.onCreateView(inflater, container, savedInstanceState);
        return inflater.inflate(R.layout.activity_home,container,false);
    }


}
