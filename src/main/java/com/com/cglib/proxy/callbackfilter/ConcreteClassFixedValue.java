package com.com.cglib.proxy.callbackfilter;

import net.sf.cglib.proxy.FixedValue;

/**
 * 实现锁定返回值FixedValue接口的类
 *
 * @author wangbinlin
 * @version V1.0
 * @date 2019/7/17
 */
public class ConcreteClassFixedValue implements FixedValue {
    @Override
    public Object loadObject() throws Exception {
        System.out.println("ConcreteClassFixedValue loadObject ...");
        Object object=999;
        return object;
        //该类实现FixedValue接口，同时锁定回调值为999(整型,CallbackFilter中定义的使用FixedValue型回调的方法为getConcreteMethodFixedValue，该方法返回值为整型)。
    }
}
