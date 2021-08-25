package com.example.music1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.DialogFragment;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;

import com.example.music1.fragment.AllSongsFragment;

public class ActivityMusic extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);

//        FragmentManager fm = getSupportFragmentManager();
//
//        FragmentTransaction ft_add = fm.beginTransaction();
//        ft_add.add(R.id.fragmentContainerView, new AllSongsFragment());
//        ft_add.commit();

        changeFragment(new AllSongsFragment(), R.id.fragmentContainerView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
//        inflate đổ giao diện
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    public void changeFragment (Fragment fragment, int id) {

        FragmentManager fm = getSupportFragmentManager();

        FragmentTransaction ft_add = fm.beginTransaction();
        ft_add.replace(id, fragment);
        ft_add.addToBackStack("key1");
        ft_add.commit();


    }
}