package com.example.example4_9;

/* **********************************************
 * 프로젝트명 :  연습문제 4-9번
 * 작성자 : 2019038050 윤승재
 * 작성일 : 2022.04.02
 * 프로그램 설명 :  회전 버튼을 클릭시 이미지가 10도씩 회전
 ************************************************/


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.*;


public class MainActivity extends AppCompatActivity {

    private ImageView img;
    Integer r = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = (Button) findViewById(R.id.btn);
        img = (ImageView) findViewById(R.id.imgDuck);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                r += 10;
                img.setRotation(r);
            }
        });
    }
}