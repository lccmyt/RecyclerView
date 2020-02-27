package com.bawei.demo_022501.model;

import com.bawei.demo_022501.contract.IHomePageContract;
import com.bawei.demo_022501.utils.VolleyUtils;

import java.util.HashMap;

/**
 * 通常情况下，一个页面对应一个Model
 * 这一个Model里面包含当前页面下所有的接口
 *
 * 实现契约类中m层接口，重写方法
 *
 * 16.写一个具体的Model层，实现契约类中的Model接口，用来调用网络工具类、
 * 17.重写契约类中的方法，在方法中完成调用工具类，并接收回调数据
 * 18.将网络工具类回调的数据，通过方法传入的callback，回调至p层
 */
public class HomePageModel implements IHomePageContract.IModel {
    @Override
    public void getBanner(String url, IModelGetBannerCallBack callBack) {

    }

    @Override
    public void getList(String url, IModelGetListCallBack callBack) {

    }

    @Override
    public void doLogin(String url, HashMap<String, String> map, final IModelLoginCallBack callBack) {
        VolleyUtils.getInstance().doPost(url, map, new VolleyUtils.CallBack() {
            @Override
            public void onSuccess(String json) {
                callBack.onLoginSuccess(json);
            }

            @Override
            public void onFailure(String msg) {
                callBack.onLoginFailure(msg);
            }
        });
    }


}
