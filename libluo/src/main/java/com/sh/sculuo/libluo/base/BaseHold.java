package com.sh.sculuo.libluo.base;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import butterknife.ButterKnife;

public class BaseHold extends RecyclerView.ViewHolder {

    public BaseHold(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}