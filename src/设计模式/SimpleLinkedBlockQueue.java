package 设计模式;

import sun.awt.geom.AreaOp;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName : SimpleLinkedBlockQueue
 * @Description :
 * @Author : zph
 * @Date: 2020-11-07 23:59
 * @Version : V1.0
 */
public class SimpleLinkedBlockQueue<T> {
    public class Node<T> {
        T item;
        Node<T> next;

        public Node(T t) {
            this.item = t;
        }
    }

    private int capacity;

    private AtomicInteger count = new AtomicInteger();

    private Node<T> head;

    private Node<T> tail;

    private Lock putLock = new ReentrantLock();

    private Condition putCond = putLock.newCondition();

    private Lock takeLock = new ReentrantLock();

    private Condition takeCond = takeLock.newCondition();

    public SimpleLinkedBlockQueue() {
        this(Integer.MAX_VALUE);
    }

    public SimpleLinkedBlockQueue(int capacity) {
        this.capacity = capacity;
        this.head = tail = new Node<>(null);
    }

    public void put(T t) throws InterruptedException {
        putLock.lock();
        try {
            while (count.get() == capacity) {
                putCond.await();
            }

            count.getAndIncrement();
            enqueue(t);

        } finally {
            putLock.unlock();
        }

        takeLock.lock();

        try {
            takeCond.signal();

        } finally {
            takeLock.unlock();
        }

    }

    private void enqueue(T t) {
        Node<T> node = new Node<>(t);
        tail.next = node;
        tail = node;
    }

    public T take() throws InterruptedException {
        T t;
        takeLock.lock();

        try {
            while (count.get() == 0) {
                takeCond.await();
            }
            count.getAndDecrement();

            t = dequeue();

        } finally {
            takeLock.unlock();
        }
        putLock.lock();
        try {
            putCond.signal();

        } finally {
            putLock.unlock();
        }


        return t;
    }

    private T dequeue() {
        T t = head.next.item;

        head = head.next;

        head.item = null;
        return  t;

    }


}
