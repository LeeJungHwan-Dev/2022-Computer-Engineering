package com.a201812163.intent_example;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AnotherActivity extends AppCompatActivity {

    TextView tv1;
    Button btn1;
    public static final String KEY_SIMPLE_DATA = "data";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_another);

        tv1 = findViewById(R.id.textView);

        Intent intent = getIntent();
        processIntent(intent);

    }


    private void processIntent(Intent intent){
        if(intent != null){
            Bundle bundle = intent.getExtras();
            SimpleData data = bundle.getParcelable(KEY_SIMPLE_DATA);

            tv1.setText("전달 받은 데이터 \n Number : " + data.getNumber() + "\nMessage : "+ data.getMessage());

        }
    }

}