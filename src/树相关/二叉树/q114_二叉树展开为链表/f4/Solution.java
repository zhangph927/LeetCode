package 树相关.二叉树.q114_二叉树展开为链表.f4;

import 树相关.二叉树.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @ClassName : Solution
 * @Description :
 * @Author : zph
 * @Date: 2020-07-18 21:36
 * @Version : V1.0
 */
public class Solution {

    /**
     * @return void
     * @Title flatten
     * @Description 改造先序遍历
     * @Author zph
     * @Date 2020/7/18 21:50
     * @Param [root]
     */
    public void flatten(TreeNode root) {
        if(root==null){
            return;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.addLast(root);
        TreeNode pre = null;
        while ( !stack.isEmpty()) {
            TreeNode temp=stack.pollLast();
            if(pre!=null){
                pre.right=temp;
                pre.left=null;
            }
            if(temp.right!=null){
                stack.addLast(temp.right);
            }
            if(temp.left!=null){
                stack.addLast(temp.left);
            }
            pre=temp;
        }


    }


}
