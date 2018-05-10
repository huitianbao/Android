package com.example.wjj3fragemt;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity implements ViewPager.OnPageChangeListener {
    private ViewPager mViewPager;
    private List<Fragment> fragments;
    private ImageView homepager;
    private ImageView pagerone;
    private ImageView pagertwo;

    boolean isChanged = false;    //=============================================================================================================================

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewPager=(ViewPager)findViewById(R.id.myviewpager);
        homepager=(ImageView)findViewById(R.id.image_homepage);
        pagerone=(ImageView)findViewById(R.id.image_one);
        pagertwo=(ImageView)findViewById(R.id.image_two);


        fragments = new ArrayList<Fragment>();//为viewpager准备数据
        fragments.add(new PagerHome());           //                                                 注意顺序
        fragments.add(new PagerOne());
        fragments.add(new PagerTwo());

        //Viewpager与listview一样，也需要adapter提供数据，由于这次的界面是三个tab组成的，所以我们在上面用List准备了数据在这里传进去。
        mViewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager(),fragments));
        mViewPager.setOnPageChangeListener(this);//监听viewpager切换

        homepager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mViewPager.setCurrentItem(0);

                if(isChanged){
                    homepager.setImageResource(R.mipmap.home_blue);

                }else
                {
                    homepager.setImageResource(R.mipmap.home_red);
                }
                isChanged = !isChanged;
            }
        });


        pagerone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mViewPager.setCurrentItem(1);
                if(isChanged){
                    pagerone.setImageResource(R.mipmap.number_1_blue);

                }else
                {
                    pagerone.setImageResource(R.mipmap.number_1_grey);
                }
                isChanged = !isChanged;
            }
        });



        pagertwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mViewPager.setCurrentItem(2);
                if(isChanged){
                    pagertwo.setImageResource(R.mipmap.number_2_blue);

                }else
                {
                    pagertwo.setImageResource(R.mipmap.number_2_grey);
                }
                isChanged = !isChanged;
            }
        });

        mViewPager.setCurrentItem(0);//设置ViewPager刚开始的时候停在第一页

    }
    private void initImageView() {
        homepager.setImageResource(R.mipmap.home_blue);
        pagerone.setImageResource(R.mipmap.number_1_blue);
        pagertwo.setImageResource(R.mipmap.number_2_blue);

    }
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

        initImageView();//更改图片前都初始化图片一次，下面写起来就方便点。
        switch (position){
            case 0:
                homepager.setImageResource(R.mipmap.home_red);
                break;
            case 1:
                pagerone.setImageResource(R.mipmap.number_1_grey);
                break;
            case 2:
                pagertwo.setImageResource(R.mipmap.number_2_grey);
                break;

        }

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
