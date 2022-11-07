package com.a201812163.fragment_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.ListFragment;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements fragment_list.ImageSelectionCallback{


    fragment_list fragment_list;
    ViewFragment viewFragment;

    int[] images = {R.drawable.dream01,R.drawable.dream02,R.drawable.dream03};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        FragmentManager manager = getSupportFragmentManager();
        fragment_list = (com.a201812163.fragment_2.fragment_list) manager.findFragmentById(R.id.listFragment);
        viewFragment = (ViewFragment) manager.findFragmentById(R.id.viewerFragment);


    }

    @Override
    public void onImageSelected(int position, String text) {
        viewFragment.setImageView(images[position], text);
    }
}