package 树.二叉树.q114_二叉树展开为链表.f5;

import 树.二叉树.TreeNode;

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
        // base case
        if (root == null) return;

        flatten(root.left);
        flatten(root.right);

        /**** 后序遍历位置 ****/
        // 1、左右子树已经被拉平成一条链表
        TreeNode left = root.left;
        TreeNode right = root.right;

        // 2、将左子树作为右子树
        root.left = null;
        root.right = left;

        // 3、将原先的右子树接到当前右子树的末端
        TreeNode p = root;
        while (p.right != null) {
            p = p.right;
        }
        p.right = right;
    }


}
