package com.bawei.demo_022501.presenter;

import com.bawei.demo_022501.base.BasePresenter;
import com.bawei.demo_022501.base.IBaseView;
import com.bawei.demo_022501.contract.IHomePageContract;
import com.bawei.demo_022501.model.HomePageModel;

import java.util.HashMap;

/**
 * 通常情况下，一个页面对应一个Presenter
 * 这一个Presenter里面包含当前页面下所有的接口
 *
 * 实现契约类中p层接口，重写方法
 *
 * 19.写一个具体的Presenter层，实现契约类中的Presenter接口，还需要继承BasePresenter（自动生成的构造方法我们不需要动）
 * 20.重写 initModel，在该方法中new 一个我们刚才创建的Model类，并提成成员变量
 * 21.重写契约类中的方法，在方法中我们需要使用刚才保存的m层的成员变量，来调用m层的方法
 * 22.通过接口回调，接收m层的数据
 * 23.通过getView（），拿到V层的泛型，通过instanceof 判断是否是我们契约类中的V层接口
 * 24.如果是，强转成契约类中的V层接口，并调用契约类中V层接口里面的方法
 * 25.如果不是，不做任何处理
 */
public class HomePagePresenter extends BasePresenter implements IHomePageContract.IPresenter {

    private HomePageModel mModel;

    public HomePagePresenter(IBaseView iBaseView) {
        super(iBaseView);
    }

    @Override
    public void getBanner(String url) {

    }

    @Override
    public void getList(String url) {
        mModel.getList(url, new IHomePageContract.IModel.IModelGetListCallBack() {
            @Override
            public void onGetListSuccess(String str) {
                IBaseView iBaseView = getView();
                if (iBaseView instanceof IHomePageContract.IView){
                    IHomePageContract.IView iVew = (IHomePageContract.IView) iBaseView;
                    iVew.onGetListSuccess(str);
                }
            }

            @Override
            public void onGetListFailure(String str) {
                IBaseView iBaseView = getView();
                if (iBaseView instanceof IHomePageContract.IView){
                    IHomePageContract.IView iVew = (IHomePageContract.IView) iBaseView;
                    iVew.onGetListFailure(str);
                }
            }
        });
    }

    @Override
    public void doLogin(String url, HashMap<String, String> hashMap) {
        mModel.doLogin(url, hashMap, new IHomePageContract.IModel.IModelLoginCallBack() {
            @Override
            public void onLoginSuccess(String str) {
                IBaseView view = getView();
                if (view instanceof IHomePageContract.IView){
                    IHomePageContract.IView iVew = (IHomePageContract.IView)view;
                    iVew.onLoginSucccess(str);
                }
            }

            @Override
            public void onLoginFailure(String str) {
                IBaseView view = getView();
                if (view instanceof IHomePageContract.IView){
                    IHomePageContract.IView iVew = (IHomePageContract.IView)view;
                    iVew.onLoginFailure(str);
                }
            }
        });
    }


    @Override
    protected void initModel() {
        mModel = new HomePageModel();
    }
}
