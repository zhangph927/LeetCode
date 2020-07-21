package 多线程和并发.多线程.ABC交替输出问题.f3;

import java.util.concurrent.Semaphore;

/**
 * @ClassName : ABC3
 * @Description :使用信号量也可以, 这个思路最简单, 整个代码也比较简洁
 * 注意:
 * <p>
 * lock是需要lock所有者去释放的, 即谁lock, 谁释放, 不可以跨线程, 会报java.lang.IllegalMonitorStateException;
 * <p>
 * semaphore是没有所有者的说法, 可以跨线程释放和获取.
 * @Author : zph
 * @Date: 2020-07-15 13:47
 * @Version : V1.0
 */
public class ABC3 {
    private static Semaphore A = new Semaphore(1);
    private static Semaphore B = new Semaphore(1);
    private static Semaphore C = new Semaphore(1);

    static class ThreadA extends Thread {

        @Override
        public void run() {
            try {
                for (int i = 0; i < 10; i++) {
                    A.acquire();
                    System.out.print("A");
                    B.release();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    static class ThreadB extends Thread {

        @Override
        public void run() {
            try {
                for (int i = 0; i < 10; i++) {
                    B.acquire();
                    System.out.print("B");
                    C.release();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    static class ThreadC extends Thread {

        @Override
        public void run() {
            try {
                for (int i = 0; i < 10; i++) {
                    C.acquire();
                    System.out.println("C");
                    A.release();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) throws InterruptedException {
        B.acquire();
        C.acquire(); // 开始只有A可以获取, BC都不可以获取, 保证了A最先执行
        new ThreadA().start();
        new ThreadB().start();
        new ThreadC().start();
    }
}
