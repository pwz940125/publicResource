package com.android.nfc.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.android.nfc.myapplication.adapter.BaseRecyclerViewAdapter;
import com.android.nfc.myapplication.adapter.ReleaseViewHolder;

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
        BaseRecyclerViewAdapter mAdapter = new BaseRecyclerViewAdapter(this,data,R.layout.layout_item_release, ReleaseViewHolder.class);
        mRc.setLayoutManager(new LinearLayoutManager(this));
        mRc.addItemDecoration(new SpaceItemDecoration(0,DisplayUtil.dp2px(20),true));
        mRc.setAdapter(mAdapter);
        mAdapter.addChildClickViewIds(R.id.tv_release);
        mAdapter.setOnItemChildClickListener(new BaseRecyclerViewAdapter.onItemChildClickListener() {
            @Override
            public void onChildItemClick(Object itemData, View view, int position) {
                if (view.getId() == R.id.tv_release){
                    CheckDialog checkDialog = new CheckDialog(SecondActivity.this,data.get(position));
                    checkDialog.setClick(new CheckDialog.OnReleaseClick() {
                        @Override
                        public void onReleaseClick() {
                            Toast.makeText(view.getContext(),"已放行",Toast.LENGTH_SHORT).show();
                        }
                    });
                    checkDialog.show();
                }
            }
        });
    }


    private void initView() {
        mRc = findViewById(R.id.rc);
    }


}