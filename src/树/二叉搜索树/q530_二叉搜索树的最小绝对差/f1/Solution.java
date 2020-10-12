package 树.二叉搜索树.q530_二叉搜索树的最小绝对差.f1;


import 树.二叉搜索树.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName : Solution
 * @Description :530. 二叉搜索树的最小绝对差
 * 给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。
 *
 *
 *
 * 示例：
 *
 * 输入：
 *
 *    1
 *     \
 *      3
 *     /
 *    2
 *
 * 输出：
 * 1
 *
 * 解释：
 * 最小绝对差为 1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。
 * @Author : zph
 * @Date: 2020-10-12 00:02
 * @Version : V1.0
 */
public class Solution {

    int ans=Integer.MAX_VALUE;
    int pre=-1;
    public int getMinimumDifference(TreeNode root) {
        helper(root);
        return ans;

    }


    private void helper(TreeNode root){
        if(root==null){
            return;
        }
        helper(root.left);

        if(pre==-1){
            pre=root.val;
        }else {
            ans=Math.min(ans,root.val-pre);
            pre=root.val;
        }

        helper(root.right);

    }
}
