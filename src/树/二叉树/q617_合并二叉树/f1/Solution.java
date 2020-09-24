package 树.二叉树.q617_合并二叉树.f1;

import 树.二叉树.TreeNode;

/**
 * @ClassName : Solution
 * @Description :617. 合并二叉树
 * 给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
 *
 * 你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点。
 *
 * 示例 1:
 *
 * 输入:
 * 	Tree 1                     Tree 2
 *           1                         2
 *          / \                       / \
 *         3   2                     1   3
 *        /                           \   \
 *       5                             4   7
 * 输出:
 * 合并后的树:
 * 	     3
 * 	    / \
 * 	   4   5
 * 	  / \   \
 * 	 5   4   7
 * 注意: 合并必须从两个树的根节点开始。
 * @Author : zph
 * @Date: 2020-09-23 23:36
 * @Version : V1.0
 */
public class Solution {
    /**
     * @Title mergeTrees
     * @Description 深度优先搜索
     * @Author zph
     * @Date 2020/9/23 23:38
     * @Param [t1, t2]
     * @return 树.二叉树.TreeNode
     */
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1==null){
            return t2;
        }
        if(t2==null){
            return t1;
        }
        TreeNode merge = new TreeNode(t1.val + t2.val);

        merge.left=mergeTrees(t1.left,t2.left);
        merge.right=mergeTrees(t1.right,t2.right);
        return merge;

    }
}
