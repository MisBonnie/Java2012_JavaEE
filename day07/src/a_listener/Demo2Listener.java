package a_listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class Demo2Listener implements ServletContextAttributeListener {
    /**
     * 向域中添加数据时触发
     *
     * @param scae
     */
    @Override
    public void attributeAdded(ServletContextAttributeEvent scae) {
        // scae得到添加进去的name-value
        System.out.println("域中有内容添加了" + scae.getName() + "--" + scae.getValue());
    }
    /**
     * 从域中删除数据时触发
     *
     * @param scae
     */
    @Override
    public void attributeRemoved(ServletContextAttributeEvent scae) {
        // scae得到被删除的name-value
        System.out.println("域种一个内容被删除了" + scae.getName() + "--" + scae.getValue());
    }

    /**
     * 修改域中数据时触发
     *
     * @param scae
     */
    @Override
    public void attributeReplaced(ServletContextAttributeEvent scae) {
        // scae得到被替换掉的name-value
        System.out.println("域中一个内容被替换了" + scae.getName() + "--" + scae.getValue());
    }
}
