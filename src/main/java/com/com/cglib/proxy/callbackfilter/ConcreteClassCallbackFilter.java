package com.com.cglib.proxy.callbackfilter;

import net.sf.cglib.proxy.CallbackFilter;

import java.lang.reflect.Method;

/**
 * 定义实现过滤器CallbackFilter接口的类
 *
 * @author wangbinlin
 * @version V1.0
 * @date 2019/7/17
 */
public class ConcreteClassCallbackFilter implements CallbackFilter {
    @Override
    public int accept(Method method) {
        System.out.println("过滤器实现类："+method.getName());
        if("getConcreteMethodB".equals(method.getName())){
            System.out.println("过滤器实现类：getConcreteMethodB");
            return 0;//Callback callbacks[0] 表示interceptor
        }else if("getConcreteMethodA".equals(method.getName())){
            System.out.println("过滤器实现类：getConcreteMethodA");
            return 1;//Callback callbacks[1] 表示noOp
        }else if("getConcreteMethodFixedValue".equals(method.getName())){
            System.out.println("过滤器实现类：getConcreteMethodFixedValue");
            return 2;//Callback callbacks[2] 表示fixedValue
        }
        //其中return值为被代理类的各个方法在回调数组Callback[]中的位置索引（见下文）
        //Callback[] callbacks=new Callback[]{interceptor,noOp,fixedValue};
        return 1;
    }
}
