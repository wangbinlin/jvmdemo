package com.com.cglib.proxy.callbackfilter;

import com.com.cglib.proxy.MethodInterceptor.ConcreteClassInterceptor;
import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.CallbackFilter;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;

/**
 * Client
 *
 * @author wangbinlin
 * @version V1.0
 * @date 2019/7/18
 */
public class Client {
    public static void main(String[] args) {
        //1.字节码增强器，可以用来为无接口的类创建代理
        Enhancer enhancer = new Enhancer();
        //2.设置被代理类
        enhancer.setSuperclass(ConcreteClassNoInterface.class);
        CallbackFilter callbackFilter = new ConcreteClassCallbackFilter();
        //3.设置回调过滤
        enhancer.setCallbackFilter(callbackFilter);
        //3.1方法拦截器,com.com.cglib.proxy.MethodInterceptor.ConcreteClassInterceptor
        Callback interceptor = new ConcreteClassInterceptor();
        //3.2这个NoOp表示no operator，即什么操作也不做，代理类直接调用被代理的方法不进行拦截。
        Callback noOp = NoOp.INSTANCE;
        //3.3FixedValue：表示锁定方法返回值，无论被代理类的方法返回什么值，回调方法都返回固定值。
        Callback fixedValue = new ConcreteClassFixedValue();
        Callback[] callbacks = new Callback[]{interceptor, noOp, fixedValue};
        //4.设置回调,回调包括方法拦截器，不拦截和锁定方法返回值
        enhancer.setCallbacks(callbacks);
        //5.生成代理类
        ConcreteClassNoInterface proxy = (ConcreteClassNoInterface) enhancer.create();

        //具体调用代理类
        System.out.println("*** NoOp Callback ***");
        String result1 = proxy.getConcreteMethodA("abcde");
        System.out.println("getConcreteMethodA返回值:" + result1);
        System.out.println();

        System.out.println("*** MethodInterceptor Callback ***");
        int result2 = proxy.getConcreteMethodB(1);
        System.out.println("getConcreteMethodB返回值:" + result2);
        System.out.println();

        System.out.println("*** FixedValue Callback ***");
        int fixed1 = proxy.getConcreteMethodFixedValue(128);
        System.out.println("fixedValue1:" + fixed1);
        int fixed2 = proxy.getConcreteMethodFixedValue(256);
        System.out.println("fixedValue2:" + fixed2);

        //getConcreteMethodA对应CallbackFilter中定义的索引1，在Callback[]数组中使用的过滤为NoOp,因此直接执行了被代理方法。
        //getConcreteMethodB对应CallbackFilter中定义的索引0，在Callback[]数组中使用的过滤为MethodInterceptor，因此执行了方法拦截器进行拦截。
        //getConcreteMethodFixedValue对应CallbackFilter中定义的索引2，在Callback[]数组中使用的过滤为FixedValue，因此2次赋值128和256的调用其结果均被锁定为返回999。
    }
}
