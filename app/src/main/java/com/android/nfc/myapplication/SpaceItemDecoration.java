package com.android.nfc.myapplication;

import android.graphics.Rect;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/**
 * @ClassName: SpaceItemDecoration
 * @Description:
 * @Author: wuzhi.peng
 * @Date: 2022/10/13
 */
public class SpaceItemDecoration extends RecyclerView.ItemDecoration {
    private int leftRight;
    private int topBottom;
    private boolean firstNeedTop;
    public SpaceItemDecoration(int leftRight,int topBottom,boolean firstNeedTop) {
        this.leftRight = leftRight;
        this.topBottom = topBottom;
        this.firstNeedTop = firstNeedTop;
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        LinearLayoutManager layoutManager = (LinearLayoutManager) parent.getLayoutManager();
        //竖直方向的
        if (layoutManager.getOrientation() == LinearLayoutManager.VERTICAL) {
            //最后一项需要 bottom
            if (parent.getChildAdapterPosition(view) == layoutManager.getItemCount() - 1) {
                outRect.bottom = topBottom;
            }
            if(!firstNeedTop&&parent.getChildAdapterPosition(view)==0){
                outRect.top = 0;
            }else{
                outRect.top = topBottom;
            }
            outRect.left = leftRight;
            outRect.right = leftRight;
        } else {
            //最后一项需要right
            if (parent.getChildAdapterPosition(view) != layoutManager.getItemCount() - 1) {
                outRect.right = leftRight;
            }
            outRect.top = topBottom;
            outRect.left = 0;
            outRect.bottom = topBottom;
        }
    }
}
