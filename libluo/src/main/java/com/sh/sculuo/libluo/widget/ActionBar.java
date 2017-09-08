package com.sh.sculuo.libluo.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.sh.sculuo.libluo.R;
import com.sh.sculuo.libluo.R2;
import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by luoxiaocheng on 2016/10/31.
 */

public class ActionBar extends LinearLayout {

    @BindView(R2.id.luolib_lefticon)
    ImageView lefticon;
    @BindView(R2.id.luolib_lefttxt)
    TextView lefttxt;
    @BindView(R2.id.luolib_v_left)
    LinearLayout vLeft;
    @BindView(R2.id.luolib_title)
    TextView title;
    @BindView(R2.id.luolib_v_mid)
    FrameLayout vMid;
    @BindView(R2.id.luolib_righttxt)
    TextView righttxt;
    @BindView(R2.id.luolib_righticon)
    ImageView righticon;
    @BindView(R2.id.luolib_v_right)
    LinearLayout vRight;
    /**
     * 资源
     */
    private Drawable drawableLeft, drawableMidLeft, drawableMidRight, drawableRight;

    private String strLeft, strMid, strRight;

    private int colorLeft;

    private int colorRight;

    private int colorMid;

    private float sizeTxtSide;

    private float sizeTxtMid;

    private boolean rightSelected;

    private int leftVisible;

    private int rightVisible;

    private boolean rightEnabled;

    public ActionBar(Context context) {

        this(context, null);
    }

    public ActionBar(Context context, AttributeSet attrs) {

        this(context, attrs, 0);
    }

    public ActionBar(Context context, AttributeSet attrs, int defStyleAttr) {

        super(context, attrs, defStyleAttr);
        init(attrs, defStyleAttr);
    }

    private void init(AttributeSet attrs, int defStyle) {

        View v = View.inflate(getContext(), R.layout.luolib_view_actionbar, this);
        ButterKnife.bind(this, v);
        colorLeft = getResources().getColor(R.color.actionbar_leftTxt);
        colorRight = getResources().getColor(R.color.actionbar_rightTxt);
        colorMid = getResources().getColor(R.color.actionbar_midTxt);
        sizeTxtSide = getResources().getDimensionPixelSize(R.dimen.actionbar_sizeTxtSide_default);
        sizeTxtMid = getResources().getDimension(R.dimen.actionbar_sizeTxtMid_default);
// Load attributes
        final TypedArray a = getContext().obtainStyledAttributes(
                attrs, R.styleable.ActionBar, defStyle, 0);
        if (a != null) {
            //图片
            if (a.hasValue(R.styleable.Actionbar_leftDrawable)) {
                drawableLeft = a.getDrawable(
                        R.styleable.Actionbar_leftDrawable);
                drawableLeft.setCallback(this);
            }
            if (a.hasValue(R.styleable.Actionbar_midLeftDrawable)) {
                drawableMidLeft = a.getDrawable(
                        R.styleable.Actionbar_midLeftDrawable);
                drawableMidLeft.setCallback(this);
            }
            if (a.hasValue(R.styleable.Actionbar_midRightDrawable)) {
                drawableMidRight = a.getDrawable(
                        R.styleable.Actionbar_midRightDrawable);
                drawableMidRight.setCallback(this);
            }
            if (a.hasValue(R.styleable.Actionbar_rightDrawable)) {
                drawableRight = a.getDrawable(
                        R.styleable.Actionbar_rightDrawable);
                drawableRight.setCallback(this);
            }
            //字
            strLeft = a.getString(R.styleable.Actionbar_leftTxt);
            strMid = a.getString(R.styleable.Actionbar_midTxt);
            strRight = a.getString(R.styleable.Actionbar_rightTxt);

            //色值
            colorLeft = a.getColor(R.styleable.Actionbar_leftTxtColor, colorLeft);
            colorMid = a.getColor(R.styleable.Actionbar_midTxtColor, colorMid);
            colorRight = a.getColor(R.styleable.Actionbar_rightTxtColor, colorRight);
            // Use getDimensionPixelSize or getDimensionPixelOffset when dealing with
            // values that should fall on pixel boundaries.
            sizeTxtMid = a.getDimension(R.styleable.Actionbar_midTxtSize, sizeTxtMid);
            sizeTxtSide = a.getDimension(R.styleable.Actionbar_sideTxtSize, sizeTxtSide);
            a.recycle();
        }
        initComp();
        initData();
    }

    protected void initComp() {
        lefttxt.setTextColor(colorLeft);
        lefttxt.setTextSize(TypedValue.COMPLEX_UNIT_PX, sizeTxtSide);
        title.setTextColor(colorMid);
        title.setTextSize(TypedValue.COMPLEX_UNIT_PX, sizeTxtMid);
        righttxt.setTextColor(colorRight);
        righttxt.setTextSize(TypedValue.COMPLEX_UNIT_PX, sizeTxtSide);
    }

    protected void initData() {
        //左
        if (drawableLeft != null || !TextUtils.isEmpty(strLeft)) {
            vLeft.setVisibility(View.VISIBLE);
            lefticon.setImageDrawable(drawableLeft);
            lefttxt.setText(TextUtils.isEmpty(strLeft) ? "" : strLeft);
        }
        //中
        if (!TextUtils.isEmpty(strMid)) {
            title.setText(strMid);
        }
        title.setCompoundDrawablesWithIntrinsicBounds(drawableMidLeft, null, drawableMidRight, null);
        //右
        if (drawableRight != null || !TextUtils.isEmpty(strRight)) {
            vRight.setVisibility(View.VISIBLE);
            righticon.setImageDrawable(drawableRight);
            righttxt.setText(TextUtils.isEmpty(strRight) ? "" : strRight);
        }

    }

    public ActionBar setNavigationOnClickListener(OnClickListener leftOnClickListener) {

        vLeft.setVisibility(View.VISIBLE);
        vLeft.setOnClickListener(leftOnClickListener);
        return this;
    }

    public ActionBar setNavigationOnClickListener(String left, OnClickListener leftOnClickListener) {
        lefttxt.setText(left);
        vLeft.setVisibility(View.VISIBLE);
        vLeft.setOnClickListener(leftOnClickListener);
        return this;
    }

    public ActionBar setRightOnClickListener(OnClickListener rightOnClickListener) {

        vRight.setVisibility(View.VISIBLE);
        vRight.setOnClickListener(rightOnClickListener);
        return this;
    }

    public ActionBar setRightOnClickListener(String right, OnClickListener rightOnClickListener) {
        righttxt.setText(right);
        vRight.setVisibility(View.VISIBLE);
        vRight.setOnClickListener(rightOnClickListener);
        return this;
    }

    public void setMidOnClickListener(OnClickListener midOnClickListener) {

        vMid.setOnClickListener(midOnClickListener);
    }

    public void setTitle(String txt) {

        try {
            strMid = txt;
            title.setText(txt);
            vMid.setVisibility(View.VISIBLE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setRightTxt(String txt) {

        strRight = txt;
        righttxt.setText(txt);
    }

    public void setLeftDrawable(int drawable) {

        lefticon.setImageResource(drawable);
        vLeft.setVisibility(View.VISIBLE);
        lefticon.setVisibility(View.VISIBLE);
    }

    public void setMidTxtSize(int midTxtColor) {

        title.setTextSize(midTxtColor);
    }

    public void setLeftTxtSize(int rightTxtColor) {

        lefttxt.setTextSize(rightTxtColor);
        vLeft.setVisibility(View.VISIBLE);
    }

    public void setRightTxtSize(int rightTxtColor) {

        righttxt.setTextSize(rightTxtColor);
        vRight.setVisibility(View.VISIBLE);
    }

    public void setMidTxtColor(int midTxtColor) {

        this.colorMid = midTxtColor;
        title.setTextColor(colorMid);
    }

    public void setRightTxtColor(int rightTxtColor) {

        this.colorRight = rightTxtColor;
        righttxt.setTextColor(colorRight);
    }

    public void setDrawableRight(int drawableRight) {

        setDrawableRight(getResources().getDrawable(drawableRight));
    }

    public void setDrawableRight(Drawable drawableRight) {

        this.drawableRight = drawableRight;
        vRight.setVisibility(View.VISIBLE);
        righticon.setImageDrawable(drawableRight);
    }

    public void setLeftVisible(int leftVisible) {

        this.leftVisible = leftVisible;
        vLeft.setVisibility(leftVisible);
    }

    public String getMidTxt() {

        return title.getText().toString().trim();
    }

    public void setLeftTxt(String strLeft) {

        this.strLeft = strLeft;
        lefttxt.setText(strLeft);
        vLeft.setVisibility(View.VISIBLE);
    }

    public void setRightSelected(boolean rightSelected) {

        this.rightSelected = rightSelected;
        vRight.setSelected(rightSelected);
    }

    public boolean isRightSelected() {

        return rightSelected;
    }

    public void setRightVisible(int rightVisible) {

        this.rightVisible = rightVisible;
        vRight.setVisibility(rightVisible);
    }

    public void setRightEnabled(boolean rightEnabled) {

        this.rightEnabled = rightEnabled;
    }

    private void addMidView(View v) {

        vMid.removeAllViews();
        vMid.addView(v);
    }

    public View getLeftView() {
        return vLeft;
    }

    public void addMidView(View v, RelativeLayout.LayoutParams lp) {

        vMid.removeAllViews();
        vMid.addView(v, lp);
    }
}
