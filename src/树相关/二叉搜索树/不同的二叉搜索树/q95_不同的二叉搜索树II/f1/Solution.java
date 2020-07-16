package 树相关.二叉搜索树.不同的二叉搜索树.q95_不同的二叉搜索树II.f1;

import 树相关.二叉搜索树.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName : Solution
 * @Description :95. 不同的二叉搜索树 II
 * 给定一个整数 n，生成所有由 1 ... n 为节点所组成的 二叉搜索树 。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：3
 * 输出：
 * [
 * [1,null,3,2],
 * [3,2,null,1],
 * [3,1,null,null,2],
 * [2,1,3],
 * [1,null,2,null,3]
 * ]
 * 解释：
 * 以上的输出对应以下 5 种不同结构的二叉搜索树：
 * <p>
 * 1         3     3      2      1
 * \       /     /      / \      \
 * 3     2     1      1   3      2
 * /     /       \                 \
 * 2     1         2                 3
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= n <= 8
 * @Author : zph
 * @Date: 2020-07-15 23:43
 * @Version : V1.0
 */
public class Solution {

    /**
     * @Title generateTrees
     * @Description 递归
     * @Author zph
     * @Date 2020/7/16 10:53
     * @Param [n]
     * @return java.util.List<树相关.二叉搜索树.TreeNode>
     */
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        return helper(1, n);
    }

    private List<TreeNode> helper(int start, int end) {
        List<TreeNode> allTreeList = new ArrayList<>();
        //此时没有数字，将 null 加入结果中
        if (start > end) {
            allTreeList.add(null);
            return allTreeList;
        }
        //只有一个数字，当前数字作为一棵树加入结果中
        if (start == end) {
            TreeNode node = new TreeNode(start);
            allTreeList.add(node);
            return allTreeList;
        }
        //尝试每个数字作为根节点
        for (int i = start; i <= end; i++) {
            //获取所有左节点
            List<TreeNode> leftNodeList = helper(start, i - 1);
            //获取所有右节点
            List<TreeNode> rightNodeList = helper(i + 1, end);
            //左子树右子树两两组合
            for (TreeNode left : leftNodeList) {
                for (TreeNode right : rightNodeList) {
                    TreeNode node = new TreeNode(i);
                    node.left = left;
                    node.right = right;
                    allTreeList.add(node);

                }

            }


        }

        return allTreeList;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<TreeNode> treeNodes = solution.generateTrees(3);
        System.out.println(treeNodes);


    }
}
