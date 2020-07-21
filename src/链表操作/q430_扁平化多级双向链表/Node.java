package 链表操作.q430_扁平化多级双向链表;

/**
 * @ClassName : Node
 * @Description :
 * @Author : zph
 * @Date: 2020-07-18 22:27
 * @Version : V1.0
 */
public class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node(int val, Node prev, Node next, Node child) {
        this.val = val;
        this.prev = prev;
        this.next = next;
        this.child = child;
    }
}
