package com.example.ood_hw;

import android.view.View;
import android.widget.AdapterView;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;

public class FaceControl implements SeekBar.OnSeekBarChangeListener, RadioGroup.OnCheckedChangeListener, Spinner.OnItemSelectedListener {

    private Face face;

    public FaceControl(Face face) {
        this.face = face;
    }

    //Seekbar changed method
    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        face.changeColor(seekBar, i);
        face.invalidate();
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        face.updateRadio(i);
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
        face.updateHairStyle(hair);
        face.invalidate();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }
}
