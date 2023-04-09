package com.example.calc;

/* **********************************************
 * 프로젝트명 :  계산기
 * 작성자 : 2019038050 윤승재
 * 작성일 : 2022.04.02
 * 프로그램 설명 :  연습문제에서 배운 내용을 응용해 계산기 구현
 ************************************************/

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.*;
import android.widget.*;


public class MainActivity extends AppCompatActivity {
    String num1, num2;
    Integer result, i;
    EditText editText1;
    EditText editText2;
    Button[] numButtons = new Button[10];
    Integer[] numBtnIDs = { R.id.BtnNum0, R.id.BtnNum1, R.id.BtnNum2, R.id.BtnNum3, R.id.BtnNum4, R.id.BtnNum5, R.id.BtnNum6, R.id.BtnNum7, R.id.BtnNum8, R.id.BtnNum9};
    Button btnAdd;
    Button btnSub;
    Button btnMul;
    Button btnDiv;
    TextView TextResult;
    Toast toast;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("계산기");

        editText1 = (EditText) findViewById(R.id.edittext1);
        editText2 = (EditText) findViewById(R.id.edittext2);
        btnAdd = (Button) findViewById(R.id.BtnAdd);
        btnSub = (Button) findViewById(R.id.BtnSub);
        btnMul = (Button) findViewById(R.id.BtnMul);
        btnDiv = (Button) findViewById(R.id.BtnDiv);
        TextResult = (TextView) findViewById(R.id.TextResult);

        for(i = 0; i<numBtnIDs.length; i++) {
            numButtons[i] = (Button) findViewById(numBtnIDs[i]);
        }

        for(i = 0; i<numBtnIDs.length;i++){
            final int index = i;

            numButtons[index].setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    if (editText1.isFocused()) {
                        num1 = editText1.getText().toString() + numButtons[index].getText().toString();
                        editText1.setText(num1);
                    } else if (editText2.isFocused()) {
                        num2 = editText2.getText().toString() + numButtons[index].getText().toString();
                        editText2.setText(num2);
                    } else {
                        Toast.makeText(getApplicationContext(), "에디트텍스트를 선택하세요.", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

        btnAdd.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View args0, MotionEvent arg1) {
                num1 = editText1.getText().toString();
                num2 = editText2.getText().toString();
                result = Integer.parseInt(num1) + Integer.parseInt(num2);
                TextResult.setText("계산 결과: " + result.toString());
                return false;
            }
        });
        btnSub.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View args0, MotionEvent arg1) {
                num1 = editText1.getText().toString();
                num2 = editText2.getText().toString();
                result = Integer.parseInt(num1) - Integer.parseInt(num2);
                TextResult.setText("계산 결과: " + result.toString());
                return false;
            }
        });
        btnMul.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View args0, MotionEvent arg1) {
                num1 = editText1.getText().toString();
                num2 = editText2.getText().toString();
                result = Integer.parseInt(num1) * Integer.parseInt(num2);
                TextResult.setText("계산 결과: " + result.toString());
                return false;
            }
        });
        btnDiv.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View args0, MotionEvent arg1) {
                num1 = editText1.getText().toString();
                num2 = editText2.getText().toString();
                if (Integer.parseInt(num2) == 0) {
                    Toast.makeText(getApplicationContext(), "0은 나눌 수 없습니다.", Toast.LENGTH_SHORT).show();
                }
                else {
                    result = Integer.parseInt(num1) / Integer.parseInt(num2);
                    TextResult.setText("계산 결과: " + result.toString());
                }
                return false;
            }
        });
    }
}