package com.sh.sculuo.libluo.base;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.MotionEvent;

import com.sh.sculuo.libluo.help.AppManager;
import com.sh.sculuo.libluo.listener.BackGestureListener;
import com.umeng.socialize.UMShareAPI;

import butterknife.ButterKnife;

/**
 **/
public abstract class BaseActivity extends AppCompatActivity {
    protected String TAG = BaseActivity.class.getSimpleName();
    protected BaseActivity activity;

    /**
     * 手势监听
     */
    private GestureDetector mGestureDetector;

    /**
     * 是否需要监听手势关闭功能
     */
    private boolean mNeedBackGesture = false;
    protected boolean SCREEN_ORIENTATION_PORTRAIT = true;// 是否禁止横竖屏切换

    @Override
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        if (SCREEN_ORIENTATION_PORTRAIT) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);// 禁止横屏
        }
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        activity = this;
        // 添加Activity到堆栈
        AppManager.getAppManager().addActivity(this);
        initGestureDetector();
        initData();
    }

    protected abstract int getLayoutId();

    private void initGestureDetector() {

        if (mGestureDetector == null) {
            mGestureDetector = new GestureDetector(getApplicationContext(),
                    new BackGestureListener(this));
        }
    }

    protected void initData() {

    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {

        if (mNeedBackGesture) {
            return mGestureDetector.onTouchEvent(ev) || super.dispatchTouchEvent(ev);
        }
        return super.dispatchTouchEvent(ev);
    }

    /**
     * 设置是否进行手势监听
     */
    protected void setNeedBackGesture(boolean mNeedBackGesture) {

        this.mNeedBackGesture = mNeedBackGesture;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // 结束Activity&从堆栈中移除
        AppManager.getAppManager().finishActivity(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
    }

}
