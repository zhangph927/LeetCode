package 树.二叉树.q617_合并二叉树.f2;

import 树.二叉树.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @ClassName : Solution
 * @Description :617. 合并二叉树
 * 给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
 * <p>
 * 你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * Tree 1                     Tree 2
 * 1                         2
 * / \                       / \
 * 3   2                     1   3
 * /                           \   \
 * 5                             4   7
 * 输出:
 * 合并后的树:
 * 3
 * / \
 * 4   5
 * / \   \
 * 5   4   7
 * 注意: 合并必须从两个树的根节点开始。
 * @Author : zph
 * @Date: 2020-09-23 23:36
 * @Version : V1.0
 */
public class Solution {
    /**
     * @return 树.二叉树.TreeNode
     * @Title mergeTrees
     * @Description 广度优先搜索
     * @Author zph
     * @Date 2020/9/23 23:38
     * @Param [t1, t2]
     */
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        TreeNode merge = new TreeNode(t1.val + t2.val);
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        queue.offer(merge);
        queue1.offer(t1);
        queue2.offer(t2);
        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            TreeNode node = queue.poll();
            TreeNode node1 = queue1.poll();
            TreeNode node2 = queue2.poll();
            TreeNode left1 = node1.left;
            TreeNode right1 = node1.right;
            TreeNode left2 = node2.left;
            TreeNode right2 = node2.right;
            if (left1 != null || left2 != null) {
                if (left1 != null && left2 != null) {

                    TreeNode left = new TreeNode(left1.val + left2.val);
                    node.left=left;
                    queue.offer(left);
                    queue1.offer(left1);
                    queue2.offer(left2);

                } else if (left1 != null) {
                    node.left = left1;

                } else if (left2 != null) {
                    node.left = left2;
                }

            }
            if (right1 != null || right2 != null) {
                if (right1 != null && right2 != null) {

                    TreeNode right = new TreeNode(right1.val + right2.val);

                    node.right=right;
                    queue.offer(right);
                    queue1.offer(right1);
                    queue2.offer(right2);
                } else if (right1 != null) {
                    node.right = right1;
                } else if (right2 != null) {
                    node.right = right2;
                }

            }


        }
        return merge;


    }

}
