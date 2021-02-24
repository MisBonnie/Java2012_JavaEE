package classLoader;
public class ClassLoaderDemo2 {
    public static void main(String[] args) {
        // 通过类加载器来获取类路径(classpath)中资源的绝对路径
        // 因为类路径就是src编译后的位置, 所以说成src中资源的绝对路径
        String path = ClassLoaderDemo2.class.getClassLoader().getResource("index.html").getPath();
        System.out.println(path);
        // 获得和ClassLoaderDemo2类同包下资源的绝对路径
        String patha = ClassLoaderDemo2.class.getResource("a.txt").getPath();
        System.out.println(patha);
        String path1 = ClassLoaderDemo2.class.getClassLoader().getResource("classLoader/a.txt").getPath();
        System.out.println(path1);


        // ServletContext.getRealPath()
    }
}
