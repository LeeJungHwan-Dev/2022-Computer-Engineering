package com.example.a5_pref;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        textView = findViewById(R.id.textView);

        loadstate();



    }


    protected void loadstate(){

        SharedPreferences sharedPreferences = (SharedPreferences) getSharedPreferences("pref",MODE_PRIVATE);
        if(sharedPreferences != null){
            if(sharedPreferences.contains("name")){
                textView.setText("이름 : " + sharedPreferences.getString("name","1")+ " , " + sharedPreferences.getString("age","2"));
            }
        }


    }


}