package annotation;

@MyAnnotation(name="lucy")
public class Demo02 {
    @MyAnnotation(name="lucy")
    public Demo02() {
    }
    @MyAnnotation(name="lucy")
    int a;
    @MyAnnotation(name="lucy")
    public void test01(@MyAnnotation(name="lucy") int s) {
        @MyAnnotation(name="lucy")
        int b = 10;
    }
}
