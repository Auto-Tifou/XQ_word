package com.example.administrator.xq;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by Administrator on 2019/6/27 0027.
 */

public class GroupActivity extends AppCompatActivity{
    private Button Bf,Tz;
    protected ImageView imagefh1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group);
        Bf=(Button)findViewById(R.id.bf);
        Tz=(Button)findViewById(R.id.tz);
        imagefh1=(ImageView)findViewById(R.id.imagefh);

        final MediaPlayer mediaPlayer = MediaPlayer.create(this,R.raw.frlot);
        Bf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.start();
            }
        });
        Tz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.stop();
            }
        });
        imagefh1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GroupActivity.this,ZxActivity.class);
                startActivity(intent);
            }
        });
    }
}
