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

public class Gejala extends AppCompatActivity {

    private ImageView sound;
    private FragmentManager fragmentManager;
    private Fragment currentFragment;
    private MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_gejala);

        initView();
        displayFragment();
    }


    private void displayFragment() {
        Fragment_slide12 fragment1 = new Fragment_slide12();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_gejala, fragment1);
        fragmentTransaction.commit();
        currentFragment = fragment1;
    }

    private void initView() {
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
        if (currentFragment instanceof Fragment_slide12) {
            soundResId = R.raw.slide12;
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