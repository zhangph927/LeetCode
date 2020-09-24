package 树.二叉树.树的遍历.q144_二叉树的前序遍历.f1;

import 树.二叉树.TreeNode;
import 王争算法课程代码.q05_array.Array;

import java.util.ArrayList;
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
     * @Description 递归
     * @Author zph
     * @Date 2020/9/22 0:02
     * @Param [root]
     * @return java.util.List<java.lang.Integer>
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root!=null){
            list.add(root.val);
            list.addAll(preorderTraversal(root.left));
            list.addAll(preorderTraversal(root.right));

        }
        return list;
    }

}
