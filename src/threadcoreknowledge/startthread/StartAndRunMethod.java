package threadcoreknowledge.startthread;


/**
 * 对比start()和run()两种启动线程的方式
 *
 * @author WuJunyi
 * @create 2020-05-13 11:27
 **/
public class StartAndRunMethod {

    public static void main(String[] args) {
        Runnable runnable = () -> {
            System.out.println(Thread.currentThread().getName());
        };
        runnable.run(); // main

        new Thread(runnable).start(); // Thread-0

    }
}
