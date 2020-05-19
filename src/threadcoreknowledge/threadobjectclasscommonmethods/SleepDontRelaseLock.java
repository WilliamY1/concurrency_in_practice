package threadcoreknowledge.threadobjectclasscommonmethods;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 演示sleep不释放lock(lock需要手动释放)
 *
 * @author WuJunyi
 * @create 2020-05-19 9:46
 **/
public class SleepDontRelaseLock implements Runnable {

    private static final Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        SleepDontRelaseLock sleepDontRelaseLock = new SleepDontRelaseLock();
        new Thread(sleepDontRelaseLock).start();
        new Thread(sleepDontRelaseLock).start();
    }

    @Override
    public void run() {
        lock.lock();
        System.out.println("线程" + Thread.currentThread().getName() + "获取到了锁");
        try {
            Thread.sleep(5000);
            System.out.println("线程" + Thread.currentThread().getName() + "已经苏醒");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }
}
