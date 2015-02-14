package com.stahmoresi.assignment2_uis;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RadioButton;
import android.widget.RadioGroup;


public class DatePicker extends ActionBarActivity {
    RadioGroup groupBtn;
    RadioButton btnCalendar, btnSpinners, btnBoth;
    android.widget.DatePicker pickerDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_picker);
        groupBtn = (RadioGroup)findViewById(R.id.optGroup);
        btnCalendar = (RadioButton)findViewById(R.id.optCalendar);
        btnSpinners = (RadioButton)findViewById(R.id.optSpinners);
        btnBoth = (RadioButton)findViewById(R.id.optBoth);
        pickerDate = (android.widget.DatePicker)findViewById(R.id.pickerdate);
        groupBtn.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){

            @Override
            public void onCheckedChanged(RadioGroup arg0, int arg1) {
                if(btnCalendar.isChecked()){
                    pickerDate.setCalendarViewShown(true);
                    pickerDate.setSpinnersShown(false);
                }else if(btnSpinners.isChecked()){
                    pickerDate.setCalendarViewShown(false);
                    pickerDate.setSpinnersShown(true);
                }else{
                    pickerDate.setCalendarViewShown(true);
                    pickerDate.setSpinnersShown(true);
                }
            }});
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_date_picker, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
