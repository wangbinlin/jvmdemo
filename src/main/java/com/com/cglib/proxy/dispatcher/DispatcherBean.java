package com.com.cglib.proxy.dispatcher;

import com.com.cglib.proxy.lazyloader.PropertyBean;
import net.sf.cglib.proxy.Enhancer;

/**
 * DispatcherBean中有需要延迟加载的属性PropertyBean
 * 延迟加载的属性PropertyBean，由代理生成
 *
 * @author wangbinlin
 * @version V1.0
 * @date 2019/7/18
 */
public class DispatcherBean {
    private String name;
    private String value;
    private PropertyBean propertyBean;

    public DispatcherBean() {
        this.name="DispatcherBean";
        this.value="abc";
        this.propertyBean=createPropertyBean();
    }

    private PropertyBean createPropertyBean() {
        return (PropertyBean) Enhancer.create(PropertyBean.class,new ConcreteClassDipatcher());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public PropertyBean getPropertyBean() {
        return propertyBean;
    }

    public void setPropertyBean(PropertyBean propertyBean) {
        this.propertyBean = propertyBean;
    }
}
