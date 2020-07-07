package 树相关.二叉树.路径总和.q112_路径总和;

import org.omg.PortableInterceptor.INACTIVE;
import 树相关.二叉树.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @ClassName : Solution
 * @Description :112. 路径总和
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \      \
 *         7    2      1
 * 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
 * @Author : zph
 * @Date: 2020-07-07 17:45
 * @Version : V1.0
 */
public class Solution {
    /**
     * @Title hasPathSum
     * @Description 深度优先遍历
     * @Author zph
     * @Date 2020/7/7 18:02
     * @Param [root, sum]
     * @return boolean
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null){
            return  false;
        }
        Deque<TreeNode> nodeStack = new ArrayDeque<>();
        Deque<Integer> valueStack = new ArrayDeque<>();
        nodeStack.addLast(root);
        valueStack.addLast(sum-root.val);
        TreeNode node;
        int value;
        while (!nodeStack.isEmpty()){
            node= nodeStack.removeLast();
           value= valueStack.removeLast();
           if(node.left==null&&node.right==null&&value==0){
               return  true;
           }
           if(node.left!=null){
               nodeStack.addLast(node.left);
               valueStack.addLast(value-node.left.val);
           }
            if(node.right!=null){
                nodeStack.addLast(node.right);
                valueStack.addLast(value-node.right.val);
            }
        }
        return  false;


    }
}
