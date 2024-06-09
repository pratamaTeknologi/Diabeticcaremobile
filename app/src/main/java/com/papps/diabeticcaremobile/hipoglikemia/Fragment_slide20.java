package com.papps.diabeticcaremobile.hipoglikemia;

import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.papps.diabeticcaremobile.R;

public class Fragment_slide20 extends Fragment {



    public Fragment_slide20() {
        // Required empty public constructor
    }

   private CardView cardView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_slide20, container, false);
        cardView = view.findViewById(R.id.cardslide1);
        cardView.setBackgroundResource(R.drawable.slide20);
        return view;
    }
}