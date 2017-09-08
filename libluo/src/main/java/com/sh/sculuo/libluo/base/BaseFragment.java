package com.sh.sculuo.libluo.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by luoxiaocheng on 2017/5/20.
 */

public abstract class BaseFragment extends Fragment {

    protected static String TAG;

    protected boolean isLoad, isVisibleToUser;

    protected abstract int getLayoutId();

    private View v;
    protected Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (v == null)
            v = inflater.inflate(getLayoutId(), null, false);
        unbinder = ButterKnife.bind(this, v);
        return v;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        TAG = getClass().getSimpleName();
        super.onActivityCreated(savedInstanceState);
        load();
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        this.isVisibleToUser = isVisibleToUser;
        load();
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
    private void load() {
        if (isVisibleToUser && !isLoad && v != null) {
            isLoad = true;
            requestData();
        }
    }

    protected void requestData() {

    }

}
