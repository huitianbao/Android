package com.example.clocksimple3;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;



public class MainActivity extends FragmentActivity implements ViewPager.OnPageChangeListener{
    private ViewPager mViewPager;
    private List<Fragment> fragments;
    private ImageView imageView1;
    private ImageView imageView2;
    private ImageView imageView3;


    boolean isChanged = false;    //=============================================================================================================================

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);



        mViewPager=(ViewPager)findViewById(R.id.myViewPager);
        imageView1=(ImageView)findViewById(R.id.image_homepage);
        imageView2=(ImageView)findViewById(R.id.image_manage);
        imageView3=(ImageView)findViewById(R.id.image_settime);


        fragments = new ArrayList<Fragment>();//为viewpager准备数据
        fragments.add(new Fragment_Home());           //                                                 注意顺序
        fragments.add(new Fragment_Manage());
        fragments.add(new Fragment_SetTime());


        //Viewpager与listview一样，也需要adapter提供数据，由于这次的界面是三个tab组成的，所以我们在上面用List准备了数据在这里传进去。
        mViewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager(),
                fragments));
        mViewPager.setOnPageChangeListener(this);//监听viewpager切换
        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mViewPager.setCurrentItem(0);
                if(isChanged){
                    imageView1.setImageResource(R.mipmap.home_red);

                }else
                {
                    imageView1.setImageResource(R.mipmap.home_blue);
                }
                isChanged = !isChanged;
            }
        });

        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mViewPager.setCurrentItem(1);
                if(isChanged){
                    imageView2.setImageResource(R.mipmap.managered);
                }else {
                    imageView2.setImageResource(R.mipmap.managelightblue);
                }
                isChanged=!isChanged;
            }
        });
        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mViewPager.setCurrentItem(2);
                if(isChanged){
                    imageView3.setImageResource(R.mipmap.jiahaored);
                }else {
                    imageView3.setImageResource(R.mipmap.jiahaolightblue);
                }
                isChanged=!isChanged;

            }
        });

        mViewPager.setCurrentItem(0);//设置ViewPager刚开始的时候停在第一页
    }

    private void initImageView() {
        imageView1.setImageResource(R.mipmap.home_red);
        imageView2.setImageResource(R.mipmap.managered);
        imageView3.setImageResource(R.mipmap.jiahaored);

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        initImageView();//更改图片前都初始化图片一次，下面写起来就方便点。
        switch (position){
            case 0:
                imageView1.setImageResource(R.mipmap.home_red);
                break;
            case 1:
                imageView2.setImageResource(R.mipmap.managered);
                break;
            case 2:
                imageView3.setImageResource(R.mipmap.jiahaored);
                break;

        }

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
