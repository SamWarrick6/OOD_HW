/**package com.example.ood_hw

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.RadioButton;
import android.content.pm.ActivityInfo;
import android.util.Log;
import android.view.View;


class MainActivity : AppCompatActivity() {

    private SeekBar seekbar;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekbar = findViewById(R.id.Red);
        findViewById(R.id.Red).setOnSeekBarChangeListener
    }
}*/