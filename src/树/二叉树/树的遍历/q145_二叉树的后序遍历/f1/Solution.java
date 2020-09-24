package 树.二叉树.树的遍历.q145_二叉树的后序遍历.f1;

import 树.二叉树.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName : Solution
 * @Description :145. 二叉树的后序遍历
 * 给定一个二叉树，返回它的 后序 遍历。
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
 * 输出: [3,2,1]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 * @Author : zph
 * @Date: 2020-09-22 00:09
 * @Version : V1.0
 */
public class Solution {

    /**
     * @Title postorderTraversal
     * @Description 递归
     * @Author zph
     * @Date 2020/9/22 0:12
     * @Param [root]
     * @return java.util.List<java.lang.Integer>
     */
    public List<Integer> postorderTraversal(TreeNode root){
        List<Integer> list = new ArrayList<>();
        if(root!=null){
            list.addAll(postorderTraversal(root.left));
            list.addAll(postorderTraversal(root.right));
            list.add(root.val);

        }
        return list;
    }
}
