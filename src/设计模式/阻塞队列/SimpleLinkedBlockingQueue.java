package 设计模式.阻塞队列;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName : SimpleLinkedBlockingQueue
 * @Description :
 * @Author : zph
 * @Date: 2020-11-05 22:26
 * @Version : V1.0
 */
public class SimpleLinkedBlockingQueue<E> {
    static class Node<E> {
        E item;
        Node<E> next;

        Node(E x) {
            item = x;
        }
    }
    private final int capacity;
    private final AtomicInteger count = new AtomicInteger();

    private Node<E> head; //头结点
    private Node<E> tail; //尾节点

    private Lock putLock = new ReentrantLock();
    private Condition putCond = putLock.newCondition();

    private Lock takeLock = new ReentrantLock();
    private Condition takeCond = takeLock.newCondition();


    public SimpleLinkedBlockingQueue() {
        this(Integer.MAX_VALUE);
    }

    public SimpleLinkedBlockingQueue(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException();
        }

        this.capacity = capacity;
        tail = head = new Node<E>(null);
    }


    public void put(E e) throws InterruptedException {
        putLock.lock();
        try {
            while (count.get() == capacity) {
                putCond.await();
            }
            enqueue(e);
            count.getAndIncrement();
        } finally {
            putLock.unlock();
        }

        takeLock.lock(); //signal的使用需要先获取锁
        try {
            takeCond.signal();
        } finally {
            takeLock.unlock();
        }
    }

    public E take() throws InterruptedException {
        E e;
        takeLock.lock();
        try {
            while (count.get() == 0) {
                takeCond.await();
            }
            e = dequeue();
            count.getAndDecrement();
        } finally {
            takeLock.unlock();
        }

        putLock.lock();
        try {
            putCond.signal();
        } finally {
            putLock.unlock();
        }

        return e;
    }

    private void enqueue(E e) {
        Node<E> newTail = new Node<>(e);
        tail.next = newTail; //新节点添加到列表末尾
        tail = newTail; //tail后移一位
    }

    private E dequeue() {
        E ret = head.next.item; //head节点是空的，仅作为哨兵使用，head.next才是第一个数据节点
        head = head.next;
        head.item = null;
        return ret;
    }

    //打印队列内容
    @Override
    public String toString() {
        List<E> arr = new ArrayList<>();

        Node<E> current = head.next;
        while (current != null && current.item != null) {
            arr.add(current.item);
            current = current.next;
        }

        return arr.toString();
    }

}
