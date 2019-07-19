package com.jvm;

/**
 * AsmDemo
 *
 * @author wangbinlin
 * @version V1.0
 * @date 2019/7/17
 */
public class AsmDemo {
    private static final String name = "xiaoming";

    private int age;

    public AsmDemo(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge() {
        this.age = age;
    }

    public static void main(String[] args) {
        AsmDemo byteCodeDeomo = new AsmDemo(12);
        System.out.println("name:" + name + "age:" + byteCodeDeomo.getAge());
    }

    /*
    在ASM的core API编程中有几个关键类:
    ClassReader:可以读取编译好的二进制Class文件
    ClassWriter:用来重新构建编译后的类，比如说修改类名、属性以及方法，甚至可以生成新的类的字节码文件。
    ClassVisitor:用于生成和变转已编译类。在ClassVisitor定义了很多方法，例如:类上的注解，类的构造方法，类的字段，类的方法，静态代码块访问。用于我们去重写，以便做一些类上的逻辑扩展。要注意的是ClassWriter继承的是ClassVistor,这里ClassWriter就可以边访问边写入。
     */
}