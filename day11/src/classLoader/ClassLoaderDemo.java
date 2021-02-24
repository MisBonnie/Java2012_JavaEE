package classLoader;
public class ClassLoaderDemo {
    public static void main(String[] args) {
        // 获取应用类加载器 - 自己写的类和第三方jar包类
        ClassLoader classLoader = ClassLoaderDemo.class.getClassLoader();
        System.out.println(classLoader);
        ClassLoader classLoader2 = ClassLoaderDemo2.class.getClassLoader();
        System.out.println(classLoader2 == classLoader);

        ClassLoader classLoader1 = String.class.getClassLoader();
        System.out.println(classLoader1); // null
    }
}
