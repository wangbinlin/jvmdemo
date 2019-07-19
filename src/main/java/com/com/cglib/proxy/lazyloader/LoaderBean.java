package com.com.cglib.proxy.lazyloader;

import net.sf.cglib.proxy.Enhancer;

/**
 * PropertyBean为需要延迟加载的Bean
 * 对需要延迟加载的Bean，由代理类生成,
 * 定义一个实体类LoaderBean，该Bean内有一个需要延迟加载的属性PropertyBean。
 *
 *
 * @author wangbinlin
 * @version V1.0
 * @date 2019/7/18
 */
public class LoaderBean {
    private String loaderName;
    private int loaderValue;
    private PropertyBean propertyBean;

    public LoaderBean() {
        this.loaderName = "loaderNameA";
        this.loaderValue = 123;
        this.propertyBean=createPropertyBean();
    }
    //在LoaderBean的构造方法中，对属性Bean进行了代理类生成，使用了CGLib中的LazyLoader回调接口。
    protected  PropertyBean createPropertyBean(){
        //Enhancer enhancer=new Enhancer();
        //enhancer.setSuperclass(PropertyBean.class);
        return  (PropertyBean)Enhancer.create(PropertyBean.class,new ConcreteClassLazyLoader());
    }

    public String getLoaderName() {
        return loaderName;
    }

    public void setLoaderName(String loaderName) {
        this.loaderName = loaderName;
    }

    public int getLoaderValue() {
        return loaderValue;
    }

    public void setLoaderValue(int loaderValue) {
        this.loaderValue = loaderValue;
    }

    public PropertyBean getPropertyBean() {
        return propertyBean;
    }

    public void setPropertyBean(PropertyBean propertyBean) {
        this.propertyBean = propertyBean;
    }
}
