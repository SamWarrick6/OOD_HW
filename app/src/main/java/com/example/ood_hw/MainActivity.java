package com.example.ood_hw;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.SurfaceView;
import android.widget.SeekBar;
import android.widget.RadioButton;
import android.content.pm.ActivityInfo;
import android.util.Log;
import android.view.View;


class MainActivity extends AppCompatActivity {

    private SeekBar seekbarRed;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_main);

        SurfaceView faceView = findViewById(R.id.faceView);
        Face face = new Face(this);
        seekbarRed = findViewById(R.id.Red);
        seekbarRed.setOnSeekBarChangeListener(face);
    }
}


