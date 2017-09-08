package com.sh.sculuo.libluo.base;

/**
 * Created by luoxiaocheng on 2017/8/1.
 */

public abstract class BasePresenterActivity extends BaseActivity implements IView {
    protected BasePresenter presenter;

    protected abstract BasePresenter<IView> createPresenter();

    @Override
    protected void onDestroy() {
        presenter.detachView();
        super.onDestroy();
    }
}
