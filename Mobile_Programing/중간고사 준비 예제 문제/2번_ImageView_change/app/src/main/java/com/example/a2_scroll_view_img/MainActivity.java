package com.example.a2_scroll_view_img;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


/********** 문제 ***********
 *
 * 2.
 *
 * 진수가 좋아하는 사진 2개가 있다. 진수는 핸드폰 사진앱에 저장해서 사진을 보기 싫어했다.
 * 그 결과 앱에 사진을 저장하여 진수가 원할때 보고 싶은 사진을 출력해주는 앱을 만들려고 한다.
 *
 * 다음을 작성하시오.
 *
 * 1. 사진1과 사진2를 출력하는 이미지 뷰를 생성해서 작성하시오.
 * 2. 버튼1과 버튼2를 만들고 버튼1을 눌렀을때는 사진1, 버튼2를 눌렀을때는 사진2를 출력하시오.
 *
 * 조건
 *
 * 1. 반드시 스크롤뷰를 사용하여 화면을 벗어난 영역도 표시할 수 있게 만들어야합니다.
 * 2. 리니어 레이아웃 가로 방향으로 작성하시오.
 * 3. 버튼1과 버튼2의 색상은 달라야 한다.
 * 4. 이미지뷰는 반드시 1개만 사용해야한다.
 *
 *
 * */



public class MainActivity extends AppCompatActivity {

    Button img_btn1 , img_btn2;
    ImageView img_view;

    int dog1_width,dog1_hegiht, dog2_width , dog2_hegiht;

    /**
     *
     * img_btn1과 img_btn2는 각 사진 전환을 위해 필요한 버튼이다.
     * img_view는 이미지를 표출하기 위한 뷰이다.
     *
     * */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img_btn1 = findViewById(R.id.img1_btn);
        img_btn2 = findViewById(R.id.img2_btn);
        img_view = findViewById(R.id.img_view);


        /**
         *
         * 생성된 뷰에서 버튼 1과 2 , 이미지뷰를 지정해준다.
         *
         * */


        img_btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Resources res = getResources();
                BitmapDrawable bitmap = (BitmapDrawable) res.getDrawable(R.drawable.dog1);
                dog1_width = img_view.getLayoutParams().width;
                dog1_hegiht = img_view.getLayoutParams().height;


                img_view.setImageDrawable(bitmap);
                img_view.getLayoutParams().width = dog1_width;
                img_view.getLayoutParams().height = dog1_hegiht;


                /**
                 *
                 * 맨 처음 Resource를 사용하여 리소스 정보를 가져온다.
                 * 이렇게 생성된 res 객체를 통해 패키지 내의 리소스 정보를 자유롭게 확인할 수 있다.
                 *
                 * BitmapDrawable은 비트맵을 Drawable 타입으로 변경해주는 클래스이다.
                 * 즉 72째줄 코드를 해석해보면 리소스를 받아와서 드로워블 파일로 형변환 한다. 라는 뜻 정도가 된다.
                 * 그외에 getLayoutParams를 사용해 가로와 세로 정보를 저장하고
                 *
                 * 새로 할당한 이미지뷰에 이전 이미지 뷰의 가로 세로를 지정한다.
                 *
                 * */




            }
        });

        img_btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Resources res = getResources();
                BitmapDrawable bitmap = (BitmapDrawable) res.getDrawable(R.drawable.dog2);
                dog2_width = bitmap.getIntrinsicWidth();
                dog2_hegiht = bitmap.getIntrinsicHeight();

                img_view.setImageDrawable(bitmap);
                img_view.getLayoutParams().width = dog2_width;
                img_view.getLayoutParams().height = dog2_hegiht;
            }
        });


    }
}