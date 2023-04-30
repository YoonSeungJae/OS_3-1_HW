package com.example.imagevote;

/* **********************************************
 * 프로젝트명 :  이미지 투표
 * 작성자 : 2019038050 윤승재
 * 작성일 : 2022.04.29
 * 프로그램 설명 : 이미지 투표
 ************************************************/
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {
    ImageView ivPic[] = new ImageView[9];
    int ivI[]= {R.id.image1, R.id.image2, R.id.image3,R.id.image4,R.id.image5
            ,R.id.image6,R.id.image7,R.id.image8,R.id.image9};
    Button btnResult;

    String picName[] = {
            "독서하는 소녀",
            "꽃장식 모자 소녀",
            "부채를 든 소녀",
            "이레느깡 단 베르양",
            "잠자는 소녀",
            "테라스의 두 자매",
            "피아노 레슨",
            "피아노 앞의 소녀들",
            "해변에서"
    };

    int voteCount[] = new int[9];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnResult = findViewById(R.id.btnResult);
        for(int i=0; i<ivPic.length;i++){
            ivPic[i]= findViewById(ivI[i]);
        }

        for(int i=0; i<ivPic.length;i++){
            final int index = i;
            ivPic[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    voteCount[index]++;
                    Toast.makeText(getApplicationContext(), picName[index]+" : "+voteCount[index],Toast.LENGTH_SHORT).show();
                }
            });
        }

        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),result.class);
                intent.putExtra("voteCount", voteCount);
                intent.putExtra("imageName",picName);

                startActivity(intent);
            }
        });
    }
}