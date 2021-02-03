package c_singleton;

public class DemoSingleton {
    public static void main(String[] args) {
        /*Single s1 = new Single();
        Single s2 = new Single();*/

        Single s1 = Single.getInstance();
        Single s2 = Single.getInstance();

        System.out.println(s1 == s2);
    }
}
