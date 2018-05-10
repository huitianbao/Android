package com.example.clock6;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by 16221 on 2018/2/3.
 */

public class AlarmAlert extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        new AlertDialog.Builder(AlarmAlert.this)
                .setIcon(R.mipmap.ic_launcher)
                .setTitle("ddd")
                .setMessage("fff")
                .setPositiveButton("ddd",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,
                                                int whichButton) {
                                System.exit(0);
                                android.os.Process
                                        .killProcess(android.os.Process
                                                .myPid());
                            }
                        }).show();
    }
}
