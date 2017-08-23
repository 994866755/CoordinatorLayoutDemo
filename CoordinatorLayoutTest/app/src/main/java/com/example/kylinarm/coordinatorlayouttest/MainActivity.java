package com.example.kylinarm.coordinatorlayouttest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
    }

    @OnClick({R.id.btn_toolbar, R.id.btn_collapsingtoolbar, R.id.btn_appbar, R.id.btn_appbarviewpager, R.id.btn_cr})
    public void click(View v){
        switch (v.getId()){
            case R.id.btn_toolbar:
                intentHelper(ToolbarActivity.class);
                break;
            case R.id.btn_collapsingtoolbar:
                intentHelper(CollapsingToolbarLayoutActivity.class);
                break;
            case R.id.btn_appbar:
                intentHelper(AppBarLayoutActivity.class);
                break;
            case R.id.btn_appbarviewpager:
                intentHelper(AppBarViewpagerActivity.class);
                break;
            case R.id.btn_cr:
                intentHelper(RefreshFoldActivity.class);
                break;
        }
    }


    private void intentHelper(Class cls){
        Intent intent = new Intent(MainActivity.this,cls);
        startActivity(intent);
    }

}
