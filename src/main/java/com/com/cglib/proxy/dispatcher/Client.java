package com.com.cglib.proxy.dispatcher;

import com.com.cglib.proxy.lazyloader.PropertyBean;

/**
 * Client
 *
 * @author wangbinlin
 * @version V1.0
 * @date 2019/7/18
 */
public class Client {
    public static void main(String[] args) {
        DispatcherBean dispatcherBean=new DispatcherBean();
        System.out.println(dispatcherBean.getName());
        System.out.println(dispatcherBean.getValue());

        PropertyBean pb=dispatcherBean.getPropertyBean();
        System.out.println(pb.getPropertyName());
//在每次访问时都要进行回调
        System.out.println(pb.getPropertyValue());
        //Dispatcher和LazyLoader的区别在于：LazyLoader只在第一次访问延迟加载属性时触发代理类回调方法，而Dispatcher在每次访问延迟加载属性时都会触发代理类回调方法。
    }
}
