package com.com.cglib.proxy.lazyloader;

/**
 * Client
 *
 * @author wangbinlin
 * @version V1.0
 * @date 2019/7/18
 */
public class Client {
    public static void main(String[] args) {
        LoaderBean loader = new LoaderBean();
        System.out.println(loader.getLoaderName());
        System.out.println(loader.getLoaderValue());
        PropertyBean propertyBean = loader.getPropertyBean();//访问延迟加载对象
        System.out.println(propertyBean.getPropertyName());
        System.out.println(propertyBean.getPropertyValue());
        System.out.println("after...");
        //当再次访问延迟加载对象时,就不会再执行回调了
        System.out.println(propertyBean.getPropertyName());
        //第一次获取property bean的属性时，会触发代理类回调方法。第二次再获取property bean的属性时，就直接返回属性值而不会再次触发代理类回调方法了。
    }
}
