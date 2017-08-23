package com.example.kylinarm.coordinatorlayouttest.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kylinarm.coordinatorlayouttest.R;

import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/8/22.
 */

public class ImageFragment extends Fragment {

    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = LayoutInflater.from(getActivity()).inflate(R.layout.layout_image,null);
        ButterKnife.inject(this,view);
        return view;
    }
}
