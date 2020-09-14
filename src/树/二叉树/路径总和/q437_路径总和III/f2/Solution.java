package 树.二叉树.路径总和.q437_路径总和III.f2;

import 树.二叉树.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName : Solution
 * @Description :437. 路径总和 III
 * 给定一个二叉树，它的每个结点都存放着一个整数值。
 *
 * 找出路径和等于给定数值的路径总数。
 *
 * 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 *
 * 二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。
 *
 * 示例：
 *
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 *
 *       10
 *      /  \
 *     5   -3
 *    / \    \
 *   3   2   11
 *  / \   \
 * 3  -2   1
 *
 * 返回 3。和等于 8 的路径有:
 *
 * 1.  5 -> 3
 * 2.  5 -> 2 -> 1
 * 3.  -3 -> 11
 * @Author : zph
 * @Date: 2020-07-07 20:18
 * @Version : V1.0
 */
public class Solution {
    /**
     * @Title pathSum
     * @Description 递归、前缀和
     * @Author zph
     * @Date 2020/7/7 20:42
     * @Param [root, sum]
     * @return int
     */
    public int pathSum(TreeNode root, int sum) {
        if(root==null){
            return  0;
        }
        Map<Integer, Integer> prefixSumMap = new HashMap<>();
        prefixSumMap.put(0,1);
        return countSum(root,sum,prefixSumMap,0);


    }
    private int countSum(TreeNode root, int sum,Map<Integer, Integer> prefixSumMap,int curSum){
        if(root==null){
            return  0;
        }
        curSum+=root.val;
        int res=0;
        res+=prefixSumMap.getOrDefault(curSum-sum,0);
        prefixSumMap.put(curSum,prefixSumMap.getOrDefault(curSum,0)+1);
       res+= countSum(root.left,sum,prefixSumMap,curSum);
        res+=countSum(root.right,sum,prefixSumMap,curSum);
        prefixSumMap.put(curSum,prefixSumMap.get(curSum)-1);
        return  res;
    }
}
