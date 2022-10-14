package com.android.nfc.myapplication.adapter;

/**
 * @ClassName: BaseViewHolder
 * @Description:
 * @Author: wuzhi.peng
 * @Date: 2022/10/14
 */
import android.content.Context;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public abstract class BaseViewHolder<T> extends RecyclerView.ViewHolder {

    public  int currentPosition;
    private  T data;
    public BaseViewHolder(@NonNull View itemView) {
        super(itemView);
        initItemView(itemView);
    }
    protected abstract void initItemView(View view);
    public abstract void loadItemData(Context context, T data, int position);
    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        itemView.setOnClickListener(onClickListener);
    }
}