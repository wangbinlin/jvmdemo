package com.com.cglib.proxy.MethodInterceptor;

/**
 * 被代理类
 *
 * @author wangbinlin
 * @version V1.0
 * @date 2019/7/17
 */
public class ConcreteClassNoInterface {
    public String getConcreteMethodA(String str){
        System.out.println("方法拦截ConcreteMethod A ... "+str);
        return str;
    }
    public int getConcreteMethodB(int n){
        System.out.println("方法拦截ConcreteMethod B ... "+n);
        return n+10;
    }
}
