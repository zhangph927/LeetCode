package 树.二叉树.树的遍历.q145_二叉树的后序遍历.f3;

import 树.二叉树.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
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
     * @Description 后序莫里斯迭代
     * 修改后序莫里斯迭代的思路其实和上面修改后序迭代的思路一样
     *
     * 把前序莫里斯遍历的代码粘贴过来
     * 把原来所有的right改成left，把原来所有的left改成right
     * 返回结果之前反转一下数组
     * 这种后序迭代遍历的核心思路都是通过交换前序遍历中遍历左右子树的顺序，达到完全逆转后序遍历的结果，最后反转得到正确的结果。
     * @Author zph
     * @Date 2020/9/22 0:12
     * @Param [root]
     * @return java.util.List<java.lang.Integer>
     */
    public List<Integer> postorderTraversal(TreeNode root){
        if (root == null) {
            return new ArrayList<>();
        }

        TreeNode cur = root;    // 记录当前节点位置
        List<Integer> res = new ArrayList<>();
        while (cur != null) {
            if (cur.right == null) {   // 右节点为空，移到左子节点
                res.add(cur.val);
                cur = cur.left;
            }  else {
                TreeNode prev = cur.right;
                while (prev.left != null && prev.left != cur) { // 遍历右子树的最左侧节点
                    prev = prev.left;
                }
                if (prev.left == null) {        // 建立返回父节点连接
                    prev.left = cur;
                    res.add(cur.val);           // 添加元素到数组
                    cur = cur.right;
                } else {                        // 右子树建立了连接，说明遍历完了，可以拆除连接
                    prev.left = null;
                    cur = cur.left;
                }
            }
        }
        Collections.reverse(res);   // 最后要反转数组得到最后的结果
        return res;
    }
}
