package com.com.cglib.proxy.MethodInterceptor;

import net.sf.cglib.proxy.Enhancer;

/**
 * Client
 *
 * @author wangbinlin
 * @version V1.0
 * @date 2019/7/17
 */
public class Client {
    public static void main(String[] args) {
        //这里Enhancer类是CGLib中的一个字节码增强器，它可以方便的对你想要处理的类进行扩展
        Enhancer enhancer = new Enhancer();
        //首先将被代理类ConcreteClassNoInterface设置成父类
        enhancer.setSuperclass(ConcreteClassNoInterface.class);
        //然后设置拦截器ConcreteClassInterceptor
        enhancer.setCallback(new ConcreteClassInterceptor());
        //最后执行enhancer.create()动态生成一个代理类，并从Object强制转型成父类型ConcreteClassNoInterface。
        ConcreteClassNoInterface ccniProxy = (ConcreteClassNoInterface) enhancer.create();

        String result1 = ccniProxy.getConcreteMethodA("wangbinlin");
        System.out.println("getConcreteMethodA返回值:"+result1);

        System.out.println();
        int result2 = ccniProxy.getConcreteMethodB(18);
        System.out.println("getConcreteMethodB返回值:"+result2);
    }
}
