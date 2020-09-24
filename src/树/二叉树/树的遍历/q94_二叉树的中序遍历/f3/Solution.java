package 树.二叉树.树的遍历.q94_二叉树的中序遍历.f3;

import 树.二叉树.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @ClassName : Solution
 * @Description :94. 二叉树的中序遍历
 * 给定一个二叉树，返回它的中序 遍历。
 *
 * 示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,3,2]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 * @Author : zph
 * @Date: 2020-09-14 23:21
 * @Version : V1.0
 */
public class Solution {

    /**
     * @Title inorderTraversal
     * @Description 中序莫里斯迭代
     * 莫里斯遍历不需要递归或者临时的栈空间就可以完成遍历，空间复杂度是常数。但是为了解决从子节点找到父节点的问题，需要临时修改树的结构，在遍历完成之后复原成原来的树结构。
     *
     * 整个遍历的过程中只需要两个指针——当前指针cur和临时前驱指针prev，具体的过程如下
     *
     * 如果左子节点是空，录入当前节点，当前指针cur指向右子节点
     * 如果左子节点不是空，遍历左子节点的最右侧右子节点，找到最右侧叶节点，在寻找的过程中可能出现两种情况：
     * 如果遍历到的叶节点的右子节点是空，把叶节点的右子节点指向cur节点，cur移向左子节点
     * 如果遍历到的叶节点的右子节点是cur节点，表示原来的叶节点到cur节点连接已经存在，现在遍历结束了，需要复原，置节点的右子节点为空，在录入了cur节点之后，cur移到自己的右子节点
     * 重复上面两步直到当前节点为空
     * 其中最不好理解的是第二步，遍历左子树的右节点的过程中，只有当左子树没有建立到父节点的连接的时候，才能最后遍历到尽头，达到尽头之后需要和父节点连接起来，当cur遍历到这个叶节点的时候才能回到正确的父节点的位置。
     *
     * 当当前节点cur遍历完了左子树回到父节点的时候，多余的连接还是存在的，需要移除这个连接，而方法就是和建立连接一样遍历左子树找到最右侧节点，这个时候判断的依据就不能是右节点为空，必须是左子节点的最右节点等于当前节点，相当于找到循环的起点，然后在这个地方切断联系。
     * @Author zph
     * @Date 2020/9/14 23:23
     * @Param [root]
     * @return java.util.List<java.lang.Integer>
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        TreeNode cur = root;    // 记录当前节点位置
        List<Integer> res = new ArrayList<>();
        while (cur != null) {
            if (cur.left == null) {   // 左节点为空，移到右子节点
                res.add(cur.val);
                cur = cur.right;
            }  else {
                TreeNode prev = cur.left;
                while (prev.right != null && prev.right != cur) { // 遍历到左子树的最右侧节点
                    prev = prev.right;
                }
                if (prev.right == null) {        // 建立返回父节点连接
                    prev.right = cur;
                    cur = cur.left;
                } else {                        // 左子树建立了连接，说明遍历完了，可以拆除连接
                    res.add(cur.val);           // 中序遍历录入当前节点
                    prev.right = null;
                    cur = cur.right;
                }
            }
        }
        return res;
    }



}
