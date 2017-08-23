package com.example.kylinarm.coordinatorlayouttest.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kylinarm.coordinatorlayouttest.R;
import com.example.kylinarm.coordinatorlayouttest.adapter.CLAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Administrator on 2017/8/22.
 */

public class ListFragment extends Fragment{

    @InjectView(R.id.rv_content)
    RecyclerView rvContent;

    private View view;
    private CLAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = LayoutInflater.from(getActivity()).inflate(R.layout.layout_recyclerview,null);
        ButterKnife.inject(this,view);
        initView();
        return view;
    }

    private void initView(){
        rvContent.setLayoutManager(new LinearLayoutManager(getActivity()));
        List<String> datalsit = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            datalsit.add(" item "+i);
        }
        adapter = new CLAdapter(getActivity(),datalsit);
        rvContent.setAdapter(adapter);
    }

}
