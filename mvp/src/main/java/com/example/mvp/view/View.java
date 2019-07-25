package com.example.mvp.view;

public interface View {
    /**
     * 显示加载框
     */
    void showLoading(String message);

    /**
     * 显示数据
     * @param showInfo
     */
    void showData(String showInfo);


}
