package 树.二叉树.q129_求根到叶子节点数字之和.f1;

import 树.二叉树.TreeNode;

/**
 * @ClassName : Solution
 * @Description :129. 求根到叶子节点数字之和
 * 给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。
 *
 * 例如，从根到叶子节点路径 1->2->3 代表数字 123。
 *
 * 计算从根到叶子节点生成的所有数字之和。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 *     1
 *    / \
 *   2   3
 * 输出: 25
 * 解释:
 * 从根到叶子节点路径 1->2 代表数字 12.
 * 从根到叶子节点路径 1->3 代表数字 13.
 * 因此，数字总和 = 12 + 13 = 25.
 * 示例 2:
 *
 * 输入: [4,9,0,5,1]
 *     4
 *    / \
 *   9   0
 *  / \
 * 5   1
 * 输出: 1026
 * 解释:
 * 从根到叶子节点路径 4->9->5 代表数字 495.
 * 从根到叶子节点路径 4->9->1 代表数字 491.
 * 从根到叶子节点路径 4->0 代表数字 40.
 * 因此，数字总和 = 495 + 491 + 40 = 1026.
 * @Author : zph
 * @Date: 2020-09-24 00:26
 * @Version : V1.0
 */
public class Solution {


    /**
     * @Title sumNumbers
     * @Description 深度遍历
     * @Author zph
     * @Date 2020/10/31 14:23
     * @Param [root]
     * @return int
     */
    public int sumNumbers(TreeNode root) {
        if(root==null){
            return 0;
        }
       return dfs(root,0);
    }

    private int dfs(TreeNode node,int preNum){
        if(node==null){
            return 0;
        }
        int sum=preNum*10+node.val;
        if(node.left==null&&node.right==null){
            return sum;
        }else {
            return dfs(node.left,sum)+dfs(node.right,sum);
        }


    }
}
