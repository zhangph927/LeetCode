package 设计模式;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName : SimpleArrayBlockingQueue
 * @Description :
 * @Author : zph
 * @Date: 2020-11-07 23:43
 * @Version : V1.0
 */
public class SimpleArrayBlockingQueue<T> {

    private int size;
    private Object[] objects;
    private int currLen;
    private int index;
    private int removeIndex;

    private Lock lock = new ReentrantLock();
    private Condition fullCond = lock.newCondition();
    private Condition emptyCond = lock.newCondition();

    public SimpleArrayBlockingQueue() {
        this(10);
    }

    public SimpleArrayBlockingQueue(int size) {
        this.size = size;
        this.currLen = 0;
        this.index = 0;
        this.removeIndex = 0;
        objects = new Object[size];
    }

    public void put(T t) throws InterruptedException {
        lock.lock();

        try {
            while (currLen == size) {
                fullCond.await();
            }
            objects[index++] = t;
            if (index == size) {
                index = 0;
            }
            currLen++;
            emptyCond.signal();
        } finally {
            lock.unlock();
        }

    }

    public T take() throws InterruptedException {
        lock.lock();


        try {
            while (removeIndex == size) {
                emptyCond.await();
            }
            Object object = objects[removeIndex++];
            if (removeIndex == size) {
                removeIndex = 0;
            }

            fullCond.signal();

            return (T) object;

        } finally {
            lock.unlock();
        }

    }


}
