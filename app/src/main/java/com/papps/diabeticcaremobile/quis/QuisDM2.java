package com.papps.diabeticcaremobile.quis;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.Toast;

import com.papps.diabeticcaremobile.MainActivity;
import com.papps.diabeticcaremobile.R;

public class QuisDM2 extends AppCompatActivity {

    private RadioButton benar,salah;
    private Button cek;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_quis_dm2);

        initView();
        cek();

        benar.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // RadioButton1 dipilih, ubah status RadioButton2 menjadi unchecked
                    salah.setChecked(false);
                }
            }
        });

        salah.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // RadioButton2 dipilih, ubah status RadioButton1 menjadi unchecked
                    benar.setChecked(false);
                }
            }
        });
    }

    private void cek() {
        cek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (salah.isChecked()) {
                    // Jawaban benar
                    AlertDialog.Builder builder = new AlertDialog.Builder(QuisDM2.this);
                    builder.setMessage("Jawaban Anda benar!\n\nDiabetes tipe gestasional merupakan gangguan toleransi glukosa berbagai derajat yang ditemukan pertama kali saat kehamilan.")
                            .setPositiveButton("LANJUT", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    // Lanjut ke Activity selanjutnya
                                    Intent intent = new Intent(QuisDM2.this, QuisDM3.class);
                                    startActivity(intent);
                                    finish();
                                }
                            });
                    builder.create().show();
                } else {
                    // Jawaban salah
                    Toast.makeText(QuisDM2.this, "Jawaban Anda salah!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void initView() {
        benar = findViewById(R.id.benar);
        salah = findViewById(R.id.salah);
        cek = findViewById(R.id.cek);
    }

    public void back(View view) {
        onBackPressed();
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(QuisDM2.this, MainActivity.class));
    }
}