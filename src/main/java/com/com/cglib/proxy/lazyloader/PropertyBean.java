package com.com.cglib.proxy.lazyloader;

/**
 * 需要被延迟加载的bean
 *
 * @author wangbinlin
 * @version V1.0
 * @date 2019/7/18
 */
public class PropertyBean {
    private String propertyName;
    private int propertyValue;

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public int getPropertyValue() {
        return propertyValue;
    }

    public void setPropertyValue(int propertyValue) {
        this.propertyValue = propertyValue;
    }
}
