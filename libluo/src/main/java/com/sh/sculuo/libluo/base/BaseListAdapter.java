package com.sh.sculuo.libluo.base;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by luoxiaocheng on 2017/7/6.
 */

public abstract class BaseListAdapter<T> extends BaseAdapter {
    private List<T> datas;

    public abstract void onBindViewHolder(BaseHold holder, int position);

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        BaseHold hold;
        if (view==null){
            view=View.inflate(getContext(),getLayoutId(),null);
            hold=getHold(view);
            view.setTag(hold);
        }else{
            hold= (BaseHold) view.getTag();
        }
        onBindViewHolder(hold,i);
        return view;
    }

    @Override
    public long getItemId ( int position ) {

        return 0;
    }
    public int getCount() {
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

    protected ViewGroup.LayoutParams getLayoutParams() {
        return null;
    }

    protected View getItemView() {
        return null;
    }

    protected abstract BaseHold getHold(View v);

}
