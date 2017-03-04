package com.ly.housepay.activity;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.ly.housepay.R;
import com.ly.housepay.fragment.DecorationFragment;
import com.ly.housepay.fragment.ForumFragment;
import com.ly.housepay.fragment.PriceFragment;
import com.ly.housepay.fragment.ToolFragment;
import com.ly.housepay.fragment.base.BaseFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{


    TextView forum_text, price_text, decoration_text,tool_text;
    Resources rs;
    int menuTextBgColor, menuTextBgCurrentColor;
    Fragment forumFragment, priceFragment, decorationFragment, toolFragment;
    Fragment mCurrentFragment;
    FragmentManager fm;
    Bundle mSavedInstanceState;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSavedInstanceState=savedInstanceState;

        initView();
        initResources();
        initFragment(mSavedInstanceState);
    }


    private void initView() {
        forum_text = (TextView) findViewById(R.id.forum_text);
        forum_text.setOnClickListener(this);
        price_text = (TextView) findViewById(R.id.price_text);
        price_text.setOnClickListener(this);
        decoration_text = (TextView) findViewById(R.id.decoration_text);
        decoration_text.setOnClickListener(this);
        tool_text = (TextView) findViewById(R.id.tool_text);
        tool_text.setOnClickListener(this);
    }

    private void initResources() {
        rs = getResources();
        menuTextBgColor = rs.getColor(R.color.menu_text_bg);
        menuTextBgCurrentColor = rs.getColor(R.color.menu_text_bg_current);
    }

    public void initFragment(Bundle savedInstanceState) {
        if(savedInstanceState==null){
            forumFragment = new ForumFragment();
            priceFragment = new PriceFragment();
            decorationFragment = new DecorationFragment();
            toolFragment = new ToolFragment();
            mCurrentFragment = forumFragment;
            fm = getFragmentManager();
            fm.beginTransaction().add(R.id.content, forumFragment, "forumFragment")
                    .add(R.id.content, priceFragment, "priceFragment").hide(priceFragment)
                    .add(R.id.content, decorationFragment, "decorationFragment").hide(decorationFragment)
                    .add(R.id.content, toolFragment, "toolFragment").hide(toolFragment)
                    .commit();
        }else{
            forumFragment = getFragmentManager().findFragmentByTag("forumFragment");
            priceFragment = getFragmentManager().findFragmentByTag("priceFragment");
            decorationFragment = getFragmentManager().findFragmentByTag("decorationFragment");
            toolFragment = getFragmentManager().findFragmentByTag("toolFragment");
            //show()一个即可
            fm = getFragmentManager();
            fm.beginTransaction()
                    .show(forumFragment)
                    .hide(priceFragment)
                    .hide(decorationFragment)
                    .hide(toolFragment)
                    .commit();
        }

    }

    @SuppressLint("NewApi")
    private void clearSelection() {
        forum_text.setTextColor(menuTextBgColor);
        Drawable drawableForum = rs.getDrawable(R.mipmap.foot_forum_normal);
        forum_text.setCompoundDrawablesRelativeWithIntrinsicBounds(null, drawableForum, null, null);


        decoration_text.setTextColor(menuTextBgColor);
        Drawable drawableDecoration = rs.getDrawable(R.mipmap.foot_decoration_normal);
        decoration_text.setCompoundDrawablesRelativeWithIntrinsicBounds(null, drawableDecoration, null, null);

        price_text.setTextColor(menuTextBgColor);
        Drawable drawablePrice = rs.getDrawable(R.mipmap.foot_price_normal);
        price_text.setCompoundDrawablesRelativeWithIntrinsicBounds(null, drawablePrice, null, null);

        tool_text.setTextColor(menuTextBgColor);
        Drawable drawableTool = rs.getDrawable(R.mipmap.foot_tool_normal);
        tool_text.setCompoundDrawablesRelativeWithIntrinsicBounds(null, drawableTool, null, null);

    }

    public void switchFragment(String toTag) {
        Fragment to = fm.findFragmentByTag(toTag);
        if (mCurrentFragment != to) {
            fm.beginTransaction().hide(mCurrentFragment).show(to).commit();
            mCurrentFragment = to;
        }
    }



    @SuppressLint("NewApi")
    @Override
    public void onClick(View v) {
        clearSelection();
        switch (v.getId()) {
            case R.id.forum_text:
                forum_text.setTextColor(menuTextBgCurrentColor);
                Drawable drawableForum = rs.getDrawable(R.mipmap.foot_forum_pressed);
                forum_text.setCompoundDrawablesRelativeWithIntrinsicBounds(null, drawableForum, null, null);
                switchFragment("forumFragment");
                break;
            case R.id.decoration_text:
                decoration_text.setTextColor(menuTextBgCurrentColor);
                Drawable drawableDecoration = rs.getDrawable(R.mipmap.foot_decoration_pressed);
                decoration_text.setCompoundDrawablesRelativeWithIntrinsicBounds(null, drawableDecoration, null, null);
                switchFragment("decorationFragment");
                break;
            case R.id.price_text:
                price_text.setTextColor(menuTextBgCurrentColor);
                Drawable drawablePrice = rs.getDrawable(R.mipmap.foot_price_pressed);
                price_text.setCompoundDrawablesRelativeWithIntrinsicBounds(null, drawablePrice, null, null);
                switchFragment("priceFragment");
                break;
            case R.id.tool_text:
                tool_text.setTextColor(menuTextBgCurrentColor);
                Drawable drawableTool = rs.getDrawable(R.mipmap.foot_tool_pressed);
                tool_text.setCompoundDrawablesRelativeWithIntrinsicBounds(null, drawableTool, null, null);
                switchFragment("toolFragment");
                break;
        }
    }


    private long mExitTime = 0;
    @Override
    public void onBackPressed() {
        if(mCurrentFragment!=null && mCurrentFragment!=toolFragment){
            if(!((BaseFragment)mCurrentFragment).onBackPressed()){
                //super.onBackPressed();
                if ((System.currentTimeMillis() - mExitTime) > 2000) {
                    Toast.makeText(this, "再按一次退出", Toast.LENGTH_SHORT).show();
                    mExitTime = System.currentTimeMillis();
                } else {
                    System.exit(0);
                }
            }
        }
    }

}
