package com.example.perfectaudioplayer.songs;

import com.example.perfectaudioplayer.R;
import java.util.ArrayList;
import java.util.List;

public class ListSong {
public List giveSongs(){
    ArrayList<Integer> songsList=new ArrayList<>();
    songsList.add(R.raw.yay);
    songsList.add(R.raw.jjk);
    songsList.add(R.raw.noragami);
    return songsList;
}
public List getTitle(){
    ArrayList<String> titles=new ArrayList<>();
    titles.add("Demon Slayer");
    titles.add("Jujutsu Kaizen");
    titles.add("Noragami");
    return titles;
}
public List getImages(){
    ArrayList<Integer> images=new ArrayList<>();
    images.add(R.drawable.yay);
    images.add(R.drawable.jjk2i);
    images.add(R.drawable.noragami);
    return images;
}

}
