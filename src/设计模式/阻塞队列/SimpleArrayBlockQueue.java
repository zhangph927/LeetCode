package 设计模式.阻塞队列;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName : BlockQueue
 * @Description :
 * @Author : zph
 * @Date: 2020-11-05 22:15
 * @Version : V1.0
 */
public class SimpleArrayBlockQueue<T> {
    private int size;
    private Object[] queue;

    private Lock lock = new ReentrantLock();
    private Condition full = lock.newCondition();
    private Condition empty = lock.newCondition();

    private int index;
    private int removeIndex;
    private int currLen;

    public SimpleArrayBlockQueue() {
        this(10);
    }

    public SimpleArrayBlockQueue(int size) {
        this.index = 0;
        this.removeIndex = 0;
        this.currLen = 0;
        this.size = size;
        queue = new Object[size];
    }

    public void put(T element) throws InterruptedException {
        lock.lock();
        try {
            while (currLen == size) {
                System.out.println("队列满。。。");
                full.await();
            }
            queue[index] = element;
            if (++index == size) {
                index = 0;
            }
            currLen++;
            empty.signal();
        } finally {
            lock.unlock();
        }
    }

    public T poll() throws InterruptedException {
        lock.lock();
        try {
            while (currLen == 0) {
                System.out.println("队列空。。。");
                empty.await();
            }
            Object obj = queue[removeIndex];
            if (++removeIndex == size) {
                removeIndex = 0;
            }
            currLen--;
            full.signal();
            return (T) obj;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        SimpleArrayBlockQueue<Integer> blockQueue = new SimpleArrayBlockQueue<Integer>(3);
        blockQueue.put(1);
        System.out.println(blockQueue.poll());
        blockQueue.put(2);
        System.out.println(blockQueue.poll());
        blockQueue.put(3);
        System.out.println(blockQueue.poll());

        blockQueue.put(5);
        blockQueue.put(5);
        System.out.println(blockQueue.poll());
    }

}
