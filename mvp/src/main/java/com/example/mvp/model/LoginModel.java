package com.example.mvp.model;

import com.example.mvp.view.LoginView;

public class LoginModel implements LoginIModel {
    public LoginView loginView;
    @Override
    public void reqLogin(String userName, String passWord, final LoginCallBack callBack) {
        new Thread(){
            @Override
            public void run() {
                super.run();
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                int code=0;
                //请求接口
                //并返回数据，然后返回给view
                if (code==0){
                    callBack.onSuccess("登录成功");
                }else {
                    callBack.onError("登录失败，用户名或密码错误");
                }
            }
        }.start();
    }
    //这里的接口可以单独抽离出来，这里我就不抽离了
    public interface LoginCallBack{
        void onSuccess(String result);
        void onError(String error);
    }
}
