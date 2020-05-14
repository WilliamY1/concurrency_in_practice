package threadcoreknowledge.sixstates;

/**
 * 展示现成的NEW、RUNNABLE、TERMINATED状态
 * 即使是正在运行，也是Runnable，而不是Running。
 *
 * @author WuJunyi
 * @create 2020-05-14 16:02
 **/
public class NewRunnableTerminated implements Runnable {

    public static void main(String[] args) {
        Thread thread = new Thread(new NewRunnableTerminated());
        // 打印出NEW的状态
        System.out.println(thread.getState());

        thread.start();
        System.out.println(thread.getState());
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 打印出RUNNABLE状态，即使是正在运行，也是Runnable,而不是Running
        System.out.println(thread.getState());
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 打印出TERMINATED状态
        System.out.println(thread.getState());
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println(i);
        }
    }
}
