package com.sh.sculuo.libluo.base;

/**
 * Created by luoxiaocheng on 2017/8/1.
 */

public interface IPresenter<T extends IView> {
    void attachView(T view);

    void detachView();

    void subscribe();

    void unsubscribe();
}
