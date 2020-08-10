package 树相关.二叉树.q100_相同的树.f1;

import 树相关.二叉树.TreeNode;

/**
 * @ClassName : Solution
 * @Description :100. 相同的树
 * 给定两个二叉树，编写一个函数来检验它们是否相同。
 *
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 *
 * 示例 1:
 *
 * 输入:       1         1
 *           / \       / \
 *          2   3     2   3
 *
 *         [1,2,3],   [1,2,3]
 *
 * 输出: true
 * 示例 2:
 *
 * 输入:      1          1
 *           /           \
 *          2             2
 *
 *         [1,2],     [1,null,2]
 *
 * 输出: false
 * 示例 3:
 *
 * 输入:       1         1
 *           / \       / \
 *          2   1     1   2
 *
 *         [1,2,1],   [1,1,2]
 *
 * 输出: false
 * @Author : zph
 * @Date: 2020-08-07 12:16
 * @Version : V1.0
 */
public class Solution {
    /**
     * @Title isSameTree
     * @Description 递归
     * @Author zph
     * @Date 2020/8/7 12:26
     * @Param [p, q]
     * @return boolean
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {

       return helper(p,q);

    }

    public boolean helper(TreeNode p, TreeNode q){
        if(p==null&&q==null){
            return true;
        }else if(p==null||q==null){
            return false;
        } else if(p.val!=q.val){
            return false;
        }
      boolean leftFlag=  helper(p.left,q.left);
      boolean rightFlag=  helper(p.right,q.right);

      return leftFlag&&rightFlag;
    }
}
