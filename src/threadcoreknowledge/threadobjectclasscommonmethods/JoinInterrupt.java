package threadcoreknowledge.threadobjectclasscommonmethods;

/**
 * 演示join期间被中断的效果
 *
 * @author WuJunyi
 * @create 2020-05-19 10:13
 **/
public class JoinInterrupt {
    public static void main(String[] args) {
        Thread mainThread = Thread.currentThread();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    mainThread.interrupt();
                    Thread.sleep(5000);
                    System.out.println("Thread1 finished.");
                } catch (InterruptedException e) {
                    System.out.println("子线程中断");
                }
            }
        });
        thread1.start();
        System.out.println("等待子线程运行完毕");
        try {
            thread1.join();
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + "主线程被中断了");
            thread1.interrupt();
            e.printStackTrace();
        }
        System.out.println("子线程已经运行完毕");
    }
}
