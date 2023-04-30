package com.example.imagevote;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class result extends AppCompatActivity {

    Integer imageFileId [] ={R.drawable.image1,R.drawable.image2,R.drawable.image3,
            R.drawable.image4,R.drawable.image5
            ,R.drawable.image6,R.drawable.image7,
            R.drawable.image8,R.drawable.image9 };

    Integer tvID[] = {R.id.tv1,R.id.tv2,R.id.tv3,R.id.tv4,R.id.tv5,
            R.id.tv6,R.id.tv7,R.id.tv8,R.id.tv9,};

    Integer rbarID[] = {R.id.rtb1,R.id.rtb2,R.id.rtb3,R.id.rtb4,R.id.rtb5,
            R.id.rtb6,R.id.rtb7,R.id.rtb8,R.id.rtb9};
    Button btnReturn;

    TextView imgName;
    ImageView mainimg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        setTitle("투표 결과");
        int max=0;
        Intent intent = getIntent();

        int[] voteCount = intent.getIntArrayExtra("voteCount");
        String[] picName = intent.getStringArrayExtra("imageName");


        TextView  tv[] = new TextView[picName.length];
        RatingBar rbar [] = new RatingBar[picName.length];


        for(int i=0;i<voteCount.length;i++){
            tv[i]=findViewById(tvID[i]);
            rbar[i] = findViewById(rbarID[i]);
        }

        btnReturn = findViewById(R.id.btnResult);

        for(int i=0;i<voteCount.length;i++){
            tv[i]=findViewById(tvID[i]);
            rbar[i] = findViewById(rbarID[i]);
        }
        for(int i=0; i<voteCount.length;i++){
            tv[i].setText(picName[i]);
            rbar[i].setRating((float) voteCount[i]);

            imgName=findViewById(R.id.imgName);
            mainimg =findViewById(R.id.mainimg);

            if(max < voteCount[i]){
                max=voteCount[i];
                imgName.setText(picName[i]);
                mainimg.setImageResource((imageFileId[i]));
            }
        }
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

}