package com.example.administrator.xq;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Administrator on 2019/5/28 0028.
 */

public class HyActivity extends AppCompatActivity implements View.OnClickListener{
    private int recLen = 4; //跳过倒计时提示4秒
    private TextView tv_tg;
    Timer timer = new Timer();
    private Handler handler;
    private Runnable runnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hy);
        tv_tg = (TextView)findViewById(R.id.Tv_tg);
        tv_tg.setOnClickListener(this);
        timer.schedule(task,1000,1000); //等待时间一秒，停顿时间一秒

        //不点击跳过
        handler = new Handler();
        handler.postDelayed(runnable = new Runnable() {
            @Override
            public void run() {
                Intent intent =new Intent(HyActivity.this,MainActivity.class);
                startActivity(intent);
                Toast.makeText(HyActivity.this,"您好，欢迎光临！",Toast.LENGTH_SHORT).show();
                finish();
            }
        },4000); //延迟4s后发送handler信息
    }
    TimerTask task = new TimerTask() {
        @Override
        public void run() {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    recLen--;
                    tv_tg.setText("跳过" + recLen);
                    if (recLen<0){
                        timer.cancel();
                        tv_tg.setVisibility(View.GONE);//倒计时到0隐藏字体
                    }
                }
            });
        }
    };
    //点击跳过
    @Override
    public void onClick(View view){
        switch (view.getId()){
            case R.id.Tv_tg:
                Intent intent = new Intent(HyActivity.this,MainActivity.class);
                startActivity(intent);
                Toast.makeText(HyActivity.this,"您好，欢迎光临！",Toast.LENGTH_SHORT).show();
                finish();
                if (runnable != null){
                    handler.removeCallbacks(runnable);
                }
                break;
            default:
                break;
        }
    }
}
