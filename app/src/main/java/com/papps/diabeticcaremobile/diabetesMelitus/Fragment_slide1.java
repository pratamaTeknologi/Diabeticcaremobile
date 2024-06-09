package com.papps.diabeticcaremobile.diabetesMelitus;

import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.papps.diabeticcaremobile.R;

public class Fragment_slide1 extends Fragment {

    public Fragment_slide1() {
        // Required empty public constructor
    }

    private CardView card;
    private TextView textView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_slide1, container, false);

        // Inisialisasi CardView
        card = view.findViewById(R.id.cardslide1);
        card.setBackgroundResource(R.drawable.slide1);
        textView = view.findViewById(R.id.textview);

        // Mengambil teks dari TextView

        return view;


    }
}
