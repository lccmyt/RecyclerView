package com.bawei.demo_022501.base;

import android.app.Application;
import android.content.Context;

/**
 * 104.创建一个app类，继承Application
 * 105.写一个静态成员变量，记录上下文
 * 106.在onCreate中通过getApplicationContext来给成员变量赋值
 * 107.编写一个静态方法，提供外部调用获取上下文
 * 108.在我们的manifest里面，application下，添加android:name=“该类的路径” ！！！！！
 */
public class App extends Application {
    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
    }
    public static Context getAppContext(){
        return mContext;
    }
}
