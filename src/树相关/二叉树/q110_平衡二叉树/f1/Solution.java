package 树相关.二叉树.q110_平衡二叉树.f1;

import 树相关.二叉树.TreeNode;

import java.util.concurrent.ConcurrentSkipListMap;

/**
 * @ClassName : Solution
 * @Description :110. 平衡二叉树
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 *
 * 本题中，一棵高度平衡二叉树定义为：
 *
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 *
 * 示例 1:
 *
 * 给定二叉树 [3,9,20,null,null,15,7]
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回 true 。
 *
 * 示例 2:
 *
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 *
 *        1
 *       / \
 *      2   2
 *     / \
 *    3   3
 *   / \
 *  4   4
 * 返回 false 。
 *
 *
 * @Author : zph
 * @Date: 2020-08-17 00:42
 * @Version : V1.0
 */
public class Solution {
    /**
     * @Title isBalanced
     * @Description 自顶向下的递归
     * @Author zph
     * @Date 2020/8/17 0:43
     * @Param [root]
     * @return boolean
     */
    public boolean isBalanced(TreeNode root) {
        if(root==null){
            return true;
        }
        return Math.abs(high(root.left)-high(root.right))<=1&&isBalanced(root.left)&&isBalanced(root.right);

    }

    private int high(TreeNode root){
        if(root==null){
            return 0;
        }
        return Math.max(high(root.left),high(root.right))+1;

    }
}
