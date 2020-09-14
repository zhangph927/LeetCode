package 树.二叉树.q257_二叉树的所有路径.f2;

import 树.二叉树.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName : Solution
 * @Description :257. 二叉树的所有路径
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * <p>
 * 1
 * /   \
 * 2     3
 * \
 * 5
 * <p>
 * 输出: ["1->2->5", "1->3"]
 * <p>
 * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 * @Author : zph
 * @Date: 2020-09-05 23:12
 * @Version : V1.0
 */
public class Solution {
    /**
     * @return java.util.List<java.lang.String>
     * @Title binaryTreePaths
     * @Description 广度遍历
     * @Author zph
     * @Date 2020/9/5 23:13
     * @Param [root]
     */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<String> pathQueue = new LinkedList<>();
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.offer(root);
        pathQueue.offer(Integer.toString(root.val));
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.poll();
            String path = pathQueue.poll();
            if (node.left == null && node.right == null) {
                res.add(path);
            } else {
                if (node.left != null) {
                    StringBuffer buffer = new StringBuffer(path);
                    buffer.append("->");
                    buffer.append(node.left.val);
                    nodeQueue.offer(node.left);
                    pathQueue.offer(buffer.toString());
                }
                if (node.right != null) {
                    StringBuffer buffer = new StringBuffer(path);
                    buffer.append("->");
                    buffer.append(node.right.val);
                    nodeQueue.offer(node.right);
                    pathQueue.offer(buffer.toString());
                }

            }


        }


        return res;
    }


}
