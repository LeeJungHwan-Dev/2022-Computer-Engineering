package com.example.a3_phone_event;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    /*********** 문제 ***********
     *
     * 만뚜르는 자신의 핸드폰의 터치 상태가 이상하다고 생각되어 핸드폰을 바꾸면 될 것을, 개발자를 고용하여 자신의 핸드폰 터치 스크린을 테스트 할 수 있는 앱을 만들라 지시했다.
     *
     * 만뚜르가 요구한 내용은 다음과 같다
     *
     * 1. 핸드폰을 터치 했을때 즉, 핸드폰에 손가락을 가져다 대면 배경화면을 빨간색으로 바꿀것
     * 2. 핸드폰의 화면에 가져간 손가락을 움직이면 배경화면을 파란색으로 바꿀것
     * 3. 손가락을 때면 배경화면을 흰색으로 바꿀것
     *
     * 조건
     * 반드시 모션이벤트를 사용할 것
     *
     * */




    View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        view = findViewById(R.id.view); // 하나의 큰 뷰를 설정함

        view.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                int action = motionEvent.getAction(); // 모션 이벤트를 사용하여 뷰 위에서 일어나는 액션을 가져온다.

                if(action == MotionEvent.ACTION_DOWN){
                    view.setBackgroundColor(Color.RED);
                }else if(action == MotionEvent.ACTION_MOVE){
                    view.setBackgroundColor(Color.BLUE);
                }else if(action == MotionEvent.ACTION_UP){
                    view.setBackgroundColor(Color.WHITE);
                }

                /**
                 *
                 * 각 모션들은 다운 무브 업이 있으며
                 *
                 * 다운은 터치, 업은 터치를 끝낸상황 , 무브는 터치후 움직인것을 뜻한다.
                 *
                 * */

                return true;
            }
        });

        // return false이면 한번만 인식한다.

    }
}