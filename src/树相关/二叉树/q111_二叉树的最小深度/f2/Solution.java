package 树相关.二叉树.q111_二叉树的最小深度.f2;

import 树相关.二叉树.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName : Solution
 * @Description :111. 二叉树的最小深度
 * 给定一个二叉树，找出其最小深度。
 *
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 *
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最小深度  2.
 * @Author : zph
 * @Date: 2020-08-21 17:37
 * @Version : V1.0
 */
public class Solution {

    class QueueNode{
       private TreeNode node;
       private  int dept;
       public QueueNode(TreeNode node,int dept){
           this.node=node;
           this.dept=dept;
       }
    }

    /**
     * @Title minDepth
     * @Description 广度优先搜索
     * @Author zph
     * @Date 2020/8/21 17:41
     * @Param [root]
     * @return int
     */
    public int minDepth(TreeNode root) {
        return helper(root);
    }

    private int helper(TreeNode root){
        if(root==null){
            return 0;
        }
        Queue<QueueNode> queue = new LinkedList<>();
        queue.offer(new QueueNode(root,1));
        while (!queue.isEmpty()){
            QueueNode queueNode = queue.poll();
            TreeNode node = queueNode.node;
            int dept = queueNode.dept;
            if(node.left==null&&node.right==null){
                return dept;
            }
            if(node.left!=null){
                queue.offer(new QueueNode(node.left,dept+1));
            }
            if(node.right!=null){
                queue.offer(new QueueNode(node.right,dept+1));
            }
        }
        return 0;
    }

}
