package com.example.mvp.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.mvp.R;
import com.example.mvp.presenter.LoginPresenter;
import com.example.mvp.view.DialogView;
import com.example.mvp.view.LoginView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Login extends AppCompatActivity implements DialogView, LoginView {

    @BindView(R.id.et_Log_UserName)
    AutoCompleteTextView etLogUserName;
    @BindView(R.id.et_Log_PassWord)
    EditText etLogPassWord;
    @BindView(R.id.bt_Loading)
    Button btLoading;
    @BindView(R.id.email_login_form)
    LinearLayout emailLoginForm;
    private ProgressDialog mProgressDialog;

    private Handler mHandler;
    private Context mContext;
    private LoginPresenter loginPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        init();
        MyClick();

    }
    private void init(){
        mContext=Login.this;
        if (loginPresenter==null){
            loginPresenter=new LoginPresenter(this,this);
        }
        mHandler=new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                switch (msg.what){
                    case 1:
                        Intent intent=new Intent(Login.this,Menu.class);
                        intent.putExtra("result",msg.obj.toString());
                        startActivityForResult(intent,1);
                        break;
                    default:
                            break;
                }
            }
        };

    }
    private void MyClick(){
        btLoading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginPresenter.reqLogin("test","123");
            }
        });
    }


    @Override
    public void showData(String result) {
//        Looper.prepare();
//        Toast.makeText(mContext, result+"", Toast.LENGTH_SHORT).show();
//        Looper.loop();
        Message msg=new Message();
        msg.what=1;
        msg.obj=result;
        mHandler.sendMessage(msg);

    }

    @Override
    public void showDialog(String message) {
        if (mProgressDialog==null){
            mProgressDialog=new ProgressDialog(Login.this);
        }
        mProgressDialog.setMessage(message);
        mProgressDialog.show();
    }

    @Override
    public void dismissDialog() {
        mProgressDialog.dismiss();
    }

}
