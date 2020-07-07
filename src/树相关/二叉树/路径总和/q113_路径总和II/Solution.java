package 树相关.二叉树.路径总和.q113_路径总和II;

import 树相关.二叉树.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @ClassName : Solution
 * @Description :113. 路径总和 II
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
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
 *          /  \    / \
 *         7    2  5   1
 * 返回:
 *
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 * @Author : zph
 * @Date: 2020-07-07 18:02
 * @Version : V1.0
 */
public class Solution {

    /**
     * @Title pathSum
     * @Description 深度优先遍历和回溯算法
     * @Author zph
     * @Date 2020/7/7 20:09
     * @Param [root, sum]
     * @return java.util.List<java.util.List<java.lang.Integer>>
     */
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res=  new ArrayList<>();
        if(root==null){
            return  res;
        }
        Deque<Integer> path = new ArrayDeque<>();

        pathSum(root,sum,res,path);
        return res;

    }

    private  void pathSum(TreeNode root, int sum,List<List<Integer>> res,Deque<Integer> path){
        if(root==null){
            return;
        }
        sum=sum-root.val;
        path.addLast(root.val);
        if(sum==0&&root.left==null&&root.right==null){
            res.add(new ArrayList<>(path));
            path.removeLast();
            return;
        }
        pathSum(root.left,sum,res,path);
        pathSum(root.right,sum,res,path);
        path.removeLast();
    }
}
