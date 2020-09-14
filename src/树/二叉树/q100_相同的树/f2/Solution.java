package 树.二叉树.q100_相同的树.f2;

import 树.二叉树.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

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
     * @Description 迭代
     * @Author zph
     * @Date 2020/8/7 12:26
     * @Param [p, q]
     * @return boolean
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null&&q==null){
            return true;
        }else if(p==null||q==null){
            return false;
        }
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        queue1.offer(p);
        queue2.offer(q);
        while (!queue1.isEmpty()&&!queue2.isEmpty()){
            TreeNode poll1 = queue1.poll();
            TreeNode poll2 = queue2.poll();
            if(poll1.val!=poll2.val){
                return false;
            }
            TreeNode left1 = poll1.left;
            TreeNode right1 = poll1.right;
            TreeNode left2 = poll2.left;
            TreeNode right2 = poll2.right;
            if(left1==null^left2==null){
                return false;
            }
            if(right1==null^right2==null){
                return false;
            }
            if(left1!=null){
                queue1.offer(left1);
            }
            if(right1!=null){
                queue1.offer(right1);
            }
            if(left2!=null){
                queue2.offer(left2);
            }
            if(right2!=null){
                queue2.offer(right2);
            }
        }
        return queue1.isEmpty()&&queue2.isEmpty();


    }


}
