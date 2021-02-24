package annotation;

import java.lang.annotation.Annotation;

/**
 * 解析注解内容
 */
@MyAnnotation(name="zhangsan")
public class Demo03 {
    public static void main(String[] args) {
        // 1.获得Demo03对应的字节码对象
        Class demo03Class = Demo03.class;
        // 2.获得类上的MyAnnotation注解
        MyAnnotation annotation =
                (MyAnnotation) demo03Class.getAnnotation(MyAnnotation.class);
        // 3.获得注解的属性值
        String name = annotation.name();
        System.out.println(name);
        // 4.对属性值进行逻辑处理...
    }
}
