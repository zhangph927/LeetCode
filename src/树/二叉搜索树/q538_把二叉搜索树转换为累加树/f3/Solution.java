package 树.二叉搜索树.q538_把二叉搜索树转换为累加树.f3;

import 树.二叉搜索树.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @ClassName : Solution
 * @Description :538. 把二叉搜索树转换为累加树
 * 给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，使得每个节点的值是原来的节点值加上所有大于它的节点值之和。
 *
 *
 *
 * 例如：
 *
 * 输入: 原始二叉搜索树:
 *               5
 *             /   \
 *            2     13
 *
 * 输出: 转换为累加树:
 *              18
 *             /   \
 *           20     13
 *
 * @Author : zph
 * @Date: 2020-09-21 22:58
 * @Version : V1.0
 */
public class Solution {
    /**
     * @Title convertBST
     * @Description Morris 遍历的核心思想是利用树的大量空闲指针，实现空间开销的极限缩减。其反序中序遍历规则总结如下：
     *
     * 如果当前节点的右子节点为空，处理当前节点，并遍历当前节点的左子节点；
     *
     * 如果当前节点的右子节点不为空，找到当前节点右子树的最左节点（该节点为当前节点中序遍历的前驱节点）；
     *
     * 如果最左节点的左指针为空，将最左节点的左指针指向当前节点，遍历当前节点的右子节点；
     *
     * 如果最左节点的左指针不为空，将最左节点的左指针重新置为空（恢复树的原状），处理当前节点，并将当前节点置为其左节点；
     *
     * 重复步骤 1 和步骤 2，直到遍历结束。
     *
     * 这样我们利用 Morris 遍历的方法，反序中序遍历该二叉搜索树，即可实现线性时间与常数空间的遍历
     *
     * @Author zph
     * @Date 2020/9/21 23:17
     * @Param [root]
     * @return 树.二叉搜索树.TreeNode
     */
    public TreeNode convertBST(TreeNode root) {
        int sum = 0;
        TreeNode node = root;

        while (node != null) {
            if (node.right == null) {
                sum += node.val;
                node.val = sum;
                node = node.left;
            } else {
                TreeNode succ = getSuccessor(node);
                if (succ.left == null) {
                    succ.left = node;
                    node = node.right;
                } else {
                    succ.left = null;
                    sum += node.val;
                    node.val = sum;
                    node = node.left;
                }
            }
        }

        return root;
    }

    public TreeNode getSuccessor(TreeNode node) {
        TreeNode succ = node.right;
        while (succ.left != null && succ.left != node) {
            succ = succ.left;
        }
        return succ;
    }
}
