package threadcoreknowledge.createthreads;

/**
 * 同时使用Runnable方式和Thread方式
 *
 * @author WuJunyi
 * @create 2020-05-13 10:49
 **/
public class BothRunnableThread {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("我来自Runnable");
            }
        }) {
            @Override
            public void run() {
                System.out.println("我来自Thread");
            }
        }.start();
    }
}
