package com.example.abir.rangetimepickersample;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TimePicker;
import android.widget.Toast;

import com.wdullaer.materialdatetimepicker.time.TimePickerDialog;

import java.util.Calendar;

public class Main2Activity extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener {

    public static final String DATEPICKER_TAG = "datepicker";
    public static final String TIMEPICKER_TAG = "timepicker";
    Context context;
    private TimePickerDialog tpd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        final Calendar calendar = Calendar.getInstance();
        context = getApplicationContext();

//        final DatePickerDialog datePickerDialog = DatePickerDialog.newInstance(this, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), isVibrate());
//        final TimePickerDialog timePickerDialog = TimePickerDialog.newInstance(this, calendar.get(Calendar.HOUR_OF_DAY) ,calendar.get(Calendar.MINUTE), false, false);


//        findViewById(R.id.dateButton).setOnClickListener(new OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                datePickerDialog.setVibrate(isVibrate());
//                datePickerDialog.setYearRange(1985, 2028);
//                datePickerDialog.setCloseOnSingleTapDay(isCloseOnSingleTapDay());
//                datePickerDialog.show(getSupportFragmentManager(), DATEPICKER_TAG);
//            }
//        });

        findViewById(R.id.time_button2).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
//                timePickerDialog.setVibrate(isVibrate());
//                timePickerDialog.setCloseOnSingleTapMinute(isCloseOnSingleTapMinute());
//                timePickerDialog.setStartTime(8,0);



//
//                timePickerDialog.show(getSupportFragmentManager(), TIMEPICKER_TAG);
                showHourPicker();


            }
        });

//        if (savedInstanceState != null) {
//
////            TimePickerDialog tpd = (TimePickerDialog) getSupportFragmentManager().findFragmentByTag(TIMEPICKER_TAG);
////            if (tpd != null) {
////                tpd.setOnTimeSetListener(this);
////            }
//        }
    }

    private void showHourPicker() {
        final Calendar myCalender = Calendar.getInstance();
//        int hour = myCalender.get(Calendar.HOUR_OF_DAY);
//        int minute = myCalender.get(Calendar.MINUTE);


//        SimpleDateFormat sdf = new SimpleDateFormat("hh:ss");
//        Date date = null;
//        try {
//            date = sdf.parse("08:00");
//        } catch (ParseException e) {
//        }
//        Calendar c = Calendar.getInstance();
//        c.setTime(date);


        RangeTimePickerDialog.OnTimeSetListener myTimeListener = new RangeTimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                if (view.isShown()) {
                    myCalender.set(Calendar.HOUR_OF_DAY, 8);
                    myCalender.set(Calendar.MINUTE, 0);

                }
            }
        };
//        RangeTimePickerDialog timePickerDialog = new RangeTimePickerDialog(Main2Activity.this, AlertDialog.THEME_DEVICE_DEFAULT_DARK, myTimeListener, 8, 0, false);
//        timePickerDialog.setTitle("Choose hour:");
//        timePickerDialog.setMin(8, 0);
//        timePickerDialog.setMax(12, 0);
//        timePickerDialog.getWindow().setBackgroundDrawableResource(android.R.color.white);
//        timePickerDialog.show();
        tpd = TimePickerDialog.newInstance(
                Main2Activity.this,
                myCalender.get(Calendar.HOUR_OF_DAY),
                myCalender.get(Calendar.MINUTE),
                false
        );

        tpd.setTitle("TimePicker Title");
//        tpd.setMinTime(12,0,0);
//        tpd.setMaxTime(17,0,0);
        tpd.setMinTime(8,0,0);
        tpd.setMaxTime(12,0,0);
        tpd.show(getFragmentManager(), "Timepickerdialog");

    }

    @Override
    public void onResume() {
        super.onResume();
        TimePickerDialog tpd = (TimePickerDialog) getFragmentManager().findFragmentByTag("Timepickerdialog");
        if(tpd != null) tpd.setOnTimeSetListener(this);
    }


    @Override
    public void onTimeSet(TimePickerDialog view, int hourOfDay, int minute, int second) {

        String hourString = hourOfDay < 10 ? "0"+hourOfDay : ""+hourOfDay;
        String minuteString = minute < 10 ? "0"+minute : ""+minute;
        String secondString = second < 10 ? "0"+second : ""+second;
        String time = "You picked the following time: "+hourString+"h"+minuteString+"m"+secondString+"s";
        Toast.makeText(this, time, Toast.LENGTH_SHORT).show();


    }
}
