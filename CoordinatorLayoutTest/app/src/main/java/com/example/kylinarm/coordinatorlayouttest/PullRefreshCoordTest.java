package com.example.kylinarm.coordinatorlayouttest;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;

import com.handmark.pulltorefresh.library.PullToRefreshBase;

/**
 * Created by yetao on 2017/8/10.
 *
 * 内容摘要：
 * 系统版本：
 * 版权所有：宝润兴业
 * 修改内容：
 * 修改日期
 */

public class PullRefreshCoordTest extends PullToRefreshBase<CoordinatorView> {

    private CoordinatorView coordinatorView;

    public PullRefreshCoordTest(Context context) {
        super(context);
    }

    public PullRefreshCoordTest(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PullRefreshCoordTest(Context context, Mode mode) {
        super(context, mode);
    }

    public PullRefreshCoordTest(Context context, Mode mode, AnimationStyle animStyle) {
        super(context, mode, animStyle);
    }

    @Override
    public Orientation getPullToRefreshScrollDirection() {
        return Orientation.VERTICAL;
    }

    @Override
    protected CoordinatorView createRefreshableView(Context context, AttributeSet attrs) {
        coordinatorView = new CoordinatorView(context);
        return coordinatorView;
    }

    @Override
    protected boolean isReadyForPullEnd() {
        return false;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected boolean isReadyForPullStart() {
        // 或者判断CoordinatorView是否全部展开

        return coordinatorView.getScrollY() == 0 && coordinatorView.getmVerticalOffset() >= 0;
    }

    public CoordinatorView getCoordinatorView() {
        return coordinatorView;
    }
}
