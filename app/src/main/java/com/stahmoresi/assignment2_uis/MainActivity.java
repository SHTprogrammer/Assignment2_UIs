package com.stahmoresi.assignment2_uis;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class MainActivity extends ActionBarActivity {

    Spinner activitySpinner;
    Button button;
    String activityStringFromSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        activitySpinner = (Spinner) findViewById(R.id.activity_spinner);
        button = (Button) findViewById(R.id.button);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.activities, android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        activitySpinner.setAdapter(adapter);

        activityStringFromSpinner = activitySpinner.getSelectedItem().toString();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = createActivityIntent(activitySpinner.getSelectedItemPosition());
                startActivity(intent);
            }
        });

    }

    private Intent createActivityIntent(int position) {
        switch (position) {
            case 0:
                return new Intent(MainActivity.this, DatePicker.class);
            case 1:
                return new Intent(MainActivity.this, Keyboard.class);
            case 2:
                return new Intent(MainActivity.this, List.class);
            default:
                return new Intent(MainActivity.this, MainActivity.class);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
