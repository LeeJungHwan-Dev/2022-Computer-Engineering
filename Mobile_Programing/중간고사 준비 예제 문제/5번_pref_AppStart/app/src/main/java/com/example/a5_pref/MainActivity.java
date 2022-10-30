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