package threadcoreknowledge.stopthreads;

/**
 * 最佳实践：catch了InterruptedException之后的优先选择：
 * 在方法签名中抛出了异常
 * 那么在run()方法中就会强制try/catch
 *
 * @author WuJunyi
 * @create 2020-05-14 9:53
 **/
public class RightWayStopThreadInProd implements Runnable {
    @Override
    public void run() {
        while (true && !Thread.currentThread().isInterrupted()) {
            System.out.println("go");
            try {
                throwInMethod();
            } catch (InterruptedException e) {
                // 保存日志、停止程序
                System.out.println("保存日志");
                e.printStackTrace();
            }
        }
    }

    private void throwInMethod() throws InterruptedException {
        // 错误情况
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        Thread.sleep(2000);
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new RightWayStopThreadInProd());
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();
    }
}
