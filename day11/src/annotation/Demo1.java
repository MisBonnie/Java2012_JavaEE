package annotation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SuppressWarnings({"unused","rawtypes"})
@Deprecated
public class Demo1 {
    @SuppressWarnings("all")
    @Deprecated
    public Demo1() {
    }
    @SuppressWarnings("all")
    @Deprecated
    private int var1;

    @SuppressWarnings("all")
    @Deprecated
    public static void main(String[] args) {
        List list = new ArrayList();
        @SuppressWarnings("all")
        @Deprecated
        int a = 10;

        new Date(2012, 4, 3);
    }
//    @SuppressWarnings(value="all")
    @SuppressWarnings("all") // 简略掉了属性名
    @Deprecated(since="8")
//    @Deprecated("8")
    public void sleep() {

    }

    @Override
    public String toString() {
        return "Demo1{" +
                "var1=" + var1 +
                '}';
    }
}
