package com.example.hw6_2;

/* **********************************************
 * 프로젝트명 :  6-2 간단 웹브라우저
 * 작성자 : 2019038050 윤승재
 * 작성일 : 2022.04.09
 * 프로그램 설명 :  url을 입력하면 해당 링크로 이동
 ************************************************/

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.*;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    Button btnGo, btnBack;
    EditText edtUrl1;
    WebView webView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.web);

        btnGo = (Button) findViewById(R.id.btnGo);
        btnBack = (Button) findViewById(R.id.btnBack);
        edtUrl1 = (EditText) findViewById(R.id.edtUrl1);
        webView1 = (WebView) findViewById(R.id.webView1);

        webView1.setWebViewClient(new CookWebViewClient());

        WebSettings webSet = webView1.getSettings();
        webSet.setBuiltInZoomControls(true);
        webSet.setJavaScriptEnabled(true);

        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webView1.loadUrl(edtUrl1.getText().toString());
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webView1.goBack();
            }
        });
    }

    class CookWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            return super.shouldOverrideUrlLoading(view, url);
        }
    }
}