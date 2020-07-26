package 排序算法.二叉搜索树排序.基础模板;

import java.util.Arrays;

/**
 * @ClassName : Solution
 * @Description :
 * @Author : zph
 * @Date: 2020-07-25 23:06
 * @Version : V1.0
 */
public class Solution {
    private int[] bstSort(int[] nums) {
        TreeNode root = new TreeNode(nums[0]);   // 构建根节点
        for (int i = 1; i < nums.length; i++) {  // 将所有的元素插入到二叉搜索树中
            buildTree(root, nums[i]);
        }
        inorderTraversal(root, nums, new int[1]);// 中序遍历获取二叉树中的所有节点
        return nums;
    }

    private void inorderTraversal(TreeNode node, int[] nums, int[] pos) {
        if (node == null) return;
        inorderTraversal(node.left, nums, pos);
        nums[pos[0]++] = node.val;
        inorderTraversal(node.right, nums, pos);
    }

    private void buildTree(TreeNode node, int num) {
        if (node == null) return;
        if (num >= node.val) {                   // 插入到右子树中
            if (node.right == null) {
                node.right = new TreeNode(num);
            } else {
                buildTree(node.right, num);
            }
        } else {                                 // 插入到左子树中
            if (node.left == null) {
                node.left = new TreeNode(num);
            } else {
                buildTree(node.left, num);
            }
        }
    }

    static class TreeNode {   // 树节点的数据结构
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }


    public static void main(String[] args) {
        int[] nums = {5, 2, 3, 1};
        Solution solution = new Solution();
        int[] res = solution.bstSort(nums);
        System.out.println(Arrays.toString(res));
    }
}
