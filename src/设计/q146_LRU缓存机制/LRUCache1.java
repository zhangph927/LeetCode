package 设计.q146_LRU缓存机制;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName : LRUCache1
 * @Description :
 * @Author : zph
 * @Date: 2020-10-13 12:14
 * @Version : V1.0
 */
public class LRUCache1 {


    class ListNode{

        public Integer key;

        public Integer value;
        /**
         * 前置节点
         */
        public ListNode pre;

        /**
         * 后置节点
         */
        public ListNode next;

        public ListNode(Integer key, Integer value) {
            this.key = key;
            this.value = value;
        }
    }
    /**
     * 容量
     */
    private int capacity;
    /**
     * 哈希表+双向链表
     */
    private Map<Integer,ListNode> map;
    /**
     * 虚拟头节点
     */
    private ListNode dummyHead;
    /**
     * 虚拟尾节点
     */
    private ListNode dummyTail;


    public LRUCache1(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>(capacity);
        this.dummyHead=new ListNode(-1,-1);
        this.dummyTail=new ListNode(-1,-1);
        this.dummyHead.next = dummyTail;
        this.dummyTail.pre = dummyHead;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            ListNode node = map.get(key);

            moveNodeToHead(key);
            return node.value;

        }else {
            return -1;
        }

    }


    public void put(int key, int value) {
        if(map.containsKey(key)){
            ListNode node = map.get(key);
            node.value=value;
            map.put(key,node);
            moveNodeToHead(key);
        }else {

            if(map.size()>=capacity){
                ListNode oldTail=removeTail();
               map.remove(oldTail.key);
            }


            ListNode node = new ListNode(key, value);

            map.put(key,node);

            add2Head(node);




        }

    }

    //公共方法

    //添加头节点

    private void add2Head(ListNode newNode){
        ListNode oldNode=  dummyHead.next;

        oldNode.pre=newNode;

        newNode.next=oldNode;
        newNode.pre=dummyHead;

        dummyHead.next=newNode;
    }


    //删除尾节点
    private ListNode removeTail(){
      ListNode oldTail=  dummyTail.pre;

      oldTail.pre.next=dummyTail;
      dummyTail.pre=oldTail.pre;

      oldTail.next=null;
      oldTail.pre=null;
      return oldTail;
    }

    //移动尾节点到头节点
    private void moveNodeToHead(Integer key){
        ListNode node = map.get(key);
        node.pre.next=node.next;
        node.next.pre=node.pre;
        add2Head(node);
    }






}
