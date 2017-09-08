package com.sh.sculuo.libluo.callback;

import android.view.View;
import android.view.ViewGroup;

public interface OnRecyleClickListener<T> {
    void onItemClick(ViewGroup parent, View view, T t, int position);

    boolean onItemLongClick(ViewGroup parent, View view, T t, int position);
}