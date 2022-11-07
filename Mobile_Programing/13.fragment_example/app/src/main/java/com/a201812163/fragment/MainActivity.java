package com.a201812163.fragment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    public String string = "";
    First_BlankFragment frm;
    Second_BlankFragment srm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        frm = new First_BlankFragment();
        srm = new Second_BlankFragment();

        getSupportFragmentManager().beginTransaction().replace(R.id.continer,
                frm).commit();

    }



    public void onFragmentChange(int i ){


        if( i == 0 ){
            getSupportFragmentManager().beginTransaction().replace(R.id.continer,
                    srm).commit();
        }else{
            getSupportFragmentManager().beginTransaction().replace(R.id.continer,
                    frm).commit();
        }


    }


}