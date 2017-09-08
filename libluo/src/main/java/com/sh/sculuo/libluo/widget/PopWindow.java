package com.sh.sculuo.libluo.widget;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.sh.sculuo.libluo.R;
import com.sh.sculuo.libluo.R2;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by luoxiaocheng on 2017/6/27.
 */

public class PopWindow extends PopupWindow {
    @BindView(R2.id.luolib_message)
    TextView message;
    @BindView(R2.id.luolib_left)
    TextView left;
    @BindView(R2.id.luolib_right)
    TextView right;

    @BindView(R2.id.luolib_line)
    View line;
    private View v;

    public PopWindow(Context context) {
        super(-1, -1);
        v = View.inflate(context, R.layout.luolib_pop_window, null);
        setContentView(v);
        ButterKnife.bind(this, v);
        setOutsideTouchable(true);
        setTouchable(true);
        setFocusable(true);
        //实例化一个ColorDrawable颜色为半透明
        ColorDrawable dw = new ColorDrawable(0xb0000000);
        //设置SelectPicPopupWindow弹出窗体的背景
        this.setBackgroundDrawable(dw);
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
    }

    public PopWindow setMessage(String msg) {
        message.setText(msg);
        return this;
    }

    public PopWindow setOnLeftClick(String leftTxt, final WindowCallback click) {
        left.setText(leftTxt);
        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (click != null) {
                    click.onClick(PopWindow.this, view);
                }
            }
        });
        return this;
    }

    public PopWindow setOnRightClick(String rightTxt, final WindowCallback click) {
        right.setText(rightTxt);
        right.setVisibility(View.VISIBLE);
        line.setVisibility(View.VISIBLE);
        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (click != null) {
                    click.onClick(PopWindow.this, view);
                }
            }
        });
        return this;
    }

    @OnClick(R2.id.luolib_v_content)
    public void onViewClicked() {
    }

    public interface WindowCallback {
        void onClick(PopWindow win, View v);
    }
}
