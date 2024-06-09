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

public class Klasifikasi extends AppCompatActivity {

    private ImageView prev, next, sound;
    private FragmentManager fragmentManager;
    private Fragment currentFragment;
    private MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_klasifikasi);

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
        if (currentFragment instanceof Fragment_slide3) {
            nextFragment = new Fragment_slide4();
        }else if (currentFragment instanceof Fragment_slide4){
            nextFragment = new Fragment_slide5();
            // Tambahkan fragment-fragment berikutnya sesuai urutan
            // sesuai kebutuhan aplikasi Anda
        }else if (currentFragment instanceof Fragment_slide5){
            nextFragment = new fragment_slide_tambahan();
            // Tambahkan fragment-fragment berikutnya sesuai urutan
            // sesuai kebutuhan aplikasi Anda
        }else {
            return;
        }

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_klasifikasi, nextFragment);
        fragmentTransaction.commit();
        currentFragment = nextFragment;

    }

    private void displayPrevFragment() {
        Fragment previousFragment;
        if (currentFragment instanceof Fragment_slide3) {
            // Jika saat ini ada di Fragment1, tidak ada Fragment sebelumnya
            return;
        } else if (currentFragment instanceof Fragment_slide4) {
            previousFragment = new Fragment_slide3();
        } else if (currentFragment instanceof Fragment_slide5) {
            previousFragment = new Fragment_slide4();
        }else if (currentFragment instanceof fragment_slide_tambahan) {
            previousFragment = new Fragment_slide5();
        } else {
            // Tambahkan fragment-fragment sebelumnya sesuai urutan
            // sesuai kebutuhan aplikasi Anda
            return;
        }

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_klasifikasi, previousFragment);
        fragmentTransaction.commit();
        currentFragment = previousFragment;
    }

    private void displayFragment() {
        Fragment_slide3 fragment1 = new Fragment_slide3();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_klasifikasi, fragment1);
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
        if (currentFragment instanceof Fragment_slide3) {
            soundResId = R.raw.slide3;
        } else if (currentFragment instanceof Fragment_slide4) {
            soundResId = R.raw.slide4;
        } else if (currentFragment instanceof Fragment_slide5) {
            soundResId = R.raw.slide5;
        }else if (currentFragment instanceof fragment_slide_tambahan) {
            soundResId = R.raw.slidetambahan;
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