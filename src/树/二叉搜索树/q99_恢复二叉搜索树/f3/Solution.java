package 树.二叉搜索树.q99_恢复二叉搜索树.f3;

import 树.二叉搜索树.TreeNode;

/**
 * @ClassName : Solution
 * @Description :99. 恢复二叉搜索树
 * 二叉搜索树中的两个节点被错误地交换。
 *
 * 请在不改变其结构的情况下，恢复这棵树。
 *
 * 示例 1:
 *
 * 输入: [1,3,null,null,2]
 *
 *    1
 *   /
 *  3
 *   \
 *    2
 *
 * 输出: [3,1,null,null,2]
 *
 *    3
 *   /
 *  1
 *   \
 *    2
 * 示例 2:
 *
 * 输入: [3,1,4,null,null,2]
 *
 *   3
 *  / \
 * 1   4
 *    /
 *   2
 *
 * 输出: [2,1,4,null,null,3]
 *
 *   2
 *  / \
 * 1   4
 *    /
 *   3
 * 进阶:
 *
 * 使用 O(n) 空间复杂度的解法很容易实现。
 * 你能想出一个只使用常数空间的解决方案吗？
 * @Author : zph
 * @Date: 2020-08-08 21:45
 * @Version : V1.0
 */
public class Solution {
    /**
     * @Title recoverTree
     * @Description Morris 中序遍历
     * @Author zph
     * @Date 2020/8/8 21:46
     * @Param [root]
     * @return void
     */
    public void recoverTree(TreeNode root) {
        TreeNode x = null, y = null, pred = null, predecessor = null;
        TreeNode cur=root;
        while (cur != null) {
            if (cur.left != null) {
                // predecessor 节点就是当前 root 节点向左走一步，然后一直向右走至无法走为止
                predecessor = cur.left;
                while (predecessor.right != null && predecessor.right != cur) {
                    predecessor = predecessor.right;
                }

                // 让 predecessor 的右指针指向 root，继续遍历左子树
                if (predecessor.right == null) {
                    predecessor.right = cur;
                    cur = cur.left;
                }
                // 说明左子树已经访问完了，我们需要断开链接
                else {
                    if (pred != null && cur.val < pred.val) {
                        y = cur;
                        if (x == null) {
                            x = pred;
                        }
                    }
                    pred = cur;

                    predecessor.right = null;
                    cur = cur.right;
                }
            }
            // 如果没有左孩子，则直接访问右孩子
            else {
                if (pred != null && cur.val < pred.val) {
                    y = cur;
                    if (x == null) {
                        x = pred;
                    }
                }
                pred = cur;
                cur = cur.right;
            }
        }
        swap(x, y);
    }

    private void swap(TreeNode x,TreeNode y){
        int temp=x.val;
        x.val=y.val;
        y.val=temp;
    }


}
