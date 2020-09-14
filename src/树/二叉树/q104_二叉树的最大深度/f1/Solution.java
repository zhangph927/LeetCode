package 树.二叉树.q104_二叉树的最大深度.f1;

import 树.二叉树.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName : Solution
 * @Description :104. 二叉树的最大深度
 * 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度 3 。
 * @Author : zph
 * @Date: 2020-07-28 22:15
 * @Version : V1.0
 */
public class Solution {
    /**
     * @Title maxDepth
     * @Description 广度遍历
     * @Author zph
     * @Date 2020/7/28 22:20
     * @Param [root]
     * @return int
     */
    public int maxDepth(TreeNode root) {
        int count=0;
        if(root==null){
            return count;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size=queue.size();
            for(int i=0;i<size;i++){
                TreeNode poll = queue.poll();
                if(poll.left!=null){
                    queue.offer(poll.left);
                }
                if(poll.right!=null){
                    queue.offer(poll.right);
                }
            }
            count++;
        }
        return count;

    }
}
