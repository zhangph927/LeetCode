package 树相关.二叉搜索树.不同的二叉搜索树.q96_不同的二叉搜索树;

import org.omg.PortableServer.LIFESPAN_POLICY_ID;
import 树相关.二叉搜索树.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName : Solution
 * @Description :
 * @Author : zph
 * @Date: 2020-07-21 23:40
 * @Version : V1.0
 */
public class Solution {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }

        return helper(1,n);


    }

    private List<TreeNode> helper(int start, int end) {
        List<TreeNode> allTrees = new ArrayList<>();

        if (start > end) {
            allTrees.add(null);
            return allTrees;
        }
        if (start == end) {
            TreeNode treeNode = new TreeNode(start);
            allTrees.add(treeNode);
            return allTrees;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftTree = helper(start, i - 1);
            List<TreeNode> rightTree = helper(i + 1, end);
            for (TreeNode left : leftTree) {
                for (TreeNode right : rightTree) {
                    TreeNode treeNode = new TreeNode(i);
                    treeNode.left = left;
                    treeNode.right = right;
                    allTrees.add(treeNode);


                }

            }

        }
        return allTrees;
    }
}
