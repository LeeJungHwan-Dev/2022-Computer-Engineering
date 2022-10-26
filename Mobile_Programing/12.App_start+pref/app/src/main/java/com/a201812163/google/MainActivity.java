package com.a201812163.google;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
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
            public void onClick(View v) {
                /*Intent intent = new Intent();
                ComponentName componentName = new ComponentName("com.history.hatda","com.history.hatda.MainActivity");
                intent.setComponent(componentName);
                startActivity(intent);*/

                loadState();

            }
        });


    }

    protected void saveState(){

        SharedPreferences preferences = getSharedPreferences("pref", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("name","강감찬");
        editor.commit();

        /**
         *
         * 상태를 저장해준다.
         *
         *
         *
         * */


    }


    protected void loadState(){

        SharedPreferences preferences = getSharedPreferences("pref", Activity.MODE_PRIVATE);

        if(preferences != null ){
            if(preferences.contains("name")){
                String name = preferences.getString("name","null");
                Toast.makeText(this,name,Toast.LENGTH_SHORT).show();
            }
        }
    }


    @Override
    protected void onPause() {
        super.onPause();
        Log.i("tag","onPause");
    }


    @Override
    protected void onResume() {
        super.onResume();
        Log.i("tag","onResume");
    }

    @Override
    protected void onDestroy(){
        saveState();
        Log.i("tag","onDestroy");
        super.onDestroy();
    }


}