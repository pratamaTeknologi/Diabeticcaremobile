package com.papps.diabeticcaremobile.quis;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
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

public class QuisDM5 extends AppCompatActivity {

    private RadioButton benar,salah;
    private Button cek,main;
    private Dialog result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_quis_dm5);

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

    private void popupResult() {
        result = new Dialog(this);
        result.setContentView(R.layout.activity_result);
        result.show();

        main = result.findViewById(R.id.main);
        main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    private void cek() {
        cek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (benar.isChecked()) {
                    // Jawaban benar
                    AlertDialog.Builder builder = new AlertDialog.Builder(QuisDM5.this);
                    builder.setMessage("Jawaban Anda benar!\n\nBerikan minuman manis 150-200 ml (teh manis atau jus buah) atau 2-3 sendok teh sirup atau madu untuk membantu meningkatkan kadar gula darah.")
                            .setPositiveButton("LANJUT", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    // Lanjut ke Activity selanjutnya
                                    popupResult();
                                }
                            });
                    builder.create().show();
                } else {
                    // Jawaban salah
                    Toast.makeText(QuisDM5.this, "Jawaban Anda salah!", Toast.LENGTH_SHORT).show();
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
        startActivity(new Intent(QuisDM5.this, MainActivity.class));
    }
}