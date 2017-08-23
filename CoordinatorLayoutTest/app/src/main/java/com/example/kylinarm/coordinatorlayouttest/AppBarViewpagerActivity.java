package com.example.kylinarm.coordinatorlayouttest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.app.AppCompatActivity;

import com.example.kylinarm.coordinatorlayouttest.fragment.ImageFragment;
import com.example.kylinarm.coordinatorlayouttest.fragment.ListFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by kylinARM on 2017/8/21.
 */

public class AppBarViewpagerActivity extends AppCompatActivity {

    @InjectView(R.id.tl_tab)
    TabLayout tlTab;
    @InjectView(R.id.vp_content)
    MyViewPager vpContent;
    @InjectView(R.id.appbar)
    AppBarLayout appbar;

    private String[] titles = {"tab1","tab2"};
    private List<Fragment> fragments = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appbarviewpager);
        ButterKnife.inject(this);
        initView();
    }

    private void initView(){
        for (int i = 0; i < titles.length; i++) {
            tlTab.addTab(tlTab.newTab().setText(titles[i]));
        }
        fragments = setFragmentList();

        vpContent.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {

            @Override
            public int getCount() {
                return titles.length;
            }

            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public CharSequence getPageTitle(int position) {
                if (null != titles) {
                    return titles[position];
                }
                return super.getPageTitle(position);
            }
        });
        tlTab.setupWithViewPager(vpContent);


    }

    private List<Fragment> setFragmentList(){
        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(new ListFragment());
        fragmentList.add(new ImageFragment());
        return fragmentList;
    }

}