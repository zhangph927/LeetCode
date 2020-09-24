package 树.二叉搜索树.q538_把二叉搜索树转换为累加树.f1;

import 树.二叉搜索树.TreeNode;

/**
 * @ClassName : Solution
 * @Description :538. 把二叉搜索树转换为累加树
 * 给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，使得每个节点的值是原来的节点值加上所有大于它的节点值之和。
 *
 *
 *
 * 例如：
 *
 * 输入: 原始二叉搜索树:
 *               5
 *             /   \
 *            2     13
 *
 * 输出: 转换为累加树:
 *              18
 *             /   \
 *           20     13
 *
 * @Author : zph
 * @Date: 2020-09-21 22:58
 * @Version : V1.0
 */
public class Solution {
    int sum=0;
    /**
     * @Title convertBST
     * @Description 反序中序遍历
     * @Author zph
     * @Date 2020/9/21 23:17
     * @Param [root]
     * @return 树.二叉搜索树.TreeNode
     */
    public TreeNode convertBST(TreeNode root) {
        if(root!=null){

        convertBST(root.right);
        sum+=root.val;
        root.val=sum;
        convertBST(root.left);
        }
        return root;
    }
}
