package com.example.kylinarm.coordinatorlayouttest;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by Administrator on 2017/8/22.
 */

public class MyViewPager extends ViewPager {

    private boolean bol;

    public void setBol(boolean bol) {
        this.bol = bol;
    }

    public MyViewPager(Context context) {
        super(context);
    }

    public MyViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (bol){
            return true;
        }
        return super.dispatchTouchEvent(ev);
    }

}
