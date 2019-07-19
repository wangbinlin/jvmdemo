package com.staticproxy;

/**
 * Client
 *
 * @author wangbinlin
 * @version V1.0
 * @date 2019/7/17
 */
public class Client {
    public static void main(String[] args) {
        //静态代理类
        BussinessProxy bussinessProxy = new BussinessProxy(new Bussiness());
        bussinessProxy.execute();
    }
}
