package com.android.nfc.myapplication.adapter;

/**
 * @ClassName: BaseRecyclerViewAdapter
 * @Description:
 * @Author: wuzhi.peng
 * @Date: 2022/10/14
 */
import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedHashSet;
import java.util.List;

public class BaseRecyclerViewAdapter<T,V extends BaseViewHolder> extends RecyclerView.Adapter<V> {

    protected List<T> dataList;
    private int layoutId;
    private onItemClickListener<T> onItemClickListener;
    private onItemLongClickListener<T> tonItemLongClickListener;
    private onItemChildClickListener<T> onItemChildClickListener;
    private Context mContext;
    private Class<T> vClass;
    private LinkedHashSet<Integer> childClickViewIds = new LinkedHashSet<>();

    public BaseRecyclerViewAdapter(Context mContext,List<T> dataList,int layoutId,Class<T> vClass){
        this.mContext = mContext;
        this.dataList = dataList;
        this.layoutId = layoutId;
        this.vClass = vClass;
    }
    public BaseRecyclerViewAdapter(Context mContext,int layoutId,Class<T> vClass){
        this.mContext = mContext;
        this.layoutId = layoutId;
        this.vClass = vClass;
    }

    private LinkedHashSet<Integer> getChildClickViewIds()  {
        return childClickViewIds;
    }


    public void addChildClickViewIds(int... ids) {
        for (int id : ids) {
            childClickViewIds.add(id);
        }
    }
    @NonNull
    @Override
    public V onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (mContext == null )mContext = viewGroup.getContext();
        try {
            Constructor<V> constructor = (Constructor<V>) vClass.getConstructor(View.class);
            V holder = constructor.newInstance(newItemView(viewGroup,layoutId));
            bindChildClick(holder);
            return holder;
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull V v, @SuppressLint("RecyclerView") final int i) {
        v.setData(dataList.get(i));
        v.loadItemData(mContext,dataList.get(i),i);
        if(onItemClickListener!=null) {
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickListener.onItemClick(dataList.get(i),v,i);
                }
            });
        }
    }

    public void setDataList(List<T> list){
        dataList = list;
    }
    @Override
    public int getItemCount() {
        return dataList == null ? 0 : dataList.size();
    }

    private void bindChildClick(V holder){
        if (onItemChildClickListener!=null){
            for (Integer childClickViewId : getChildClickViewIds()) {
                View itemView = holder.itemView.findViewById(childClickViewId);
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int position = holder.getAdapterPosition();
                        onItemChildClickListener.onChildItemClick(dataList.get(position),v,position);
                    }
                });
            }
        }
    }

    private View newItemView(ViewGroup viewGroup,int layoutId){
        return LayoutInflater.from(mContext).inflate(layoutId,viewGroup,false);
    }
    public void setOnItemClickListener(onItemClickListener<T> onItemClickListener){
        this.onItemClickListener = onItemClickListener;
    }
    public void setOnItemLongClickListener(onItemLongClickListener<T> tonItemLongClickListener){
        this.tonItemLongClickListener = tonItemLongClickListener;
    }
    public void setOnItemChildClickListener(onItemChildClickListener<T> onItemChildClickListener){
        this.onItemChildClickListener = onItemChildClickListener;
    }

    public interface onItemClickListener<D>{
        void onItemClick(D itemData, View view, int position);
    }
    public interface  onItemLongClickListener<D>{
        void onItemLongClick(D data,int position);
    }
    public interface onItemChildClickListener<D>{
        void onChildItemClick(D itemData, View view, int position);
    }
}