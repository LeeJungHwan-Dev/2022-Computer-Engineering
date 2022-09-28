package com.a201812163.button;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Button btn1;
    ImageView img1 , img2;
    int status = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frame_layout);

        btn1 = findViewById(R.id.chang_btn1);
        img1 = findViewById(R.id.imageView2);

    }

    public void onButtonClick(View v){
        change_pic();
    }


    public void change_pic(){

    }




}