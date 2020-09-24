package 树.二叉树.树的遍历.q144_二叉树的前序遍历.f2;

import 树.二叉树.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @ClassName : Solution
 * @Description :144. 二叉树的前序遍历
 * 给定一个二叉树，返回它的 前序 遍历。
 *
 *  示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,2,3]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 * @Author : zph
 * @Date: 2020-09-21 23:43
 * @Version : V1.0
 */
public class Solution {
    /**
     * @Title preorderTraversal
     * @Description 迭代
     * @Author zph
     * @Date 2020/9/22 0:02
     * @Param [root]
     * @return java.util.List<java.lang.Integer>
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur=root;
        while (cur!=null||!stack.isEmpty()){
            if(cur!=null){
                list.add(cur.val);
                stack.offerLast(cur);
                cur=cur.left;
            }else {
                cur=stack.pollLast();
                cur=cur.right;
            }
        }
        return list;
    }

}
