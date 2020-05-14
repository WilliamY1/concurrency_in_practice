package threadcoreknowledge.stopthreads;

/**
 * 注意Thread.interrupted()方法的目标对象是"当前线程"
 * 而不管本方法来自于哪个对象
 * @author WuJunyi
 * @create 2020-05-14 14:51
 **/
public class RightWayInterrupted {

    public static void main(String[] args) throws InterruptedException {
        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                for (; ; ) {

                }
            }
        });
        // 启动线程
        threadOne.start();
        // 设置中断标志
        threadOne.interrupt();
        //获取中断标志
        System.out.println("isInterrupted:"+threadOne.isInterrupted());// true
        // 获取中断标志并重置
        System.out.println("isInterrupted:"+threadOne.interrupted());//false 返回main函数的线程 中断状态被清除
        // 获取中断标志并重置
        System.out.println("isInterrupted:"+Thread.interrupted());//false 返回当前主线程的运行状态，所以是false
        // 获取中断标志
        System.out.println("isInterrupted:"+threadOne.isInterrupted());//true isInterrupted不会清除状态
        threadOne.join();
        System.out.println("Main thread is over.");
    }
}
