package 树.二叉树.填充每个节点的下一个右侧节点指针;

/**
 * @ClassName : Node
 * @Description :
 * @Author : zph
 * @Date: 2020-09-28 23:31
 * @Version : V1.0
 */
public class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
