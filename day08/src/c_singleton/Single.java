package c_singleton;

/**
 * 设计Single为单例模式
 * 1.不能随意new对象, 构造方法私有化
 * 2.提供一个公共的获得该对象的方法
 * 3.定义一个自己类型的静态成员变量(只执行一次)
 * 懒汉模式   饿汉模式(静态变量直接创建好的)
 */
public class Single {
    private static Single single;
    private Single() {

    }
    public static Single getInstance() {
        if (single == null) {
            single = new Single();
        }
        return single;
    }
}
