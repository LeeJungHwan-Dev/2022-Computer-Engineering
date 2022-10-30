package com.example.my_android_stduy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


/**
 * ********* 문제 **************
 * 미정이는 매번 작업하는 내용을 앱으로 작성하고 싶어했다. 미정이가 요구한 기능은 크게 3가지이다.
 *
 * 1. 010 - 0000 - 0000으로 버튼을 누르면 전화번호를 다이얼 할 것.
 * 2. http://www.google.com 을 버튼을 클릭했을 때 웹뷰로 해당 링크가 연결 될 것
 * 3. Toast 메시지를 가볍게 출력해보시오. 내용 자유
 *
 *
 * 조건
 *
 * 1. 반드시 인텐트를 사용할 것
 * 2. 버튼을 눌렀을 때 이벤트를 처리할 것
 * 3. 리니어 레이아웃 세로 방향으로 제작할 것
 *
 *
 * */




public class MainActivity extends AppCompatActivity {

    Button call, web, toast_btn;

    /**
     *
     * 버튼 클릭 이벤트를 처리하기 위해 각
     *
     * call : 전화 버튼
     * web : 검색 버튼
     * toast_btn : Toast 버튼
     *
     * 을 만들기 위한 객체를 생성한다.
     *
     * */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        call = findViewById(R.id.btn1);
        web = findViewById(R.id.btn2);
        toast_btn = findViewById(R.id.btn3);

        /**
         *
         * findViewById(R.id.x)를 사용하여 뷰에서 생성된 버튼을 객체와 연결시켜준다.
         * */



        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:010-0000-0000"));
                startActivity(intent);
            }
        });

        /**
         *
         * Intent를 생성하여 전화 다이얼 기능을 구현한다.
         * 이떄, Intent를 사용하여 Intent(Intent.ACTION_VIEW , Uri.parse("tel : 010-0000-0000"))
         * 에서 ACTION_VIEW는 해당 URI를 보고 적절하게 이벤트를 처리해준다.
         * */


        web.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
                startActivity(intent);
            }
        });

        /**
         *
         * URI parse가 웹사이트 검색 URI를 넘겨주면 ACTION_VIEW는 기본 브라우저로 설정된 인터넷 브라우저를
         * URI parse가 가져온 주소로 검색을 한다.
         * */



        toast_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"가볍게 출력",Toast.LENGTH_SHORT).show();
            }
        });

        /**
         *
         * Toast.makeText를 사용하여 앱의 context정보와 출력할 텍스트 , 보여줄 시간 텀 . show()를 하여 간단한 Toast 이벤트 처리
         * 
         * */



    }
}