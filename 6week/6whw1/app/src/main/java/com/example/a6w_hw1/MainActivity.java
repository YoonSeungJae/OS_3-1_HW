package com.example.a6w_hw1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DatePicker dp;
    EditText edtDiary;
    Button btnWrite;
    String fileName;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("일기장");

        dp = findViewById(R.id.datePicker1);
        edtDiary = findViewById(R.id.edtDiary);
        btnWrite = findViewById(R.id.btnWrite);

        Calendar cal = Calendar.getInstance();
        int cYear = cal.get(Calendar.YEAR);
        int cMonth = cal.get(Calendar.MONTH);
        int cDay = cal.get(Calendar.DAY_OF_MONTH);

        fileName = cYear + "_"+(cMonth + 1) + "_"+ cDay + ".txt";
        String str = readDiary(fileName);
        edtDiary.setText(str);

        dp.init(cYear, cMonth, cDay, new DatePicker.OnDateChangedListener() {
            public void onDateChanged(DatePicker view, int year,
                                      int monthOfYear, int dayOfMonth) {
                fileName = year + "_"+(monthOfYear + 1) + "_"+ dayOfMonth + ".txt";
                String str = readDiary(fileName);
                edtDiary.setText(str);
                btnWrite.setEnabled(true);
            }
        });

        btnWrite.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    FileOutputStream outFs = openFileOutput(fileName,
                            Context.MODE_PRIVATE);
                    String str = edtDiary.getText().toString();
                    outFs.write(str.getBytes());
                    outFs.close();
                    Toast.makeText(getApplicationContext(),
                            fileName + " 저장됨", Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                }
            }
        });

    }

    String readDiary(String fName) {
        String diaryStr = null;
        FileInputStream inFs;
        try {
            inFs = openFileInput(fName);
            byte[] txt = new byte[500];
            inFs.read(txt);
            inFs.close();
            diaryStr = (new String(txt)).trim();
            btnWrite.setText("modify");
        } catch (IOException e) {
            edtDiary.setHint("empty");
            btnWrite.setText("save");
        }
        return diaryStr;
    }
}