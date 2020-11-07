package 设计模式;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName : SimpleArrayBlockQueue
 * @Description :
 * @Author : zph
 * @Date: 2020-11-05 23:39
 * @Version : V1.0
 */
public class SimpleArrayBlockQueue<T> {

    private int size;
    private Object[] queue;

    private Lock lock = new ReentrantLock();
    private Condition empty = lock.newCondition();
    private Condition full = lock.newCondition();

    private int index;
    private int removeIndex;
    private int currLen;

    public SimpleArrayBlockQueue() {
        this(10);
    }

    public SimpleArrayBlockQueue(int size) {
        this.size = size;
        this.queue = new Object[size];
        this.index = 0;
        this.removeIndex = 0;
        this.currLen = 0;
    }

    public void put(T element) throws InterruptedException {
        lock.lock();
        try {
            while (currLen == size) {
                full.await();
            }
            queue[index++] = element;
            if (index == size) {
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
                empty.await();
            }
            Object val = queue[removeIndex++];
            if (removeIndex == size) {
                removeIndex = 0;
            }
            currLen--;
            full.signal();
            return (T) val;
        } finally {
            lock.unlock();
        }
    }


}
