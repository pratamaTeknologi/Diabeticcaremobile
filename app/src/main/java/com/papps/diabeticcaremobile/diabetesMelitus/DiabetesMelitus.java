package com.papps.diabeticcaremobile.diabetesMelitus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;

import com.papps.diabeticcaremobile.R;

public class DiabetesMelitus extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_diabetes_melitus);
    }

    public void back(View view) {
        onBackPressed();
    }

    public void kepengertianDM(View view) {
        startActivity(new Intent(DiabetesMelitus.this, Pengertian.class));
    }

    public void keklasifikasiDM(View view) {
        startActivity(new Intent(DiabetesMelitus.this, Klasifikasi.class));
    }

    public void kefaktorDM(View view) {
        startActivity(new Intent(DiabetesMelitus.this, Faktor.class));
    }

    public void kegejalaDM(View view) {
        startActivity(new Intent(DiabetesMelitus.this, Gejala.class));
    }

    public void keMakananDM(View view) {
        startActivity(new Intent(DiabetesMelitus.this, Makanan.class));
    }
}