package com.example.henry.itreview.activity;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.example.henry.itreview.R;
import com.example.henry.itreview.adapter.ViewPagerAdapter;
import com.example.henry.itreview.fragment.ForumFragment;
import com.example.henry.itreview.fragment.HomeFragment;
import com.example.henry.itreview.fragment.MineFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements BottomNavigationBar.OnTabSelectedListener, ViewPager.OnPageChangeListener, View.OnClickListener{
    private BottomNavigationBar bottomNavigationBar;
    private ArrayList<Fragment> fragments;
    private ViewPager viewPager;
    private static final String MAIN_LOG_TAG = "MAIN";
    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViewPager();
        initBottomBar();
        Log.v(MAIN_LOG_TAG, "onCreate调用");
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null) {
            actionBar.hide();
        }
    }

    private void initBottomBar() {
        bottomNavigationBar = (BottomNavigationBar)findViewById(R.id.bottom_bar);
        bottomNavigationBar
                .setBarBackgroundColor(R.color.colorPrimary)
                .setActiveColor("#FFA500")
                .setMode(BottomNavigationBar.MODE_FIXED)
                .setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC)
                .addItem(new BottomNavigationItem(R.drawable.study, "首页"))
                .addItem(new BottomNavigationItem(R.drawable.forum, "论坛"))
                .addItem(new BottomNavigationItem(R.drawable.mine, "我的"))
                .setFirstSelectedPosition(0)
                .setTabSelectedListener(this)
                .initialise();
    }

    private void initViewPager() {
        viewPager = (ViewPager)findViewById(R.id.view_pager);
        fragments = new ArrayList<Fragment>();
        fragments.add(new HomeFragment());
        fragments.add(new ForumFragment());
        fragments.add(new MineFragment());
        viewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager(), fragments));
        viewPager.addOnPageChangeListener(this);
        viewPager.setCurrentItem(0);

    }


    @Override
    public void onPageScrolled (int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected (int position) {
        bottomNavigationBar.selectTab(position);
    }

    @Override
    public void onPageScrollStateChanged (int state) {

    }

    @Override
    public void onClick (View v) {

    }

    @Override
    public void onTabSelected (int position) {
        viewPager.setCurrentItem(position);
    }

    @Override
    public void onTabUnselected (int position) {

    }

    @Override
    public void onTabReselected (int position) {

    }
}
