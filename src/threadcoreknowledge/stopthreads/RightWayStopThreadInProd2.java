package threadcoreknowledge.stopthreads;

/**
 * 最佳实践2：在catch语句中调用Thread.currentThread().interrupt()来恢复设置中断状态
 * 以便于在后续执行中，依然能够检查到刚才发生了中断
 * 回到刚才的RightWayStopThreadInProd补上中断，让它跳出
 *
 * @author WuJunyi
 * @create 2020-05-14 9:53
 **/
public class RightWayStopThreadInProd2 implements Runnable {
    @Override
    public void run() {
        while (true) {
            System.out.println("go");
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("Interrupted,程序运行结束");
                break;
            }
            reInterrupt();
        }
    }

    private void reInterrupt() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // 响应中断后会清除中断标志位，重新设置中断
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new RightWayStopThreadInProd2());
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();
    }
}
