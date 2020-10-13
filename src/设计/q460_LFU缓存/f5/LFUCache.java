package 设计.q460_LFU缓存.f5;

import java.util.HashMap;

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
     * @Description 最傻fufuの O(N) —— 只用1条双向链表
     * @Author zph
     * @Date 2020/10/12 23:24
     * @Param
     * @return
     */
    HashMap<Integer, Node> cache;
    Node head;
    Node tail;
    int capacity;
    int size;

    public LFUCache(int capacity) {
        cache = new HashMap<Integer, Node>(capacity);
        this.capacity = capacity;
        head = new Node();
        tail = new Node();
        head.post = tail;
        tail.pre = head;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        }
        node.freq++;
        moveToNewPosition(node);
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
            moveToNewPosition(node);
        } else {
            if (size == capacity) {
                cache.remove(head.post.key);
                removeNode(head.post);
                size--;
            }
            Node newNode = new Node(key, value);
            addNode(newNode);
            cache.put(key, newNode);
            size++;
        }
    }

    private void moveToNewPosition(Node node) {
        Node nextNode = node.post;
        removeNode(node);
        while (nextNode.freq <= node.freq && nextNode != tail) {
            nextNode = nextNode.post;
        }
        nextNode.pre.post = node;
        node.pre = nextNode.pre;
        node.post = nextNode;
        nextNode.pre = node;
    }

    private void addNode(Node node) {
        node.post = head.post;
        node.pre = head;
        head.post.pre = node;
        head.post = node;
        moveToNewPosition(node);
    }

    private void removeNode(Node node) {
        node.pre.post = node.post;
        node.post.pre = node.pre;
    }
}

class Node {
    int key;
    int value;
    int freq = 1;
    Node pre;
    Node post;

    public Node() {}
    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

