package 树.二叉树.q106_从中序与后序遍历序列构造二叉树.f1;

import 树.二叉树.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName : Solution
 * @Description :106. 从中序与后序遍历序列构造二叉树
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * @Author : zph
 * @Date: 2020-09-25 00:35
 * @Version : V1.0
 */
public class Solution {
    int post_idx;
    int[] postorder;
    int[] inorder;
    Map<Integer, Integer> idx_map = new HashMap<Integer, Integer>();

    public TreeNode helper(int in_left, int in_right) {
        // 如果这里没有节点构造二叉树了，就结束
        if (in_left > in_right) {
            return null;
        }

        // 选择 post_idx 位置的元素作为当前子树根节点
        int root_val = postorder[post_idx];
        TreeNode root = new TreeNode(root_val);

        // 根据 root 所在位置分成左右两棵子树
        int index = idx_map.get(root_val);

        // 下标减一
        post_idx--;
        // 构造右子树
        //根据后序遍历逻辑，递归创建右子树 helper(index + 1, in_right)
        // 和左子树 helper(in_left, index - 1)。注意这里有需要先创建右子树，
        // 再创建左子树的依赖关系。可以理解为在后序遍历的数组中整个数组是先存储左子树的节点，
        // 再存储右子树的节点，最后存储根节点，
        // 如果按每次选择「后序遍历的最后一个节点」为根节点，
        // 则先被构造出来的应该为右子树
        root.right = helper(index + 1, in_right);
        // 构造左子树
        root.left = helper(in_left, index - 1);
        return root;
    }

    /**
     * @Title buildTree
     * @Description 递归
     * @Author zph
     * @Date 2020/9/25 0:40
     * @Param [inorder, postorder]
     * @return 树.二叉树.TreeNode
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.postorder = postorder;
        this.inorder = inorder;
        // 从后序遍历的最后一个元素开始
        post_idx = postorder.length - 1;

        // 建立（元素，下标）键值对的哈希表
        int idx = 0;
        for (Integer val : inorder) {
            idx_map.put(val, idx++);
        }

        return helper(0, inorder.length - 1);
    }

}
