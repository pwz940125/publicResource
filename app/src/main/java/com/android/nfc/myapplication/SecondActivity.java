package com.android.nfc.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity {

    private RecyclerView mRc;
    private List<ReleaseBean> data = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        initView();
        initData();
    }

    private void initData() {
        for (int i = 0; i < 10; i++) {
            ReleaseBean bean = new ReleaseBean();
            bean.setAdmin("张三");
            bean.setLicense("黑E12345");
            bean.setIdCard("230221199709161534");
            bean.setPhone("18746362313");
            bean.setCheckPoint("大广高速卡口");
            bean.setPersons(3);
            bean.setEntryTime("2022-10-10 10:30:02");
            bean.setDelayTime(i<5 ? 2.3f : 5.3f);
            bean.setRelease(false);
            data.add(bean);
        }
        mRc.setLayoutManager(new LinearLayoutManager(this));
        mRc.addItemDecoration(new SpaceItemDecoration(0,DisplayUtil.dp2px(20),true));
        mRc.setAdapter(mAdapter);
        mAdapter.setNewInstance(data);
        mAdapter.addChildClickViewIds(R.id.tv_release);
        mAdapter.setOnItemChildClickListener((adapter, view, position) -> {
            if (view.getId() == R.id.tv_release){
                CheckDialog checkDialog = new CheckDialog(this,data.get(position));
                checkDialog.setClick(new CheckDialog.OnReleaseClick() {
                    @Override
                    public void onReleaseClick() {
                        Toast.makeText(view.getContext(),"已放行",Toast.LENGTH_SHORT).show();
                    }
                });
                checkDialog.show();
            }
        });
    }

    private BaseQuickAdapter<ReleaseBean , BaseViewHolder> mAdapter = new BaseQuickAdapter<ReleaseBean, BaseViewHolder>(R.layout.layout_item_release) {
        @Override
        protected void convert(BaseViewHolder holder, ReleaseBean bean) {
            holder.setText(R.id.tv_admin,bean.getAdmin());
            holder.setText(R.id.tv_license_plate,bean.getLicense());
            holder.setText(R.id.tv_id_card_value,bean.getIdCard());
            holder.setText(R.id.tv_phone_number,bean.getPhone());
            holder.setText(R.id.tv_person_num,bean.getPersons()+"人");
            holder.setText(R.id.tv_transit_checkpoint_value,bean.getCheckPoint());
            holder.setText(R.id.tv_entry_time_value,bean.getEntryTime());
            holder.setText(R.id.tv_delay_time,String.format(getString(R.string.delayTime),bean.getDelayTime()));
            holder.setTextColor(R.id.tv_delay_time,bean.getDelayTime()<5? Color.parseColor("#009688"):Color.parseColor("#FF0000"));
        }
    };
    private void initView() {
        mRc = findViewById(R.id.rc);
    }


}