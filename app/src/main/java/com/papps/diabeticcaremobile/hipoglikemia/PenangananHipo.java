package com.papps.diabeticcaremobile.hipoglikemia;

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
import com.papps.diabeticcaremobile.diabetesMelitus.Fragment_slide10;
import com.papps.diabeticcaremobile.diabetesMelitus.Fragment_slide11;
import com.papps.diabeticcaremobile.diabetesMelitus.Fragment_slide6;
import com.papps.diabeticcaremobile.diabetesMelitus.Fragment_slide7;
import com.papps.diabeticcaremobile.diabetesMelitus.Fragment_slide8;
import com.papps.diabeticcaremobile.diabetesMelitus.Fragment_slide9;

public class PenangananHipo extends AppCompatActivity {

    private ImageView prev, next, sound;
    private FragmentManager fragmentManager;
    private Fragment currentFragment;
    private MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_penanganan_hipo);

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
        if (currentFragment instanceof Fragment_slide15) {
            nextFragment = new Fragment_slide16();
        }else if (currentFragment instanceof Fragment_slide16){
            nextFragment = new Fragment_slide17();

        } else if (currentFragment instanceof Fragment_slide17){
            nextFragment = new Fragment_slide18();

        } else if (currentFragment instanceof Fragment_slide18){
            nextFragment = new Fragment_slide19();

        }else if (currentFragment instanceof Fragment_slide19){
            nextFragment = new Fragment_slide20();

        } else {
            return;
        }

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_penagananhipo, nextFragment);
        fragmentTransaction.commit();
        currentFragment = nextFragment;

    }

    private void displayPrevFragment() {
        Fragment previousFragment;
        if (currentFragment instanceof Fragment_slide15) {
            // Jika saat ini ada di Fragment1, tidak ada Fragment sebelumnya
            return;
        } else if (currentFragment instanceof Fragment_slide16) {
            previousFragment = new Fragment_slide15();
        } else if (currentFragment instanceof Fragment_slide17) {
            previousFragment = new Fragment_slide16();
        } else if (currentFragment instanceof Fragment_slide18) {
            previousFragment = new Fragment_slide17();
        } else if (currentFragment instanceof Fragment_slide19) {
            previousFragment = new Fragment_slide18();
        }else if (currentFragment instanceof Fragment_slide20) {
            previousFragment = new Fragment_slide19();
        } else {
            // Tambahkan fragment-fragment sebelumnya sesuai urutan
            // sesuai kebutuhan aplikasi Anda
            return;
        }

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_penagananhipo, previousFragment);
        fragmentTransaction.commit();
        currentFragment = previousFragment;
    }

    private void displayFragment() {
        Fragment_slide15 fragment1 = new Fragment_slide15();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_penagananhipo, fragment1);
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
        if (currentFragment instanceof Fragment_slide15) {
            soundResId = R.raw.slide15;
        } else if (currentFragment instanceof Fragment_slide16) {
            soundResId = R.raw.slide16;
        } else if (currentFragment instanceof Fragment_slide17) {
            soundResId = R.raw.slide17;
        } else if (currentFragment instanceof Fragment_slide18) {
            soundResId = R.raw.slide18;
        } else if (currentFragment instanceof Fragment_slide19) {
            soundResId = R.raw.slide19;
        }else if (currentFragment instanceof Fragment_slide20) {
            soundResId = R.raw.slide20;
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