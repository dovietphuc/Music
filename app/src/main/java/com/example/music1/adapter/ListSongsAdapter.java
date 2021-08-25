package com.example.music1.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.music1.ActivityMusic;
import com.example.music1.R;
import com.example.music1.fragment.MediaPlaybackFragment;
import com.example.music1.model.Song;

import java.util.ArrayList;

public class ListSongsAdapter extends RecyclerView.Adapter<ListSongsAdapter.SongViewHolder> {

    public ArrayList<Song> mSongs;
    public  Activity mActivity;


    class SongViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView mIndex;
        public TextView mTitle;
        public TextView mTime;


        public SongViewHolder(@NonNull View itemView) {
            super(itemView);

            mIndex = itemView.findViewById(R.id.index);
            mTitle = itemView.findViewById(R.id.title);
            mTime = itemView.findViewById(R.id.time);

            itemView.setOnClickListener(this);

//            FragmentManager fm = Frag;


        }

        @SuppressLint("NotifyDataSetChanged")
        @Override
        public void onClick(View view) {

//            Toast.makeText(mIndex.getContext(), mTitle.getText(), Toast.LENGTH_LONG).show();

            ((ActivityMusic) mActivity ).changeFragment(new MediaPlaybackFragment(), R.id.fragmentContainerView);

            Bundle bundle = new Bundle();

        }

        public void bindView (int index, String title, String time) {
            mIndex.setText(String.valueOf(index));
            mTitle.setText(title);
            mTime.setText(time);
        }
    }

    public ListSongsAdapter (Context context) {
        mSongs = new ArrayList<Song>();
        mSongs.add(new Song(1, "test1", "00:00"));
        mSongs.add(new Song(2, "test2", "00:00"));
        mSongs.add(new Song(3, "test3", "00:00"));

        mActivity = (Activity) context;
    }

    @NonNull
    @Override
    public SongViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        khởi tạo viewholder để đổ dữ liệu vào view

        View mItemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.songs_item, parent, false);
        //        nạp dữ liệu cho RecyclerView là wordlist_item

        return new SongViewHolder(mItemView);
    }

    @Override
    public void onBindViewHolder(@NonNull SongViewHolder holder, int position) {

        holder.bindView(mSongs.get(position).index, mSongs.get(position).title, mSongs.get(position).time);

    }

    @Override
    public int getItemCount() {
        return mSongs.size();
    }

}
