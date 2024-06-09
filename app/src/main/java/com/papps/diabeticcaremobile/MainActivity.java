package com.papps.diabeticcaremobile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;

import com.papps.diabeticcaremobile.diabetesMelitus.DiabetesMelitus;
import com.papps.diabeticcaremobile.diabetesMelitus.Makanan;
import com.papps.diabeticcaremobile.hipoglikemia.PenangananHipo;
import com.papps.diabeticcaremobile.quis.QuisDM;
import com.papps.diabeticcaremobile.videoInteraktif.VideoInteraktif;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_main);

        CardView card = findViewById(R.id.card);
        card.setBackgroundResource(R.drawable.gambarmain);
    }

    public void kediabetesmelitus(View view) {
        startActivity(new Intent(MainActivity.this, DiabetesMelitus.class));
    }

    public void kehipo(View view) {
        startActivity(new Intent(MainActivity.this, PenangananHipo.class));
    }

    public void keMakananDM(View view) {
        startActivity(new Intent(MainActivity.this, Makanan.class));
    }

    public void ketentang(View view) {
        startActivity(new Intent(MainActivity.this, TentangAplikasi.class));
    }

    public void kevideo(View view) {
        startActivity(new Intent(MainActivity.this, VideoInteraktif.class));
    }

    public void kequis(View view) {
        startActivity(new Intent(MainActivity.this, QuisDM.class));
    }
}