package a_listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.http.HttpSessionBindingEvent;

/**
 * <servlet></servlet>
 * <servlet-mapping></servlet-mapping>
 *
 * <listener></listener>
 * <listener>-->
 *      <listener-class>a_listener.Demo1Listener</listener-class>
 * </listener>
 */
@WebListener
public class Demo1Listener implements ServletContextListener {
    /**
     * 监听 ServletContext 对象创建的
     * 当对象创建(之后)时, 该方法自动调用
     * @param sce
     */
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("监听到了ServletContext的创建");
        // 初始化工作
    }
    /**
     * 监听 ServletContext 对象销毁的
     * 当对象销毁时(之前), 该方法自动调用
     * @param sce
     */
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("监听到了ServletContext的销毁");
    }
}
