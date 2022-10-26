package com.a201812163.intent_example;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    Button btn1,btn2,btn3;
    TextView tv1;
    EditText edt1;


    public int REQUEST_CODE_MENU = 101;
    public static final String KEY_SIMPLE_DATA = "data";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        tv1 = findViewById(R.id.tv1);
        edt1 = findViewById(R.id.edt1);
        btn3 = findViewById(R.id.button3);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MainActivity2.class);
                intent.putExtra("id","qwer1245");
                startActivityForResult(intent,REQUEST_CODE_MENU);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = edt1.getText().toString();
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(data));
                startActivity(intent);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),AnotherActivity.class);
                SimpleData data = new SimpleData(100,"Hello Android");
                intent.putExtra("data",data);
                startActivity(intent);
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQUEST_CODE_MENU){
            Toast.makeText(this,"onActivityResult 메소드 호출됨 : "+requestCode, Toast.LENGTH_SHORT).show();

            if(resultCode == RESULT_OK){
                String name = data.getStringExtra("name");
                Toast.makeText(this,"응답으로 전달된 name : "+ name, Toast.LENGTH_SHORT).show();
            }

        }


    }
}