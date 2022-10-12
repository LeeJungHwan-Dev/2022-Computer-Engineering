package com.a201812163.event;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintSet;

import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    View view1,view2;
    TextView tv;
    GestureDetector detector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        view1 = findViewById(R.id.view1);
        view2 = findViewById(R.id.view2);
        tv = findViewById(R.id.textView);


        detector = new GestureDetector(new GestureDetector.OnGestureListener() {
            @Override
            public boolean onDown(MotionEvent e) {
                println("onDown : 호출");
                return false;
            }

            @Override
            public void onShowPress(MotionEvent e) {
                println("onShowPress : 호출");
            }

            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                println("onSingleTapUp : 호출");
                return false;
            }

            @Override
            public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
                println("onScroll : " + distanceX + " " + distanceY);
                return false;
            }

            @Override
            public void onLongPress(MotionEvent e) {
                println("onLongPress : 호출");
            }

            @Override
            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                println("onFling : "+ velocityX + " " + velocityY);
                return false;
            }
        });



        view1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                int action = event.getAction();
                float curx = event.getX();
                float cury = event.getY();

                if(action == MotionEvent.ACTION_DOWN){
                    println("Action : "+ Integer.toString(action) + " "+ "X : "+ Float.toString(curx) + " "+ "Y : " + Float.toString(cury) + " 손가락 눌림");
                }else if(action == MotionEvent.ACTION_MOVE){
                    println("Action : "+ Integer.toString(action) + " "+ "X : "+ Float.toString(curx) + " "+ "Y : " + Float.toString(cury) + " 손가락 움직임");
                }else if(action == MotionEvent.ACTION_UP){
                    println("Action : "+ Integer.toString(action) + " "+ "X : "+ Float.toString(curx) + " "+ "Y : " + Float.toString(cury) + " 손가락 땜");
                }


                return true;
            }
        });


        view2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                detector.onTouchEvent(event);
                return true;
            }
        });



    }


    public void println(String data){


        tv.append(data+"\n");


    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if(keyCode == KeyEvent.KEYCODE_BACK){
            Toast.makeText(getApplicationContext(),"Back Button clicked...!",Toast.LENGTH_SHORT).show();

            return true;
        }

        return false;
    }
}