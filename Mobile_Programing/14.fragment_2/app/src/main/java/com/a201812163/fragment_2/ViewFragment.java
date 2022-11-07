package com.a201812163.fragment_2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class ViewFragment extends Fragment {
    ImageView imageView;
    TextView textView;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container,
                             @NonNull Bundle savedInstanceState){
        ViewGroup rootview = (ViewGroup) inflater.inflate(R.layout.activity_view_fragment, container , false);

        imageView = rootview.findViewById(R.id.imageView);
        textView = rootview.findViewById(R.id.imge_text);
        return rootview;
    }

    public void setImageView(int resId , String text){
        imageView.setImageResource(resId);
        textView.setText(text);
    }

}