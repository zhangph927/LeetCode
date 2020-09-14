package 树.二叉树.q114_二叉树展开为链表.f1;

import 树.二叉树.TreeNode;

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
     * @Description 解法一
     * 可以发现展开的顺序其实就是二叉树的先序遍历。算法和 94 题中序遍历的 Morris 算法有些神似，我们需要两步完成这道题。
     * <p>
     * 将左子树插入到右子树的地方
     * 将原来的右子树接到左子树的最右边节点
     * 考虑新的右子树的根节点，一直重复上边的过程，直到新的右子树为 null
     * @Author zph
     * @Date 2020/7/18 21:50
     * @Param [root]
     */
    public void flatten(TreeNode root) {
        while (root != null) {
            if (root.left == null) {
                root = root.right;
            } else {
                TreeNode pre = root.left;
                while (pre.right != null) {
                    pre = pre.right;
                }
                pre.right = root.right;
                root.right = root.left;
                root.left = null;
                root = root.right;
            }

        }

    }


}
