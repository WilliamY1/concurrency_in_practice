package threadcoreknowledge.createthreads.wrongways;

/**
 * 用Lambda表达式实现线程
 *
 * @author WuJunyi
 * @create 2020-05-13 11:20
 **/
public class Lambda {

    public static void main(String[] args) {
        new Thread(() -> System.out.println(Thread.currentThread().getName())).start();
    }
}
