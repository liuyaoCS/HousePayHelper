package com.ly.housepay.fragment.base;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.ly.housepay.R;


public  abstract  class BaseFragment extends Fragment {
    private View mView;
    private WebView web;
    protected  abstract String getUrl();

    private  void initViews(View view){
        web= (WebView) view.findViewById(R.id.web);
        web.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return false;
            }
        });
        web.getSettings().setJavaScriptEnabled(true);
        web.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (mView == null) {
            mView = inflater.inflate(R.layout.frg_webview, container, false);
            initViews(mView);
        }
        return mView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        web.loadUrl(getUrl());
    }
    public boolean onBackPressed(){
        if(web.canGoBack()){
            web.goBack();
            return true;
        }else{
            return false;
        }
    }
}
