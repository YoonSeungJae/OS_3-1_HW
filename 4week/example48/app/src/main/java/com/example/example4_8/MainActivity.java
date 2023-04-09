package com.example.example4_8;

/* **********************************************
 * 프로젝트명 :  연습문제 4-8번
 * 작성자 : 2019038050 윤승재
 * 작성일 : 2022.04.02
 * 프로그램 설명 : 에디트텍스트에 키가 눌릴 때마다, 바뀐 글자가 Toast 메시지 출력
 ************************************************/

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // EditText 변수에 참조
        editText = findViewById(R.id.edit_text);


        // EditText에 TextWatcher 등록
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // Nothing to do
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // 변경된 글자를 Toast로 출력
                Toast.makeText(MainActivity.this, s.toString(), Toast.LENGTH_SHORT).show();

            }

            @Override
            public void afterTextChanged(Editable s) {
                // Nothing to do
            }
        });
    }
}
