package threadcoreknowledge.stopthreads;

/**
 * run无法抛出checked Exception,只能用try/catch
 * @author WuJunyi
 * @create 2020-05-14 10:03
 **/
public class RunThrowException {
    public void aVoid() throws Exception {
        throw new Exception();
    }

    public static void main(String[] args)  {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    throw new Exception();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
