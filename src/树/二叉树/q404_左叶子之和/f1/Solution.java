package 树.二叉树.q404_左叶子之和.f1;

import 树.二叉树.TreeNode;

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
     * @Description 深度优先搜索
     * @Author zph
     * @Date 2020/9/19 23:02
     * @Param [root]
     */
    public int sumOfLeftLeaves(TreeNode root) {

        return root != null ? dfs(root) : 0;

    }

    private int dfs(TreeNode node) {
        int ans = 0;
        if (node.left != null) {
            ans += isLeft(node.left) ? node.left.val : dfs(node.left);
        }
        if (node.right != null && !isLeft(node.right)) {
            ans += dfs(node.right);
        }
        return ans;


    }

    private boolean isLeft(TreeNode node) {
        return node.left == null && node.right == null;
    }
}
