package 树.二叉树.树的遍历.q145_二叉树的后序遍历.f2;

import 树.二叉树.TreeNode;

import java.util.*;

/**
 * @ClassName : Solution
 * @Description :145. 二叉树的后序遍历
 * 给定一个二叉树，返回它的 后序 遍历。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * 输出: [3,2,1]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 * @Author : zph
 * @Date: 2020-09-22 00:09
 * @Version : V1.0
 */
public class Solution {

    /**
     * @return java.util.List<java.lang.Integer>
     * @Title postorderTraversal
     * @Description 递归
     * @Author zph
     * @Date 2020/9/22 0:12
     * @Param [root]
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = root;
        TreeNode preVisit = null;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.offerLast(cur);
                cur = cur.left;
            } else {
                cur=stack.peekLast();
                if(cur.right!=null&&cur.right!=preVisit){
                    cur=cur.right;
                }else {
                    cur=stack.pollLast();
                    preVisit=cur;
                    list.add(preVisit.val);
                    cur=null;
                }
            }
        }
        return list;
    }
}
