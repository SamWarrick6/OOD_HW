package com.example.ood_hw;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.SurfaceView;
import android.widget.RadioGroup;
import android.widget.SeekBar;

import java.util.Random;

public class Face extends SurfaceView implements SeekBar.OnSeekBarChangeListener, RadioGroup.OnCheckedChangeListener{

    private Face face;

    //Face variables
    int skinColor;
    int eyeColor;
    int hairColor;
    int hairStyle;

    //face location variables
    float left, top, right, bottom;

    //Paints
    Paint hairPaint = new Paint();
    Paint eyePaint = new Paint();
    Paint skinPaint = new Paint();
    Paint hairLinePaint = new Paint();

    //hex colors
    int rgbRed;
    int rgbGreen;
    int rgbBlue;

    //radio group buttons
    int radioButton;

    //constructor class to set the Face variables
    public Face(Context context, AttributeSet attrs) {
        super(context, attrs);
        //set it to draw
        setWillNotDraw(false);

        //call randomize method to set the Face variables
        randomize();

        //setup the palette
        hairPaint.setColor(hairColor);
        hairPaint.setStyle(Paint.Style.FILL);
        eyePaint.setColor(eyeColor);
        eyePaint.setStyle(Paint.Style.FILL);
        skinPaint.setColor(skinColor);
        skinPaint.setStyle(Paint.Style.FILL);
        hairLinePaint.setColor(hairColor);
        hairLinePaint.setStyle(Paint.Style.FILL);
        hairLinePaint.setStrokeWidth(3);


    }

    /**External Citation
        Date: 10 September 2020
        Problem: Did not know how to generate random numbers in a given range

        Resource:
     https://stackoverflow.com/questions/20389890/generating-a-random-number-between-1-and-10-java
        Solution: I followed the example code from the first answer
     */

    //randomize the Face variables
    void randomize() {

        /**External Citation
         Date: 05 October 2020
         Problem: Did not know how to convert the sliders to hex

         Resource:
         https://stackoverflow.com/questions/43986353/using-seekbars-to-change-rgb-values-android-studio
         Solution: Using the examples code as guidance I was able to create a hex number for the color
         */

        //create random color variables and assign the colors to each face aspect
        Random ran1 = new Random();
        rgbRed = ran1.nextInt(255-0+1) + 0;
        Random ran2 = new Random();
        rgbGreen = ran2.nextInt(255-0+1) + 0;
        Random ran3 = new Random();
        rgbBlue = ran3.nextInt(255-0+1) + 0;
        skinColor = 0xFF000000 + (rgbRed * 0x10000) + (rgbGreen * 0x100) + rgbBlue;

        rgbRed = ran1.nextInt(255-0+1) + 0;
        rgbGreen = ran2.nextInt(255-0+1) + 0;
        rgbBlue = ran3.nextInt(255-0+1) + 0;
        eyeColor = 0xFF000000 + (rgbRed * 0x10000) + (rgbGreen * 0x100) + rgbBlue;

        rgbRed = ran1.nextInt(255-0+1) + 0;
        rgbGreen = ran2.nextInt(255-0+1) + 0;
        rgbBlue = ran3.nextInt(255-0+1) + 0;
        hairColor = 0xFF000000 + (rgbRed * 0x10000) + (rgbGreen * 0x100) + rgbBlue;

        //choose the hair style randomly out of 3
        Random ran4 = new Random();
        int hairStyleRan = ran4.nextInt(3-1+1) + 1;
        hairStyle = hairStyleRan;

    }

    @Override
    public void onDraw(Canvas canvas) {
        //set the starting variables for the face
        left = 500.0f;
        top = 350.0f;
        right = 800.0f;
        bottom = 950.0f;

        //check to see what aspect of the face is changing using the radio button

        //draw the face shape as an oval
        canvas.drawOval(left, top, right, bottom, skinPaint);

        //draw the eyes
        drawEyes(canvas, left + 75.0f, top + 100.0f, right - 75.0f, bottom - 275.0f);


        switch (hairStyle) {
            case 1:
                drawHair1(canvas, left + 50.0f, top - 50.0f, right - 50.0f, top + 50.0f);
                break;

            case 2:
                drawHair2(canvas, left + 100.0f, top - 100.0f, right - 100.0f, top + 50.0f);
                break;

            case 3:
                drawHair3(canvas, left, top, right, top);
                break;

            default:
                break;
        }
    }


    //draw the eyes
    public void drawEyes(Canvas canvas, float left, float top, float right, float bottom) {
        canvas.drawOval(left, top, right - 100.0f, bottom, eyePaint);
        canvas.drawOval(left + 100.0f, top, right, bottom, eyePaint);
    }

    //draw hair style 1, oval hair with spikes
    public void drawHair1(Canvas canvas, float left, float top, float right, float bottom) {
        //draw the oval part
        canvas.drawOval(left, top, right, bottom, hairPaint);

        /**External Citation
         Date: 05 October 2020
         Problem: Did not know how to draw a triangle

         Resource:
         https://stackoverflow.com/questions/20544668/how-to-draw-filled-triangle-on-android-canvas/22690364
         Solution: I followed the example code and used what i learned to draw triangles
         */

        //draw the spikes
        Point point1 = new Point(350, 200);
        Point point2 = new Point(350, 190);
        Point point3 = new Point(300, 195);

        Path path = new Path();
        path.setFillType(Path.FillType.EVEN_ODD);
        path.moveTo(point1.x,point1.y);
        path.lineTo(point2.x,point2.y);
        path.lineTo(point3.x,point3.y);
        path.close();

        canvas.drawPath(path, hairLinePaint);
    }

    //draw hair as a mohawk
    public void drawHair2 (Canvas canvas, float left, float top, float right, float bottom) {
        canvas.drawRect(left, top, right, bottom, hairPaint);
    }

    //draw hair as three small lines
    public void drawHair3(Canvas canvas, float left, float top, float right, float bottom) {
        canvas.drawRect(left + 100.0f, top - 50.0f, right - 180.0f, bottom + 50, hairPaint);
        canvas.drawRect(left + 140.0f, top - 50.0f, right - 140.0f, bottom + 50, hairPaint);
        canvas.drawRect(left + 180.0f, top - 50.0f, right - 100.0f, bottom + 50, hairPaint);
    }

    //Seekbar changed method
    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        //change the color to the correct color
        int Color = 0;
        switch (seekBar.getId()) {
            case R.id.Red:
                //set eye color
                Color = 0xFF000000 + (i * 0x10000) + (rgbGreen * 0x100) + rgbBlue;
                break;

            case R.id.Green:
                //set eye color
                Color = 0xFF000000 + (rgbRed * 0x10000) + (i * 0x100) + rgbBlue;
                break;

            case R.id.Blue:
                //set eye color
                Color = 0xFF000000 + (rgbRed * 0x10000) + (rgbGreen * 0x100) + i;
                break;

            default:
                break;
        }

        //determine which aspect of the face is changing
        switch (radioButton) {
            case 1:
                hairColor = Color;
                break;

            case 2:
                eyeColor = Color;
                break;

            case 3:
                skinColor = Color;
                break;

            default:
                break;
        }

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
        radioButton = i;
    }
}
