package com.hencoder.hencoderpracticedraw6;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hencoder.hencoderpracticedraw6.practice.PracticeAnimatedMap;

public class AnimateMapFragment extends Fragment {
    public static Fragment newInstance() {
        return new AnimateMapFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.practice_animated_map, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        PracticeAnimatedMap map = (PracticeAnimatedMap) view.findViewById(R.id.map);
        map.startAnim();
    }
}
