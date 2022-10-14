package com.android.nfc.myapplication.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.android.nfc.myapplication.R;
import com.android.nfc.myapplication.ReleaseBean;

/**
 * @ClassName: ReleaseViewHolder
 * @Description:
 * @Author: wuzhi.peng
 * @Date: 2022/10/14
 */
public class ReleaseViewHolder extends BaseViewHolder<ReleaseBean> {

    private TextView mTvAdmin;
    private TextView mTvLicense;
    private TextView mTvIdCard;
    private TextView mTvPhone;
    private TextView mTvPersons;
    private TextView mTvCheckPoint;
    private TextView mTvEntryTime;
    private TextView mTvDelayTime;



    public ReleaseViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    @Override
    protected void initItemView(View view) {
        mTvAdmin = view.findViewById(R.id.tv_admin);
        mTvLicense= view.findViewById(R.id.tv_license_plate);
        mTvIdCard= view.findViewById(R.id.tv_id_card_value);
        mTvPhone= view.findViewById(R.id.tv_phone_number);
        mTvPersons= view.findViewById(R.id.tv_person_num);
        mTvCheckPoint= view.findViewById(R.id.tv_transit_checkpoint_value);
        mTvEntryTime= view.findViewById(R.id.tv_entry_time_value);
        mTvDelayTime= view.findViewById(R.id.tv_delay_time);
    }

    @Override
    public void loadItemData(Context context, ReleaseBean data, int position) {
        mTvAdmin.setText(data.getAdmin());
        mTvLicense.setText(data.getLicense());
        mTvIdCard.setText(data.getIdCard());
        mTvPhone.setText(data.getPhone());
        mTvPersons.setText(data.getPersons()+"人");
        mTvCheckPoint.setText(data.getCheckPoint());
        mTvEntryTime.setText(data.getEntryTime());
        mTvDelayTime.setText(String.format(context.getString(R.string.delayTime),data.getDelayTime()));
        mTvDelayTime.setTextColor(data.getDelayTime()<5? Color.parseColor("#009688"):Color.parseColor("#FF0000"));
    }
}
