package reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Demo2 {
    public static void main(String[] args) throws NoSuchMethodException, NoSuchFieldException {
        Class strClass = String.class;
        // 1.可以获得类中任意信息 - 父接口
        Class[] interfaces = strClass.getInterfaces();

        System.out.println(Arrays.toString(interfaces));

        // 构造方法
        Constructor constructor = strClass.getConstructor();
        System.out.println(constructor);

        Constructor constructor1 = strClass.getConstructor(String.class);
        System.out.println(constructor1);

        Constructor constructor2 = strClass.getConstructor(char[].class);
        System.out.println(constructor2);

        // 获得方法
        Method substring = strClass.getMethod("substring", int.class);
        Method trim = strClass.getMethod("trim");

        System.out.println(substring);
        System.out.println(trim);

        // 成员变量
//        Field value = strClass.getField("value");
//        System.out.println(value);

        // 获得私有成员
        Field value1 = strClass.getDeclaredField("value");
        System.out.println(value1);

        // 获得注解
        // strClass.getAnnotation(xx.class);

        strClass.getMethods();
    }
}
