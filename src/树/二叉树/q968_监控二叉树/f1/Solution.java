package 树.二叉树.q968_监控二叉树.f1;

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
     * @Author zph
     * @Date 2020/9/22 17:52
     * @Param [root]
     * @return int
     */
    public int minCameraCover(TreeNode root) {
        int last = preOrder(root);
        //处理最后一个节点，根节点
        if(last==0) res++;
        return res;
    }
    private int res=0;
    //0未覆盖，1被覆盖，2安装了相机
    public int preOrder(TreeNode node){
        //空节点不做处理，就当它是被覆盖的
        if(node==null) return 1;
        //获取子节点的情况
        int left = preOrder(node.left);
        int right = preOrder(node.right);
        //如果两个子节点都是1，说明子节点不存在或者子节点被其它相机覆盖了
        //那么为了相机最小化，当前节点不能有相机，需要被它的父节点覆盖
        if(left==1&&right==1) return 0;
        //如果子节点都是0，表示它们等待被覆盖，那么当前节点就要安装相机
        if(left==0||right==0)
        {
            res++;return 2;
        }
        //但凡只要子节点任何一个节点安装了相机，那么当前节点就是被覆盖的
        if(left==2||right==2)
            return 1;
        return 1;
    }

}
