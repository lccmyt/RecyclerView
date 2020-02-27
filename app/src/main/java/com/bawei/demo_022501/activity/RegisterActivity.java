package com.bawei.demo_022501.activity;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.bawei.demo_022501.R;
import com.bawei.demo_022501.base.BaseActivity;
import com.bawei.demo_022501.base.BasePresenter;
import com.bawei.demo_022501.contract.IHomePageContract;
import com.bawei.demo_022501.presenter.HomePagePresenter;

import java.util.HashMap;

/**
 * @ProjectName: Demo_022501
 * @Package: com.bawei.demo_022501.activity
 * @ClassName: RegisterActivity
 * @Description: (java类作用描述)
 * @Author: 李聪聪
 * @CreateDate: 2020/2/25 19:36
 */
public class RegisterActivity extends BaseActivity implements IHomePageContract.IView {

    private Button bt_register;
    private TextView pwd;
    private TextView phone;
    private TextView tv_login;

    @Override
    protected int getLayout() {
        return R.layout.acitivity_register;
    }

    @Override
    protected BasePresenter initPresenter() {
        return new HomePagePresenter(this);
    }

    @Override
    protected void initView() {
        phone = findViewById(R.id.phone);
        pwd = findViewById(R.id.pwd);
        bt_register = findViewById(R.id.bt_register);
        tv_login = findViewById(R.id.tv_login);
    }

    @Override
    protected void initData() {
        tv_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        bt_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = RegisterActivity.this.phone.getText().toString();
                String pwd = RegisterActivity.this.pwd.getText().toString();

                HashMap<String, String> map = new HashMap<>();
                map.put("phone", phone);
                map.put("pwd", pwd);
                BasePresenter presneter = getPresneter();
                if (presneter != null && presneter instanceof HomePagePresenter){
                    ((HomePagePresenter) presneter).doLogin("http://mobile.bwstudent.com/small/user/v1/register", map);
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
        Log.i("xxx", str);
    }

    @Override
    public void onLoginFailure(String str) {
        Log.i("xxx", str);
    }
}
