package com.example.music1.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;

import com.example.music1.R;
import com.example.music1.adapter.ListSongsAdapter;


public class AllSongsFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_all_song, container, false);
        RecyclerView songs = view.findViewById(R.id.list_songs);
        ListSongsAdapter listSongAdapter = new ListSongsAdapter(getContext());
        songs.setAdapter(listSongAdapter);
        songs.setLayoutManager(new LinearLayoutManager(view.getContext()));
        return view;
    }
}