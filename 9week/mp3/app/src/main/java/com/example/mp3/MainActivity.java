package com.example.mp3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listViewMP3;
    Button btnPlay, btnStop, btnPause;
    TextView tvMP3;
    ProgressBar pbMP3;

    ArrayList<String> mp3List;
    String selectedMP3;

    String mp3Path = Environment.getExternalStorageDirectory().getPath() + "/";
    MediaPlayer mPlayer;
    boolean PAUSED = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("간단 MP3 플레이어");
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, MODE_PRIVATE);

        mp3List = new ArrayList<String>();

        File[] listFiles = new File(mp3Path).listFiles();
        String fileName, extName;
        for (File file : listFiles) {
            fileName = file.getName();
            extName = fileName.substring(fileName.length() - 3);
            if (extName.equals("mp3")) {
                mp3List.add(fileName);
            }
        }

        listViewMP3 = findViewById(R.id.listViewMP3);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_single_choice, mp3List);
        listViewMP3.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        listViewMP3.setAdapter(adapter);
        listViewMP3.setItemChecked(0, true);

        listViewMP3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectedMP3 = mp3List.get(position);
            }
        });

        selectedMP3 = mp3List.get(0);


        btnPlay = findViewById(R.id.btnPlay);
        btnStop = findViewById(R.id.btnStop);
        btnPause = findViewById(R.id.btnPause);
        tvMP3 = findViewById(R.id.tvMP3);
        pbMP3 = findViewById(R.id.pbMP3);

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    mPlayer = new MediaPlayer();
                    mPlayer.setDataSource(mp3Path + selectedMP3);
                    mPlayer.prepare();
                    mPlayer.start();
                    btnPlay.setClickable(false);
                    btnStop.setClickable(true);
                    btnPause.setClickable(true);
                    tvMP3.setText("실행중인 음악 : " + selectedMP3);
                    pbMP3.setVisibility(View.VISIBLE);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });

        btnPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!PAUSED) {
                    btnPause.setText("이어듣기");
                    mPlayer.pause();
                    PAUSED = true;
                    pbMP3.setVisibility(View.INVISIBLE);
                } else {
                    mPlayer.start();
                    PAUSED = false;
                    pbMP3.setVisibility(View.VISIBLE);
                    btnPause.setText("일시정지");
                }
            }
        });


        btnPause.setClickable(false);

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPlayer.stop();
                mPlayer.reset();
                btnPlay.setClickable(true);
                btnStop.setClickable(false);
                btnPause.setClickable(false);
                tvMP3.setText("실행중인 음악 : ");
                pbMP3.setVisibility(View.INVISIBLE);
            }
        });

        btnStop.setClickable(false);
    }
}