package com.example.abir.rangetimepickersample;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements RangeTimePickerDialog.OnTimeSetListener {

    public static final String DATEPICKER_TAG = "datepicker";
    public static final String TIMEPICKER_TAG = "timepicker";
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

        findViewById(R.id.time_button).setOnClickListener(new OnClickListener() {
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

        if (savedInstanceState != null) {
//            DatePickerDialog dpd = (DatePickerDialog) getSupportFragmentManager().findFragmentByTag(DATEPICKER_TAG);
//            if (dpd != null) {
//                dpd.setOnDateSetListener(this);
//            }

//            TimePickerDialog tpd = (TimePickerDialog) getSupportFragmentManager().findFragmentByTag(TIMEPICKER_TAG);
//            if (tpd != null) {
//                tpd.setOnTimeSetListener(this);
//            }
        }
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
        RangeTimePickerDialog timePickerDialog = new RangeTimePickerDialog(MainActivity.this, AlertDialog.THEME_DEVICE_DEFAULT_DARK, myTimeListener, 8, 0, false);
        timePickerDialog.setTitle("Choose hour:");
        timePickerDialog.setMin(8,0);
        timePickerDialog.setMax(12,0);
        timePickerDialog.getWindow().setBackgroundDrawableResource(android.R.color.white);
        timePickerDialog.show();

    }

//    private boolean isVibrate() {
//        return ((CheckBox) findViewById(R.id.checkBoxVibrate)).isChecked();
//    }

//    private boolean isCloseOnSingleTapDay() {
//        return ((CheckBox) findViewById(R.id.checkBoxCloseOnSingleTapDay)).isChecked();
//    }

//    private boolean isCloseOnSingleTapMinute() {
//        return ((CheckBox) findViewById(R.id.checkBoxCloseOnSingleTapMinute)).isChecked();
//    }

//    @Override
//    public void onDateSet(DatePickerDialog datePickerDialog, int year, int month, int day) {
//        Toast.makeText(MainActivity.this, "new date:" + year + "-" + month + "-" + day, Toast.LENGTH_LONG).show();
//    }
//
//    @Override
//    public void onTimeSet(RadialPickerLayout view, int hourOfDay, int minute) {
//        Toast.makeText(MainActivity.this, "new time:" + hourOfDay + "-" + minute, Toast.LENGTH_LONG).show();
//    }

    @Override
    public void onTimeSet(TimePicker timePicker, int i, int i1) {

    }
}