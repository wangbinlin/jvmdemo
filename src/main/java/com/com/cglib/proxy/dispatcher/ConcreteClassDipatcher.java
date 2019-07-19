package com.com.cglib.proxy.dispatcher;

import com.com.cglib.proxy.lazyloader.PropertyBean;
import net.sf.cglib.proxy.Dispatcher;

/**
 * 延迟加载实现类，返回延迟加载的属性
 *
 * @author wangbinlin
 * @version V1.0
 * @date 2019/7/18
 */
public class ConcreteClassDipatcher implements Dispatcher {
    @Override
    public Object loadObject() throws Exception {
        System.out.println("Dispatcher loadObject ...");
        PropertyBean object=new PropertyBean();
        object.setPropertyName("PropertyBeanName!");
        object.setPropertyValue(1);
        return object;
    }
}
