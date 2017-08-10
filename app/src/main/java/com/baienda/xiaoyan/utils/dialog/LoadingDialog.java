package com.baienda.xiaoyan.utils.dialog;

import android.app.ProgressDialog;
import android.content.Context;

public class LoadingDialog {
    private ProgressDialog mDialog;

    private LoadingDialog() {
    }

    private static class LoadingDialogHolder {
        public static final LoadingDialog INSTANCE = new LoadingDialog();
    }

    public static LoadingDialog getInstance() {
        return LoadingDialogHolder.INSTANCE;
    }

    public void show(Context context, String message, boolean cancleable) {
        mDialog = ProgressDialog.show(context, null, message);
        mDialog.setCancelable(cancleable);
        mDialog.show();
    }

    public void show(Context context, int message, boolean cancleable) {
        mDialog = ProgressDialog.show(context, null, context.getResources().getString(message));
        mDialog.setCancelable(cancleable);
        mDialog.show();
    }

    public void dismissDialog() {
        try {
            if (mDialog != null && mDialog.isShowing()) {
                mDialog.dismiss();
            }
        } catch (Exception e) {
        }
    }
}
