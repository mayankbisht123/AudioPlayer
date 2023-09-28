package com.example.perfectaudioplayer.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.perfectaudioplayer.MainActivity;
import com.example.perfectaudioplayer.R;
import com.example.perfectaudioplayer.song;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{

    private Context context;
    private List<String> songsList;
    public final static String id="Audio.com";

    public RecyclerViewAdapter(Context context, List<String> songsList)
    {
        this.context=context;
        this.songsList=songsList;
    }
    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.row,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder holder, int position) {
        String s=songsList.get(position);
        holder.songName.setText(s);
        holder.songNumber.setText(String.valueOf(position+1));
    }

    @Override
    public int getItemCount() {
        return songsList.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView songName;
        public TextView songNumber;
        public ViewHolder(View view)
        {
            super(view);
            view.setOnClickListener(this);
            songName=view.findViewById(R.id.textView);
            songNumber=view.findViewById(R.id.textView3);

        }

        @Override
        public void onClick(View v) {
            int position =getAdapterPosition();
            if(position!=RecyclerView.NO_POSITION){
                Intent intent=new Intent(context,song.class);
                intent.putExtra(id,position);
                context.startActivity(intent);
            }
        }
    }
}


