package com.com.cglib.proxy.MethodInterceptor;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 拦截器
 *  //定义一个拦截器。在调用目标方法时，CGLib会回调MethodInterceptor接口方法拦截，来实现你自己的代理逻辑，类似于JDK中的InvocationHandler接口。
 *
 * @author wangbinlin
 * @version V1.0
 * @date 2019/7/17
 */
public class ConcreteClassInterceptor implements MethodInterceptor {
    /**
     *
     * @param o 为由CGLib动态生成的代理类实例
     * @param method 为上文中实体类所调用的被代理的方法引用
     * @param objects 为参数值列表
     * @param methodProxy 为生成的代理类对方法的代理引用
     * @return 从代理实例的方法调用返回的值
     * @throws Throwable
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("Before:"+method);
        //proxy.invokeSuper(obj,arg):调用代理类实例上的proxy方法的父类方法（即实体类ConcreteClassNoInterface中对应的方法）
        Object object=methodProxy.invokeSuper(o,objects);
        System.out.println("After:"+method);
        return object;
    }
}
