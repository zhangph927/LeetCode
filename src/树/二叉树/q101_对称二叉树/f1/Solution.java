package 树.二叉树.q101_对称二叉树.f1;

import 树.二叉树.TreeNode;

/**
 * @ClassName : Solution
 * @Description :101. 对称二叉树
 * 给定一个二叉树，检查它是否是镜像对称的。
 *
 *
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *
 *
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *
 *
 * 进阶：
 *
 * 你可以运用递归和迭代两种方法解决这个问题吗？
 * @Author : zph
 * @Date: 2020-09-23 23:58
 * @Version : V1.0
 */
public class Solution {
    /**
     * @Title isSymmetric
     * @Description 递归
     * @Author zph
     * @Date 2020/9/23 23:59
     * @Param [root]
     * @return boolean
     */
    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    public boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
    }

}
