package b_objectListener;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import javax.servlet.http.HttpSessionEvent;
import java.io.Serializable;

public class User implements HttpSessionBindingListener, Serializable, HttpSessionActivationListener {
    private String name;
    private Integer age;

    public User() {
    }

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public void valueBound(HttpSessionBindingEvent event) {
        System.out.println("对象被绑定到session上了: " + this.getName());
    }
    @Override
    public void valueUnbound(HttpSessionBindingEvent event) {
        System.out.println("对象从session中解绑了: " + this.getName());
    }
    // 对象被钝化时调用方法
    @Override
    public void sessionWillPassivate(HttpSessionEvent se) {
        System.out.println("对象即将被钝化: " + this.getName());
    }
    // 对象被活化时调用方法
    @Override
    public void sessionDidActivate(HttpSessionEvent se) {
        System.out.println("对象被活化了: " + this.getName());
    }
}
