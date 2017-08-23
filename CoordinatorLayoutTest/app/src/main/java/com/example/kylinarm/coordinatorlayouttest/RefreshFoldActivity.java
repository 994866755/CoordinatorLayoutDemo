package com.example.kylinarm.coordinatorlayouttest;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.handmark.pulltorefresh.library.PullToRefreshBase;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by kylinARM on 2017/8/23.
 */

public class RefreshFoldActivity extends AppCompatActivity{

    @InjectView(R.id.pull)
    PullRefreshCoordTest pull;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refresh_fold);
        ButterKnife.inject(this);
        initView();
    }

    private void initView(){
        pull.getRefreshableView().initView();
        pull.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener<CoordinatorView>() {
            @Override
            public void onRefresh(PullToRefreshBase<CoordinatorView> refreshView) {
                // todo 下拉操作
                setData();
            }
        });
    }

    private void setData(){
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (pull.isRefreshing()){
                    pull.onRefreshComplete();
                }
            }
        },1000);
    }

}
