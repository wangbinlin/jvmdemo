package com.staticproxy;

/**
 * 代理类
 * 通过实现与目标对象相同的接口
 *
 * @author wangbinlin
 * @version V1.0
 * @date 2019/7/17
 */
public class BussinessProxy implements BussinessInterface {
    private BussinessInterface bussinessImpl;

    public BussinessProxy(BussinessInterface bussinessImpl) {
        this.bussinessImpl = bussinessImpl;
    }

    @Override
    public void execute() {
        System.out.println("前拦截...");
        bussinessImpl.execute();
        System.out.println("后拦截...");
    }
}
