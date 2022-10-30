package com.example.a5_pref;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    /******** 문제 **********
     *
     *
     *
     * 정호는 로그인 기능을 구현했다. 하지만 로그인을 하며 받아온 정보를 다음 엑티비티에서 사용하고 싶어한다.
     *
     * 사용하고 싶은 내용은 이렇다
     *
     * 이름 : 이정호
     * 나이 : 24세
     *
     * 해당 정보를 엑티비티1에서 입력받아 엑티비티2에서 텍스트뷰에 “ 이름 : 이정호 , 나이 : 24세 ” 를 출력해라
     *
     * 조건
     *
     * 텍스트뷰에 임으로 작성하여 출력하면 안됨.
     * 반드시 putExtra와 같은 인텐트로 정보를 전달해야함.
     *
     *
     *
     *
     *
     *
     *
     * */

    Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.button);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveState();
                Intent intent = new Intent(getApplicationContext(),MainActivity2.class);
                startActivity(intent);
            }
        });


    }

    protected void saveState(){

        SharedPreferences preferences = getSharedPreferences("pref", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("name","이정호");
        editor.putString("age","24세");
        editor.commit();

        /**
         *
         * SharedPreferences를 사용하여 pref이름을 가진 상태 저장 객체를 생성
         * 모드는 여러가지가 있지만 프라이빗모드를 선언하여 다른 앱 접근 제한
         *
         *
         * */


    }





}