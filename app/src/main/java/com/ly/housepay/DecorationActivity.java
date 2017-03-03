package com.ly.housepay;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class DecorationActivity extends AppCompatActivity {

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
        web.loadUrl("http://m.newsmth.net/board/Occupier");
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
