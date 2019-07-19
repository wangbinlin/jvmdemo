package com.com.cglib.proxy.interfacemaker;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.InterfaceMaker;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Client
 *
 * @author wangbinlin
 * @version V1.0
 * @date 2019/7/18
 */
public class Client {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        InterfaceMaker maker = new InterfaceMaker();
        maker.add(ConcreteClassNoInterface.class);
        Class interfaceObj = maker.create();
        System.out.println(interfaceObj.isInterface());
        System.out.println(interfaceObj.getName());

        Method[] methods = interfaceObj.getMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
        }

        //下面通过生成的接口，可以对某个类进行Enhancer 生成代理
        Object obj = Enhancer.create(Object.class, new Class[]{interfaceObj},
                new MethodInterceptor() {
                    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
                        return "intercept!";
                    }
                });
        Method method = obj.getClass().getMethod("getConcreteMethodA", new Class[]{String.class});
        System.out.println(method.invoke(obj, new Object[]{"12345"}));
        //此处让Object生成的代理类实现了由InterfaceMaker生成的接口，但是由于Object类并没有覆写其中的方法，
        // 因此，每当对生成接口内方法进行MethodInterceptor方法拦截时，都返回一个字符串，并在最后打印出来。
    }
}
