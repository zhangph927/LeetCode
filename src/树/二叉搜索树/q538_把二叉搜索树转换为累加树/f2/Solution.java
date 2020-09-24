package 树.二叉搜索树.q538_把二叉搜索树转换为累加树.f2;

import 树.二叉搜索树.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

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
    /**
     * @Title convertBST
     * @Description 反序中序遍历
     * @Author zph
     * @Date 2020/9/21 23:17
     * @Param [root]
     * @return 树.二叉搜索树.TreeNode
     */
    public TreeNode convertBST(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur=root;
        int sum=0;
        while (cur!=null||!stack.isEmpty()){
            if(cur!=null){
                stack.offerLast(cur);
                cur=cur.right;
            }else {
                cur=stack.pollLast();
                sum+=cur.val;
                cur.val=sum;
                cur=cur.left;
            }
        }

        return root;
    }
}
