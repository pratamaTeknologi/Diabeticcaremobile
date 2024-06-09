package com.papps.diabeticcaremobile.diabetesMelitus;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;


import com.papps.diabeticcaremobile.R;

public class Pengertian extends AppCompatActivity {

    private ImageView prev, next, sound;
    private FragmentManager fragmentManager;
    private Fragment currentFragment;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_pengertian);

        initView();
        prevNextFragment();
        displayFragment();
    }

    private void prevNextFragment() {
        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                displayPrevFragment();
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                displayNextFragment();
            }
        });


    }

    private void displayNextFragment() {

        Fragment nextFragment;
        if (currentFragment instanceof Fragment_slide1) {
            nextFragment = new Fragment_slide2();
        }else {
            // Tambahkan fragment-fragment berikutnya sesuai urutan
            // sesuai kebutuhan aplikasi Anda
            return;
        }

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_pengertian, nextFragment);
        fragmentTransaction.commit();
        currentFragment = nextFragment;

    }

    private void displayPrevFragment() {
        Fragment previousFragment;
        if (currentFragment instanceof Fragment_slide1) {
            // Jika saat ini ada di Fragment1, tidak ada Fragment sebelumnya
            return;
        } else if (currentFragment instanceof Fragment_slide2) {
            previousFragment = new Fragment_slide1();
        } else {
            // Tambahkan fragment-fragment sebelumnya sesuai urutan
            // sesuai kebutuhan aplikasi Anda
            return;
        }

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_pengertian, previousFragment);
        fragmentTransaction.commit();
        currentFragment = previousFragment;
    }

    private void displayFragment() {
        Fragment_slide1 fragment1 = new Fragment_slide1();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_pengertian, fragment1);
        fragmentTransaction.commit();
        currentFragment = fragment1;
    }

    private void initView() {
        prev = findViewById(R.id.prev);
        next = findViewById(R.id.next);
        sound = findViewById(R.id.sound);
        fragmentManager = getSupportFragmentManager();

        sound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playSound();
            }
        });
    }

    private void playSound() {
        int soundResId = 0;
        if (currentFragment instanceof Fragment_slide1) {
            soundResId = R.raw.slide1;
        } else if (currentFragment instanceof Fragment_slide2) {
            soundResId = R.raw.slide2;
        }

        if (soundResId != 0) {
            if (mediaPlayer != null) {
                mediaPlayer.release();
            }
            mediaPlayer = MediaPlayer.create(this, soundResId);
            mediaPlayer.start();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
    public void back(View view) {
        onBackPressed();
    }
}