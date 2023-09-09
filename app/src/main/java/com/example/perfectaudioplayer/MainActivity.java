package com.example.perfectaudioplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Intent intent;
    boolean visible=false;
    ListView li;
    public final static String id="Audio.com";
    public void go(View view){
        intent=new Intent(this,song.class);
        startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        li=findViewById(R.id.listView);
        ArrayList<String> songs=new ArrayList<>();
        songs.add("Jujutsu kaizen");
        songs.add("Demon Slayer");
        songs.add("Noragami");

        ArrayAdapter<String> adapter=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,songs);
        li.setAdapter(adapter);

        li.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                intent=new Intent(MainActivity.this,song.class);
                intent.putExtra(id,i);
                startActivity(intent);
            }
        });
    }
    public void more(View view){
        if(!visible) {
            li.setVisibility(View.VISIBLE);
        }
        else{
            li.setVisibility(View.GONE);
        }
        visible=!visible;
    }


}