package threadcoreknowledge.uncaughtexception;

/**
 * 1. 不加try catch 抛出4个异常，都是带线程名字的
 * 2. 加了try catch 期望捕获到第一个线程的异常，线程234不应该运行，
 * 希望看到打印出Caught Exception
 * 3. 执行时发现，根本又有Caught Exception,线程234依然运行并且抛出异常
 * <p>
 * 说明线程的异常不能用传统方法捕获
 *
 * @author WuJunyi
 * @create 2020-05-20 9:29
 **/
public class CantCatchDirectly implements Runnable {

    public static void main(String[] args) throws InterruptedException {
        new Thread(new CantCatchDirectly(), "MyThread-1").start();
        Thread.sleep(300);
        new Thread(new CantCatchDirectly(), "MyThread-2").start();
        Thread.sleep(300);
        new Thread(new CantCatchDirectly(), "MyThread-3").start();
        Thread.sleep(300);
        new Thread(new CantCatchDirectly(), "MyThread-4").start();
        Thread.sleep(300);

    }

    @Override
    public void run() {
        try {
            throw new RuntimeException();
        } catch (RuntimeException e) {
            System.out.println("Caught Exception.");
        }

    }
}
