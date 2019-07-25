package com.example.mvp.model;

public interface LoginIModel {
    void reqLogin(String userName, String passWord, LoginModel.LoginCallBack callBack);
}
