package com.example.perfectaudioplayer;

import androidx.appcompat.app.AppCompatActivity;

import com.example.perfectaudioplayer.adapter.RecyclerViewAdapter;
import com.example.perfectaudioplayer.songs.ListSong;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.List;

public class song extends AppCompatActivity {
    int i;
     List<Integer> arr;
    List<Integer> song;

    List<String> name;

    TextView txt1;
    Handler handler;
    ImageView img;
    MediaPlayer player;
    SeekBar seek;
    ImageButton img1;
    ImageButton img2;

    boolean f=false;

    public void onBackPressed(){
        if(player!=null)
        {
            player.release();
            player=null;
        }

    }
    public void play(View view){
        if(player==null)
        {
           //Will be used in future version.
           //There is no use for this function for now.
        }
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
            txt1.setText(name.get(i));
            player.release();
            player = MediaPlayer.create(this, song.get(i));
            img.setImageResource(arr.get(i));
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
        if(i<arr.size()) {
            i++;
            txt1.setText(name.get(i));
            player.release();
            player = MediaPlayer.create(this, song.get(i));
            img.setImageResource(arr.get(i));
            seek.setMax(player.getDuration());
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song);

        Intent intent=getIntent();
        i=intent.getIntExtra(RecyclerViewAdapter.id,0);
        ListSong songObj=new ListSong();

        img=findViewById(R.id.imageView);
        seek=findViewById(R.id.seekBar);
        img1=findViewById(R.id.imageButton);
        img2=findViewById(R.id.imageButton4);
        txt1=findViewById(R.id.Name);

        arr=songObj.getImages();
        song=songObj.giveSongs();
        name=songObj.getTitle();

        img.setImageResource(arr.get(i));
        player=MediaPlayer.create(this,song.get(i));

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