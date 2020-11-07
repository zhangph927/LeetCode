package 设计模式.阻塞队列;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName : TestSimpleLinkedBlockingQueue
 * @Description :
 * @Author : zph
 * @Date: 2020-11-05 22:29
 * @Version : V1.0
 */
public class TestSimpleLinkedBlockingQueue {

    private static SimpleLinkedBlockingQueue<Integer> queue = new SimpleLinkedBlockingQueue<>(3);
    private static AtomicInteger ai = new AtomicInteger();

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        queue.put(ai.getAndIncrement());
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        //打印队列现有元素
                        System.out.println(queue);
                        Integer e = queue.take();
                        System.out.println(e);
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

}
