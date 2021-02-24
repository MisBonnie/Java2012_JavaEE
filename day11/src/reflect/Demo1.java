package reflect;

/**
 * 获得类的字节码对象
 */
public class Demo1 {
    public static void main(String[] args) throws ClassNotFoundException {
        // 1.通过类名来获得 -- 适用于所有类型,包括基本数据类型
        Class stuClass = Student.class;
        // 2.方式二, 通过Class的静态方法forName
        Class stuClass2 = Class.forName("reflect.Student");

        System.out.println(stuClass == stuClass2);
        // 3.方式三, 通过对象来获得
        Student stu = new Student();
        Class stuClass3 = stu.getClass();

        Class intClass = int.class;
        Class integerClass = Integer.class;
        System.out.println(intClass == integerClass);
    }
}
