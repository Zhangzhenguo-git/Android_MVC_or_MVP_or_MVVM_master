package com.example.mvp.view;

public interface DialogView {
    /**
     * 显示弹框
     * @param message
     */
    void showDialog(String message);
    /**
     * 关闭弹框
     */
    void dismissDialog();
}
