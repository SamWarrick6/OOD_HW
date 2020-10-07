package com.example.ood_hw;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.SurfaceView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.content.pm.ActivityInfo;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener, RadioGroup.OnCheckedChangeListener, Spinner.OnItemSelectedListener {

    private SeekBar seekbarRed;
    private SeekBar seekbarGreen;
    private SeekBar seekbarBlue;
    private RadioGroup radioButton;
    private Spinner spinnerButton;

    private Face face = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_main);
        //create new face object
        face = new Face(this);
        //SurfaceView faceView = findViewById(R.id.faceView);

        /**External Citation
         Date: 05 October 2020
         Problem: Did not know how to implement a spinner

         Resource:
         https://www.tutorialspoint.com/android/android_spinner_control.htm
         Solution: I followed the example code and was able to implement the spinner
         */
        //initialize the spinner, setting the popup values
        spinnerButton =  findViewById(R.id.spinner);
        spinnerButton.setOnItemSelectedListener(this);

        List<String> spinnerList = new ArrayList<String>();
        spinnerList.add("Style 1");
        spinnerList.add("Style 2");
        spinnerList.add("Style 3");

        ArrayAdapter<String> arrayAdap = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,spinnerList);
        arrayAdap.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerButton.setAdapter(arrayAdap);
        //set the seekbars
        seekbarRed = findViewById(R.id.Red);
        seekbarRed.setOnSeekBarChangeListener(this);
        seekbarGreen = findViewById(R.id.Green);
        seekbarGreen.setOnSeekBarChangeListener(this);
        seekbarBlue = findViewById(R.id.Blue);
        seekbarBlue.setOnSeekBarChangeListener(this);

        //set the radio group listener
        radioButton = findViewById(R.id.RadioGroup);
        radioButton.setOnCheckedChangeListener(this);

        //set the spinner
        spinnerButton = findViewById(R.id.spinner);
        spinnerButton.setOnItemSelectedListener(this);

    }

    //Seekbar changed method
    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        this.face.changeColor(seekBar, i);
        this.face.invalidate();
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        this.face.updateRadio(i);
    }

    //when an item in the spinner is selected, call call the update hair style method in face
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        /**External Citation
         Date: 05 October 2020
         Problem: Did not know how to convert long to int

         Resource:
         https://beginnersbook.com/2019/04/java-long-to-int-conversion/
         Solution: I followed the example code and was able to convert long to int
         */
        int hair = (int)id;
        this.face.updateHairStyle(hair);
        this.face.invalidate();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }
}


