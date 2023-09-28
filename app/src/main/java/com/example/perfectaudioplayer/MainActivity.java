package com.example.perfectaudioplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    boolean visible=false;
    public final static String id="Audio.com";
    public void go(View view){
        Intent intent=new Intent(this,song.class);
        startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void more(View view){
        Intent intent=new Intent(this,ChooseSong.class);
        startActivity(intent);
    }


}