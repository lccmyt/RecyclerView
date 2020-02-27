package com.bawei.demo_022501.utils;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bawei.demo_022501.base.App;

import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName: Demo_022501
 * @Package: com.bawei.demo_022501.utils
 * @ClassName: VolleyUtils
 * @Description:     //RequestQueue 这个就是volley给我们提供的统一管理所有请求的一个队列
 *                              //把所有的请求都放到队列中，然后他自己会帮我们执行
 * @Author: 李聪聪
 * @CreateDate: 2020/2/25 17:57
 */
public class VolleyUtils {

    private final RequestQueue mQueue;

    private VolleyUtils(){
            //103.在单例模式的构造方法之中，初始化队列
            //    初始化队列的方法 Volley.newRequestQueue
            //    后面需要跟一个  全局！！！！ 的上下文，避免内存泄露
            //109.把app下的静态全局上下文当做参数传入
        mQueue = Volley.newRequestQueue(App.getAppContext());
    }
    //这个是静态内部类的单例模式，是一种推荐大家使用的单例模式
    private static class SingleInstance{
        private static final VolleyUtils INSTANCE = new VolleyUtils();
    }
    public static VolleyUtils getInstance(){
        return SingleInstance.INSTANCE;
    }

    public interface CallBack{
        void onSuccess(String json);
        void onFailure(String msg);
    }

    /**
     * 110.写get请求方法，入参和以前一样，路径+callback
     * 111.我们通过new 创建一个StringRequest
     * 112.我们这里new的时候，需要传入四个参数
     * 113.第一个参数，我们的请求方式，这里是Request.Method.GET，代表我们发起get请求
     * 114.第二个参数，请求路径，对应传入的url
     * 115.第三个参数，请求返回值的监听 这里我们需要自己new一个，在监听当中，把数据通过callback回调给M层
     * 116.第四个参数，请求失败的监听，这里我们需要自己new一个，在监听当中，把失败的结果通过callback回调给M层
     *
     *
     *     请求失败：网络失败（没有网，链接超时）、参数拼错、请求格式错误等等导致网络请求无法完成的错误会走第四个参数
     *     如果说我们的账号密码错误，或者请求成功了，服务器告诉我们失败，会走第三个参数
     */
    public void doGet(String url, final CallBack callBack){
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        callBack.onSuccess(response);
                    }
                }, new Response.ErrorListener() {
                  @Override
                  public void onErrorResponse(VolleyError error) {
                        callBack.onFailure(error.getMessage());
            }
        });
        mQueue.add(stringRequest);
    }

    /**
     * 118.写post请求方法，入参和以前一样，路径 + hashmap + callback
     * 119.我们通过new 创建一个StringRequest
     * 120.我们这里new的时候，需要传入四个参数
     * 121.第一个参数，我们的请求方式，这里是Request.Method.POST，代表我们发起post请求
     * 122.第二个参数，请求路径，对应传入的url
     * 123.第三个参数，请求返回值的监听 这里我们需要自己new一个，在监听当中，把数据通过callback回调给M层
     * 124.第四个参数，请求失败的监听，这里我们需要自己new一个，在监听当中，把失败的结果通过callback回调给M层
     * 125.在第四个参数后面重写getParams方法 return 我们传入的map，这个方法的作用是，用来返回我们post需要传递的参数集合
     *     他的返回，会自动帮我们把post请求拼接好
     * @param url
     * @param map
     * @param callBack
     */
    public void doPost(String url, final HashMap<String,String> map, final CallBack callBack){
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        callBack.onSuccess(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                        callBack.onFailure(error.getMessage());
            }
        }){

            protected Map getParams(){
                return map;
            }

        };
        mQueue.add(stringRequest);
    }
}
