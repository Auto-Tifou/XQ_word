package com.example.administrator.xq;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import static android.R.attr.name;

/**
 * Created by Administrator on 2019/6/27 0027.
 */

public class LtkActivity extends AppCompatActivity{
    private TextView aName,aInfo;
    private ImageView aImg,imgfh;
    private int[]stimg={R.mipmap.qq1,R.mipmap.qq2,R.mipmap.qq03,R.mipmap.qq04,
            R.mipmap.qq05,R.mipmap.qq06,R.mipmap.qq7,R.mipmap.qq08,R.mipmap.qq9,R.mipmap.qq10,
            R.mipmap.qq11,R.mipmap.qq12,R.mipmap.qq13,R.mipmap.qq14,R.mipmap.qq15,R.mipmap.qq16,
            R.mipmap.qq17};
    private String[]stname={"古兜","过渡","离港","三穗","名螚","秋凉","孤","俗趣",
            "夏忧","瘾","阿明","豁","梦归所梦","梦净","忘川","任你","热钕"};
    private String[]stinfo={"吃好饭了吗，快点来打王者。","你今天有事吗？",
            "来打王者啊，甜蜜双排，我带飞你。","我们29放假，你呢？","我们放假好晚啊，你们都回去了。",
            "有时间去我那里玩啊，我带你去种田。", "你在哪里啊，我在老食堂，快过来。",
            "待会去吃鸡公煲吗，特辣的那种哟。","希望明天下雨，体育课就不用上了。",
            "现在有啥电影好看的啊，推荐推荐。","待会去拿快递吗？",
            "现在好晚啊，喝口水压压惊。","滴滴","宜春明月山比庐山好玩多了。",
            "又是搬砖的一天。","好好学习天天向上。","你那里好热啊。"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ltk);
         init();
        Intent it1 = getIntent();
        int i = it1.getIntExtra("n",0);

        aName.setText(stname[i]);
        aInfo.setText(stinfo[i]);
        aImg.setImageResource(stimg[i]);

        imgfh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LtkActivity.this,ZxActivity.class);
                startActivity(intent);
            }
        });
    }
    public void init(){
        aName=(TextView)findViewById(R.id.aname);
        aInfo=(TextView)findViewById(R.id.ainfo);
        aImg=(ImageView) findViewById(R.id.aimg);
        imgfh=(ImageView)findViewById(R.id.menufh);
    }
}