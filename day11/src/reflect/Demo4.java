package reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * 通过反射来注入属性/成员变量
 */
public class Demo4 {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        Class stuClass = Student.class;
        Student student = new Student();

        Field name = stuClass.getDeclaredField("name");
        Field age = stuClass.getDeclaredField("age");

        // 设置私有权限为可访问
        name.setAccessible(true);
        age.setAccessible(true);

        // 属性是属于对象的
        name.set(student, "tom");
        age.set(student, 19);

        System.out.println(student);
    }
}
