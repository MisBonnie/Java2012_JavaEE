package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class Demo1 {
    public static void main(String[] args) {
        // 普通对象, 增强之前的对象 - 被代理对象
        UserService us = new UserServiceImpl();

        // 将us这个对象增强一下 -> 动态代理生成的对象 -> 代理对象
        us.transfer();
        System.out.println("-------------");
        /*
            第一个参数: 类加载器, 被代理对象的类加载器
            第二个参数: 被代理对象的父接口
            第三个参数: InvocationHandler 执行句柄
         */
        UserService proxyUs = (UserService) Proxy.newProxyInstance(
                UserServiceImpl.class.getClassLoader(),
                UserServiceImpl.class.getInterfaces(),
                new InvocationHandler() {
                    @Override
                    /**
                     * 代理对象要增强的部分, 需求: 在不改变原先方法功能的前提下, 增强部分功能
                     * 参数1: proxy -> 生成的代理对象
                     * 参数2: method -> 当前正在执行的方法
                     * 参数3: args -> 参数, 正在执行的这个方法传递的参数
                     */
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        //System.out.println("invoke     " +  method.getName() + "," + Arrays.toString(args));
                        // 开启事务
                        System.out.println("开启事务");
                        // 调用原来的方法
                        Object invoke = method.invoke(us, args);
                        System.out.println("关闭事务");
                        return invoke;
                    }
                }
        );
        proxyUs.transfer(); // 执行代理对象的执行句柄中的invoke方法
        proxyUs.addUser("lucy");
        proxyUs.deleteUser(1);
        proxyUs.updateUser();
        proxyUs.selectUser();

        System.out.println(proxyUs);
    }
}
