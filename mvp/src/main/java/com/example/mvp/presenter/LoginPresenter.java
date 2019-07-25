package com.example.mvp.presenter;

import com.example.mvp.model.LoginModel;
import com.example.mvp.view.DialogView;
import com.example.mvp.view.LoginView;

public class LoginPresenter implements LoginIPresenter{
    private DialogView mDialog;
    private LoginView mLoginView;
    private LoginModel loginModel;
    public LoginPresenter(DialogView mDialog,LoginView mLoginView){
        this.mDialog=mDialog;
        this.mLoginView=mLoginView;
        if (loginModel==null){
            loginModel=new LoginModel();
        }
    }

    @Override
    public void reqLogin(String userName, String passWord) {
        mDialog.showDialog("正在登陆中...");
        loginModel.reqLogin(userName, passWord, new LoginModel.LoginCallBack() {
            /**
             * 成功回调数据
             * @param result
             */
            @Override
            public void onSuccess(String result) {
                mDialog.dismissDialog();
                mLoginView.showData(result);
            }

            //失败回调原因
            @Override
            public void onError(String error) {
                mDialog.dismissDialog();
                mLoginView.showData(error);
            }
        });
    }
}
