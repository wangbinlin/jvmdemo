package com.com.cglib.proxy.lazyloader;

import net.sf.cglib.proxy.LazyLoader;

/**
 * 实现延迟加载LazyLoader回调接口的类，对需要延迟加载的Bean进行实例化并返回
 *
 * @author wangbinlin
 * @version V1.0
 * @date 2019/7/18
 */
public class ConcreteClassLazyLoader implements LazyLoader {
    @Override
    public Object loadObject() throws Exception {
        System.out.println("执行延迟加载回调，LazyLoader loadObject() ...");
        PropertyBean bean = new PropertyBean();
        bean.setPropertyName("lazy-load object propertyName!");
        bean.setPropertyValue(11);
        return bean;
    }
}
