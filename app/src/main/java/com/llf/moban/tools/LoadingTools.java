package com.llf.moban.tools;

import android.app.ProgressDialog;
import android.content.Context;

/**
 * Created by llf on 2016/9/11.
 */
public class LoadingTools {
    private static ProgressDialog mProgressDialog;

    public static void showLoding(Context context) {
        mProgressDialog = new ProgressDialog(context);
        mProgressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);// 设置进度条的形式为圆形转动的进度条
        mProgressDialog.setCancelable(true);// 设置是否可以通过点击Back键取消
        mProgressDialog.setCanceledOnTouchOutside(false);// 设置在点击Dialog外是否取消Dialog进度条
//        mProgressDialog.setIcon(R.mipmap.ic_launcher);
        // 设置提示的title的图标，默认是没有的，如果没有设置title的话只设置Icon是不会显示图标的
        mProgressDialog.setMessage("加载中");
        mProgressDialog.show();
    }

    public static void closeLoding() {
        if (mProgressDialog != null) {
            mProgressDialog.dismiss();
            mProgressDialog = null;
        }
    }
}
