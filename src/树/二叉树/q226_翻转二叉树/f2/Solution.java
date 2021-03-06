package 树.二叉树.q226_翻转二叉树.f2;

import 树.二叉树.TreeNode;

/**
 * @ClassName : Solution
 * @Description :226. 翻转二叉树
 * 翻转一棵二叉树。
 *
 * 示例：
 *
 * 输入：
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 输出：
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 * 备注:
 * 这个问题是受到 Max Howell 的 原问题 启发的 ：
 *
 * 谷歌：我们90％的工程师使用您编写的软件(Homebrew)，但是您却无法在面试时在白板上写出翻转二叉树这道题，这太糟糕了。
 * @Author : zph
 * @Date: 2020-09-18 00:09
 * @Version : V1.0
 */
public class Solution {
    /**
     * @Title invertTree
     * @Description 前序遍历 递归
     * @Author zph
     * @Date 2020/9/18 0:14
     * @Param [root]
     * @return 树.二叉树.TreeNode
     */
    public TreeNode invertTree(TreeNode root) {
        // base case
        if (root == null) {
            return null;
        }

        /**** 前序遍历位置 ****/
        // root 节点需要交换它的左右子节点
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        // 让左右子节点继续翻转它们的子节点
        invertTree(root.left);
        invertTree(root.right);

        return root;

    }
}
