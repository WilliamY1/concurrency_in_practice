package threadcoreknowledge.threadobjectclasscommonmethods;

/**
 * ID从1开始，JVM运行起来之后，我们自己创建的线程的ID早已不是2
 *
 * @author WuJunyi
 * @create 2020-05-19 15:59
 **/
public class Id {
    public static void main(String[] args) {
        Thread thread = new Thread();
        System.out.println("主线程的ID"+Thread.currentThread().getId());
        System.out.println("子线程的ID"+thread.getId());
    }
}
