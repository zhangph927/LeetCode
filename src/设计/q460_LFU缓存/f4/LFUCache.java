package 设计.q460_LFU缓存.f4;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @ClassName : LFUCache
 * @Description :460. LFU缓存
 * 请你为 最不经常使用（LFU）缓存算法设计并实现数据结构。它应该支持以下操作：get 和 put。
 * <p>
 * get(key) - 如果键存在于缓存中，则获取键的值（总是正数），否则返回 -1。
 * put(key, value) - 如果键已存在，则变更其值；如果键不存在，请插入键值对。当缓存达到其容量时，则应该在插入新项之前，使最不经常使用的项无效。在此问题中，当存在平局（即两个或更多个键具有相同使用频率）时，应该去除最久未使用的键。
 * 「项的使用次数」就是自插入该项以来对其调用 get 和 put 函数的次数之和。使用次数会在对应项被移除后置为 0 。
 * <p>
 * <p>
 * <p>
 * 进阶：
 * 你是否可以在 O(1) 时间复杂度内执行两项操作？
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * LFUCache cache = new LFUCache( 2  capacity (缓存容量)  );
 * <p>
 * cache.put(1,1);
 * cache.put(2,2);
 * cache.get(1);       // 返回 1
 * cache.put(3,3);    // 去除 key 2
 * cache.get(2);       // 返回 -1 (未找到key 2)
 * cache.get(3);       // 返回 3
 * cache.put(4,4);    // 去除 key 1
 * cache.get(1);       // 返回 -1 (未找到 key 1)
 * cache.get(3);       // 返回 3
 * cache.get(4);       // 返回 4
 * @Author : zph
 * @Date: 2020-10-12 23:14
 * @Version : V1.0
 */
public class LFUCache {
    /**
     * @Title
     * @Description O(logN) 解法 —— 使用小根堆找到 freq 最小，
     * 因为 Java 中的 PriorityQueue 默认就是小根堆, 实现最简单
     * @Author zph
     * @Date 2020/10/12 23:23
     * @Param
     * @return
     */
    Map<Integer, Node> cache;
    Queue<Node> queue;
    int capacity;
    int size;
    int idx = 0;

    public LFUCache(int capacity) {
        cache = new HashMap<>(capacity);
        if (capacity > 0) {
            queue = new PriorityQueue<>(capacity);
        }
        this.capacity = capacity;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        }
        node.freq++;
        node.idx = idx++;
        queue.remove(node);
        queue.offer(node);
        return node.value;

    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        Node node = cache.get(key);
        if (node != null) {
            node.value = value;
            node.freq++;
            node.idx = idx++;
            queue.remove(node);
            queue.offer(node);
        } else {
            if (size == capacity) {
                cache.remove(queue.peek().key);
                queue.poll();
                size--;
            }
            Node newNode = new Node(key, value, idx++);
            cache.put(key, newNode);
            queue.offer(newNode);
            size++;
        }
    }
}

class Node implements Comparable<Node> {
    int key;
    int value;
    int freq;
    int idx;

    public Node() {
    }

    public Node(int key, int value, int idx) {
        this.key = key;
        this.value = value;
        freq = 1;
        this.idx = idx;
    }

    @Override
    public int compareTo(Node node) {
        int diff = freq - node.freq;
        return diff != 0 ? diff : idx - node.idx;
    }
}
