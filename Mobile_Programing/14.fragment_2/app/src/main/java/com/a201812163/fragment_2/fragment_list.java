package com.a201812163.fragment_2;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class fragment_list extends Fragment {

    public static interface ImageSelectionCallback{
        public void onImageSelected(int position , String text);
    }

    public ImageSelectionCallback callback;

    @Override
    public void onAttach(Context context){
        super.onAttach(context);

        if (context instanceof ImageSelectionCallback){
            callback = (ImageSelectionCallback) context;
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container,
                             @NonNull Bundle savedInstanceState){
        ViewGroup rootview = (ViewGroup) inflater.inflate(R.layout.activity_linear_fragment, container , false);

        Button button = rootview.findViewById(R.id.button);
        Button button1 = rootview.findViewById(R.id.button2);
        Button button2 = rootview.findViewById(R.id.button3);
        EditText editText = rootview.findViewById(R.id.edit_text_list);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callback.onImageSelected(0,editText.getText().toString());
            }
        });


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callback.onImageSelected(1,editText.getText().toString());
            }
        });


        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callback.onImageSelected(2,editText.getText().toString());
            }
        });

        return rootview;
    }

}