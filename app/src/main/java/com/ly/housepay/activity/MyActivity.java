package com.ly.housepay.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.ly.housepay.R;

public class MyActivity extends AppCompatActivity {
    private WebView web;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        initViews();
    }
    private  void initViews(){
        web= (WebView) findViewById(R.id.web);
        web.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return false;
            }
        });
        web.getSettings().setJavaScriptEnabled(true);
        web.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT);
        web.loadUrl("http://bj.lianjia.com/chengjiao/101100529253.html");
    }
}
