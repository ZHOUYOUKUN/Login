package com.sh.sculuo.libluo.base;

/**
 * Created by luoxiaocheng on 2017/8/1.
 */

public abstract class BasePresenter<T extends IView> implements IPresenter<T> {
    protected T view;

    @Override
    public void detachView() {
        view = null;
    }
}
