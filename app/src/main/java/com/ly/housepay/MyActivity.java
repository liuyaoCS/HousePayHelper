package com.ly.housepay;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MyActivity extends AppCompatActivity {

    WebView web;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        web= (WebView) findViewById(R.id.web);
        web.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return false;
            }
        });
        web.getSettings().setJavaScriptEnabled(true);
        web.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT);
        web.loadUrl("http://bj.lianjia.com/ershoufang/rs%E5%8D%97%E6%B9%96%E6%B8%A0%E8%A5%BF%E9%87%8C/");
    }

    @Override
    public void onBackPressed() {
        if(web.canGoBack()){
            web.goBack();
        }else{
            super.onBackPressed();
        }
    }
}
