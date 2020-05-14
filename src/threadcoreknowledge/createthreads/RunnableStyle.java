package threadcoreknowledge.createthreads;

/**
 * 用Runnable方式实现线程
 *
 * @author WuJunyi
 * @create 2020-05-13 10:37
 **/
public class RunnableStyle implements Runnable {
    public static void main(String[] args) {
        Thread thread = new Thread(new RunnableStyle());
        thread.start();
    }

    @Override
    public void run() {
        System.out.println("用Runnable方法实现线程");
    }
}
