package com.bawei.demo_022501.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.bawei.demo_022501.R;
import com.bawei.demo_022501.base.BaseActivity;
import com.bawei.demo_022501.base.BasePresenter;
import com.bawei.demo_022501.contract.IHomePageContract;
import com.bawei.demo_022501.presenter.HomePagePresenter;

import java.util.HashMap;

/**
 * 实现契约类中的v层接口，重写回调方法
 *
 *
 * 31.继承BaseActivity，实现契约类中V层接口
 * 32.在initPresenter中，new 一个具体的P层，传入this
 * 33.在发起请求的地方（可能是initData，可能是点击事件，根据需求来定），
 *    通过getPresenter，判断是契约类中P层接口，是则调用p层方法
 * 34.在重写的契约类中V层的方法里，实现对结果的处理
 */
public class MainActivity extends BaseActivity implements IHomePageContract.IView {

    private Button bt_login;
    private TextView tv_register;
    private TextView tv_phone;
    private TextView tv_pwd;

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected BasePresenter initPresenter() {
        return new HomePagePresenter(this);
    }

    @Override
    protected void initView() {
        bt_login = findViewById(R.id.bt_login);
        tv_register = findViewById(R.id.tv_register);
        tv_phone = findViewById(R.id.tv_phone);
        tv_pwd = findViewById(R.id.tv_pwd);
    }

    @Override
    protected void initData() {
        tv_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

        bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BasePresenter presneter = getPresneter();
                if (presneter != null && presneter instanceof HomePagePresenter){
                    String phone = tv_phone.getText().toString();
                    String pwd = tv_pwd.getText().toString();
                    HashMap<String, String> map = new HashMap<>();
                    map.put("phone", phone);
                    map.put("pwd", pwd);

                    ((HomePagePresenter)presneter).doLogin("http://mobile.bwstudent.com/small/user/v1/login",map);

                }
            }
        });

    }

    @Override
    public void onGetBannerSuccess(String str) {

    }

    @Override
    public void onGetBannerFailure(String str) {

    }

    @Override
    public void onGetListSuccess(String str) {

    }

    @Override
    public void onGetListFailure(String str) {

    }

    @Override
    public void onLoginSucccess(String str) {
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
        Log.i("xxx", str);
    }

    @Override
    public void onLoginFailure(String str) {
        Log.i("xxx", str);
    }
}
