package 动态规划.q1372_二叉树中的最长交错路径.f1;

import 动态规划.q1372_二叉树中的最长交错路径.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * 1372. 二叉树中的最长交错路径
 * 给你一棵以 root 为根的二叉树，二叉树中的交错路径定义如下：
 *
 * 选择二叉树中 任意 节点和一个方向（左或者右）。
 * 如果前进方向为右，那么移动到当前节点的的右子节点，否则移动到它的左子节点。
 * 改变前进方向：左变右或者右变左。
 * 重复第二步和第三步，直到你在树中无法继续移动。
 * 交错路径的长度定义为：访问过的节点数目 - 1（单个节点的路径长度为 0 ）。
 *
 * 请你返回给定树中最长 交错路径 的长度。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：root = [1,null,1,1,1,null,null,1,1,null,1,null,null,null,1,null,1]
 * 输出：3
 * 解释：蓝色节点为树中最长交错路径（右 -> 左 -> 右）。
 * 示例 2：
 *
 *
 *
 * 输入：root = [1,1,1,null,1,null,null,1,1,null,1]
 * 输出：4
 * 解释：蓝色节点为树中最长交错路径（左 -> 右 -> 左 -> 右）。
 * 示例 3：
 *
 * 输入：root = [1]
 * 输出：0
 *
 *
 * 提示：
 *
 * 每棵树最多有 50000 个节点。
 * 每个节点的值在 [1, 100] 之间。
 */
public class Solution {

    Map<TreeNode,Integer> map=new HashMap<>();

    public int longestZigZag(TreeNode root) {
        if(root==null){
            return  0;
        }
        int left=0;
        if(root.left!=null){
            left=lengthOf(root.left,0)+1;
        }
        int right=0;
        if(root.right!=null){
            right= lengthOf(root.right,1)+1;
        }
        int maxLen=Math.max(left,right);
      int a=  longestZigZag( root.left);
      int b=  longestZigZag( root.right);
      maxLen=Math.max(maxLen,Math.max(a,b));
        return maxLen;
    }


    /**
     * @Title lengthOf
     * @Description 递归计算交错树长度
     * @Author zph
     * @Date 2020/7/4 18:22
     * @Param [root, dir 0-表示左边，1-表示右边]
     * @return int
     */
    private int lengthOf(TreeNode root,int dir){

        if(map.containsKey(root)){
            return  map.get(root);
        }
        if(root.left==null&&root.right==null){
            return  0;
        }
        int left=0;

        if(root.left!=null&&dir==1){
          left=  1+lengthOf(root.left,0);
        }
        int right=0;

        if(root.right!=null&&dir==0){
            right= 1+ lengthOf(root.right,1);
        }
        int maxLen=Math.max(left,right);
        map.put(root,maxLen);
        return  maxLen;
    }



}
