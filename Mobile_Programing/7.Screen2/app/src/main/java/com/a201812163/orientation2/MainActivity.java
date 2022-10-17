package com.a201812163.orientation2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

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
                showSnackBar("안녕",v);
            }
        });



    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        if(newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE){ // 가로
            showToast("방향 : 가로방향" );
            Log.i("작동","작동1");
        }else if(newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){ // 세로
            showToast("방향 : 세로방향");
            Log.i("작동","작동2");
        }


    }


    public void showToast(String coment){
        Toast.makeText(this,coment,Toast.LENGTH_SHORT).show();
    }

    public void showSnackBar(String coment, View v){
        Snackbar.make(v,coment,Snackbar.LENGTH_SHORT).show();
    }

}