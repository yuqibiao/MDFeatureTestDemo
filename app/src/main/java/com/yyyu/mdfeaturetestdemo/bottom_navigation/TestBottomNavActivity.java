package com.yyyu.mdfeaturetestdemo.bottom_navigation;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.yyyu.mdfeaturetestdemo.R;
import com.yyyu.mdfeaturetestdemo.bottom_navigation.fragment.FavoriteFragment;
import com.yyyu.mdfeaturetestdemo.bottom_navigation.fragment.HomeFragment;
import com.yyyu.mdfeaturetestdemo.bottom_navigation.fragment.MyFragment;
import com.yyyu.mdfeaturetestdemo.bottom_navigation.fragment.RestFragment;
import com.yyyu.mdfeaturetestdemo.bottom_navigation.fragment.StudyFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * 功能：测试Bottom Navigation的使用
 * <p>
 * <p>
 * 常用方法 & XML属性详解：
 * 1.
 * <p>
 * 参考：
 * https://zhuanlan.zhihu.com/p/23711456
 * <p>
 * Created by yyyu on 2017/2/17.
 */

public class TestBottomNavActivity extends AppCompatActivity {

    private BottomNavigationView bottom_nav_test;
    private ViewPager vp_nav;
    private List<Fragment> tabs;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_nav);

        initTab();
        initView();
        initListener();

    }

    private void initTab() {
        tabs = new ArrayList<>(5);
        tabs.add(new HomeFragment());
        tabs.add(new StudyFragment());
        tabs.add(new RestFragment());
        tabs.add(new FavoriteFragment());
        tabs.add(new MyFragment());
    }

    private void initView() {
        bottom_nav_test = (BottomNavigationView) findViewById(R.id.bottom_nav_test);
        vp_nav = (ViewPager) findViewById(R.id.vp_nav);

        vp_nav.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return tabs.get(position);
            }

            @Override
            public int getCount() {
                return tabs.size();
            }
        });
    }

    private void initListener() {
        //---Item的监听
        bottom_nav_test.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.item_bottom_home:{
                        vp_nav.setCurrentItem(0 , false);
                        break;
                    }
                    case R.id.item_bottom_study:{
                        vp_nav.setCurrentItem(1 , false);
                        break;
                    }
                    case R.id.item_bottom_rest:{
                        vp_nav.setCurrentItem(2 , false);
                        break;
                    }
                    case R.id.item_bottom_favorite:{
                        vp_nav.setCurrentItem(3 , false);
                        break;
                    }
                    case R.id.item_bottom_my:{
                        vp_nav.setCurrentItem(4 , false);
                        break;
                    }
                }
                return true;
            }
        });
        //viewpager的滑动监听
        vp_nav.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                bottom_nav_test.getMenu().getItem(position).setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
