package com.example.timepicker1;


import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;


public class MainActivity extends AppCompatActivity {

    private Button mButtonTimePickerDialog;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButtonTimePickerDialog=(Button)findViewById(R.id.button_time);
        mButtonTimePickerDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showTimePickerDialog(mButtonTimePickerDialog);
            }
        });


    }
    private void showTimePickerDialog(final Button button) {
        final Calendar mCalendar = Calendar.getInstance();
        TimePickerDialog dialog = new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int i, int i1) {
                mCalendar.set(Calendar.HOUR, i);
                mCalendar.set(Calendar.MINUTE, i1);
/*
                SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日HH:mm");
                Toast.makeText(getApplicationContext(), "" + format.format(mCalendar.getTime()), Toast.LENGTH_SHORT).show();
*/
                button.setText(i+":"+i1);

                Toast.makeText(getApplicationContext(), "the time you set is "+i+":"+i1 , Toast.LENGTH_SHORT).show();
            }
        }, mCalendar.get(Calendar.HOUR), mCalendar.get(Calendar.MINUTE), true);
        dialog.show();

    }


}
