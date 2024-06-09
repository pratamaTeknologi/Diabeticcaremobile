package com.papps.diabeticcaremobile.diabetesMelitus;

import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.papps.diabeticcaremobile.R;


public class Fragment_slide9 extends Fragment {

    public Fragment_slide9() {
        // Required empty public constructor
    }

    private CardView cardView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_slide9, container, false);
        cardView = view.findViewById(R.id.cardslide1);
        cardView.setBackgroundResource(R.drawable.slide9);
        return view;
    }
}