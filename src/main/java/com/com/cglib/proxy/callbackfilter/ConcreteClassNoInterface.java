package com.com.cglib.proxy.callbackfilter;

/**
 * 被代理类
 *
 * @author wangbinlin
 * @version V1.0
 * @date 2019/7/17
 */
public class ConcreteClassNoInterface {
    public String getConcreteMethodA(String str){
        System.out.println("回调过滤:ConcreteMethod A ... "+str);
        return str;
    }
    public int getConcreteMethodB(int n){
        System.out.println("回调过滤:ConcreteMethod B ... "+n);
        return n+10;
    }
    public int getConcreteMethodFixedValue(int n){
        System.out.println("回调过滤:getConcreteMethodFixedValue..."+n);
        return n+10;
    }
}
