package threadcoreknowledge.createthreads.wrongways;

/**
 * 用匿名内部类实现线程
 * @author WuJunyi
 * @create 2020-05-13 11:17
 **/
public class AnonymousInnerClassDemo {

    public static void main(String[] args) {
        new Thread(){
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        }.start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        }).start();
    }
}
