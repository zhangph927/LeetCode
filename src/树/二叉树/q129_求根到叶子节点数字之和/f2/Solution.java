package 树.二叉树.q129_求根到叶子节点数字之和.f2;

import 树.二叉树.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName : Solution
 * @Description :129. 求根到叶子节点数字之和
 * 给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。
 * <p>
 * 例如，从根到叶子节点路径 1->2->3 代表数字 123。
 * <p>
 * 计算从根到叶子节点生成的所有数字之和。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3]
 * 1
 * / \
 * 2   3
 * 输出: 25
 * 解释:
 * 从根到叶子节点路径 1->2 代表数字 12.
 * 从根到叶子节点路径 1->3 代表数字 13.
 * 因此，数字总和 = 12 + 13 = 25.
 * 示例 2:
 * <p>
 * 输入: [4,9,0,5,1]
 * 4
 * / \
 * 9   0
 * / \
 * 5   1
 * 输出: 1026
 * 解释:
 * 从根到叶子节点路径 4->9->5 代表数字 495.
 * 从根到叶子节点路径 4->9->1 代表数字 491.
 * 从根到叶子节点路径 4->0 代表数字 40.
 * 因此，数字总和 = 495 + 491 + 40 = 1026.
 * @Author : zph
 * @Date: 2020-09-24 00:26
 * @Version : V1.0
 */
public class Solution {


    /**
     * @return int
     * @Title sumNumbers
     * @Description 广度遍历
     * @Author zph
     * @Date 2020/10/31 14:23
     * @Param [root]
     */
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> numQueue = new LinkedList<>();

        nodeQueue.offer(root);
        numQueue.offer(root.val);
        int sum=0;
        while (!nodeQueue.isEmpty()){
            TreeNode node = nodeQueue.poll();
            Integer num = numQueue.poll();
            TreeNode left= node.left;
            TreeNode right= node.right;
            if(left==null&&right==null){
                sum+=num;
            }else {
                if(left!=null){
                    nodeQueue.offer(left);
                    numQueue.offer(num*10+left.val);
                }
                if(right!=null){
                    nodeQueue.offer(right);
                    numQueue.offer(num*10+right.val);
                }
            }
        }
        return sum;

    }


}
