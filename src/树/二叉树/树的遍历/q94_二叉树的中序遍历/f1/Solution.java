package 树.二叉树.树的遍历.q94_二叉树的中序遍历.f1;

import 树.二叉树.TreeNode;
import 王争算法课程代码.q05_array.Array;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName : Solution
 * @Description :94. 二叉树的中序遍历
 * 给定一个二叉树，返回它的中序 遍历。
 *
 * 示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,3,2]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 * @Author : zph
 * @Date: 2020-09-14 23:21
 * @Version : V1.0
 */
public class Solution {

    /**
     * @Title inorderTraversal
     * @Description 递归
     * @Author zph
     * @Date 2020/9/14 23:23
     * @Param [root]
     * @return java.util.List<java.lang.Integer>
     */
    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> list = new ArrayList<>();
        helper(root,list);
        return list;
    }

    private void helper(TreeNode root,List<Integer> list){
        if(root==null){
            return;
        }
        helper(root.left,list);
       list.add(root.val);
        helper(root.right,list);

    }

}
