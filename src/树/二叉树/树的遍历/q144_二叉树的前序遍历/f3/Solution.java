package 树.二叉树.树的遍历.q144_二叉树的前序遍历.f3;

import 树.二叉树.TreeNode;

import java.util.*;

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
     * @Description 莫里斯遍历
     * 方法基于 莫里斯的文章，可以优化空间复杂度。算法不会使用额外空间，只需要保存最终的输出结果。如果实时输出结果，那么空间复杂度是 O(1)O(1)。
     *
     * 算法
     *
     * 算法的思路是从当前节点向下访问先序遍历的前驱节点，每个前驱节点都恰好被访问两次。
     *
     * 首先从当前节点开始，向左孩子走一步然后沿着右孩子一直向下访问，直到到达一个叶子节点（当前节点的中序遍历前驱节点），所以我们更新输出并建立一条伪边 predecessor.right = root 更新这个前驱的下一个点。如果我们第二次访问到前驱节点，由于已经指向了当前节点，我们移除伪边并移动到下一个顶点。
     *
     * 如果第一步向左的移动不存在，就直接更新输出并向右移动
     *
     * @Author zph
     * @Date 2020/9/22 0:02
     * @Param [root]
     * @return java.util.List<java.lang.Integer>
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        LinkedList<Integer> output = new LinkedList<>();

        TreeNode node = root;
        while (node != null) {
            if (node.left == null) {
                output.add(node.val);
                node = node.right;
            }
            else {
                TreeNode predecessor = node.left;
                while ((predecessor.right != null) && (predecessor.right != node)) {
                    predecessor = predecessor.right;
                }

                if (predecessor.right == null) {
                    output.add(node.val);
                    predecessor.right = node;
                    node = node.left;
                }
                else{
                    predecessor.right = null;
                    node = node.right;
                }
            }
        }
        return output;
    }


}
