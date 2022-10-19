package com.a201812163.inflation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button send,add_sub1,add_sub2;
    EditText edt1;
    LinearLayout layout;

    /**
     *
     * 이 예제는 inflater를 사용한 레이아웃에 View를 부여하는 예제 입니다.
     * 버튼 클릭에 따른 sub1.xml , sub2.xml 을 lay id를 가진 레이아웃에 부여합니다.
     *
     *
     * 다음 시간에는 Intent를 사용한 액티비티간 화면 전환을 진행할 예정입니다.
     *
     * */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layout = findViewById(R.id.lay);

        send = findViewById(R.id.send); // 전송
        add_sub1 = findViewById(R.id.add_sub1); // 추가
        add_sub2 = findViewById(R.id.add_sub2);
        edt1 = findViewById(R.id.editText);


        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = edt1.getText().toString();

                TextView edt2 = (TextView) layout.getRootView().findViewById(R.id.sub1_tv);
                if(edt2 != null) {
                    edt2.setText(str);
                }

            }
        });

        add_sub1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                layout.removeAllViews();

                LayoutInflater inflater = (LayoutInflater)
                        getSystemService(Context.LAYOUT_INFLATER_SERVICE);

                inflater.inflate(R.layout.sub1 , layout, true);

                add_sub2 = layout.getRootView().findViewById(R.id.sub_btn);

                add_sub2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        layout.removeAllViews();
                    }
                });

            }
        });


        add_sub2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout.removeAllViews();

                LayoutInflater inflater = (LayoutInflater)
                        getSystemService(Context.LAYOUT_INFLATER_SERVICE);

                inflater.inflate(R.layout.sub2 , layout, true);
            }
        });





    }





}