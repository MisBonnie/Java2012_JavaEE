package reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 通过反射来创建对象
 */
public class Demo3 {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class stuClass = Student.class;
        Constructor constructor = stuClass.getConstructor();

        // 调用无参构造器
        Student stu1 = (Student) constructor.newInstance();
        // 简写 - 调用无参构造器创建对象
        stuClass.newInstance();

        System.out.println(stu1);

        // ----------------
        Constructor constructor1 = stuClass.getConstructor(String.class, int.class);
        Student stu2 = (Student) constructor1.newInstance("lucy", 28);

        System.out.println(stu2);
    }
}
