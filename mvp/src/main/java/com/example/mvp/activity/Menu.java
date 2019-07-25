package com.example.mvp.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mvp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Menu extends AppCompatActivity {

    @BindView(R.id.tv_ShowData)
    TextView tvShowData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        ButterKnife.bind(this);
        Toast.makeText(Menu.this, getIntent().getStringExtra("result")+"此处给你一个赞", Toast.LENGTH_SHORT).show();
        tvShowData.setText(getIntent().getStringExtra("result"));
    }
}
