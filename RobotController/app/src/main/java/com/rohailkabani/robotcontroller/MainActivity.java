package com.rohailkabani.robotcontroller;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MyActivity";
    float set_speed;
    float set_rpm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText input_speed = (EditText) findViewById(R.id.speed_set);
        final EditText input_rpm = (EditText) findViewById(R.id.rpm_set);
        final TextView show_speed  = (TextView) findViewById(R.id.show_speed);
        final TextView show_rpm = (TextView) findViewById(R.id.show_rpm);
        Button btn_enter_speed = (Button) findViewById(R.id.btn_speed);
        Button btn_enter_rpm = (Button) findViewById(R.id.btn_rpm);
        Button btn_brake = (Button) findViewById(R.id.allow);
        Button btn_unbrake = (Button) findViewById(R.id.deny);


        btn_enter_speed.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.d(TAG, "onClick: Speed Button Pressed!");
                float input_speed_float = Float.parseFloat(input_speed.getText().toString());

                if ((input_speed_float >= 0) && (input_speed_float <= 1) && (input_speed != null)) {
                   set_speed = Float.parseFloat(input_speed.getText().toString());
                    Log.d(TAG, "onClick: SPEED btn:" + set_speed);

                    show_speed.setText(Float.toString(set_speed));
                    input_rpm.setText("0");
                    set_rpm = 0;
                    show_rpm.setText("If wifi module worked... :(");
                } else {
                    //TODO: Fix the toast
                   Toast.makeText(getApplicationContext(), "Invalid speed.", Toast.LENGTH_SHORT);
               }
            }
        });

        btn_enter_rpm.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                float input_rpm_float = Float.parseFloat(input_rpm.getText().toString());

                if ((input_rpm_float >= 0) && (input_rpm_float <= 6500) && (input_rpm != null)) {
                    set_rpm = Float.parseFloat(input_rpm.getText().toString());
                    Log.d(TAG, "onClick: RPM Btn: " + set_rpm);

                    show_rpm.setText(Float.toString(set_rpm));
                    input_speed.setText("0");
                    set_speed = 0;
                    show_speed.setText("If wifi module worked... :(");
                } else {
                    //TODO: Fix the toast
                    Toast.makeText(getApplicationContext(), "Invalid rpm.", Toast.LENGTH_SHORT);
                }
            }
        });

        btn_brake.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Braking...", Toast.LENGTH_SHORT);

                input_speed.setText("0");
                input_rpm.setText("0");
                show_rpm.setText("0");
                show_speed.setText("0");
            }
        });

        btn_unbrake.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Braking...", Toast.LENGTH_SHORT);

                input_speed.setText(Float.toString(set_speed));
                input_rpm.setText(Float.toString(set_rpm));

                if (set_rpm == 0) {
                    show_rpm.setText("If wifi module worked... :(");
                    show_speed.setText(Float.toString(set_speed));
                } else {
                    show_speed.setText("If wifi module worked... :(");
                    show_rpm.setText(Float.toString(set_rpm));
                }
            }
        });
    }
}
