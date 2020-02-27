package com.bawei.demo_022501.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * BaseActivity,我们需要在内部初始化我们的P层，BaseActivity作为一个基类，他是无法指定具体的哪一个P层
 * 所以必须使用P层的基类BasePresenter
 *
 * 告知使用了继承BasePresenter的泛型，然后实现IBaseView接口
 * 编写一个抽象方法initPresenter，让我们的子类完成初始化具体p层的工作
 * 在onCreate中初始化P层，在BaseActivity的子类中，完成重写的initPresenter这个抽象方法
 * @param <P>
 *
 *
 * 26.编写BaseActivity（或者BaseFragment），告知需要使用泛型<P extends BasePresenter>
 * 27.写一个抽象方法，提供给子类，具体初始化哪一个p层
 * 28.在onCreate中，调用抽象方法，并将结果保存成成员变量
 * 29.添加getPresenter方法，便于V层获取P层
 * 30.在onDestroy方法中，调用BasePresenter提供的解绑的方法
 */
public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements IBaseView {
    P mPresenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        mPresenter = initPresenter();
        initView();
        initData();
    }
    public P getPresneter(){
        return mPresenter;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null){
            mPresenter.detachView();
            mPresenter = null;
        }
    }

    protected abstract int getLayout();

    protected abstract P initPresenter();

    protected abstract void initView();

    protected abstract void initData();
}
