package 多线程.ABC交替输出问题.f1;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName : ABC
 * @Description :大概的问题是这样的:
 * <p>
 * 有A,B,C三个线程, A线程输出A, B线程输出B, C线程输出C
 * <p>
 * 要求, 同时启动三个线程, 按顺序输出ABC, 循环10次
 * <p>
 * 这是一个多线程协同的问题, 本身多线程是没有执行顺序的, 顺序不一定, Java在concurrent里面提供了多线程同步的支持
 * <p>
 * 使用ReentrantLock来解决, 还有个state整数用来判断轮到谁执行了
 * @Author : zph
 * @Date: 2020-07-15 13:42
 * @Version : V1.0
 */
public class ABC {
    private static Lock lock = new ReentrantLock();//通过JDK5中的锁来保证线程的访问的互斥

    private static int state = 0;


    static class ThreadA extends Thread {

        @Override


        public void run() {
            for (int i = 0; i < 10; ) {
                lock.lock();
                if (state % 3 == 0) {
                    System.out.print("A");
                    state++;
                    i++;

                }
                lock.unlock();
            }

        }

    }


    static class ThreadB extends Thread {

        @Override


        public void run() {
            for (int i = 0; i < 10; ) {
                lock.lock();
                if (state % 3 == 1) {
                    System.out.print("B");
                    state++;
                    i++;

                }
                lock.unlock();

            }

        }

    }


    static class ThreadC extends Thread {

        @Override


        public void run() {
            for (int i = 0; i < 10; ) {
                lock.lock();
                if (state % 3 == 2) {
                    System.out.print("C");
                    state++;
                    i++;

                }
                lock.unlock();

            }

        }

    }


    public static void main(String[] args) {
        new ThreadA().start();
        new ThreadB().start();
        new ThreadC().start();

    }
}
