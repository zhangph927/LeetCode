package 树相关.二叉树.q114_二叉树展开为链表.f3;

import 树相关.二叉树.TreeNode;

import java.util.*;

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
     * @Description 改造版本后序遍历 迭代
     * 而 6 5 4 3 2 1 的遍历顺序其实变形的后序遍历，遍历顺序是右子树->左子树->根节点。
     * @Author zph
     * @Date 2020/7/18 21:50
     * @Param [root]
     */
    public void flatten(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = root;
        TreeNode pre = null;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.addLast(cur);
                cur = cur.right;
            } else {
                cur = stack.peekLast();
                if (cur.left != null && cur.left != pre) {
                    cur = cur.left;
                } else {
                    cur = stack.pollLast();
                    cur.right = pre;
                    cur.left = null;
                    pre = cur;
                    cur = null;

                }
            }

        }


    }


}
