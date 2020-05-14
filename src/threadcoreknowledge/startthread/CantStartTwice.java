package threadcoreknowledge.startthread;

/**
 * 演示不能两次调用start方法，否则会报错
 *
 * @author WuJunyi
 * @create 2020-05-13 13:50
 **/
public class CantStartTwice {

    public static void main(String[] args) {
        Thread thread = new Thread();
        thread.start();
        thread.start();
    }
}
