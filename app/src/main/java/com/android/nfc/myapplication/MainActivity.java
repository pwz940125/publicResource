package com.android.nfc.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Spinner;

import com.android.nfc.SpinnerView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private SpinnerView mSpArea;
    private SpinnerView mSpAreaShort;
    private SpinnerView mSpQx;
    private SpinnerView mSpKk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.xxtx);
        initView();
        initData();
    }


    private void initView(){
        mSpArea = findViewById(R.id.spinner);
        mSpAreaShort = findViewById(R.id.spinners);
        mSpQx = findViewById(R.id.spinner_qx);
        mSpKk = findViewById(R.id.spinner_kk);
        mSpArea.setOnClickListener(this);
        mSpAreaShort.setOnClickListener(this);
        mSpQx.setOnClickListener(this);
        mSpKk.setOnClickListener(this);
    }

    public void navigate2act(View view){
        startActivity(new Intent(this,SecondActivity.class));
    }

    private void initData(){

    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.spinner:
                String[] array = getResources().getStringArray(R.array.province);
                ArrayList< String> arrayList = new ArrayList<String>(array.length);
                Collections.addAll(arrayList, array);
                ItemSelectPopUpWindow pop = new ItemSelectPopUpWindow(this,arrayList);
                pop.show(mSpArea.getTitleView(),200,-50,30);
            break;
            case R.id.spinners:
                String[] array2 = getResources().getStringArray(R.array.province_short);
                ArrayList< String> arrayList2 = new ArrayList<String>(array2.length);
                Collections.addAll(arrayList2, array2);
                ItemSelectPopUpWindow pop2 = new ItemSelectPopUpWindow(this,arrayList2);
                pop2.show(mSpAreaShort.getTitleView(),200,-50,30);
                break;
            case R.id.spinner_qx:
                String[] array3 = getResources().getStringArray(R.array.province_qx);
                ArrayList< String> arrayList3 = new ArrayList<String>(array3.length);
                Collections.addAll(arrayList3, array3);
                ItemSelectPopUpWindow pop3 = new ItemSelectPopUpWindow(this,arrayList3);
                pop3.showUp(mSpQx.getTitleView(),mSpQx.getWidth());
                break;
            case R.id.spinner_kk:
                String[] array4 = getResources().getStringArray(R.array.province_kk);
                ArrayList< String> arrayList4 = new ArrayList<String>(array4.length);
                Collections.addAll(arrayList4, array4);
                ItemSelectPopUpWindow pop4 = new ItemSelectPopUpWindow(this,arrayList4);
                pop4.showUp(mSpKk.getTitleView(),mSpKk.getWidth());
                break;
        }
    }
}