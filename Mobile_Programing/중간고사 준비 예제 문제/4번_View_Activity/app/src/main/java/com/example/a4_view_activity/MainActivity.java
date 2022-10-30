package com.example.a4_view_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    Button btn1, btn2, btn3;
    LinearLayout view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);

        view = findViewById(R.id.views);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View views) {
                view.removeAllViews();
                LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
                inflater.inflate(R.layout.activity_1,view,true);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View views) {
                view.removeAllViews();
                LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
                inflater.inflate(R.layout.activity_2,view,true);

            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View views) {
                view.removeAllViews();
                LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
                inflater.inflate(R.layout.activity_3,view,true);
                Snackbar.make(views,"엑티비티3",Snackbar.LENGTH_SHORT).show();
            }
        });



    }
}