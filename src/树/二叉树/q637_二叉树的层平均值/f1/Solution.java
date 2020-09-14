package 树.二叉树.q637_二叉树的层平均值.f1;

import 树.二叉树.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName : Solution
 * @Description :637. 二叉树的层平均值
 * 给定一个非空二叉树, 返回一个由每层节点平均值组成的数组。
 *
 *
 *
 * 示例 1：
 *
 * 输入：
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 输出：[3, 14.5, 11]
 * 解释：
 * 第 0 层的平均值是 3 ,  第1层是 14.5 , 第2层是 11 。因此返回 [3, 14.5, 11] 。
 *
 *
 * 提示：
 *
 * 节点值的范围在32位有符号整数范围内。
 * @Author : zph
 * @Date: 2020-09-12 22:31
 * @Version : V1.0
 */
public class Solution {

    /**
     * @Title averageOfLevels
     * @Description 广度遍历
     * @Author zph
     * @Date 2020/9/12 22:39
     * @Param [root]
     * @return java.util.List<java.lang.Double>
     */
    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Double> list = new ArrayList<>();
        if(root==null){
            return list;

        }
        queue.offer(root);
        while (!queue.isEmpty()){
            int size=queue.size();
            double total=0;
            for(int i=0;i<size;i++){
                TreeNode poll = queue.poll();
                total+=poll.val;
                if(poll.left!=null){
                    queue.offer(poll.left);
                }
                if(poll.right!=null){
                    queue.offer(poll.right);
                }
            }
            list.add(total/size);
        }
        return list;

    }
}
