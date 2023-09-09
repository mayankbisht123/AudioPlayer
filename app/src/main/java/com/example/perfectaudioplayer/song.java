package com.example.perfectaudioplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

public class song extends AppCompatActivity {
    int i;
    int[] arr;
    int[] song;

    String[] name;

    TextView txt1;
    Handler handler;
    ImageView img;
    MediaPlayer player;
    SeekBar seek;
    ImageButton img1;
    ImageButton img2;

    boolean f=false;
    public void play(View view){
        if(!f) {
            player.start();
            img1.setVisibility(View.GONE);
            img2.setVisibility(View.VISIBLE);
            f=true;
        }
        else {
            player.pause();
            img2.setVisibility(View.GONE);
            img1.setVisibility(View.VISIBLE);
            f=false;
        }
    }

    public void previous(View view){
        if(player.isPlaying()) {
            player.pause();
            player.seekTo(0);
            img2.setVisibility(View.GONE);
            img1.setVisibility(View.VISIBLE);
            f=false;
        }
        if(i>0) {
            i--;
            txt1.setText(name[i]);
            player.release();
            player = MediaPlayer.create(this, song[i]);
            img.setImageResource(arr[i]);
            seek.setMax(player.getDuration());
        }
    }

    public void next(View view){
        if(player.isPlaying()) {
            player.pause();
            player.seekTo(0);
            img2.setVisibility(View.GONE);
            img1.setVisibility(View.VISIBLE);
            f=false;

        }
        if(i<arr.length) {
            i++;
            txt1.setText(name[i]);
            player.release();
            player = MediaPlayer.create(this, song[i]);
            img.setImageResource(arr[i]);
            seek.setMax(player.getDuration());
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song);

        Intent intent=getIntent();
        i=intent.getIntExtra(MainActivity.id,0);

        img=findViewById(R.id.imageView);
        seek=findViewById(R.id.seekBar);
        img1=findViewById(R.id.imageButton);
        img2=findViewById(R.id.imageButton4);
        txt1=findViewById(R.id.Name);

        arr=new int[]{R.drawable.yay,R.drawable.jjk2i,R.drawable.noragami};
        song=new int[]{R.raw.yay,R.raw.jjk,R.raw.noragami};
        name=new String[]{"Demon Slayer","Jujutsu kaizen","Noragami"};

        img.setImageResource(arr[i]);
        player=MediaPlayer.create(this,song[i]);

        seek.setMax(player.getDuration());

        handler=new Handler();
        Runnable r=new Runnable() {
            @Override
            public void run() {
                seek.setProgress(player.getCurrentPosition());
                handler.postDelayed(this,1000);
            }
        };handler.post(r);

        seek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                if(b)
                {
                    player.pause();
                    player.seekTo(i);
                    player.start();
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
}