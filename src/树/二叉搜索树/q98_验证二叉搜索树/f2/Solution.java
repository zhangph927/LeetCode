package 树.二叉搜索树.q98_验证二叉搜索树.f2;

import 树.二叉树.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @ClassName : Solution
 * @Description :98. 验证二叉搜索树
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 假设一个二叉搜索树具有如下特征：
 *
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 示例 1:
 *
 * 输入:
 *     2
 *    / \
 *   1   3
 * 输出: true
 * 示例 2:
 *
 * 输入:
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
 * @Author : zph
 * @Date: 2020-07-08 21:30
 * @Version : V1.0
 */
public class Solution {


    /**
     * @Title isValidBST
     * @Description 迭代
     * @Author zph
     * @Date 2020/7/8 21:31
     * @Param [root]
     * @return boolean
     */
    public boolean isValidBST(TreeNode root) {
        if(root==null){
            return true;
        }
        //前一个值
        long pre=Long.MIN_VALUE;
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode node=root;
        while (!stack.isEmpty()||node!=null){
            if(node!=null){
                stack.addLast(node);
                node=node.left;
            }else {
               node= stack.removeLast();
               if(node.val<=pre){
                   return false;
               }
               pre=node.val;
               node=node.right;
            }


        }
        return true;



    }
}
