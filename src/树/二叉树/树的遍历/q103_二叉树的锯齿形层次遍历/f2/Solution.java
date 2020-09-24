package 树.二叉树.树的遍历.q103_二叉树的锯齿形层次遍历.f2;

import 树.二叉树.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName : Solution
 * @Description :103. 二叉树的锯齿形层次遍历
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回锯齿形层次遍历如下：
 *
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 * @Author : zph
 * @Date: 2020-09-22 00:57
 * @Version : V1.0
 */
public class Solution {
    /**
     * @Title zigzagLevelOrder
     * @Description 深度遍历
     * @Author zph
     * @Date 2020/9/22 0:58
     * @Param [root]
     * @return java.util.List<java.util.List<java.lang.Integer>>
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        dfs(root,0,result);
        return result;
    }

    private void dfs(TreeNode root,int level,List<List<Integer>> result){
        if(level>=result.size()){
            List<Integer> levelList = new ArrayList<>();
            levelList.add(root.val);
            result.add(levelList);

        }else {
            if(level%2==0){
                result.get(level).add(root.val);
            }else {
                result.get(level).add(0,root.val);
            }
        }

        if(root.left!=null){
            dfs(root.left,level+1,result);
        }
        if(root.right!=null){
            dfs(root.right,level+1,result);
        }

    }


}
