package com.android.nfc.myapplication;

import android.content.Context;
import android.content.res.Resources;

/**
 * @ClassName: DisplayUtil
 * @Description:
 * @Author: wuzhi.peng
 * @Date: 2022/10/13
 */
public class DisplayUtil {
    public static int dp2px(int dpValue){
        return (int) (0.5f + dpValue* Resources.getSystem().getDisplayMetrics().density);
    }

    public static int getScreenWidth( Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    public static int getScreenHeight( Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }
}
