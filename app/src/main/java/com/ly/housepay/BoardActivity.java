package com.ly.housepay;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class BoardActivity extends AppCompatActivity {
    WebView web;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board);
        web= (WebView) findViewById(R.id.web);
        web.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return false;
            }
        });
        web.getSettings().setJavaScriptEnabled(true);
        web.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT);
        web.loadUrl("http://m.newsmth.net/board/RealEstate");
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
