package 树.二叉树.q968_监控二叉树.f2;

import 树.二叉树.TreeNode;

/**
 * @ClassName : Solution
 * @Description :968. 监控二叉树
 * 给定一个二叉树，我们在树的节点上安装摄像头。
 *
 * 节点上的每个摄影头都可以监视其父对象、自身及其直接子对象。
 *
 * 计算监控树的所有节点所需的最小摄像头数量。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：[0,0,null,0,0]
 * 输出：1
 * 解释：如图所示，一台摄像头足以监控所有节点。
 * 示例 2：
 *
 *
 *
 * 输入：[0,0,null,0,null,0,null,null,0]
 * 输出：2
 * 解释：需要至少两个摄像头来监视树的所有节点。 上图显示了摄像头放置的有效位置之一。
 *
 * 提示：
 *
 * 给定树的节点数的范围是 [1, 1000]。
 * 每个节点的值都是 0。
 * @Author : zph
 * @Date: 2020-09-22 17:51
 * @Version : V1.0
 */
public class Solution {
    /**
     * @Title minCameraCover
     * @Description 递归
     * 根据上面的讨论，能够分析出，对于每个节点 \textit{root}root ，需要维护三种类型的状态：
     *
     * 状态 aa：\textit{root}root 必须放置摄像头的情况下，覆盖整棵树需要的摄像头数目。
     * 状态 bb：覆盖整棵树需要的摄像头数目，无论 \textit{root}root 是否放置摄像头。
     * 状态 cc：覆盖两棵子树需要的摄像头数目，无论节点 \textit{root}root 本身是否被监控到。
     *
     *
     * @Author zph
     * @Date 2020/9/22 17:52
     * @Param [root]
     * @return int
     */
    public int minCameraCover(TreeNode root) {
        int[] array = dfs(root);
        return array[1];
    }

    public int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[]{Integer.MAX_VALUE / 2, 0, 0};
        }
        int[] leftArray = dfs(root.left);
        int[] rightArray = dfs(root.right);
        int[] array = new int[3];
        array[0] = leftArray[2] + rightArray[2] + 1;
        array[1] = Math.min(array[0], Math.min(leftArray[0] + rightArray[1], rightArray[0] + leftArray[1]));
        array[2] = Math.min(array[0], leftArray[1] + rightArray[1]);
        return array;
    }


}
