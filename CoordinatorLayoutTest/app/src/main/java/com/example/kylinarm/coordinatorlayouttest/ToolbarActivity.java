package com.example.kylinarm.coordinatorlayouttest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.kylinarm.coordinatorlayouttest.adapter.CLAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by kylinARM on 2017/8/21.
 */

public class ToolbarActivity extends AppCompatActivity{

    @InjectView(R.id.rv_content)
    RecyclerView rvContent;

    private CLAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toolbar);
        ButterKnife.inject(this);
        initView();
    }

    private void initView(){
        rvContent.setLayoutManager(new LinearLayoutManager(this));
        List<String> datalsit = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            datalsit.add(" item "+i);
        }
        adapter = new CLAdapter(this,datalsit);
        rvContent.setAdapter(adapter);
    }


}
