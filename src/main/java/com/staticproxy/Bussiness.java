package com.staticproxy;

/**
 * 目标对象实现类
 *
 * @author wangbinlin
 * @version V1.0
 * @date 2019/7/17
 */
public class Bussiness implements BussinessInterface {
    @Override
    public void execute() {
        System.out.println("目标对象实现类执行业务逻辑...");
    }
}
