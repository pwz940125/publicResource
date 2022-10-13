package com.android.nfc.myapplication;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.PopupWindow;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;

import java.util.List;
import com.chad.library.adapter.base.listener.OnItemClickListener;

/**
 * @ClassName: ItemSelectPopUpWindow
 * @Description:
 * @Author: wuzhi.peng
 * @Date: 2022/10/12
 */
public class ItemSelectPopUpWindow extends PopupWindow implements OnItemClickListener {

    private Context mContext;
    private List<String> mData;
    private View contentView;
    private TextView mValue;
    private RecyclerView mRc;
    private OnItemClick onItemClick;
    private int popupWidth;
    private int popupHeight;

    public ItemSelectPopUpWindow(Context context, List<String> data){
        super(context);
        mContext = context;
        mData = data;
        contentView =  LayoutInflater.from(context).inflate(R.layout.layout_item_select_popwindow,null);

        setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        setBackgroundDrawable(new BitmapDrawable());
        setOutsideTouchable(true);
        setContentView(contentView);
        mRc = contentView.findViewById(R.id.recycler);
    }

    public void setOnItemClick(OnItemClick click){
        onItemClick = click;
    }

    private final BaseQuickAdapter<String, BaseViewHolder> mAdapter = new BaseQuickAdapter<String, BaseViewHolder>(R.layout.layout_item_select_rc_item) {
        @Override
        protected void convert(BaseViewHolder baseViewHolder, String s) {
            baseViewHolder.setText(R.id.tv,s);
        }
    };

    public void showUp(View anchor,int showWidth) {
        setWidth(showWidth);
        if (anchor instanceof TextView) {
            mValue = (TextView) anchor;
        }
        mAdapter.setNewInstance(mData);
        mAdapter.setOnItemClickListener(this);
        mRc.setLayoutManager(new LinearLayoutManager(mContext));
        mRc.setAdapter(mAdapter);
        super.showAtLocation(anchor, Gravity.BOTTOM, 0, 0);
    }

    public void show(View anchor,int showWidth,int offX,int offY) {
        setWidth(showWidth);
        show(anchor,offX,offY);
    }

    public void show(View anchor,int offX,int offY) {
        if (anchor instanceof TextView) {
            mValue = (TextView) anchor;
        }
        mAdapter.setNewInstance(mData);
        mAdapter.setOnItemClickListener(this);
        mRc.setLayoutManager(new LinearLayoutManager(mContext));
        mRc.setAdapter(mAdapter);
        super.showAsDropDown(anchor,offX,offY);
    }

    @Override
    public void onItemClick(@NonNull BaseQuickAdapter<?, ?> adapter, @NonNull View view, int position) {
        mValue.setText(mData.get(position));
        if (onItemClick!=null) {
            onItemClick.onItemClick(position,view);
        }
        dismiss();
    }

    interface OnItemClick{
        void onItemClick(int position,View view);
    }
}
