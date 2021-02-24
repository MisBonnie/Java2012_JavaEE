package reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 通过反射来调用方法
 */
public class Demo5 {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        Class stuClass = Student.class;
        Student student = new Student("tom", 29);

        /*String java = student.study("java");
        System.out.println(java);*/

        Method study = stuClass.getMethod("study", String.class);
        // 调用方法需要对象
        Object obj = study.invoke(student, "java");
        System.out.println(obj);

        Method sleep = stuClass.getMethod("sleep");
        Object obj1 = sleep.invoke(student); // sleep方法没有返回值, 所以invoke返回null
        System.out.println(obj1);
    }

}
