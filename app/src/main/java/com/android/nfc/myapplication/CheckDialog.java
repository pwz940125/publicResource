package com.android.nfc.myapplication;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

/**
 * @ClassName: CheckDialog
 * @Description:
 * @Author: wuzhi.peng
 * @Date: 2022/10/13
 */
public class CheckDialog extends Dialog implements View.OnClickListener {
    private View view;
    private ImageView mClear;
    private TextView mRelease;
    private ReleaseBean mData;
    private OnReleaseClick click;
    public CheckDialog(@NonNull Context context) {
        this(context,R.style.CheckDialogStyle);
    }

    public CheckDialog(@NonNull Context context,ReleaseBean bean) {
        this(context,R.style.CheckDialogStyle);
        mData = bean;
        initData(mData);
    }


    public CheckDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
        view = LayoutInflater.from(context).inflate(R.layout.layout_check_dialog,null,false);
        setContentView(view);
        mClear = findViewById(R.id.clear);
        mRelease = findViewById(R.id.tv_release);
        mClear.setOnClickListener(this);
        mRelease.setOnClickListener(this);
    }

    private void initData(ReleaseBean bean){
        ((TextView)view.findViewById(R.id.tv_admin)).setText(bean.getAdmin());
         ((TextView)view.findViewById(R.id.tv_license_plate)).setText(bean.getLicense());
         ((TextView)view.findViewById(R.id.tv_id_card_value)).setText(bean.getIdCard());
         ((TextView)view.findViewById(R.id.tv_phone_number)).setText(bean.getPhone());
         ((TextView)view.findViewById(R.id.tv_person_num)).setText(bean.getPersons()+"人");
         ((TextView)view.findViewById(R.id.tv_transit_checkpoint_value)).setText(bean.getCheckPoint());
         ((TextView)view.findViewById(R.id.tv_entry_time_value)).setText(bean.getEntryTime());
         ((TextView)view.findViewById(R.id.tv_delay_time)).setText(bean.getDelayTime()+"h");
        ((TextView)view.findViewById(R.id.tv_delay_time)).setTextColor(bean.getDelayTime()<5? Color.parseColor("#009688"):Color.parseColor("#FF0000"));
    }

    @Override
    public void show() {
        super.show();
       getWindow().setLayout(DisplayUtil.getScreenWidth(getContext()) - DisplayUtil.dp2px(30), WindowManager.LayoutParams.WRAP_CONTENT);
    }

    public void setClick(OnReleaseClick click) {
        this.click = click;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.clear:
                dismiss();
                break;
            case R.id.tv_release:
                if (click!=null) {
                    click.onReleaseClick();
                }
                dismiss();
                break;
        }
    }

    interface OnReleaseClick{
        void onReleaseClick();
    }
}
