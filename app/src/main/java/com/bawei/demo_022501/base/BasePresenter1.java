package com.bawei.demo_022501.base;

import java.lang.ref.WeakReference;

/**
 * @ProjectName: Demo_022501
 * @Package: com.bawei.demo_022501.base
 * @ClassName: BasePresenter1
 * @Description: (java类作用描述)
 * @Author: 李聪聪
 * @CreateDate: 2020/2/26 20:47
 */
public abstract class BasePresenter1<V extends IBaseView> {

    private  WeakReference<V> vWeakReference;

    public BasePresenter1(V v){
        vWeakReference = new WeakReference<>(v);
        initMedel();
    }

    protected abstract void initMedel();

    public V getView(){
        if (vWeakReference != null){
            return vWeakReference.get();
        }
        return null;
    }
    protected void detachView(){
        if (vWeakReference != null){
            vWeakReference.clear();
            vWeakReference = null;
        }
    }
}
