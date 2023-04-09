package com.example.example4_7;

/* **********************************************
 * 프로젝트명 :  연습문제 4-7번
 * 작성자 : 2019038050 윤승재
 * 작성일 : 2022.04.02
 * 프로그램 설명 :  체크박스를 선택할 때마다, 버튼의 속성이 설정
 ************************************************/

import android.widget.CheckBox;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CheckBox enableCheckbox = findViewById(R.id.enable_checkbox);
        CheckBox clickableCheckbox = findViewById(R.id.clickable_checkbox);
        CheckBox rotateCheckbox = findViewById(R.id.rotate_checkbox);
        Button button1 = findViewById(R.id.button1);

        enableCheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                button1.setEnabled(isChecked);
            }
        });

        clickableCheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                button1.setClickable(isChecked);
            }
        });

        rotateCheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    button1.setRotation(45);
                } else {
                    button1.setRotation(0);
                }
            }
        });
    }
}
