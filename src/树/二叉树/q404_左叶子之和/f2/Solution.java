package 树.二叉树.q404_左叶子之和.f2;

import 树.二叉树.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName : Solution
 * @Description :404. 左叶子之和
 * 计算给定二叉树的所有左叶子之和。
 * <p>
 * 示例：
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
 * @Author : zph
 * @Date: 2020-09-19 23:00
 * @Version : V1.0
 */
public class Solution {


    /**
     * @return int
     * @Title sumOfLeftLeaves
     * @Description 广度优先搜索
     * @Author zph
     * @Date 2020/9/19 23:02
     * @Param [root]
     */
    public int sumOfLeftLeaves(TreeNode root) {

        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int ans = 0;
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            if (poll.left != null) {
                if (isLeft(poll.left)) {

                    ans += poll.left.val;
                } else {
                    queue.offer(poll.left);
                }
            }
            if (poll.right != null) {
                if (!isLeft(poll.right)) {
                    queue.offer(poll.right);
                }
            }
        }
        return ans;
    }


    private boolean isLeft(TreeNode node) {
        return node.left == null && node.right == null;
    }
}
