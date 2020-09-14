package 树.N叉树.q429_N叉树的层序遍历;

import java.util.List;

/**
 * @ClassName : Node
 * @Description :
 * @Author : zph
 * @Date: 2020-07-14 23:20
 * @Version : V1.0
 */
public class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
