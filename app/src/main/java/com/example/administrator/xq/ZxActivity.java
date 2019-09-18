package com.example.administrator.xq;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import layout.fxFragment;
import layout.txlFragment;
import layout.wFragment;
import layout.xxFragment;


public class ZxActivity extends AppCompatActivity {
    private ImageView menujh;
    private ViewPager myView;
    private FragmentPagerAdapter myAdapter;
    private List<Fragment>myFrags;
    private LinearLayout tabxx,tabtxl,tabfx,tabw;
    private ImageButton imgxx,imgtxl,imgfx,imgw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zx);
        initView();
        initEvents();
        initDatas();
    }
    private void initDatas(){
        myFrags=new ArrayList<>();
        myFrags.add(new xxFragment());
        myFrags.add(new txlFragment());
        myFrags.add(new fxFragment());
        myFrags.add(new wFragment());
        myAdapter=new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return myFrags.get(position);
            }

            @Override
            public int getCount() {
                return myFrags.size();
            }
        };
        myView.setAdapter(myAdapter);
        myView.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                resetImgs();
                selectTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
    private void initView() {
        //初始化控件
        menujh=(ImageView)findViewById(R.id.menu_jh);
        myView=(ViewPager)findViewById(R.id.viewpager);

        tabxx=(LinearLayout)findViewById(R.id.tab_xx);
        tabtxl=(LinearLayout)findViewById(R.id.tab_txl);
        tabfx=(LinearLayout)findViewById(R.id.tab_fx);
        tabw=(LinearLayout)findViewById(R.id.tab_w);

        imgxx=(ImageButton)findViewById(R.id.tab_xx_img);
        imgtxl=(ImageButton)findViewById(R.id.tab_txl_img);
        imgfx=(ImageButton)findViewById(R.id.tab_fx_img);
        imgw=(ImageButton)findViewById(R.id.tab_w_img);

        //点击
        menujh.setOnClickListener(new MyListener());
    }
    private void initEvents(){
        MyListener myListener = new MyListener();
        tabxx.setOnClickListener(myListener);
        tabtxl.setOnClickListener(myListener);
        tabfx.setOnClickListener(myListener);
        tabw.setOnClickListener(myListener);
    }
    //事件监听
    private class MyListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
           switch (v.getId()){
               case R.id.menu_jh:
                   PopupMenu popupMenu = new PopupMenu(ZxActivity.this,v);
                   popupMenu.getMenuInflater().inflate(R.menu.popumenu,popupMenu.getMenu());
                   popupMenu.show();
                   break;
               case R.id.tab_xx:
                   selectTab(0);
                   break;
               case R.id.tab_txl:
                   selectTab(1);
                   break;
               case R.id.tab_fx:
                   selectTab(2);
                   break;
               case R.id.tab_w:
                   selectTab(3);
                   break;
           }
        }
    }
    private void selectTab(int i){
        switch (i){
            case 0:
                imgxx.setImageResource(R.drawable.menuxx1);
                break;
            case 1:
                imgtxl.setImageResource(R.drawable.menutxl1);
                break;
            case 2:
                imgfx.setImageResource(R.drawable.menufx1);
                break;
            case 3:
                imgw.setImageResource(R.drawable.menuw1);
                break;
        }
        myView.setCurrentItem(i);
    }
    private void resetImgs(){
        imgxx.setImageResource(R.drawable.menuxx);
        imgtxl.setImageResource(R.drawable.menutxl);
        imgfx.setImageResource(R.drawable.menufx);
        imgw.setImageResource(R.drawable.menuw);
    }

}

