package com.com.dynamic.jdk.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 代理处理器类
 *
 * @author wangbinlin
 * @version V1.0
 * @date 2019/7/17
 */
public class ProxyHandler implements InvocationHandler {
    private Object concreteClass;

    public ProxyHandler(Object concreteClass){
        this.concreteClass=concreteClass;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("proxy:"+proxy.getClass().getName());
        System.out.println("method:"+method.getName());
        System.out.println("args:"+args[0].getClass().getName());
        System.out.println("Before invoke method...");
        //普通的Java反射代码,通过反射执行某个类的某方法
        Object object=method.invoke(concreteClass,args);
        System.out.println("After invoke method...");
        return object;
    }
}
