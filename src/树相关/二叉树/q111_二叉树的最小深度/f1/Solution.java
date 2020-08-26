package 树相关.二叉树.q111_二叉树的最小深度.f1;

import 树相关.二叉树.TreeNode;

/**
 * @ClassName : Solution
 * @Description :111. 二叉树的最小深度
 * 给定一个二叉树，找出其最小深度。
 *
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 *
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最小深度  2.
 * @Author : zph
 * @Date: 2020-08-21 17:37
 * @Version : V1.0
 */
public class Solution {
    /**
     * @Title minDepth
     * @Description 深度优先搜索
     * @Author zph
     * @Date 2020/8/21 17:41
     * @Param [root]
     * @return int
     */
    public int minDepth(TreeNode root) {
        return helper(root);
    }

    private int helper(TreeNode root){
        if(root==null){
            return 0;
        }
        if(root.left==null&&root.right==null){
            return 1;
        }
        int minNum=Integer.MAX_VALUE;
        if(root.left!=null){
            minNum=Math.min(minNum,helper(root.left));
        }
        if(root.right!=null){
            minNum=Math.min(minNum,helper(root.right));
        }
        return minNum+1;
    }

}
