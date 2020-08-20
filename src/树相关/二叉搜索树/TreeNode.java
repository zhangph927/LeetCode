package 树相关.二叉搜索树;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode() {
    }

    public TreeNode(int x) {
        val = x;
    }

    @Override
    //preorder traversal
    public String toString() {
        StringBuilder s = new StringBuilder();
        TreeNode cur = this;
        Queue<TreeNode> queue = new LinkedList<>();
        if(cur!=null)
            queue.offer(this);
        while(!queue.isEmpty()) {
            cur = queue.poll();
            s.append(cur.val);
            s.append("  ");
            if(cur.left!=null)
                queue.offer(cur.left);
            if(cur.right!=null)
                queue.offer(cur.right);
        }
        return s.toString();
    }
}
