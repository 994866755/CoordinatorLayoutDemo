package com.example.kylinarm.coordinatorlayouttest;

import android.content.Context;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.example.kylinarm.coordinatorlayouttest.fragment.ImageFragment;
import com.example.kylinarm.coordinatorlayouttest.fragment.ListFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by yetao on 2017/8/10.
 *
 * 内容摘要：
 * 系统版本：
 * 版权所有：宝润兴业
 * 修改内容：
 * 修改日期
 */

public class CoordinatorView extends FrameLayout {

    @InjectView(R.id.tl_tab)
    TabLayout tlTab;
    @InjectView(R.id.vp_content)
    MyViewPager vpContent;
    @InjectView(R.id.appbar)
    AppBarLayout appbar;

    private View contentView;
    //记录是否处于展开状态
    public int mVerticalOffset = 0;
    private String[] titles = {"tab1","tab2"};
    private List<Fragment> fragments = new ArrayList<>();
    private Context context;
    private FragmentActivity fActivity;

    public CoordinatorView(Context context) {
        super(context);
        this.context = context;

        if (context instanceof FragmentActivity){
            fActivity = (FragmentActivity) context;
        }

        init();
    }

    private void init(){
        contentView = LayoutInflater.from(getContext()).inflate(R.layout.activity_appbarviewpager,null);
        contentView.setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        addView(contentView);
        ButterKnife.inject(this,contentView);
        appbar.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                mVerticalOffset = verticalOffset;
            }
        });
    }

    public void initView(){
        for (int i = 0; i < titles.length; i++) {
            tlTab.addTab(tlTab.newTab().setText(titles[i]));
        }
        fragments = setFragmentList();
        vpContent.setAdapter(new FragmentPagerAdapter(fActivity.getSupportFragmentManager()) {

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

    public int getmVerticalOffset() {
        return mVerticalOffset;
    }

}
