package com.android.nfc;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.android.nfc.myapplication.R;

/**
 * @ClassName: SpinnerView
 * @Description:
 * @Author: wuzhi.peng
 * @Date: 2022/10/12
 */
public class SpinnerView extends LinearLayout {
    private String title = "";
    private View mRootView;
    private TextView mTvTitle;
    public SpinnerView(Context context) {
        this(context,null);
    }

    public SpinnerView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,-1);
    }

    public SpinnerView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mRootView = LayoutInflater.from(context).inflate(R.layout.layout_spinner,this);
        TypedArray typedArray = context.obtainStyledAttributes(attrs,R.styleable.spinner);
        title = typedArray.getString(R.styleable.spinner_title_name);
        typedArray.recycle();
        initView();
        initData();
    }

    private void initData() {
        mTvTitle.setText(title);
    }

    private void initView() {
        mTvTitle = mRootView.findViewById(R.id.tv_title);
    }

    public TextView getTitleView(){
        return mTvTitle;
    }

    public void setTitle(String title){
        mTvTitle.setText(title);
    }

    @Override
    public View getRootView() {
        return mRootView;
    }
}
