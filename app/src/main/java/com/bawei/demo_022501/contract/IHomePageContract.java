package com.bawei.demo_022501.contract;

import com.bawei.demo_022501.base.IBaseView;

import java.util.HashMap;

/**
 * 契约类，作用是用来管理所有的接口
 * 他把我们V层，P层和M层所需要实现的所有接口统一管理
 * 然后，由我们具体的V层（某个Activity或者某个Fragment）实现其中的V层接口
 * 由我们具体的P层,实现其中的P层接口
 * 由我们具体的M层,实现其中的M层接口
 *
 * 注意：契约类实际上是一个接口，使用interface而不是class!!!!!!!!!!!!!!
 *
 *
 * 8.创建该页面的契约类，这个类是个接口
 * 9.在契约类中，实现V层的接口，继承IBaseView
 * 10.在V层接口中，添加需要实现的方法，一般是成功和失败两个
 * 11.在契约类中，实现P层的接口
 * 12.在P层接口中，添加需要实现的方法，一般是获取数据一个
 * 13.在契约类中，实现M层的接口
 * 14.在M层接口中，添加需要实现的方法，一般是获取数据一个
 * 15.在M层接口中，添加一个接口回调，内部实现成功和失败两个方法
 */
public interface IHomePageContract {
    interface IView extends IBaseView{
        void onGetBannerSuccess(String str);
        void onGetBannerFailure(String str);

        void onGetListSuccess(String str);
        void onGetListFailure(String str);

        void onLoginSucccess(String str);
        void onLoginFailure(String str);
    }

    interface IPresenter{
        void getBanner(String url);
        void getList(String url);

        void doLogin(String url, HashMap<String,String> hashMap);
    }

    interface IModel{
        void getBanner(String url,IModelGetBannerCallBack callBack);

        void getList(String url,IModelGetListCallBack callBack);

        void doLogin(String url, HashMap<String, String> map,IModelLoginCallBack callBack);

        interface IModelGetBannerCallBack{
            void onGetBannerSucess(String str);
            void onGetBannerFailure(String str);
        }
        interface IModelGetListCallBack{
            void onGetListSuccess(String str);
            void onGetListFailure(String str);
        }
        interface IModelLoginCallBack{
            void onLoginSuccess(String str);
            void onLoginFailure(String str);
        }
    }
}
