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

    /********** 문제 **********8
     *
     *
     * 정민이는 가로 방향으로 버튼을 3개 배치하고, 그 버튼 아래에 버튼을 제외하고 화면을 꽉 채우는 View를 배치하여
     * 버튼을 눌렀을 때 View에 원하는 엑티비티를 보여주는 앱을 만들고 싶어한다.
     *
     * 버튼1을 누르면 텍스트 뷰에 화면1을 출력하고
     * 버튼2를 누르면 바뀐 엑티비티에 파란색 배경을 출력하고
     * 버튼3을 누르면 화면을 전환하고 스낵바를 출력후 “엑티비티3” 이라는 내용을 출력해라.
     *
     * 조건
     *
     * 반드시 하나의 엑티비티안에서 작업해야한다.
     * Intent를 사용하여 인텐트를 전환하면 안된다.
     *
     *
     *
     *
     *
     *
     * */

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