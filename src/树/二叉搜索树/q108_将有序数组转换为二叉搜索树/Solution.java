package 树.二叉搜索树.q108_将有序数组转换为二叉搜索树;

import 树.二叉搜索树.TreeNode;

/**
 * @ClassName : Solution
 * @Description :108. 将有序数组转换为二叉搜索树
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 * <p>
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 * <p>
 * 示例:
 * <p>
 * 给定有序数组: [-10,-3,0,5,9],
 * <p>
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 * <p>
 * 0
 * / \
 * -3   9
 * /   /
 * -10  5
 * @Author : zph
 * @Date: 2020-08-18 17:27
 * @Version : V1.0
 */
public class Solution {

    /**
     * @Title sortedArrayToBST
     * @Description 中序遍历，总是选择中间位置左边的数字作为根节点
     * @Author zph
     * @Date 2020/8/18 23:48
     * @Param [nums]
     * @return 树相关.二叉搜索树.TreeNode
     */
    public TreeNode sortedArrayToBST(int[] nums) {

        //根据列表构造平衡二叉搜索树
        TreeNode newTree = buildTree(nums, 0, nums.length - 1);

        return newTree;

    }

    private TreeNode buildTree(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildTree(nums, start, mid - 1);
        root.right = buildTree(nums, mid + 1, end);
        return root;

    }

}
