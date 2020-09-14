package 数组.两数之和.q653_两数之和IV输入BST.f2;

import 数组.两数之和.q653_两数之和IV输入BST.TreeNode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @ClassName : Solution
 * @Description :653. 两数之和 IV - 输入 BST
 * 给定一个二叉搜索树和一个目标结果，如果 BST 中存在两个元素且它们的和等于给定的目标结果，则返回 true。
 *
 * 案例 1:
 *
 * 输入:
 *     5
 *    / \
 *   3   6
 *  / \   \
 * 2   4   7
 *
 * Target = 9
 *
 * 输出: True
 *
 *
 * 案例 2:
 *
 * 输入:
 *     5
 *    / \
 *   3   6
 *  / \   \
 * 2   4   7
 *
 * Target = 28
 *
 * 输出: False
 * @Author : zph
 * @Date: 2020-09-13 15:18
 * @Version : V1.0
 */
public class Solution {
    /**
     * @Title findTarget
     * @Description 使用 BFS 和 HashSet
     * @Author zph
     * @Date 2020/9/13 15:20
     * @Param [root, k]
     * @return boolean
     */
    public boolean findTarget(TreeNode root, int k) {
        Set < Integer > set = new HashSet();
        Queue< TreeNode > queue = new LinkedList();
        if(root==null){
            return false;
        }
        queue.add(root);
        while (!queue.isEmpty()) {
                TreeNode node = queue.remove();
                if (set.contains(k - node.val))
                    return true;
                set.add(node.val);
                if(node.right!=null){
                    queue.add(node.right);
                }
                if(node.left!=null){
                    queue.add(node.left);
                }
        }
        return false;
    }


}
