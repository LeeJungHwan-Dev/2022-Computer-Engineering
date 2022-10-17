package com.a201812163.orientation1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String name;
    EditText editText;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("상태","onCreate실행됨");

        Button button = findViewById(R.id.button);


        editText = findViewById(R.id.EditText);
        textView = findViewById(R.id.textView2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = editText.getText().toString();
                Toast.makeText(getApplicationContext(),"입력한 값을 변수에 저장 : "+name,Toast.LENGTH_SHORT).show();
            }
        });

        if (savedInstanceState != null){
            name = savedInstanceState.getString("name");
            Toast.makeText(getApplicationContext(),"값을 복원함 : "+name,Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(getApplicationContext(),"복원할 값이 없습니다.",Toast.LENGTH_SHORT).show();
        }




    }


    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("name",name);
        Toast.makeText(getApplicationContext(),"name으로 인스턴스 상태 저장 : "+name,Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("상태","onStart실행됨");
    }



    @Override
    protected void onResume() {
        super.onResume();
        Log.i("상태","onResume실행됨");
    }


    @Override
    protected void onPause() {
        super.onPause();
        Log.i("상태","onPause실행됨");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("상태","onStop실행됨");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("상태","onDestroy실행됨");
        // finish();
    }


}