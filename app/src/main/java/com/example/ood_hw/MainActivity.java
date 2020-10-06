package com.example.ood_hw;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.SurfaceView;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.RadioButton;
import android.content.pm.ActivityInfo;
import android.util.Log;
import android.view.View;
import android.widget.Spinner;


class MainActivity extends AppCompatActivity {

    private SeekBar seekbarRed;
    private SeekBar seekbarGreen;
    private SeekBar seekbarBlue;
    private RadioGroup radioButton;
    private Spinner spinnerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_main);

        //set the seek bar listeners
        Face face = new Face(this);
        seekbarRed = findViewById(R.id.Red);
        seekbarRed.setOnSeekBarChangeListener(face);
        seekbarGreen = findViewById(R.id.Green);
        seekbarGreen.setOnSeekBarChangeListener(face);
        seekbarBlue = findViewById(R.id.Blue);
        seekbarBlue.setOnSeekBarChangeListener(face);

        //set the radio group listener
        radioButton = findViewById(R.id.RadioGroup);
        radioButton.setOnCheckedChangeListener(face);

        //set the spinner
        spinnerButton = findViewById(R.id.spinner);
        spinnerButton.setOnItemSelectedListener(face);

    }
}


