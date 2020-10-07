package com.example.ood_hw;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.content.pm.ActivityInfo;
import android.widget.Spinner;


public class MainActivity extends AppCompatActivity  {

    private SeekBar seekbarRed;
    private SeekBar seekbarGreen;
    private SeekBar seekbarBlue;
    private RadioGroup radioButton;
    private Spinner spinnerButton;

    //private Face face = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_main);
        //create new face object
        Face face = findViewById(R.id.faceView);
        FaceControl facecontrol = new FaceControl(face);

        /**External Citation
         Date: 05 October 2020
         Problem: Did not know how to implement a spinner

         Resource:
         https://www.tutorialspoint.com/android/android_spinner_control.htm
         Solution: I followed the example code and was able to implement the spinner
         */
        //initialize the spinner, setting the popup values
        spinnerButton =  findViewById(R.id.spinner);
        spinnerButton.setOnItemSelectedListener(facecontrol);

        //set the seekbars
        seekbarRed = findViewById(R.id.Red);
        seekbarRed.setOnSeekBarChangeListener(facecontrol);
        seekbarGreen = findViewById(R.id.Green);
        seekbarGreen.setOnSeekBarChangeListener(facecontrol);
        seekbarBlue = findViewById(R.id.Blue);
        seekbarBlue.setOnSeekBarChangeListener(facecontrol);

        //set the radio group listener
        radioButton = findViewById(R.id.RadioGroup);
        radioButton.setOnCheckedChangeListener(facecontrol);

        //set the spinner
        spinnerButton = findViewById(R.id.spinner);
        spinnerButton.setOnItemSelectedListener(facecontrol);

        face.randomize();
        face.invalidate();

    }

}


