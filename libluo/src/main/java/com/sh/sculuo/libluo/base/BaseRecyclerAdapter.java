package com.sh.sculuo.libluo.base;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by luoxiaocheng on 2017/7/6.
 */

public abstract class BaseRecyclerAdapter<T> extends RecyclerView.Adapter<BaseHold> {
    private List<T> datas;

    @Override
    public BaseHold onCreateViewHolder(ViewGroup parent, int viewType) {
        View v;
        if (getLayoutId() != 0) {
            v = View.inflate(getContext(), getLayoutId(), null);
        } else {
            v = getItemView();
        }
        if (v == null)
            throw new NullPointerException("请初始化layout");
        else {
            RecyclerView.LayoutParams lp = getLayoutParams();
            if (lp != null)
                v.setLayoutParams(lp);
            return getHold(v);
        }
    }

    @Override
    public int getItemCount() {
        return getDatas().size();
    }

    public List<T> getDatas() {
        if (datas == null)
            datas = new ArrayList<>();
        return datas;
    }

    public void setDatas(List<T> datas) {
        this.datas = datas;
    }

    public T getItem(int position) {
        return getDatas().get(position);
    }

    protected abstract int getLayoutId();

    protected abstract Context getContext();

    protected RecyclerView.LayoutParams getLayoutParams() {
        RecyclerView.LayoutParams lp = new RecyclerView.LayoutParams(-1, -2);
        return lp;
    }

    protected View getItemView() {
        return null;
    }

    protected abstract BaseHold getHold(View v);

}
