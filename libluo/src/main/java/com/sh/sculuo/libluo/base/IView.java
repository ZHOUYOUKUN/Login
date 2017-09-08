package com.sh.sculuo.libluo.base;

import android.app.Activity;

/**
 * Created by luoxiaocheng on 2017/8/1.
 */

public interface IView {
    void showLoading();

    void dismissLoading();

    Activity getActivty();
}
