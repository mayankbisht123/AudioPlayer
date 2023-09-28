package com.example.perfectaudioplayer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.perfectaudioplayer.songs.ListSong;
import android.os.Bundle;

import com.example.perfectaudioplayer.adapter.RecyclerViewAdapter;
import com.example.perfectaudioplayer.songs.ListSong;

import java.util.List;

public class ChooseSong extends AppCompatActivity {

    RecyclerViewAdapter recyclerViewAdapter;
    RecyclerView recyclerView;
    List<String> songNameList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_song);

        recyclerView=findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ListSong songObj =new ListSong();

        songNameList=songObj.getTitle();
        recyclerViewAdapter = new RecyclerViewAdapter(this,songNameList);
        recyclerView.setAdapter(recyclerViewAdapter);

    }
}