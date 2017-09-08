package com.sh.sculuo.libluo.callback;

import android.view.View;
import android.view.ViewGroup;

public abstract class OnRecyleItemClickListener<T> implements OnRecyleClickListener<T> {
    @Override
    public boolean onItemLongClick(ViewGroup parent, View view, T t, int position) {
        return false;
    }
}