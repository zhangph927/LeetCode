package 设计.q460_LFU缓存.f1;

import java.lang.ref.Reference;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

/**
 * @ClassName : LFUCache
 * @Description :460. LFU缓存
 * 请你为 最不经常使用（LFU）缓存算法设计并实现数据结构。它应该支持以下操作：get 和 put。
 *
 * get(key) - 如果键存在于缓存中，则获取键的值（总是正数），否则返回 -1。
 * put(key, value) - 如果键已存在，则变更其值；如果键不存在，请插入键值对。当缓存达到其容量时，则应该在插入新项之前，使最不经常使用的项无效。在此问题中，当存在平局（即两个或更多个键具有相同使用频率）时，应该去除最久未使用的键。
 * 「项的使用次数」就是自插入该项以来对其调用 get 和 put 函数的次数之和。使用次数会在对应项被移除后置为 0 。
 *
 *
 *
 * 进阶：
 * 你是否可以在 O(1) 时间复杂度内执行两项操作？
 *
 *
 *
 * 示例：
 *
 * LFUCache cache = new LFUCache( 2  capacity (缓存容量)  );
        *
        *cache.put(1,1);
        *cache.put(2,2);
        *cache.get(1);       // 返回 1
        *cache.put(3,3);    // 去除 key 2
        *cache.get(2);       // 返回 -1 (未找到key 2)
        *cache.get(3);       // 返回 3
        *cache.put(4,4);    // 去除 key 1
        *cache.get(1);       // 返回 -1 (未找到 key 1)
        *cache.get(3);       // 返回 3
        *cache.get(4);       // 返回 4
 * @Author : zph
 * @Date: 2020-10-12 23:14
 * @Version : V1.0
 */
public class LFUCache {
    /**
     * @Title
     * @Description O(1) 解法 —— 双向链表直接使用LinkedHashSet
     * @Author zph
     * @Date 2020/10/12 23:17
     * @Param
     * @return
     */
    Map<Integer, Node> cache;  // 存储缓存的内容
    Map<Integer, LinkedHashSet<Node>> freqMap; // 存储每个频次对应的双向链表
    int size;
    int capacity;
    int min; // 存储当前最小频次

    public LFUCache(int capacity) {
        cache = new HashMap<>(capacity);
        freqMap = new HashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        }
        freqInc(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        Node node = cache.get(key);
        if (node != null) {
            node.value = value;
            freqInc(node);
        } else {
            if (size == capacity) {
                Node deadNode = removeNode();
                cache.remove(deadNode.key);
                size--;
            }
            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            addNode(newNode);
            size++;
        }
    }

    void freqInc(Node node) {
        // 从原freq对应的链表里移除, 并更新min
        int freq = node.freq;
        LinkedHashSet<Node> set = freqMap.get(freq);
        set.remove(node);
        if (freq == min && set.size() == 0) {
            min = freq + 1;
        }
        // 加入新freq对应的链表
        node.freq++;
        LinkedHashSet<Node> newSet = freqMap.get(freq + 1);
        if (newSet == null) {
            newSet = new LinkedHashSet<>();
            freqMap.put(freq + 1, newSet);
        }
        newSet.add(node);
    }

    void addNode(Node node) {
        LinkedHashSet<Node> set = freqMap.get(1);
        if (set == null) {
            set = new LinkedHashSet<>();
            freqMap.put(1, set);
        }
        set.add(node);
        min = 1;
    }

    Node removeNode() {
        LinkedHashSet<Node> set = freqMap.get(min);
        Node deadNode = set.iterator().next();
        set.remove(deadNode);
        return deadNode;
    }
}

class Node {
    int key;
    int value;
    int freq = 1;

    public Node() {}

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

